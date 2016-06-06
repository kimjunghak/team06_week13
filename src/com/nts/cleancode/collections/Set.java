package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (contains(element))
			return;
		
		super.add(element);

	}

	public void addAll(AbstractCollection l) {
		for (int i = 0; i < l.size(); i++) {
			if (!contains(l.getElementAt(i)))
				elements[size++] = l.getElementAt(i);
		}
	}
}
