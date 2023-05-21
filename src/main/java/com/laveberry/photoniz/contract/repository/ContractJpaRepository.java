package com.laveberry.photoniz.contract.repository;

import com.laveberry.photoniz.contract.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractJpaRepository extends JpaRepository<Contract, Integer> {
}
