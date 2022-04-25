package Testing;

import Leaves.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeTest
{
	private Node<Integer> node;
	
	@BeforeEach void setUp()
	{
		node = new Node<>(4);
	}
	
	@AfterEach void tearDown()
	{
	
	}
	
	@Test void getElementReturns4()
	{
		assertEquals(4, node.getElement());
	}
	
	@Test void settingElementTo11()
	{
		node.setElement(11);
		assertEquals(11, node.getElement());
	}
	
	@Test void nullWhenGettingNonExistentLeft()
	{
		assertNull(node.getLeft());
	}
	
	@Test void nullWhenGettingNonExistentRight()
	{
		assertNull(node.getRight());
	}
	
	@Test void returns23WhenLeftIs23()
	{
		node.setLeft(new Node<>(23));
		assertEquals(23, node.getLeft().getElement());
	}
	
	@Test void returns78WhenRightIs78()
	{
		node.setRight(new Node<>(78));
		assertEquals(78, node.getRight().getElement());
	}
}
