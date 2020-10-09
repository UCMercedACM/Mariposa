package com.example.mariposa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class LANInfoTests {

	@Test
	void allData() {
		LANInfo actual = new LANInfo(0);
		Assert.isTrue(actual.getContent().equals("placeholder for all lan party content"), "");
	}

	@Test
	void octThird() {
		LANInfo actual = new LANInfo(0, "10/3/20");
		Assert.isTrue(actual.getContent().equals("month: 10, day: 3, year: 20"), "");
	}

	@Test
	void f19() {
		LANInfo actual = new LANInfo(0, "F", 19);
		Assert.isTrue(actual.getContent().equals("F19"), "");
	}

}
