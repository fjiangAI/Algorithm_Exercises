package ex03_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test03_02 {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetMax() {
		//这是正常情况
		double[] array1={0,1,2,3,4,5,6};
		assertEquals(6,Max.getMax(0, array1));
		//这是如果有相同大小的情况，结果是下标取最右边的。
		double[] array2={0,1,7,7,7,5,6};
		assertEquals(4,Max.getMax(0, array2));
		//这是起始坐标为负值
		double[] array3={0,1,7,7,7,5,6};
		assertEquals(-1,Max.getMax(-1, array3));
		//这是数组为空
		double[] array4={};
		assertEquals(-1,Max.getMax(0, array4));
	}

}
