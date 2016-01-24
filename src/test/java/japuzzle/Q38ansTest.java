package japuzzle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import japuzzle.Q38ans.SegNum;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Q38ansTest {

	private Q38ans q38ans;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		q38ans = new Q38ans();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculatePoint_1_2() {
		int actual = q38ans.calculatePoint(Arrays.asList(SegNum.ONE, SegNum.TWO));
		assertThat(actual, is(5));
	}
	
	@Test
	public void testCalculatePoint_0_1_2() {
		int actual = q38ans.calculatePoint(Arrays.asList(SegNum.ZERO, SegNum.ONE, SegNum.TWO));
		assertThat(actual, is(9));
	}


}
