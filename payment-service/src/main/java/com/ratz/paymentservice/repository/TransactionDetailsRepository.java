package com.ratz.paymentservice.repository;

import com.ratz.paymentservice.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsRepository  extends JpaRepository<TransactionDetails, Long> {
}
