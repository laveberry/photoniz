package com.laveberry.photoniz.common;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.laveberry.photoniz.common.BaseSpringBootTest.*;
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection")
@DatabaseSetup(value = {USER
}, type = DatabaseOperation.CLEAN_INSERT)
@DatabaseTearDown(value = {USER
}, type = DatabaseOperation.DELETE_ALL)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class BaseSpringBootTest {

    @Autowired
    protected MockMvc mockMvc;

    public static final String PATH = "/dbunit/common";
    public static final String USER = "classpath:dbunit/common/users.xml";

}
