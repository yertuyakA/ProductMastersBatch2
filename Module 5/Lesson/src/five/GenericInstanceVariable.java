package five;

public class GenericInstanceVariable<T> {  // #A

    T t;  // #B

    public GenericInstanceVariable(T t) {  // #C
        this.t = t;
    }

    public static void main(String[] args) {
        GenericInstanceVariable<String> genericInstance = 
            new GenericInstanceVariable<>("T type");  // #D

        String tString = genericInstance.t;  // #E
        System.out.println(tString);
    }
}