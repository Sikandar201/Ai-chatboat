package com.example.devops_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"gemini.api.key=test-key",

})
class DevopsProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
