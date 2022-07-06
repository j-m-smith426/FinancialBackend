package com.smith.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smith.main.entity.Bill;
import com.smith.main.entity.DurationProxy;
import com.smith.main.exceptions.BillNotFoundException;
import com.smith.main.exceptions.BillSaveErrorException;
import com.smith.main.service.BillService;

@RestController
@CrossOrigin
public class BillController {
	
	private BillService billService;

	public BillController(BillService billService) {
		this.billService = billService;
	}
		//Get
		@GetMapping("/{id}")
		public ResponseEntity<Bill> getBill(@PathVariable Long id) throws BillNotFoundException{
			
				Bill retrieved = billService.getBillById(id);
				
				return new ResponseEntity<Bill>(retrieved, HttpStatus.OK);
			 
		}
		
		//Get All
		@PostMapping("/duration")
		public ResponseEntity<List<Bill>> getBillsFromPeriod(@RequestBody DurationProxy proxy) throws BillNotFoundException{
			List<Bill> retrieved;
			System.out.println(proxy);
			
				retrieved = billService.getBillsByRange(proxy.getBegin(), proxy.getEnd());
				System.out.println(retrieved);
				return new ResponseEntity<List<Bill>>(retrieved, HttpStatus.OK);
			
		}
		
		//Save
		@PostMapping("/save")
		public ResponseEntity<Bill> saveBill(@RequestBody Bill bill){
			System.out.print(bill);
			Bill saved;
			try {
				saved = billService.saveBill(bill);
				return new ResponseEntity<Bill>(saved, HttpStatus.OK);
			} catch (BillSaveErrorException e) {
				return new ResponseEntity<Bill>(HttpStatus.BAD_REQUEST);
			}
		}
		
		//Update
		@PutMapping("/update")
		public ResponseEntity<Bill> updateBill(@RequestBody Bill bill){
			Bill saved;
			try {
				saved = billService.updateBill(bill);
				return new ResponseEntity<Bill>(saved, HttpStatus.OK);
			} catch (BillSaveErrorException e) {
				return new ResponseEntity<Bill>(HttpStatus.BAD_REQUEST);
			}
		}
		
		//Delete
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteBill(@PathVariable Long id){
			try {
				String retrieved = billService.deleteBill(id);
				
				return new ResponseEntity<String>(retrieved, HttpStatus.OK);
			} catch (BillNotFoundException e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} 
		}

}
