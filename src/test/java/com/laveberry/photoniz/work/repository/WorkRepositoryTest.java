package com.laveberry.photoniz.work.repository;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.work.domain.Work;
import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class WorkRepositoryTest extends BaseSpringBootTest {

    @Autowired
    private WorkRepository workRepository;

    @AfterEach
    public void cleanup(){
        workRepository.deleteAll();
    }

    @Test
    public void WorkEntity_등록(){
        LocalDateTime now = LocalDateTime.now();
        workRepository.save(Work.builder()
                .work_profile_id(777)
                .author_id(123)
                .customer_id(1004)
                .work_state(2)
                .work_flag(1)
                .price(65000)
                .build());

        //when
        List<Work> workList = workRepository.findAll();

        //then
        Work work = workList.get(0);

        System.out.println("work_id = "+work.getWork_id()+" / work_flag = "+work.getWork_flag()+" / price ="+work.getPrice());

        assertThat(work.getWork_time()).isAfter(now);

        System.out.println("work_time = "+work.getWork_time());

    }

}