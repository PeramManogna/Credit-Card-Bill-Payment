package com.cg.creditcardbillpayment.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpayment.dao.CreditCardRepository;
import com.cg.creditcardbillpayment.entities.CreditCard;
import com.cg.creditcardbillpayment.exceptions.CreditCardServiceException;
/************************************************************************************
 *          @author          Peram Manogna
 *          Description      It is a service class that provides the services to add a transaction, remove a transaction,
                             update a transaction and view a transaction          
  *         Version          1.0
  *         Created Date     24-03-2021
 ************************************************************************************/

@Service
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	private CreditCardRepository creditcardRepository; 
	
	/************************************************************************************
	 * Method:                         		 :addCreditCard
     *Description:							 :To add the creditcard to the Database
	 * @param CreditCard       			     - creditcard to be added to the Database
	 * @returns CreditCard                 	 - returns creditcard after adding the account to DataBase
	 * @throws  CreditCardException			 - It is raised when creditcard already exists in Database
     *Created By                             - Peram Manogna
     *Created Date                           - 24-03-2021                           
	 
	 ************************************************************************************/


	@Override
	public CreditCard addCreditCard(CreditCard creditcard) {
		// TODO Auto-generated method stub
		CreditCard newCreditCard;
		Optional<CreditCard> resultcreditcard=creditcardRepository.findById(creditcard.getCardId());	
		if(resultcreditcard.isEmpty()) {newCreditCard=creditcardRepository.saveAndFlush(creditcard);
		}
		else {throw new CreditCardServiceException("CreditCard already exist");}
		return newCreditCard;
	}
	/************************************************************************************
	 * Method:                         		 :removeCreditCard
     *Description:							 :To remove the creditcard to the Database
	 * @param CreditCard       			     - creditcard to be added to the Database
	 * @returns CreditCard                 	 - returns void
	 * @throws  CreditCardException			 - It is raised when creditcard does not exists in Database
     *Created By                             - Peram Manogna
     *Created Date                           - 24-03-2021                           
	 
	 ************************************************************************************/


	@Override
	public void removeCreditCard(long cardId) throws CreditCardServiceException {
		// TODO Auto-generated method stub
		Optional<CreditCard> creditcard=creditcardRepository.findById(cardId);
		if(creditcard.isEmpty())throw new CreditCardServiceException("Card does not exist to delete");
		
		else
			creditcardRepository.delete(creditcard.get());
		
	}

	/************************************************************************************
	 * Method:                         		 :findCreditCard
     *Description:							 :To fetch the creditcard to the Database
	 * @param CreditCard       			     - creditcard to be fetch to the Database
	 * @returns CreditCard                 	 - returns creditcard
	 * @throws  CreditCardException			 - It is raised when creditcard does not exists in Database
     *Created By                             - Peram Manogna
     *Created Date                           - 24-03-2021                           
	 
	 ************************************************************************************/

	

	@Override
	public CreditCard getCreditCard(long cardId) throws CreditCardServiceException  {
		// TODO Auto-generated method stub
		Optional<CreditCard> creditcard = creditcardRepository.findById(cardId);
		if(!creditcard.isEmpty())
		    return creditcard.get();
		else
			throw new CreditCardServiceException("Given refNo does not exist");
	}
	/************************************************************************************
	 * Method:                         		 :getAllCreditCard
     *Description:							 :To fetchAll the creditcard to the Database
	 * @param CreditCard       			     - creditcard to be fetchAll to the Database
	 * @returns CreditCard                 	 - returns creditcard
	 * @throws  CreditCardException			 - It is raised when creditcard does not exists in Database
     *Created By                             - Peram Manogna
     *Created Date                           - 24-03-2021                           
	 
	 ************************************************************************************/


	@Override
	public List<CreditCard> getAllCreditCards() {
		// TODO Auto-generated method stub
		return creditcardRepository.findAll();

	}
	/************************************************************************************
	 * Method:                         		 :updateCreditCard
     *Description:							 :To update the creditcard to the Database
	 * @param CreditCard       			     - creditcard to be updated to the Database
	 * @returns CreditCard                 	 - returns creditcard 
	 * @throws  CreditCardException			 - It is raised when creditcard does not exists in Database
     *Created By                             - Peram Manogna
     *Created Date                           - 24-03-2021                           
	 
	 ************************************************************************************/


	@Override
	public CreditCard updateCreditCard(long cardId, CreditCard creditcard) throws CreditCardServiceException {
		// TODO Auto-generated method stub
		Optional<CreditCard>creditcard1=creditcardRepository.findById(cardId);
		if(!creditcard1.isEmpty())
		{
		return  creditcardRepository.save(creditcard);
		}
		else
			throw new CreditCardServiceException("Card Doesnot Exist");

}
}
