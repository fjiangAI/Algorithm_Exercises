package ex04_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test04_01 {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetBinSearch() {
		//这是正常的查找
		double[] arrary1={1,2,3,4,5,6,7};
		assertEquals(3, BinSearch.getBinSearch(arrary1, 0, arrary1.length-1,4));
		//这是查找边界值
		assertEquals(6, BinSearch.getBinSearch(arrary1, 0, arrary1.length-1,7));
		//这是找不到的情况
		double[] arrary2={2,4,6,8,10};
		assertEquals(-1, BinSearch.getBinSearch(arrary2, 0, arrary2.length-1,5));
	}

}
