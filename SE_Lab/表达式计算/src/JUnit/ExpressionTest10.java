package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import ���ʽ����.Expression;

public class ExpressionTest10 {

	@Test
	public void testGetExpression() {
		assertEquals("Error",new Expression().getExpression("Abc*^"));
	}

}
