package com.nts.cleancode.collections;

public class List extends AbstractCollection {
	public void set(int i, Object value) {
		if (!readOnly) {
			if (i >= size)
				throw new ArrayIndexOutOfBoundsException();
			elements[i] = value;
		}
	}
}
