package Testing;

import Leaves.SearchNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchNodeTest
{
	private SearchNode<Integer> n1;
	private SearchNode<Integer> n2;
	
	@BeforeEach void setUp()
	{
		n1 = new SearchNode<>(15);
		n2 = new SearchNode<>(5);
	}
	
	@AfterEach void tearDown()
	{
	
	}
	
	@Test void compare15To5GivingPlus10()
	{
		assertEquals(10, n1.compareTo(n2.getElement()));
	}
	
	@Test void compare15To20GivingMinus5()
	{
		n2.setElement(20);
		assertEquals(-5, n1.compareTo(n2.getElement()));
	}
}
