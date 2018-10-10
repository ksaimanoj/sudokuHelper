package base;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class GridItemTest {

	GridItem gridItem;

	@Before
	public void setUp() {
		gridItem = new GridItem();
	}

	private void allPossibleValueMustBeFalse() {
		for (int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++) {
			assertFalse(gridItem.isPossible(index));
		}
	}

	private void allPossibleValuesMustBeTrue() {
		for (int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++) {
			assertTrue(gridItem.isPossible(index));
		}
	}

	private boolean compareLists(List<Integer> list1, List<Integer> list2) {
		if (list1.size() != list2.size())
			return false;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != list2.get(i))
				return false;
		}
		return true;
	}

	private List<Integer> getFullList(int startIndex) {
		List<Integer> fullList = new ArrayList<>();
		for (int i = 0; i < GridItem.MAXIMUM_POSSIBLE_VALUE; i++)
			fullList.add(i + startIndex);
		return fullList;
	}

	@Test
	public void initializePossibleValuesTest() {
		for (int index = 0; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++)
			assertTrue(gridItem.isPossible(index));
	}

	@Test
	public void setValueNonZeroTest() {
		gridItem.setValue(3);
		allPossibleValueMustBeFalse();
	}

	@Test
	public void setValueZeroTest() {
		gridItem.setValue(0);
		allPossibleValuesMustBeTrue();
	}

	@Test
	public void setPossibleValueFalseTest() {
		gridItem.changePossibleValue(4, false);

		for (int index = 0; index < 4 - 1; index++) {
			assertTrue(gridItem.isPossible(index));
		}

		assertFalse(gridItem.isPossible(4 - 1));

		for (int index = 4; index < GridItem.MAXIMUM_POSSIBLE_VALUE; index++) {
			assertTrue(gridItem.isPossible(index));
		}
	}

	@Test
	public void isValueFixedTest() {
		gridItem.setValue(3);
		assertTrue(gridItem.isValueKnown());

		gridItem.setValue(0);
		assertFalse(gridItem.isValueKnown());
	}

	@Test
	public void compareTwoArraysTest() {
		List<Integer> emptyList1 = new ArrayList<>();
		List<Integer> emptyList2 = new ArrayList<>();
		Assert.assertTrue(compareLists(emptyList1, emptyList2));

		List<Integer> nonEmptyList1 = new ArrayList<>();
		nonEmptyList1.add(1);
		Assert.assertFalse(compareLists(emptyList1, nonEmptyList1));

		List<Integer> nonEmptyList2 = new ArrayList<>();
		nonEmptyList2.add(1);
		Assert.assertTrue(compareLists(nonEmptyList1, nonEmptyList2));

		List<Integer> nonEmptyList3 = new ArrayList<>();
		nonEmptyList3.add(2);
		Assert.assertFalse(compareLists(nonEmptyList1, nonEmptyList3));

		List<Integer> nonEmptyList4 = new ArrayList<>();
		nonEmptyList4.add(1);
		nonEmptyList4.add(2);
		nonEmptyList4.add(3);
		nonEmptyList4.add(4);
		nonEmptyList4.add(7);
		nonEmptyList4.add(8);
		List<Integer> nonEmptyList5 = new ArrayList<>();
		nonEmptyList5.add(1);
		nonEmptyList5.add(2);
		nonEmptyList5.add(3);
		nonEmptyList5.add(4);
		nonEmptyList5.add(7);
		nonEmptyList5.add(9);
		Assert.assertFalse(compareLists(nonEmptyList4, nonEmptyList5));

		List<Integer> fullList1 = getFullList(0);
		List<Integer> fullList2 = getFullList(0);
		Assert.assertEquals(fullList1, fullList2);
	}

	@Test
	public void getPossibleValuesTest() {
		List<Integer> fullList1 = getFullList(1);
		Assert.assertTrue(
				compareLists(fullList1, gridItem.getPossibleValues()));

		fullList1 = new ArrayList<>();
		fullList1.add(1);
		fullList1.add(2);
		fullList1.add(3);
		fullList1.add(4);
		fullList1.add(7);
		fullList1.add(8);
		fullList1.add(9);
		gridItem.changePossibleValue(5, false);
		gridItem.changePossibleValue(6, false);
		Assert.assertTrue(
				compareLists(fullList1, gridItem.getPossibleValues()));
	}

}
