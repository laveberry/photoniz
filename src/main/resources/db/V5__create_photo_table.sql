CREATE TABLE PHOTO (
    PHOTO_ID INT NOT NULL AUTO_INCREMENT,
    USER_ID INT NOT NULL,
    BOARD_ID INT NOT NULL,
    WORK_ID INT,
    PHOTO_NAME VARCHAR(255) NOT NULL,
    PHOTO_ORIGIN_NAME VARCHAR(255) NOT NULL,
    PHOTO_URL VARCHAR(255) NOT NULL,
    EXT VARCHAR(3) NOT NULL COMMENT '확장자',
    PHOTO_SIZE BIGINT NOT NULL,
    CREATED_AT DATETIME COMMENT '생성일',
    UPDATED_AT DATETIME COMMENT '수정일',
    PHOTO_TYPE VARCHAR(100),
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (WORK_ID) REFERENCES WORK(WORK_ID),
    PRIMARY KEY(PHOTO_ID)
);
