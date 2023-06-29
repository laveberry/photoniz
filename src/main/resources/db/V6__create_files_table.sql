CREATE TABLE FILES (
    FILE_ID INT NOT NULL AUTO_INCREMENT,
    FILE_NAME VARCHAR(255) NOT NULL,
    FILE_ORIGIN_NAME VARCHAR(255) NOT NULL,
    FILE_SIZE BIGINT NOT NULL,
    IS_IMAGE TINYINT NOT NULL DEFAULT 0,
    FILE_TYPE VARCHAR(50),
    CREATED_AT DATETIME COMMENT '생성일',
    UPDATED_AT DATETIME COMMENT '수정일',
    USER_ID INT NOT NULL,
    BOARD_ID INT NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (BOARD_ID) REFERENCES BOARD(BOARD_ID),
    PRIMARY KEY(FILE_ID)
);
