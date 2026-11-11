public class BSTMain {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // Hub codes
        int[] hubs = {50, 30, 70, 20, 40,
                      60, 80, 10, 35, 45};

        // Insert all hub codes
        for (int hub : hubs) {
            bst.root = bst.insert(bst.root, hub);
        }

        // Search operation
        int key = 45;

        if (bst.search(bst.root, key)) {
            System.out.println(key + " found in BST");
        } else {
            System.out.println(key + " not found in BST");
        }

        // Calculate height
        System.out.println("Height of BST: "
                + bst.findHeight(bst.root));
    }
}
