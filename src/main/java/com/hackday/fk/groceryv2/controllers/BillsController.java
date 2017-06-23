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

import java.util.ArrayList;
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
            Bills bill = billService.findOne(bid);
            return  bill.toString();
        }
        catch (Exception ex) {
            return "Bill not found for "+ bid;
        }
    }

    @RequestMapping(value = "/bill/", method = RequestMethod.GET)
    public ResponseEntity<List<Bills>> listAllBills() {
        List<Bills> bills = toList(billService.findAll());

        if (bills.isEmpty()) {
            return new ResponseEntity<List<Bills>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }

        return new ResponseEntity<List<Bills>>(bills, HttpStatus.OK);


    }

    public static <E> List<E> toList(Iterable<E> iterable) { if(iterable instanceof List) { return (List<E>) iterable; }
        ArrayList<E> list = new ArrayList<E>(); if(iterable != null) { for(E e: iterable) { list.add(e); } } return list; }


    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bills> getBill(@PathVariable("id") long id) {
        System.out.println("Fetching Bill with id " + id);
        Bills bill = billService.findOne(id);
        return new ResponseEntity<Bills>(bill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bill/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBill(@RequestBody Bills bill, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating bill " + bill.getRestaurantid());

        billService.save(bill);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bill/{id}").buildAndExpand(bill.getOrderid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bill/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bills> updateUser(@PathVariable("id") long id, @RequestBody Bills bill) {

        Bills currentBill = billService.findOne(id);

        currentBill.setOrdercontent(bill.getOrdercontent());
        billService.save(currentBill);
        return new ResponseEntity<Bills>(currentBill, HttpStatus.OK);
    }
}
