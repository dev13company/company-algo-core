package com.company.graph.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

	private Node<T> element;
	private int n;
	
	private static class Node<T> {
		private T t;
		private Node<T> next;
	}
	
	public Bag(){
		element = null;
		n=0;
	}
	
	public boolean isEmpty(){
		return element == null;
	}
	
	public int size(){
		return n;
	}
	
	public void add(T t){
		Node<T> telement = element;
		element = new Node<T>();
		element.t = t;
		element.next = telement;
		n++;
	}
	public Iterator<T> iterator() {
		return new ListIterator<T>(element);
	}
	
	private class ListIterator<T> implements Iterator<T> {
		private Node<T> current;
		
		public ListIterator(Node<T> element) {
			this.current = element;
		}

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T t = current.t;
			current = current.next;
			return t;
		}
		
	}

}
