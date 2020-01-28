package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
	private Stack<Object> stack;
	private String testElement;

	@Before
	public void setUp() throws Exception {
		//stack = new Stack<Object>();
		testElement = "test element";
	}

	/**
	 * Test on push method.
	 */
	@Test
	public void testPush() {
		stack.push(testElement);
		Assert.assertEquals(testElement, stack.top());
	}

	/**
	 * Test on pop/remove method.
	 */
	@Test
	public void testPop() {
		stack.push(testElement);
		Assert.assertEquals(testElement, stack.remove());
	}

	/**
	 * Test on top method.
	 */
	@Test
	public void testTop() {
		stack.push(testElement);
		Assert.assertEquals(testElement, stack.top());
	}

}