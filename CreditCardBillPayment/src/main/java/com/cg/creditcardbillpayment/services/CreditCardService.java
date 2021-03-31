package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.CreditCardServiceException;

public interface CreditCardService {
	public CreditCard addCreditCard(CreditCard creditCard);

	public void removeCreditCard(long cardId);

	public CreditCard updateCreditCard(long cardId, CreditCard card);

	public CreditCard getCreditCard(long cardId)  ;

	public List<CreditCard> getAllCreditCards();

}
