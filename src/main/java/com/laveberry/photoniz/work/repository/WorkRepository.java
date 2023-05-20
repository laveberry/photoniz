package com.laveberry.photoniz.work.repository;

import com.laveberry.photoniz.work.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity클래스, PK타입> : DB접근하게 해줌
public interface WorkRepository extends JpaRepository<Work, Integer> {

}
