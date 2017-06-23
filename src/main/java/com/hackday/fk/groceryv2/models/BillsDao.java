package com.hackday.fk.groceryv2.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 * 
 * @author netgloo
 */
@Transactional
public interface BillsDao extends CrudRepository<Bills, Long> {

  /**
   * Return the user having the passed email or null if no user is found.
   * 
   * @param bid the user email.
   */
  Bills findById(long id);

  void saveBill(Bills bill);

  void updateBill(Bills bill);

  // void deleteBillById(String orderId);

  List<Bills> findALl();

  void deleteAllBill();

  public boolean isBillExist(Bills bill);
  public Bills findByBid(Long bid);

} // class UserDao
