package com.hackday.fk.groceryv2.controllers;

import com.hackday.fk.groceryv2.models.Inventory;
import com.hackday.fk.groceryv2.models.InventoryDAO;
import com.hackday.fk.groceryv2.models.User;
import com.hackday.fk.groceryv2.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siba.sethy on 23/06/17.
 */
@Controller
public class InventoryController {
    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param resturantID The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */

    @RequestMapping("/Inventory/ByResID")
    @ResponseBody
    public List<Inventory> getByEmail(Long resturantID) {
        String userId;
        try {
            ArrayList<Inventory> inventoryList = inventoryDAO.findAllByResturantID(resturantID);
            return inventoryList;
        }
        catch (Exception ex) {
            return null;
        }

    }


    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private InventoryDAO inventoryDAO;
}
