package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import 表达式计算.Expression;

public class ExpressionTest3 {

	@Test
	public void testGetExpression() {
		assertEquals("Error",new Expression().getExpression("a~b!c"));
	}

}
