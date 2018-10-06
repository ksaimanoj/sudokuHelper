package base.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import base.GridItem;

public class GridItemTest {
	
	GridItem gridItem;
	
	@Before
	public void setUp()
	{
		gridItem = new GridItem();
	}
	
	@Test
	public void initializePossibleValuesTest()
	{
		for(int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
			assertTrue(gridItem.isPossible(index));
	}
	
	@Test
	public void setValueNonZeroTest()
	{
		gridItem.setValue(3);
		
		for(int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
		{
			assertFalse(gridItem.isPossible(index));
		}
	}
	
	@Test
	public void setValueZeroTest()
	{
		gridItem.setValue(0);
		
		for(int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
		{
			assertTrue(gridItem.isPossible(index));
		}
	}
	
	@Test
	public void setPossibleValueFalseTest()
	{
		gridItem.changePossibleValue(4, false);
		
		for(int index = 0; index < 4; index++)
		{
			assertTrue(gridItem.isPossible(index));
		}
		
		assertFalse(gridItem.isPossible(4));
		
		for(int index = 4 + 1; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
		{
			assertTrue(gridItem.isPossible(index));
		}
	}
	
	@Test
	public void isValueFixedTest()
	{
		gridItem.setValue(3);
		assertTrue(gridItem.isValueKnown());
		
		gridItem.setValue(0);
		assertFalse(gridItem.isValueKnown());
	}

}
