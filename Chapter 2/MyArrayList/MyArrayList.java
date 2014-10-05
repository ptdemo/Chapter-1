import java.util.AbstractList;

public class MyArrayList<E> extends AbstractList<E> {
	private static final int INITIAL_CAPACITY = 10;
	private E[] theData;
	private int size = 0;
	private int capacity = 0;

	public MyArrayList() {
		capacity = INITIAL_CAPACITY;
		theData = (E[]) new Object[capacity];
	}

	/**
	 * Add an entry to the data inserting it before the item at the specified
	 * index.
	 * 
	 * @param index
	 *            - The index of the time that the new value it to be inserted
	 *            in front of.
	 * @param theValue
	 *            - The value to be inserted
	 * @throws ArrayIndexOUtOfBoundsException
	 *             if index is less than zero or greater than size
	 */
	public void add(int index, E anEntry) {
		if (index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException(index);
		if (size >= capacity) {
			reallocate();
		}
		size++;
		E newData = theData[index];
		E oldData = theData[index];
		theData[index] = anEntry;

		for (int x = index + 1; x < size; x++) {
			oldData = theData[x];
			theData[x] = newData;
			newData = oldData;

		}

	}

	/**
	 * Get a value in the array based on its index.
	 * 
	 * @param index
	 *            - The index of the item desired
	 * @return The contents of the array at that index
	 * @throws ArrayIndexOutOfBoundsException
	 *             - if the index is negative or if it is greater than or equal
	 *             to the current size
	 */
	public E get(int index) {
		if (index < 0 || index > size - 1)
			throw new ArrayIndexOutOfBoundsException(index);

		return theData[index];
	}

	/**
	 * Set the value in the array based on its index.
	 * 
	 * @param index
	 *            - The index of the item desired
	 * @param newValue
	 *            - The new value to store at this position
	 * @return The old value at this position
	 * @throws ArrayIndexOutOfBoundsException
	 *             - if the index is negative or if it is greater than or equal
	 *             to the current size
	 */
	public E set(int index, E newValue) {
		if (index < 0 || index > size - 1)
			throw new ArrayIndexOutOfBoundsException(index);

		E oldValue = theData[index];
		theData[index] = newValue;

		return oldValue;
	}

	/**
	 * Remove an entry based on its index
	 * 
	 * @param index
	 *            - The index of the entry to be removed
	 * @return The value removed
	 * @throws ArrayIndexOutOfBoundsException
	 *             - if the index is negative or if it is greater than or equal
	 *             to the current size
	 */
	public E remove(int index) {
		if (index < 0 || index > size - 1)
			throw new ArrayIndexOutOfBoundsException(index);

		E oldValue = theData[index];
		for (int x = index; x < size - 1; x++) {
			theData[x] = theData[x + 1];
		}
		theData[size - 1] = null;
		size--;
		return oldValue;
	}

	/**
	 * Get the current size of the array
	 * 
	 * @return The current size of the array
	 */
	public int size() {
		return size;
	}

	/**
	 * Allocate a new array for more space
	 */
	private void reallocate() {
		capacity = 2 * capacity;
		E[] newData = (E[]) new Object[capacity];
		System.arraycopy(theData, 0, newData, 0, size);
		theData = newData;
	}

}
