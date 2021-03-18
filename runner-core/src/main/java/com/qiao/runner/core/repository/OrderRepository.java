package com.qiao.runner.core.repository;

import com.qiao.runner.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
