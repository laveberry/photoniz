package com.laveberry.photoniz.work.repository;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.work.domain.Work;
import com.laveberry.photoniz.work.enums.WorkType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("작업 레포지토리")
class WorkRepositoryTest extends BaseSpringBootTest {

    @Autowired
    private WorkRepository workRepository;

    @AfterEach
    public void cleanup() {
        workRepository.deleteAll();
    }

    @Test
    public void WorkEntity_등록() {
        LocalDateTime now = LocalDateTime.now();
        //LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);

        workRepository.save(Work.builder()
                .author_id(123)
                .work_type(String.valueOf(WorkType.PERSONAL))
                .price(65000)
                .build());

        //when
        List<Work> workList = workRepository.findAll();

        //then
        Work resultWork = workList.stream().filter(work -> work.getAuthor_id() == 123).findFirst().get();

        System.out.println("work_id = " + resultWork.getWork_id() + " / work_flag = " + resultWork.getWork_type() + " / price =" + resultWork.getPrice());
        //생성일&수정일 자동등록
        System.out.println("createTime =" + resultWork.getCreateDate() + " / getModifiedDate = " + resultWork.getModifiedDate());

        assertThat(resultWork.getCreateDate()).isAfter(now);
    }

    @Test
    @DisplayName("작업 찾기")
    void findWork() {
        List<Work> works = workRepository.findAll();
        assertThat(works.get(0).getWork_type()).isEqualTo("PHOTO");
    }

}