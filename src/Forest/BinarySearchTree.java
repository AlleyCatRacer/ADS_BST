package Forest;

import Leaves.SearchNode;

import java.util.ArrayList;

public class BinarySearchTree<E> extends BinaryTree<E>
{
	
	public BinarySearchTree(SearchNode<E> root)
	{
		super(root);
	}
	
	public boolean insert(E element)
	{
		if (contains(element)) return false;
		
		recursiveInsertion((SearchNode<E>) getRoot(), element);
		return true;
	}
	
	private void recursiveInsertion(SearchNode<E> node, E element)
	{
		if (node.compareTo(element) > 0)
		{
			if (node.getLeft() == null)
			{
				node.setLeft(new SearchNode<>(element));
			}
			else
			{
				recursiveInsertion((SearchNode<E>) node.getLeft(), element);
			}
		}
		else if (node.compareTo(element) <= 0)
		{
			if (node.getRight() == null)
			{
				node.setRight(new SearchNode<>(element));
			}
			else
			{
				recursiveInsertion((SearchNode<E>) node.getRight(), element);
			}
		}
	}
	
	public boolean remove(E element)
	{
		if (!contains(element) || element == null) return false;
		
		recursiveRemoval((SearchNode<E>) getRoot(), element);
		return true;
	}
	
	private void recursiveRemoval(SearchNode<E> node, E element)
	{
		if (getRoot().getElement().equals(element))
		{
			rootRemovalAndRebalance();
			return;
		}
		
		// Checking the first left
		if (node.getLeft() != null && node.getLeft().getElement().equals(element))
		{
			if (node.getLeft().getLeft() == null && node.getLeft().getRight() == null)
			{
				node.setLeft(null);
			}
			else
			{
				ArrayList<E> temp = runForest(Gait.inOrder);
				E remove = temp.get(temp.indexOf(element)+1);
				recursiveRemoval(node, remove);
				node.getLeft().setElement(remove);
			}
		}
		
		// Checking the first right
		if (node.getRight() != null && node.getRight().getElement().equals(element))
		{
			if (node.getRight().getLeft() == null && node.getRight().getRight() == null)
			{
				node.setRight(null);
			}
			else
			{
				ArrayList<E> temp = runForest(Gait.inOrder);
				E remove = temp.get(temp.indexOf(element) + 1);
				recursiveRemoval(node, remove);
				node.getRight().setElement(remove);
			}
		}
		
		// Checking next left
		else if (node.compareTo(element) > 0)
		{
			if (node.getLeft() != null)
			{
				recursiveRemoval((SearchNode<E>) node.getLeft(), element);
			}
		}
		
		// Checking next right
		else if (node.compareTo(element) <= 0)
		{
			if (node.getRight() != null)
			{
				recursiveRemoval((SearchNode<E>) node.getRight(), element);
			}
		}
	}
	
	public E findMin()
	{
		return runForest(Gait.inOrder).get(0);
	}
	
	public E findMax()
	{
		return runForest(Gait.inOrder).get(size() - 1);
	}
	
	public boolean contains(E element)
	{
		return super.contains(element);
	}
	
	public void rebalance()
	{
		ArrayList<E> temp = runForest(Gait.inOrder);
		E newRoot = temp.get(temp.size() / 2);
		setRoot(new SearchNode<>(newRoot));
		middleFinger(temp);
	}
	
	private void middleFinger(ArrayList<E> nodes)
	{
		int middle = (nodes.size() / 2);
		
		if (!getRoot().getElement().equals(nodes.get(middle)))
		{
			insert(nodes.get(middle));
		}
		
		ArrayList<E> leftLeg = new ArrayList<>(nodes.subList(0, middle));
		ArrayList<E> rightLeg = new ArrayList<>(nodes.subList((middle + 1), nodes.size()));
		
		nodes.remove(nodes.get(middle));
		
		if (!leftLeg.isEmpty()) middleFinger(leftLeg);
		
		if (!rightLeg.isEmpty()) middleFinger(rightLeg);
	}
	
	private void rootRemovalAndRebalance()
	{
		ArrayList<E> temp = runForest(Gait.inOrder);
		temp.remove(getRoot().getElement());
		E newRoot = temp.get(temp.size() / 2);
		setRoot(new SearchNode<>(newRoot));
		middleFinger(temp);
	}
}
