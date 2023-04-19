
import java.util.Random;

public class PaperRecycleBin<T> implements IBag<T> {

    private T[] items;
    private int itemCount;
    private int capacity;

    public PaperRecycleBin() {
        int[] values = {5, 10, 15};
        Random rand = new Random();
        int randomIndex = rand.nextInt(values.length);
        this.capacity = values[randomIndex];
        this.items = (T[]) new Object[capacity];
        this.itemCount = 0;
    }

    //You can refer to the IBag interface to check the tasks of the methods.

    public T getByIndex(int index){

        return items[index];
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


    //If we call the display method directly with the items list returned by the add method in the FileIO class
    //it would print the same object three times since the add method adds each garbage object one by one
    //(for example olive  packet,plastic,3 creating three entries in the list for an object with a count of 3)
    // Therefore, we try to prevent this repetition when displaying by implementing a check in the code.
    //olive  packet,plastic,1
    //olive  packet,plastic,1    ===> olive  packet,plastic,3
    //olive  packet,plastic,1
    public void displayItems() {
        for (int a = 0; a < getItemCount(); a++) {
            T garbage = getByIndex(a);
            int count = 1; // start count at 1 for the first item
            if (a>0 && garbage.equals(getByIndex(a-1))) {
                continue;
            }
            for (int i = a + 1; i < getItemCount(); i++) {
                if (garbage.equals(getByIndex(i))) {
                    count++;
                }
                else{break;}
            }
            if(garbage instanceof Garbage) {
                System.out.println(((Garbage) garbage).getGarbageName() + ","+ count);
            }
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