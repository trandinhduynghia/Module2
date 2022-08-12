package my_list_1;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> mylist = new MyList();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);

        //System.out.println(mylist.getData());
        System.out.println(mylist.size());
        System.out.println(mylist.indexof(4));
        System.out.println(mylist.get(0));
    }
}
