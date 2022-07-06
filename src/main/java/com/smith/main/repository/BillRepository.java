package com.smith.main.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smith.main.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	public List<Bill> findByDateBetweenOrderByDateAsc(Date begin, Date end);

}
