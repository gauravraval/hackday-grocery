package com.hackday.fk.groceryv2.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Created by gaurav.raval on 23/06/17.
 */
@Entity
@Table(name = "bills")
public class Bills {
        private Long orderid;
        private String ordercontent;
        private java.sql.Timestamp date;
        private Long restaurantid;


        public Bills ( Long orderid,
                       String ordercontent,
                       java.sql.Timestamp date,
                       Long restaurantid)
        {
            this.orderid=orderid;
            this.ordercontent=ordercontent;
            this.date=date;
            this.restaurantid=restaurantid;

        }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bid;

        public Long getOrderid() {
            return orderid;
        }

        public void setOrderid(Long orderid) {
            this.orderid = orderid;
        }

        public String getOrdercontent() {
            return ordercontent;
        }

        public void setOrdercontent(String ordercontent) {
            this.ordercontent = ordercontent;
        }

        public java.sql.Timestamp getDate() {
            return date;
        }

        public void setDate(java.sql.Timestamp date) {
            this.date = date;
        }

        public Long getRestaurantid() {
            return restaurantid;
        }

        public void setRestaurantid(Long restaurantid) {
            this.restaurantid = restaurantid;
        }

    }
