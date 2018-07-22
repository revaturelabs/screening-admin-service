package com.revature.caliber.daos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.caliber.beans.Question;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionDAOTest {
	
	@Autowired
	private QuestionDAO qd;
	private static Question q;
	
	@Before
	public final void init(){
		/*
		 * Note:
		 * 	By default, data JPA tests are transactional and roll back at the end of each test
		 */
		q = new Question(1, 1, true, "How do I test JPA?", "Use integration tests",
				"Don't use unit tests", "Decorate with the @DataJpaTest annotation",
				"Use the @RunWith annotation", "Figure out another way");
		q = qd.save(q);
	}

	@Test
	public void testFindByBucketId() {
		assertTrue(qd.findByBucketId(1).contains(q) == true);
	}
}
