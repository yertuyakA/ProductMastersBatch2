package hard;

import medium.MyData;

public class Main {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Something important");
        Box<Integer> box2 = new Box<>(220103);
        Box<MyData> box3 = new Box<>(new MyData(10, "Said"));

        System.out.println(box1.getValue());
        box1.showType();
        System.out.println();

        System.out.println(box2.getValue());
        box2.showType();
        box2.setValue(123);
        System.out.println(box2.getValue());
        System.out.println();

        System.out.println(box3.getValue());
        box3.showType();
    }
}
