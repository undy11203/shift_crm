package com.example.crm.dao.repository;

import com.example.crm.models.Seller;
import com.example.crm.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}