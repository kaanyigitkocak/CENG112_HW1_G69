import java.util.Arrays;

public class TrashCan<T> implements IBag<T> {

    public T[] items;
    private int itemCount;
    private int capacity;

    private static final int DEFAULT_CAPACITY = 450;

    public TrashCan() {
        this.capacity = DEFAULT_CAPACITY;
        this.items = (T[]) new Object[capacity];
        this.itemCount = 0;

    }

    public boolean separate(T item,IBag<T> targetBag1,IBag<T> targetBag2,IBag<T> targetBag3,IBag<T> targetBag4,IBag<T> targetBag5,IBag<T> targetBag6) {

        if (item instanceof Garbage) {
            Garbage garbage = (Garbage) item;
            String garbageType = garbage.getGarbageType();
            // Separate the garbage based on its type
            switch (garbageType) {
                case "metal":
                    if (!targetBag1.isFull()) {
                        transferTo(targetBag1,item);
                    }

                    break;
                case "glass":
                    if (!targetBag2.isFull()) {
                        transferTo(targetBag2,item);
                    }

                    break;

                case "organic":
                    if (!targetBag3.isFull()) {
                        transferTo(targetBag3,item);
                    }


                    break;
                case "paper":
                    if (!(targetBag4.isFull())) {
                        transferTo(targetBag4,item);
                    }


                    break;
                case "plastic":
                    if (!(targetBag5.isFull())) {
                        transferTo(targetBag5,item);
                    }


                    break;
                case "fabric":
                    if (!(targetBag6.isFull())) {
                        transferTo(targetBag6,item);
                    }


                    break;
                default:
                    return false;
            }

            return true;
        }

        // The item is not a Garbage instance
        return false;
    }

    public boolean add(T newItem) {
        if (isFull()) {
            return false;
        }
        items[itemCount] = newItem;
        itemCount++;
        return true;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public boolean isFull() {
        return itemCount == capacity;
    }

    public T getByIndex(int index){

        return items[index];
    }
    public T removeByIndex(int index) {
        if (index < 0 || index >= itemCount) {
            return null;
        }
        T removedItem = items[index];
        for (int i = index; i < itemCount - 1; i++) {
            items[i] = items[i+1];
        }
        items[itemCount-1] = null;
        itemCount--;
        return removedItem;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T removedItem = items[itemCount-1];
        items[itemCount-1] = null;
        itemCount--;
        return removedItem;
    }

    public T remove(T item) {
        int index = getIndexOf(item);
        if (index == -1) {
            return null;
        }
        return removeByIndex(index);
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getIndexOf(T item) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return getIndexOf(item) != -1;
    }

    public void displayItems() {
        System.out.println(Arrays.toString(items));
    }

    public void dump() {
        Arrays.fill(items, null);
        itemCount = 0;
    }

    public boolean transferTo(IBag<T> targetBag, T item) {
        if (!contains(item)) {
            return false;
        }
        targetBag.add(remove(item));
        return true;
    }
}

