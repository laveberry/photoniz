package com.laveberry.photoniz.board.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BoardType {
    NOTICE("NOTICE"),
    NORMAL("NORMAL"),
    QNA("Q&A");
    private final String name;
}
