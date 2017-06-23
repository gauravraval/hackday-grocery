package com.hackday.fk.groceryv2.controllers;

import com.hackday.fk.groceryv2.models.BillsDao;
import com.hackday.fk.groceryv2.models.Bills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaurav.raval on 23/06/17.
 */
public class BillsController {
    @Autowired
    private BillsDao billsDao;
    
    @RequestMapping("/getbybill")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            Bills bill = billsDao.findByBid(email);

        }
        catch (Exception ex) {
            return "User not found";
        }
        return "Not found: " ;
        
        
    }
}
