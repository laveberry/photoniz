package com.laveberry.photoniz.photoBoard.controller;

import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.photoBoard.model.PhotoBoardListModel;
import com.laveberry.photoniz.photoBoard.model.CreatePhotoBoardModel;
import com.laveberry.photoniz.photoBoard.model.UpdatePhotoBoardModel;
import com.laveberry.photoniz.photoBoard.service.PhotoBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/photoBoard")
public class PhotoBoardController {

    private final PhotoBoardService photoBoardService;

    @GetMapping("/list")
    public BasicResponse photoBoardList(@RequestParam String type, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<PhotoBoardListModel> boardList = photoBoardService.findPhotoBoardList(type, pageable);
        return BasicResponse.toResponse(HttpStatus.OK, boardList);
    }

    @GetMapping("/detail/{boardId}")
    public BasicResponse boardDetail(@PathVariable Integer boardId) {
        return BasicResponse.toResponse(HttpStatus.OK, photoBoardService.findBoardDetail(boardId));
    }

    @PostMapping
    public BasicResponse createBoard(@RequestHeader("Authorization") String token, @RequestBody CreatePhotoBoardModel createBoardModel) {
        return BasicResponse.toResponse(HttpStatus.CREATED, photoBoardService.createBoard(createBoardModel, token).getId());
    }

    @PutMapping
    public BasicResponse updateBoard(@RequestHeader("Authorization") String token, @RequestBody UpdatePhotoBoardModel updatePhotoBoardModel) {
        Integer boardId = photoBoardService.updateBoard(updatePhotoBoardModel, token);
        return BasicResponse.toResponse(HttpStatus.CREATED, boardId);
    }

    @DeleteMapping("{boardId}")
    public BasicResponse deleteBoard(@RequestHeader("Authorization") String token, @PathVariable Integer boardId) {
        photoBoardService.deleteBoard(boardId, token);
        return BasicResponse.toResponse(HttpStatus.OK, boardId);
    }
}
