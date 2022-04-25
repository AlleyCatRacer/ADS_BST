package Forest;

import Leaves.Node;

import java.util.ArrayList;

public class BinaryTree<E>
{
	private final ArrayList<E> value;
	private Node<E> root;
	
	public BinaryTree(Node<E> node)
	{
		value = new ArrayList<>();
		root = node;
	}
	
	public Node<E> getRoot()
	{
		return root;
	}
	
	public void setRoot(Node<E> node)
	{
		root = node;
	}
	
	public ArrayList<E> runForest(Gait g)
	{
		// Delegation method to extract and return Node elements in order of specified traversal enum
		ArrayList<E> temp = new ArrayList<>();
		
		if (root != null)
		{
			switch (g)
			{
				case inOrder -> temp.addAll(inOrder(root));
				case preOrder -> temp.addAll(preOrder(root));
				case postOrder -> temp.addAll(postOrder(root));
				case levelOrder -> temp.addAll(levelOrder(root));
			}
			
			value.clear();
		}
		
		return temp;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public int size()
	{
		return runForest(Gait.inOrder).size();
	}
	
	public boolean contains(E element)
	{
		return runForest(Gait.inOrder).contains(element);
	}
	
	public int height(Node<E> node)
	{
		if (node == null)
		{
			return -1;
		}
		
		int leftH = height(node.getLeft());
		int rightH = height(node.getRight());
		
		return leftH >= rightH ? leftH + 1 : rightH + 1;
	}
	
	private ArrayList<E> inOrder(Node<E> node)
	{
		if (node == null)
		{
			return null;
		}
		
		inOrder(node.getLeft());
		value.add(node.getElement());
		inOrder(node.getRight());
		
		return value;
	}
	
	private ArrayList<E> preOrder(Node<E> node)
	{
		if (node == null)
		{
			return null;
		}
		
		value.add(node.getElement());
		preOrder(node.getLeft());
		preOrder(node.getRight());
		
		return value;
	}
	
	private ArrayList<E> postOrder(Node<E> node)
	{
		if (node == null)
		{
			return null;
		}
		
		postOrder(node.getLeft());
		postOrder(node.getRight());
		value.add(node.getElement());
		
		return value;
	}
	
	private ArrayList<E> levelOrder(Node<E> node)
	{
		if (node == null)
		{
			return null;
		}
		
		int h = height(node);
		
		for (int i = 0; i <= h; i++)
		{
			saveLevel(node, i);
		}
		
		return value;
	}
	
	private void saveLevel(Node<E> node, int level)
	{
		if (node != null)
		{
			if (level == 0)
			{
				value.add(node.getElement());
			}
			else if (level > 0)
			{
				saveLevel(node.getLeft(), (level - 1));
				saveLevel(node.getRight(), (level - 1));
			}
		}
	}
	
	public enum Gait
	{
		// Enum representing kinds of traversals
		inOrder, preOrder, postOrder, levelOrder
	}
}
