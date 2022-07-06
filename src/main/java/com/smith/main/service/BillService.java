package com.smith.main.service;

import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.smith.main.entity.Bill;
import com.smith.main.exceptions.BillNotFoundException;
import com.smith.main.exceptions.BillSaveErrorException;
import com.smith.main.repository.BillRepository;

@Service
public class BillService {

	private BillRepository billRepository;
	
	public BillService(BillRepository billRepository) {
		this.billRepository = billRepository;
	}
	
	//get
	public Bill getBillById(Long id) throws BillNotFoundException {
		Bill retrieved = billRepository.findById(id).orElseThrow(() -> new BillNotFoundException("The bill with the id: " + id + " was not found"));
		return retrieved;
	}
	
	public List<Bill> getBillsByRange(Date begin, Date end) throws BillNotFoundException{
		List<Bill> bills = billRepository.findByDateBetweenOrderByDateAsc(begin, end);
		
		return bills;
	}
	
	//add
	
	public Bill saveBill(Bill bill) throws BillSaveErrorException {
		try {
			Bill updatedBill = billRepository.save(bill);
			return updatedBill;
		}catch(Exception e) {
			throw new BillSaveErrorException("There was a problem saving the bill. \n" + e.getMessage());
		}
	}
	
	//update
	
	public Bill updateBill(Bill bill) throws BillSaveErrorException {
		try {
			Bill updatedBill = billRepository.save(bill);
			return updatedBill;
		}catch(Exception e) {
			throw new BillSaveErrorException("There was a problem updateing the bill. \n" + e.getMessage());
		}
	}
	
	//delete
	
	public String deleteBill (Long id) throws BillNotFoundException {
		try {
			Bill savedBill = this.getBillById(id);
			billRepository.delete(savedBill);
			return "The bill was deleted";
		}catch(Exception e) {
			throw new BillNotFoundException("The bill with the id: " + id + " was not found");
		}
	}

}
