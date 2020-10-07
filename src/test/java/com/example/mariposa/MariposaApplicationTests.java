package com.example.mariposa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MariposaApplicationTests {

	@Test
	void datedLANInfoTests() {
		LANInfo test = new LANInfo(0, "");
		System.out.println(test.getContent());
	}

}
