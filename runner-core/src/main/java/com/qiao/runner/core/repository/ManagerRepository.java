package com.qiao.runner.core.repository;

import com.qiao.runner.core.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
