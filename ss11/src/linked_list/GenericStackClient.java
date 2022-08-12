package linked_list;

public class GenericStackClient {
    private static Object Integer;

    public static void main(String[] args) {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("size:"+stack.size());
        while (!stack.isEmty()){
            System.out.printf("%d", stack.pop());
        }
        System.out.println("\nsize:"+stack.size());
    }

}
