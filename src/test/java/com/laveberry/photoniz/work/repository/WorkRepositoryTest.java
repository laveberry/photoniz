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
        //LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);

        workRepository.save(Work.builder()
                .author_id(123)
                .price(65000)
                .build());

        //when
        List<Work> workList = workRepository.findAll();

        //then
        Work work = workList.get(0);

        System.out.println("work_id = "+work.getWork_id()+" / work_flag = "+work.getWork_type()+" / price ="+work.getPrice());
        //생성일&수정일 자동등록
        System.out.println("createTime =" + work.getCreateDate() + " / getModifiedDate = " + work.getModifiedDate() );

        assertThat(work.getCreateDate()).isAfter(now);
    }

}