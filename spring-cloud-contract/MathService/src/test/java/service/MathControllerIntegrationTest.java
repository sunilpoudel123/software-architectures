package service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.acme:evenoddService:+:stubs:8906")
public class MathControllerIntegrationTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void given_WhenPassEvenNumberInQueryParam_ThenReturnEven() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/calculate").param("number1", "2")
							.param("number2", "4")
	          .contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk())
	          .andExpect(content().string("Even"));
	    }

	    @Test
	    public void given_WhenPassOddNumberInQueryParam_ThenReturnOdd() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/calculate").param("number1", "1")
							.param("number2", "3")
	          .contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk())
	          .andExpect(content().string("Odd"));
	    }
}
