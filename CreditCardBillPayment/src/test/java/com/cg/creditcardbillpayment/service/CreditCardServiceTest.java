package com.cg.creditcardbillpayment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.CreditCardServiceException;
import com.cg.creditcardbillpayment.services.CreditCardService;
/************************************************************************************
 *          @author          Peram Manogna
 *          Description      It is a service class that provides the testcases to test the CreditCardService class
                                        
  *         Version           1.0
  *         Created Date    22-03-2021
 ************************************************************************************/


@SpringBootTest
public class CreditCardServiceTest {
	
	@Autowired
	private CreditCardService creditcardservice;
	
	CreditCard creditcard=new CreditCard(1L,"A","U","Manogna","vtu9438",LocalDate.parse("2021-03-12"),4);
	CreditCard creditcard1=new CreditCard(29L,"B","V","Manogna","vtu9438",LocalDate.parse("2021-03-12"),4);
	CreditCard creditcard2=new CreditCard(23L,"B","V","Manogna","vtu9438",LocalDate.parse("2021-03-12"),4);
	@Test
	void AddTest() {
		
		assertThrows(CreditCardServiceException.class,()->{
			creditcardservice.addCreditCard(creditcard);
		});
		
	}
	@Test
	void getTest1() {
		assertEquals("B",creditcardservice.getCreditCard(29L).getBankName());
	}
	@Test
	void getTest2() {
		assertEquals(LocalDate.parse("2021-03-12"),creditcardservice.getCreditCard(29L).getCardExpiry());

	}
	@Test
	void updateTest() {
		creditcardservice.updateCreditCard(29L, creditcard);
		assertEquals("Manogna",creditcardservice.getCreditCard(29L).getCardName());
		
	}
	@Test
	void updateTest1() {
		
		assertThrows(CreditCardServiceException.class,()->{
			creditcardservice.updateCreditCard(2976578L, creditcard1).getCardName();
		});
	}
	@Test

	void deleteTest() {
		assertThrows(CreditCardServiceException.class,()->{
			creditcardservice.removeCreditCard(23L);;
		});


	}

}
