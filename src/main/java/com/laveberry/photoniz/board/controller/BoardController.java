package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.model.UpdateBoardModel;
import com.laveberry.photoniz.board.service.BoardService;
import com.laveberry.photoniz.common.model.BasicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public BasicResponse boardList(@RequestParam String type, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<BoardListModel> boardList = boardService.findBoardList(type, pageable);
        return BasicResponse.toResponse(HttpStatus.OK, boardList);
    }

    @GetMapping("/detail/{boardId}")
    public BasicResponse boardDetail(@PathVariable Integer boardId) {
        return BasicResponse.toResponse(HttpStatus.OK, boardService.findBoardDetail(boardId));
    }

    @PostMapping
    public BasicResponse createBoard(@RequestHeader("Authorization") String token, @RequestBody @Validated CreateBoardModel createBoardModel) {
        return BasicResponse.toResponse(HttpStatus.CREATED, boardService.createBoard(createBoardModel, token).getId());
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
