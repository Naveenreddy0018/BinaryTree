import java.util.Scanner;

public class BinaryTree {
    private class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void populate(Scanner sc) {
        System.out.print("Enter the value of the node: ");
        int n = sc.nextInt();
        root = new Node(n);
        populate(sc, root);
    }
    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to add to the left of value: " + node.data);
        Boolean left = sc.nextBoolean();
        if(left) {
            System.out.println("Give the value to add to left of the value: " + node.data);
            int val = sc.nextInt();
            node.left = new Node(val);
            populate(sc, node.left);
        }

        System.out.println("Do you want to add to the right of value: " + node.data);
        Boolean right = sc.nextBoolean();
        if(right) {
            System.out.println("Give the value to add to right of the value: " + node.data);
            int val = sc.nextInt();
            node.right = new Node(val);
            populate(sc, node.right);
        }
    }

    public void display() {
        display(root, 0);
    }
    
    private void display(Node node, int level) {
        if(node == null) {
            return;
        }

        display(node.right, level + 1);

        if(level != 0) {
            for(int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----------->" + node.data);
        }
        else {
            System.out.println(node.data);
        }

        display(node.left, level+1);
        


    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }

    
}
