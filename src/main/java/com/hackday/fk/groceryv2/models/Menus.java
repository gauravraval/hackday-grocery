package com.hackday.fk.groceryv2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Created by gaurav.raval on 23/06/17.
 *
 * `menuid` int(11) NOT NULL,
 `menuname` varchar(255) NOT NULL DEFAULT '',
 `mappingcontent` varchar(5000) NOT NULL DEFAULT ''
 */

@Entity
@Table(name = "menus")
public class Menus {



    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuId;

    public Menus() {

    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMappingcontent() {
        return mappingcontent;
    }

    public void setMappingcontent(String mappingcontent) {
        this.mappingcontent = mappingcontent;
    }

    public Long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Long restaurantid) {
        this.restaurantid = restaurantid;
    }

    private String menuName;
    private String mappingcontent;

    public Menus(String menuName, String mappingcontent, Long restaurantid) {
        this.menuName = menuName;
        this.mappingcontent = mappingcontent;
        this.restaurantid = restaurantid;
    }


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    private Long restaurantid;
    public Menus (
                   String menuName,

                   String mappingcontent)
    {
        this.menuName=menuName;
        this.mappingcontent=mappingcontent;

    }


}
