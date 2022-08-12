package BST;

public class TestBST {
    public static void main(String[] args) {
        BST<String> tree = new BST<String>();
        tree.insert("ha noi");
        tree.insert("ho chi minh");
        tree.insert("da nang");
        tree.insert("hai phong");
        tree.insert("quang nam");
        tree.insert("an giang");
        tree.insert("hue");

        System.out.println(tree.getSize());
        tree.inorder();
    }
}
