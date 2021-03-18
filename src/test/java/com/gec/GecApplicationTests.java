package com.gec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.gec.GecApplication;

@SpringBootTest(classes=GecApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
class GecApplicationTests {

	@Test
	void contextLoads() {
	} 

}
