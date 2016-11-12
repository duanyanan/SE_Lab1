package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import 表达式计算.Expression;

public class ExpressionTest {

	@Test
	public void testGetExpression() {
		assertEquals("abc+4*(25+ecd)^3-xyz^100",new Expression().getExpression("abc+4*(25 + ecd)^3-xyz^100"));

	}

}
