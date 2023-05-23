package com.laveberry.photoniz.work.service;

import com.laveberry.photoniz.work.dto.WorkSaveRequestDto;
import com.laveberry.photoniz.work.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor //@Autowired
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    @Transactional
    public Integer save(WorkSaveRequestDto requestDto) {
        return workRepository.save(requestDto.toEntity()).getWork_id();
    }

}
