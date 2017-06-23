package com.hackday.fk.groceryv2.controllers;

import com.hackday.fk.groceryv2.models.BillsDao;
import com.hackday.fk.groceryv2.models.Bills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by gaurav.raval on 23/06/17.
 */
@Controller
public class BillsController {
    @Autowired
    private BillsDao billService;
    
    @RequestMapping("/getbybill")
    @ResponseBody
    public String getByEmail(Long bid) {
        String userId;
        try {
            Bills bill = billService.findByBid(bid);
            return  bill.toString();
        }
        catch (Exception ex) {
            return "Bill not found for "+ bid;
        }
    }

    @RequestMapping(value = "/bill/", method = RequestMethod.GET)
    public ResponseEntity<List<Bills>> listAllBills() {
        List<Bills> bills = billService.findALl();
        if (bills.isEmpty()) {
            return new ResponseEntity<List<Bills>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Bills>>(bills, HttpStatus.OK);
    }


    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bills> getBill(@PathVariable("id") long id) {
        System.out.println("Fetching Bill with id " + id);
        Bills bill = billService.findById(id);
        return new ResponseEntity<Bills>(bill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bill/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBill(@RequestBody Bills bill, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating bill " + bill.getRestaurantid());

        billService.saveBill(bill);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bill/{id}").buildAndExpand(bill.getOrderid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bills> updateUser(@PathVariable("id") long id, @RequestBody Bills bill) {

        Bills currentBill = billService.findById(id);

        currentBill.setOrdercontent(bill.getOrdercontent());
        billService.updateBill(currentBill);
        return new ResponseEntity<Bills>(currentBill, HttpStatus.OK);
    }
}
