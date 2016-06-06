package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (contains(element))
			return;

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
		Object[] newElements = new Object[elements.length + INITIAL_CAPACITY];
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

	public void addAll(List l) {
		for (int i = 0; i < l.size(); i++) {
			if (!contains(l.getElementAt(i)))
				elements[size++] = l.getElementAt(i);
		}
	}
}
