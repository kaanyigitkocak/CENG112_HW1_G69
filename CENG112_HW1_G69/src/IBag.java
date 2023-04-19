public interface IBag<T> {

	// Methods to add, remove, and check if the bag is empty or full.
	public boolean add(T newItem);
	public boolean isEmpty();
	public boolean isFull();

	// Methods to remove an item from the bag by its index, remove the first item,
	// or remove a specific item.
	public T removeByIndex(int index);
	public T remove();
	public T remove(T item);

	// Methods to get the number of items in the bag and the index of a specific item.
	public int getItemCount();
	public int getIndexOf(T item);

	// Method to check if the bag contains a specific item.
	public boolean contains(T item);

	// Method to display the items in the bag.
	public void displayItems();

	// Method to empty the bag.
	// You can check the method by looking at the comment added at the end of the GarbageRecyclingApp.
	public void dump();

	// Method to transfer an item to another bag.
	public boolean transferTo(IBag<T> targetBag, T item);

	// Method to get an item by its index.
	public T getByIndex(int index);
}
