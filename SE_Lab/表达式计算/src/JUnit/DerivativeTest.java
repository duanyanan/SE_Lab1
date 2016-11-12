package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import 表达式计算.Expression;

public class DerivativeTest {
	private Expression expression;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		expression = new Expression();
		String finalResult = expression.getExpression("1*a+2*a^2+3*(a+b)+4*(c+d)+5*(a^6+4)+6");
		System.out.println(finalResult);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCommand() {
		assertEquals("4+4*a+0*(c+d)+5*(6*a^5+0)",expression.Command("!d/da"));
	}

}
