package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.model.UpdateBoardModel;
import com.laveberry.photoniz.board.service.BoardService;
import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.photo.service.PhotoService;
import com.laveberry.photoniz.work.enums.WorkType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardController {

    private final BoardService boardService;
    private final PhotoService photoService;

    @GetMapping("/list")
    public BasicResponse boardList(@RequestParam String type, @RequestParam(defaultValue = "ALL") String mainType, @RequestParam(defaultValue = "ALL")
                                    String workType, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardListModel> boardList = boardService.findBoardList(type, mainType, workType, pageable);
        return BasicResponse.toResponse(HttpStatus.OK, boardList);
    }

    @GetMapping("/detail/{boardId}")
    public BasicResponse boardDetail(@PathVariable Integer boardId) {
        return BasicResponse.toResponse(HttpStatus.OK, boardService.findBoardDetail(boardId));
    }

    @PostMapping
    public BasicResponse createBoard(@RequestHeader("Authorization") String token
            , @RequestPart("data") CreateBoardModel createBoardModel, @RequestPart List<MultipartFile> multipartFiles) {
        Board board = boardService.createBoard(createBoardModel, token);
        if(!multipartFiles.isEmpty()){
            photoService.imgUpload(createBoardModel, multipartFiles, board);
        }
        return BasicResponse.toResponse(HttpStatus.CREATED, board.getId());
    }

    @PutMapping
    public BasicResponse updateBoard(@RequestHeader("Authorization") String token, @RequestBody @Validated UpdateBoardModel updateBoardModel) {
        Integer boardId = boardService.updateBoard(updateBoardModel, token);
        return BasicResponse.toResponse(HttpStatus.CREATED, boardId);
    }

    @DeleteMapping("{boardId}")
    public BasicResponse deleteBoard(@RequestHeader("Authorization") String token, @PathVariable Integer boardId) {
        boardService.deleteBoard(boardId, token);
        return BasicResponse.toResponse(HttpStatus.OK, boardId);
    }
}
