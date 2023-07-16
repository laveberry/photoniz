package com.laveberry.photoniz.photo.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.common.util.FileUploader;
import com.laveberry.photoniz.photo.domain.Photo;
import com.laveberry.photoniz.photo.enums.PhotoType;
import com.laveberry.photoniz.photo.repository.PhotoRepository;
import com.laveberry.photoniz.photoBoard.enums.MainType;
import com.laveberry.photoniz.work.enums.WorkType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final FileUploader fileUploader;

    @Override
    public void imgUpload(CreateBoardModel createBoardModel, List<MultipartFile> multipartFile, Board board) {

        for (MultipartFile file : multipartFile) {
            // 변경 파일이름으로 서버 저장
            int dot = file.getOriginalFilename().lastIndexOf(".");
            String ext = file.getOriginalFilename().substring(dot + 1);
            String reFileName = UUID.randomUUID() + "." + ext;

            log.info("orgin = {}, rename = {}", file.getName(), reFileName);

            String uploadPath = fileUploader.upload(reFileName, file);

            Photo photo = Photo.builder()
                    .photoType(PhotoType.MAIN)
                    .photoName(reFileName)
                    .photoOriginName(file.getOriginalFilename())
                    .ext(ext)
                    .photoUrl(uploadPath)
                    .photoSize(file.getSize())
                    .user(board.getUser())
                    .board(board)
                    .build();

            photoRepository.save(photo);
        }
    }
}
