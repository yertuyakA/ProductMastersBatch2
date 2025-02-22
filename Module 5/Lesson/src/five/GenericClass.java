package five;

public class GenericClass<T> {   // #A
    public T doSomething(T type) {  // #B
        System.out.println(type.getClass()); // #C
        return type;
    }

    public static void main(String[] args) {
        GenericClass<StringBuilder> genericClass = new GenericClass<>(); // #D
        genericClass.doSomething(new StringBuilder("Generic Builder")); // #E

        new GenericClass<>().doSomething("Generic String"); // #F
        Integer genericNumber = new GenericClass<Integer>().doSomething(7); // #G
        System.out.println(genericNumber);
    }
}


