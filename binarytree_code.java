
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null
        right = null;
    }
}

public class Main {

    static Node createTree(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            Node curr = q.poll();
            curr.left = new Node(arr[i]);
            q.add(curr.left);
            i++;
            if (i < arr.length) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
                i++;
            }
        }
        return root;
    }
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node root = createTree(arr);
        System.out.println();
        inorder(root);

        System.out.println();
        preorder(root);

        System.out.println();
        postorder(root);
    }
}
