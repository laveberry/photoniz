CREATE TABLE CONTRACT (
    CONTRACT_ID INT AUTO_INCREMENT PRIMARY KEY,
    USER_ID INT NOT NULL,
    WORK_ID INT NOT NULL,
    WORK_PROGRESS TINYINT(1),
    CREATED_AT DATETIME,
    UPDATED_AT DATETIME,
    START_DATE DATETIME,
    END_DATE DATETIME,
    FOREIGN KEY (WORK_ID) REFERENCES WORK(WORK_ID),
    FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);