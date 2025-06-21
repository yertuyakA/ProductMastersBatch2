package hard;

public class Box<T> {

    private T value;

    protected Box(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void showType() {
        System.out.println(value.getClass().getSimpleName());
    }
}
