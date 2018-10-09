package base;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class GridItemTest {
	
	GridItem gridItem;
	
	@Before
	public void setUp()
	{
		gridItem = new GridItem();
	}
	
	private void allPossibleValueMustBeFalse() {
		for(int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
		{
			assertFalse(gridItem.isPossible(index));
		}
	}
		
	private void allPossibleValuesMustBeTrue() {
		for(int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
		{
			assertTrue(gridItem.isPossible(index));
		}
	}
	
	private boolean compareArrays(int[] array1, int[] array2) {
		if(array1.length != array2.length)
			return false;
		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] != array2[i])
				return false;
		}
		return true;
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
		allPossibleValueMustBeFalse();
	}

	
	@Test
	public void setValueZeroTest()
	{
		gridItem.setValue(0);
		allPossibleValuesMustBeTrue();
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
	
	@Test
	public void compareTwoArraysTest()
	{
		int[] a = new int[9];
		int[] b = new int[9];
		Assert.assertTrue(compareArrays(a,b));
		
		int[] c = new int[3];
		Assert.assertFalse(compareArrays(a, c));
		
		a[0] = 1;
		Assert.assertFalse(compareArrays(a, b));
		
		b[0] = 1;
		Assert.assertTrue(compareArrays(a, b));
		
		int[] d = {1,2,3,7,8};
		int[] e = {1,2,4,9,7};
		Assert.assertFalse(compareArrays(d, e));
		
		int[] f = {1,2,3,4,5,6,7,8,9};
		int[] g = {1,2,3,4,5,6,7,8,9};
		Assert.assertTrue(compareArrays(f, g));
	}

	@Test
	public void getPossibleValuesTest()
	{
		// TODO: Replace the array of int(s) with ArrayList.
		int[] allValues = {1,2,3,4,5,6,7,8,9};
		Assert.assertTrue(compareArrays(allValues, gridItem.getPossibleValues()));
	}

}
