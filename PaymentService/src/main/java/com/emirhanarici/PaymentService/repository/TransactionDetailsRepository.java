package com.emirhanarici.PaymentService.repository;

import com.emirhanarici.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

    Optional<TransactionDetails> findByOrderId(long orderId);
}
