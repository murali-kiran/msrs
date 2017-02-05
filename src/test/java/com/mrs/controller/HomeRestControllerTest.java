package com.mrs.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/*@RunWith(SpringJUnit4ClassRunner.class)*/
/*@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration*/
public class HomeRestControllerTest {
	/*public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	MockMvc mockMvc;
	
	@Autowired
	HomeRestController homeRestController;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(homeRestController).build();
	}
	@Test
	public void shouldFindById() throws Exception {
		mockMvc.perform(get("/rest/getEmp?empid={empid}", "1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$empid", is("1")));
		//.andExpect(jsonPath("$name", is("Doe, John")));
	}*/
}
