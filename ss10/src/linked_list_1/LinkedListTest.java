package linked_list_1;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.add(1,0);
        linkedList.printList();
        System.out.println(linkedList.get(0));
        linkedList.size();
        System.out.println(linkedList.indexOf(1));
        System.out.println(linkedList.contains("1"));



    }
}
