package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SumDistancesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testLandingPage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}

	@Test
	void testDistanceSummationWhenNoUnitsSpecified() throws Exception {
		this.mockMvc.perform(get("/distance/5/5"))
				.andExpect(status().isOk())
				.andExpect(content().string("5,00 meters + 5,00 meters = 10,00 meters!"));
	}

	@Test
	void testDistanceSummationResultIsYards() throws Exception {
		this.mockMvc.perform(get("/distance/5/5?isYardsResult=true"))
				.andExpect(status().isOk())
				.andExpect(content().string("5,00 meters + 5,00 meters = 10,94 yards!"));
	}

	@Test
	void testDistanceSummationEverythingIsYards() throws Exception  {
		this.mockMvc.perform(get("/distance/5/5?isYardsUnit1=true&isYardsUnit2=true&isYardsResult=true"))
				.andExpect(status().isOk())
				.andExpect(content().string("5,00 yards + 5,00 yards = 10,00 yards!"));
	}

}
