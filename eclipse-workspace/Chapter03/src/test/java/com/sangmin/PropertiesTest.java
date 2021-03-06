package com.sangmin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoardController.class,
			properties= {"author.name=Sangmin",
						"author.age = 26",
						"author.nation=Korea"})
public class PropertiesTest {

	@Autowired
	Environment enviroment;
	@Test
	public void testMethod() {
		System.out.println("이름 : "+enviroment.getProperty("author.name"));
		System.out.println("나이 : "+enviroment.getProperty("author.age"));
		System.out.println("국가 : "+enviroment.getProperty("author.nation"));
	}
}
