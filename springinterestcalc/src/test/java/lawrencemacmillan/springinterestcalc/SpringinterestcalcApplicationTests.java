package lawrencemacmillan.springinterestcalc;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SpringinterestcalcApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
    @Autowired
    WebApplicationContext wac;
    
    @Before
    public void setup(){
    
        // Setup Spring test in webapp-mode (same config as spring-boot)
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
	@Test
    public void outputTest() throws Exception {

		mockMvc.perform(get("/submit?lumpsum=100&interestrate=8&inputYears=10"))
		.andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("userinput"))
			.andExpect(MockMvcResultMatchers.model().attributeExists("calculationObjects"));

    }

}