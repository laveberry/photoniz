package com.laveberry.photoniz.photo.service;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.common.util.FileUploader;
import com.laveberry.photoniz.photo.domain.Photo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService{
    FileUploader fileUploader;
    @Override
    public void imgUpload(CreateBoardModel createBoardModel, Board board) {
        for(MultipartFile file : createBoardModel.multipartFile()){
            // 변경 파일이름으로 서버 저장
            int dot = file.getName().lastIndexOf(".");
            String ext = (file.getName().toLowerCase()).substring(dot, file.getName().length());
            String reFileName = LocalDateTime.now() + UUID.randomUUID().toString() + "." + ext;

            log.info("orgin = {}, rename = {}" , file.getName(), reFileName);

            String uploadPath = fileUploader.upload(reFileName, file);

            Photo photo = Photo.builder()
                    .photoName(reFileName)
                    .photoOriginName(file.getOriginalFilename())
                    .ext(ext)
                    .photoUrl(uploadPath)
                    .photoSize(file.getSize())
                    .board(board)
                    .build();
        }
    }
}
