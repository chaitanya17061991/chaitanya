package com.spring.accumulator;



import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpringAccumulatorTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none(); 
	
	@Test
	public void testEmptyString() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("");
		Assert.assertEquals(0, result);
	}
	@Test
	public void testBasicStringWithTwoNumbers() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("1,2");
		Assert.assertEquals(3, result);
	}
	@Test
	public void testBasicStringWithOneNumbers() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("1");
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void testBasicStringWithUnknownAmountOfNumbers() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("1,2,4,5,8,9,22");
		Assert.assertEquals(51, result);
	}
	
	@Test
	public void testBasicStringWithValidNewLine() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("1\n2,3");
		Assert.assertEquals(6, result);
	}
	
	@Test
	public void testBasicStringWithInValidNewLine() {
		SpringAccumulator acc = new SpringAccumulator();
		exception.expect(Exception.class);
		int result = acc.add("1,\n");
	}
	
	@Test
	public void testBasicStringWithUserDefinedDelimiter() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("//;\n1,2\n3;4");
		Assert.assertEquals(10, result);
	}
	
	@Test
	public void testBasicStringWithNegativeNumbers() {
		SpringAccumulator acc = new SpringAccumulator();
		exception.expect(Exception.class);
		exception.expectMessage("Negative Numbers are not allowed : -3,-4,");
		int result = acc.add("1,2,-3\n-4");
		
	}
	@Test
	public void testBasicStringWithBiggerThanThousand() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("1,2,1002\n4");
		Assert.assertEquals(7, result);
	}
	
	@Test
	public void testBasicStringWithDelimitersOfAnyLength() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("//****\n1****2****3");
		Assert.assertEquals(6, result);
	}
	@Test
	public void testBasicStringWithMultipleDelimiter() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("//*|%\n1*2%3");
		Assert.assertEquals(6, result);
	}
	@Test
	public void testBasicStringWithMultipleDelimitersLongerThanOneCharacter() {
		SpringAccumulator acc = new SpringAccumulator();
		int result = acc.add("//****|abcd\n1****2abcd3");
		Assert.assertEquals(6, result);
	}
	
	
}
