public class Node {
    public final int value;

    public Node left;

    public Node right;

    Node (int value) {
        this.value = value;
    }

    public void add(int value) {
        /*
         * Skip value if it already exists in a tree
         */
        if (this.value == value) {
            System.out.print("Value already exists in a tree, therefore it will be skipped.");
            return;
        }

        if (this.value > value) {
            if (this.left == null) {
                this.left = new Node(value);
            } else {
                this.left.add(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(value);
            } else {
                this.right.add(value);
            }
        }
    }
}
