package com.hackday.fk.groceryv2.controllers;

import com.hackday.fk.groceryv2.models.Bills;
import com.hackday.fk.groceryv2.models.Menus;
import com.hackday.fk.groceryv2.models.MenusDao;
import com.hackday.fk.groceryv2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gaurav.raval on 23/06/17.
 */
@Controller
public class MenusController {
    @Autowired
    private MenusDao menusDao;
    
    @RequestMapping("/getByMenuId")
    @ResponseBody
    public String getBy(Long menuId) {
        String userId;
        try {
            Menus menus = menusDao.findBymenuId(menuId);
            return  menus.getMappingcontent();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "Menus not found for id " + menuId;
        }

        
    }


    @RequestMapping("/createMenu")
    @ResponseBody
    public String create(String menuName, String mapping) {
        Menus menu = null;
        try {
            menu = new Menus(menuName, mapping);
            menusDao.save(menu);
        }
        catch (Exception ex) {
            return "Error creating the menu: " + ex.toString();
        }
        return "Menu succesfully created! (id = " + menu.getMenuId() + ")";
    }
}
