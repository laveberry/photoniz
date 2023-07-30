package com.laveberry.photoniz.board.controller;

import com.laveberry.photoniz.board.domain.Board;
import com.laveberry.photoniz.board.model.BoardListModel;
import com.laveberry.photoniz.board.model.CreateBoardModel;
import com.laveberry.photoniz.board.model.UpdateBoardModel;
import com.laveberry.photoniz.board.service.BoardService;
import com.laveberry.photoniz.common.model.BasicResponse;
import com.laveberry.photoniz.photo.service.PhotoService;
import com.laveberry.photoniz.work.enums.WorkType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "Authorization")
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardController {

    private final BoardService boardService;
    private final PhotoService photoService;

    @Operation(summary = "게시판 리스트 조회", description = "게시판 리스트를 조회 합니다.", tags = {"Board Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @GetMapping("/list")
    public BasicResponse boardList(@RequestParam String type, @RequestParam(defaultValue = "ALL") String mainType, @RequestParam(defaultValue = "ALL")
                                    String workType, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<BoardListModel> boardList = boardService.findBoardList(type, mainType, workType, pageable);
        return BasicResponse.toResponse(HttpStatus.OK, boardList);
    }

    @Operation(summary = "게시물 상세 조회", description = "게시물 상세 내용을 조회 합니다.", tags = {"Board Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @GetMapping("/detail/{boardId}")
    public BasicResponse boardDetail(@PathVariable Integer boardId) {
        return BasicResponse.toResponse(HttpStatus.OK, boardService.findBoardDetail(boardId));
    }

    @Operation(summary = "게시물 생성", description = "게시물 생성 합니다.",
            tags = {"Board Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @PostMapping
    public BasicResponse createBoard(@RequestHeader("Authorization") String token
            , @RequestPart("data") CreateBoardModel createBoardModel, @RequestPart List<MultipartFile> multipartFiles) {
        Board board = boardService.createBoard(createBoardModel, token);
        if(!multipartFiles.isEmpty()){
            photoService.imgUpload(createBoardModel, multipartFiles, board);
        }
        return BasicResponse.toResponse(HttpStatus.CREATED, board.getId());
    }

    @Operation(summary = "게시물 수정", description = "게시물 내용을 수정 합니다.", tags = {"Board Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @PutMapping
    public BasicResponse updateBoard(@RequestHeader("Authorization") String token, @RequestBody @Validated UpdateBoardModel updateBoardModel) {
        Integer boardId = boardService.updateBoard(updateBoardModel, token);
        return BasicResponse.toResponse(HttpStatus.CREATED, boardId);
    }

    @Operation(summary = "게시물 삭제", description = "게시물을 삭제합니다.", tags = {"Board Controller"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = BasicResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR"),
    })
    @DeleteMapping("{boardId}")
    public BasicResponse deleteBoard(@RequestHeader("Authorization") String token, @PathVariable Integer boardId) {
        boardService.deleteBoard(boardId, token);
        return BasicResponse.toResponse(HttpStatus.OK, boardId);
    }
}
