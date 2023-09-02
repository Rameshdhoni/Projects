/*
 * Author: Ramesh
 * interface name: OrderDetailsRepository
 * purpose:it extends predefined  JpaRepository interface and create tables using spring data jpa annotations.
*/

package com.hcl.miniproject.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.miniproject.entities.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
	// this function is used to find details by userName
	public List<OrderDetails> findByUserName(String userName);

	// this function is used to find details by date
	public List<OrderDetails> findByDate(LocalDate ld);

	//// this function is used to find total monthly sale
	@Query("select o from  OrderDetails o where  totalAmount(o. date)=year(ld)and month(o.date)=month(ld)")
	public List<OrderDetails> totalMonthlyBill();
}
