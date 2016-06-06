package com.nts.cleancode.collections;

public abstract class AbstractCollection {
	protected static int INITIAL_CAPACITY = 10;
	protected Object[] elements = new Object[INITIAL_CAPACITY];
	protected int size = 0;
	protected boolean readOnly;

	public void addAll(AbstractCollection c) {
		for (int i = 0; i < c.size(); i++)
			if (!contains(c.getElementAt(i)))
				add(c.getElementAt(i));
	}

	/**
	 * @param m
	 */

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object element) {
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element))
				return true;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean remove(Object element) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (elements[i].equals(element)) {
				removeElement(i);
				return true;
			}
		return false;
	}

	/**
	 * @param i
	 */
	protected void removeElement(int i) {
		elements[i] = null;
		Object[] newElements = new Object[size - 1];
		int k = 0;
		for (int j = 0; j < size; j++) {
			if (elements[j] != null)
				newElements[k++] = elements[j];
		}
		size--;
		elements = newElements;
	}

	public Object getElementAt(int index) {
		return elements[index];
	}

	public int capacity() {
		return elements.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}

	public void add(Object element) {
		if (readOnly)
			return;

		if (shouldGrow())
			grow();

		addElement(element);

	}

	/**
	 * @param element
	 */
	protected void addElement(Object element) {
		elements[size++] = element;
	}

	/**
	 * 
	 */
	protected void grow() {
		Object[] newElements = new Object[elements.length + 10];
		for (int i = 0; i < size; i++)
			newElements[i] = elements[i];
		elements = newElements;
	}

	/**
	 * @return
	 */
	protected boolean shouldGrow() {
		return size + 1 > elements.length;
	}
}
