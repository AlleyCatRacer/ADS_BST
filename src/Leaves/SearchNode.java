package Leaves;

public class SearchNode<E> extends Node<E> implements Comparable<E>
{
	public SearchNode(E element)
	{
		super(element);
	}
	
	@Override public int compareTo(E element)
	{
		return (Integer) getElement() - (Integer) element;
	}
}
