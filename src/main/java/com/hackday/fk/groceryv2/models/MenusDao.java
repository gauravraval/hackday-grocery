package com.hackday.fk.groceryv2.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by gaurav.raval on 23/06/17.
 */
@Transactional
public interface MenusDao extends CrudRepository<Menus, Long> {

    public Menus findBymenuId(Long menuId);

}
