CREATE TABLE FILES (
    FILE_ID INT NOT NULL AUTO_INCREMENT,
    USER_ID INT NOT NULL,
    BOARD_ID INT NOT NULL,
    FILE_NAME VARCHAR(255) NOT NULL,
    FILE_ORIGIN_NAME VARCHAR(255) NOT NULL,
    PHOTO_URL VARCHAR(255) NULL,
    EXT VARCHAR(3) NOT NULL COMMENT '확장자',
    FILE_SIZE BIGINT NOT NULL,
    CREATED_AT DATETIME COMMENT '생성일',
    UPDATED_AT DATETIME COMMENT '수정일',
    FILE_TYPE VARCHAR(100),
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (BOARD_ID) REFERENCES BOARD(BOARD_ID),
    PRIMARY KEY(FILE_ID)
);