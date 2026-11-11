
public class BinarySearchTree {

    Node root;

    // Insert a new value
    Node insert(Node root, int value) {

        // Base condition
        if (root == null) {
            return new Node(value);
        }

        // Move left
        if (value < root.data) {
            root.left = insert(root.left, value);
        }

        // Move right
        else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Search for a value
    boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Find height of BST
    int findHeight(Node root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
