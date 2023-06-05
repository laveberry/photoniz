package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.model.UpdateBoardModel;
import com.laveberry.photoniz.board.service.BoardService;
import com.laveberry.photoniz.common.model.BasicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public BasicResponse boardDetail(@PathVariable Integer boardId) {
        return BasicResponse.toResponse(HttpStatus.OK, boardService.findBoardDetail(boardId));
    }

    @PostMapping
    public BasicResponse createBoard(@RequestBody CreateBoardModel createBoardModel) {
        return BasicResponse.toResponse(HttpStatus.CREATED, "");
    }

    @PutMapping("/{boardId}")
    public BasicResponse updateBoard(@PathVariable Integer boardId, @RequestBody UpdateBoardModel updateBoardModel) {
        return BasicResponse.toResponse(HttpStatus.CREATED, "");
    }

    @DeleteMapping("{boardId}")
    public BasicResponse deleteBoard(@PathVariable Integer boardId) {
        return BasicResponse.toResponse(HttpStatus.OK, boardId);
    }
}
