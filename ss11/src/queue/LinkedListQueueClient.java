package queue;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enquue(10);
        queue.enquue(20);
        queue.dequue();
        queue.dequue();
        queue.enquue(30);
        queue.enquue(40);
        queue.enquue(50);
        System.out.println("Dequeue item is: " + queue.dequue().key);
    }
}
