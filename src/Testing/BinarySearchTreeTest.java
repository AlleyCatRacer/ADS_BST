package Testing;

import Forest.BinarySearchTree;
import Leaves.SearchNode;
import Utility.LumberMill;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	@Test void remove5()
	{
		mill.printTree(root);
		tree.remove(5);
		mill.printTree(tree.getRoot());
	}
}
