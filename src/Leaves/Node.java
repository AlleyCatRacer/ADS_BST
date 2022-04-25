package Leaves;

public class Node<E>
{
	private E element;
	private Node<E> right;
	private Node<E> left;
	
	public Node(E elem)
	{
		element = elem;
		right = null;
		left = null;
	}
	
	public void setElement(E elem)
	{
		element = elem;
	}
	
	public E getElement()
	{
		return element;
	}
	
	public void setRight(Node<E> node)
	{
		right = node;
	}
	
	public Node<E> getRight()
	{
		return right;
	}
	
	public void setLeft(Node<E> node)
	{
		left = node;
	}
	
	public Node<E> getLeft()
	{
		return left;
	}
}
