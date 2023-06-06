package com.laveberry.photoniz.board.enums;

import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum BoardType {
    NOTICE("NOTICE"),
    NORMAL("NORMAL"),
    QNA("Q&A");
    private final String type;

    public static BoardType getType(String type) {
        return Arrays.stream(BoardType.values())
                .filter(boardType -> Objects.equals(type, boardType.type))
                .findFirst().orElseThrow(() -> new CustomException(ExceptionType.INCORRECT_BOARD_TYPE));
    }
}
