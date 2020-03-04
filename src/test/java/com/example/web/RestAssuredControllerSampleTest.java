package com.example.web;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.DemoApplication;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestAssuredControllerSampleTest {

	private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext context;
     
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

	
	
	@Test
	public void test2() throws InterruptedException {
		given()	   
	    .when()
	    .get("/todo/1")
	    .then()
	    .statusCode(HttpServletResponse.SC_OK).
        contentType("application/json");
//        body(equalTo("Hello world!"));
	}
}
