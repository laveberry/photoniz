package com.laveberry.photoniz.common;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.laveberry.photoniz.common.BaseSpringBootTest.*;

@Disabled
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection")
@DatabaseSetup(value = {WORK, USER, BOARD
}, type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown(value = {WORK, USER, BOARD
}, type = DatabaseOperation.DELETE_ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class BaseSpringBootTest {

    @Autowired
    protected MockMvc mockMvc;

    public static final String PATH = "/dbunit/common";
    public static final String WORK = PATH + "/work.xml";
    public static final String USER = PATH + "/user.xml";
    public static final String BOARD = PATH + "/board.xml";

}
