package com.revature.caliber.driver;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author Dimitrei Nazi | 1803-USF-MAR26 | Wezley Singleton
 *
 *	Creating Launcher
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestDriver.class ,properties="/gambit-question-bucket-service/src/test/resources/bootstrap.yml" ,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes=Application.class)

public class TestDriver {
	
	 public static void main(String[] args){
	        new SpringApplicationBuilder()
	        .sources(TestDriver.class)
	        .run(args);
	  }
	
	@Test
	@Ignore
	public void run() {}
	
}
