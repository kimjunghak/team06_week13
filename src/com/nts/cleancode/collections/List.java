package com.nts.cleancode.collections;

public class List extends AbstractCollection {
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

	public void set(int i, Object value) {
		if (!readOnly) {
			if (i >= size)
				throw new ArrayIndexOutOfBoundsException();
			elements[i] = value;
		}
	}
}
