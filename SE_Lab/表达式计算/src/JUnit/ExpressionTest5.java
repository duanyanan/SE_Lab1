package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ���ʽ����.Expression;

public class ExpressionTest5 {

	@Test
	public void testGetExpression() {
		assertEquals("Error",new Expression().getExpression("1#25"));
	}

}
