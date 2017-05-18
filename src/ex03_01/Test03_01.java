package ex03_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test03_01 {
	public GCD gcd=new GCD();
	@Before
	public void setUp() throws Exception {}

	@Test
	public void testGetGCD(){
		//这是正常案例使用
		assertEquals(10,gcd.getGCD(20, 10));
		//这是前一个数比后一个数小
		assertEquals(12,gcd.getGCD(24, 36));
		//这是有负数的情况
		assertEquals(-1,gcd.getGCD(-20, 36));
	}

}
