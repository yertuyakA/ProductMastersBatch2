package hard;

public class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void showType() {
        if (item != null) {
            System.out.println("Object type is " + item.getClass().getSimpleName() + '\n');
        } else {
            System.out.println("Object type is null" + '\n');
        }
    }
}
