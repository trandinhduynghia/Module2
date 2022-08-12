package linked_list_1;

import linked_list.MyLinkedList;

public class LinkedList {
    private Node head;
    private int numNodes;
    private boolean flag;

    public LinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, Object data) {
       Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object data){
        if(head == null)
            addFirst(data);
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(data);
        }
    }
    public void remove(int index) {
        Node temp = head;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp.next = temp.next.next;
        }

        numNodes--;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void size(){
       Node temp = head;
        int i =0;
        while (temp != null){
            temp = temp.next;
            i ++;
        }
        System.out.println("size:"+i);
    }
    public boolean contains(Object data) {
        Node temp = head;
        for (int i = 0; i <= numNodes; i++) {
            if ((temp.data).equals(data)) {
                flag = true;
                break;
            }
            else {
                flag = false;
                temp = temp.next;
            }
        }
        return flag;
    }
    public int indexOf(Object data) {
        Node temp = head;
        int q = 0;
        for (int i = 0; i <= numNodes; i++) {
            if ((temp.data).equals(data)) {
                q = i;
                break;
            }
            else {
                temp = temp.next;
            }
        }
        return q;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
