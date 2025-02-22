package five;

public class GenericsMethod {

    public <T> T doSomething(T type) {  // #A
        System.out.println(type.getClass());
        return type;
    }

    public static void main(String[] args) {
        GenericsMethod genericsMethod = new GenericsMethod();
        String result = genericsMethod.doSomething("Generics Method");  // #B
        System.out.println(result);

        result = genericsMethod.<String>doSomething("Method with Generics");  // #C
        System.out.println(result);
    }
}

