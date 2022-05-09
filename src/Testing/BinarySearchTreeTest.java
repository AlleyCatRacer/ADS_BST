package Testing;

import Forest.BinarySearchTree;
import Leaves.SearchNode;
import Utility.LumberMill;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest
{
	private SearchNode<Integer> root;
	private BinarySearchTree<Integer> tree;
	private LumberMill mill;
	
	@BeforeEach void setUp()
	{
		mill = new LumberMill();
		root = new SearchNode<>(29);
		tree = new BinarySearchTree<>(root);
		tree.insert(5);
		tree.insert(53);
		tree.insert(7);
		tree.insert(44);
		tree.insert(17);
	}
	
	@AfterEach void tearDown()
	{
		System.out.println("\n\n____________________________________________________________________________________________________________________________________\n\n");
	}
	
	@Test void removeElement5()
	{
		mill.printTree(root);
		System.out.println("\n\n____________________________________________________________________________________________________________________________________\n\n");
		tree.remove(5);
		mill.printTree(tree.getRoot());
	}
	
	@Test void insertElement8()
	{
		mill.printTree(root);
		System.out.println("\n\n____________________________________________________________________________________________________________________________________\n\n");
		tree.insert(8);
		mill.printTree(tree.getRoot());
	}
	
	@Test void rebalance()
	{
		mill.printTree(root);
		System.out.println("\n\n____________________________________________________________________________________________________________________________________\n\n");
		tree.rebalance();
		mill.printTree(tree.getRoot());
	}
	
	@Test void insertElement8AndRebalance()
	{
		mill.printTree(root);
		System.out.println("\n\n____________________________________________________________________________________________________________________________________\n\n");
		tree.insert(8);
		tree.rebalance();
		mill.printTree(tree.getRoot());
	}
	
	@Test void removeRootAndRebalance()
	{
		mill.printTree(root);
		System.out.println("\n\n____________________________________________________________________________________________________________________________________\n\n");
		tree.remove(29);
		mill.printTree(tree.getRoot());
	}
}
