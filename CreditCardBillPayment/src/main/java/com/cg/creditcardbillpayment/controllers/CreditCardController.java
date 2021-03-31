package com.cg.creditcardbillpayment.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.CreditCardServiceException;
import com.cg.creditcardbillpayment.services.CreditCardService;

@RestController
@RequestMapping("/")
public class CreditCardController {
	@Autowired
	private CreditCardService creditcardService;
	/************************************************************************************
	* Method : addCreditCard
	*Description : To add the CreditCard from the Database
	* @param creditcard - creditcard to be added to the Database
	* @param RequestBody - It maps the HttpRequest body to a transfer or domain object,
	enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	* @returns CreditCard - returns creditcard
	* @throws CreditCardServiceException - It is raised when creditcard already exists in the Database
	*Created By - Peram Manogna
	*Created Date - 24-03-2021
	************************************************************************************/
	
	
	@PostMapping("/addcreditcard")
	public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditcard) {
		CreditCard resultCreditCard = creditcardService.addCreditCard(creditcard);
		return new ResponseEntity<CreditCard>(resultCreditCard, HttpStatus.OK);


	}
	/************************************************************************************
	* Method : getCreditCard
	*Description : To fetch the creditcard from the Database
	* @param creditcard - creditcard to be fetched to the Database
	* @param PathVariable - It maps the HttpRequest body to a transfer or domain object,
	enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	* @returns CreditCard - returns creditcard
	* @throws CreditCardServiceException - It is raised when creditcard already exists in the Database
	*Created By - Peram Manogna
	*Created Date - 24-03-2021
	************************************************************************************/
	
	@GetMapping("/getcreditcard/{id}")
	public ResponseEntity<CreditCard> getCreditCard(@PathVariable long id) {
		CreditCard creditcard= creditcardService.getCreditCard(id);
		return new ResponseEntity<CreditCard>(creditcard,HttpStatus.OK);

	}
	/************************************************************************************
	* Method : deleteCreditCard
	*Description : To delete the creditcard from the Database
	* @param creditcard - creditcard to be added to the Database
	* @param PathVariable - It maps the HttpRequest body to a transfer or domain object,
	enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	* @returns CreditCard - returns creditcard
	* @throws CreditCardServiceException - It is raised when creditcard already exists in the Database
	*Created By - Peram Manogna
	*Created Date - 24-03-2021
	************************************************************************************/

	
	@DeleteMapping("/deletecreditcard/{id}") 
	public void deleteCreditCard(@PathVariable long id){
		creditcardService.removeCreditCard(id);
		
	}
	/************************************************************************************
	* Method : updateCreditCard
	*Description : To update the CreditCard from the Database
	* @param creditcard - creditcard to be updated to the Database
	* @param RequestBody - It maps the HttpRequest body to a transfer or domain object,
	enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	* @returns CreditCard - returns creditcard
	* @throws CreditCardServiceException - It is raised when creditcard already exists in the Database
	*Created By - Peram Manogna
	*Created Date - 24-03-2021
	************************************************************************************/
	
	
	@PutMapping("/updatecreditcard")
	public ResponseEntity<CreditCard> updateCreditCard(@RequestBody CreditCard creditcard) {
		CreditCard resultcreditCard = creditcardService.updateCreditCard(creditcard.getCardId(),creditcard);
		return new ResponseEntity<CreditCard>(resultcreditCard, HttpStatus.OK);
	}
	/************************************************************************************
	* Method : getAllCreditCard
	*Description : To fetchAll the creditcard from the Database
	* @param creditcard - creditcard to be fetched to the Database
	* @param PathVariable - It maps the HttpRequest body to a transfer or domain object,
	enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
	* @returns CreditCard - returns creditcard
	* @throws CreditCardServiceException - It is raised when creditcard already exists in the Database
	*Created By - Peram Manogna
	*Created Date - 24-03-2021
	************************************************************************************/
	
	
	@GetMapping("/getallcreditcards")
	public ResponseEntity<List<CreditCard>> getAllCreditCards() {
		List<CreditCard> creditcards= creditcardService.getAllCreditCards();
		return new  ResponseEntity<List<CreditCard>>(creditcards,HttpStatus.OK);

	
	}
	

}
