
import java.util.Random;

public class GlassRecycleBin<T> implements IBag<T> {

    private T[] items;
    private int itemCount;
    private int capacity;

    public GlassRecycleBin() {
        int[] values = {5, 10, 15};
        Random rand = new Random();
        int randomIndex = rand.nextInt(values.length);
        this.capacity = values[randomIndex];
        this.items = (T[]) new Object[capacity];
        this.itemCount = 0;
    }
    public T getByIndex(int index){

        return items[index];
    }

    public boolean add(T newItem) {
        if (isFull()) {
            return false;
        }
        if (newItem instanceof Garbage) {
            for (int i = 1; i <= ((Garbage) newItem).getAmount(); i++) {
                items[itemCount] = newItem;
                itemCount++;
            }
            return true;
        }

        return true;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public boolean isFull() {
        return itemCount == capacity;
    }

    public T removeByIndex(int index) {
        if (index < 0 || index >= itemCount) {
            return null;
        }
        T removedItem = items[index];
        for (int i = index; i < itemCount - 1; i++) {
            items[i] = items[i + 1];
        }
        items[itemCount - 1] = null;
        itemCount--;
        return removedItem;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T removedItem = items[itemCount - 1];
        items[itemCount - 1] = null;
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
        for (int i = 0; i < itemCount; i++) {
            System.out.println(getByIndex(i));
        }
    }

    public void dump() {
        while(!isEmpty()){
            remove();
        }
    }

    public boolean transferTo(IBag<T> targetBag, T item) {
        if (!contains(item)) {
            return false;
        }
        if (targetBag.isFull()) {
            return false;
        }
        targetBag.add(remove(item));
        return true;
    }

}