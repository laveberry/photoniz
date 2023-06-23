package com.laveberry.photoniz.work.repository;

import com.laveberry.photoniz.common.BaseSpringBootTest;
import com.laveberry.photoniz.contract.model.Contract;
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
    void WorkEntity_등록() {
        LocalDateTime now = LocalDateTime.now();
        //LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);

        workRepository.save(Work.builder()
                .authorId(123)
                .workType(String.valueOf(WorkType.PERSONAL))
                .price(65000)
                .build());

        //when
        List<Work> workList = workRepository.findAll();

        //then
        Work resultWork = workList.stream().filter(work -> work.getAuthorId() == 123).findFirst().get();

        System.out.println("work_id = " + resultWork.getId() + " / work_flag = " + resultWork.getWorkType() + " / price =" + resultWork.getPrice());
        //생성일&수정일 자동등록
        System.out.println("createTime =" + resultWork.getCreateDate() + " / getModifiedDate = " + resultWork.getModifiedDate());

        assertThat(resultWork.getCreateDate()).isAfter(now);


        Work work = workList.get(0);

        // FIXME 테스트는 print문 보단 assertThat 등으로 검증하는것이 좋음
        System.out.println("work_id = "+work.getId()+" / work_flag = "+work.getWorkType()+" / price ="+work.getPrice());
        //생성일&수정일 자동등록
        System.out.println("createTime =" + work.getCreateDate() + " / getModifiedDate = " + work.getModifiedDate() );


        //계약 추가
        Contract contract = Contract.builder()
                .user_id(1004)
                .work(work)
                .work_progress(1)
                .start_date(work.getCreateDate())
                .build();

        Work work2 = contract.getWork();

        assertThat(work2).isEqualTo(work);
        assertThat(contract.getUser_id()).isEqualTo(1004);

        // FIXME 테스트는 print문 보단 assertThat 등으로 검증하는것이 좋음
        System.out.println("1004 -> " + contract.getUser_id());
        System.out.println("getWork   ->   " + contract.getWork().getWorkType());
    }

    @Test
    @DisplayName("작업 찾기")
    void findWork() {
        List<Work> works = workRepository.findAll();
        assertThat(works.get(0).getWorkType()).isEqualTo("PHOTO");
    }

}