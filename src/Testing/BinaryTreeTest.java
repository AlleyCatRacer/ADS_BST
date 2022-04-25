package Testing;

import Forest.BinaryTree;
import Leaves.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest
{
	private Node<Integer> root;
	private Node<Integer> n1;
	private Node<Integer> n2;
	private Node<Integer> n3;
	private Node<Integer> n4;
	private Node<Integer> n5;
	private Node<Integer> n6;
	private BinaryTree<Integer> tree;
	
	@BeforeEach void setUp()
	{
		root = new Node<>(7);
		n1 = new Node<>(62);
		n2 = new Node<>(5);
		n3 = new Node<>(53);
		n4 = new Node<>(44);
		n5 = new Node<>(17);
		n6 = new Node<>(29);
		
		root.setLeft(n1);
		root.setRight(n2);
		
		n1.setLeft(n6);
		n1.setRight(n5);
		
		n2.setRight(n4);
		
		n5.setRight(n3);
		
		tree = new BinaryTree<>(root);
	}
	
	@AfterEach void tearDown()
	{
	
	}
	
	@Test void getRootShouldReturn7()
	{
		assertEquals(7, tree.getRoot().getElement());
	}
	
	@Test void setRootTo29()
	{
		tree.setRoot(n6);
		assertEquals(29, tree.getRoot().getElement());
	}
	
	@Test void trueWhenEmpty()
	{
		BinaryTree<Integer> emptyTree = new BinaryTree<>(new Node<>(2));
		emptyTree.setRoot(null);
		assertTrue(emptyTree.isEmpty());
	}
	
	@Test void falseWhenNotEmpty()
	{
		assertFalse(tree.isEmpty());
	}
	
	@Test void sizeReturns7()
	{
		assertEquals(7, tree.size());
	}
	
	@Test void trueWhenElementIsThere()
	{
		assertTrue(tree.contains(62));
	}
	
	@Test void falseWhenElementIsNotThere()
	{
		assertFalse(tree.contains(9));
	}
	
	@Test void heightIs3()
	{
		assertEquals(3, tree.height(root));
	}
	
	@Test void runForestInOrder()
	{
		ArrayList<Integer> correct = new ArrayList<>(Arrays.asList(29, 62, 17, 53, 7, 5, 44));
		assertEquals(correct, tree.runForest(BinaryTree.Gait.inOrder));
	}
	
	@Test void runForestPreOrder()
	{
		ArrayList<Integer> correct = new ArrayList<>(Arrays.asList(7, 62, 29, 17, 53, 5, 44));
		assertEquals(correct, tree.runForest(BinaryTree.Gait.preOrder));
	}
	
	@Test void runForestPostOrder()
	{
		ArrayList<Integer> correct = new ArrayList<>(Arrays.asList(29, 53, 17, 62, 44, 5, 7));
		assertEquals(correct, tree.runForest(BinaryTree.Gait.postOrder));
	}
	
	@Test void runForestLevelOrder()
	{
		ArrayList<Integer> correct = new ArrayList<>(Arrays.asList(7, 62, 5, 29, 17, 44, 53));
		assertEquals(correct, tree.runForest(BinaryTree.Gait.levelOrder));
	}
}