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
            System.out.println("Value already exists in a tree, therefore it will be skipped.");
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

    public boolean contains(int value) {
        if (this.value == value) {
            return true;
        }

        if (this.value > value) {
            if (this.left != null) {
                return this.left.contains(value);
            }
        } else {
            if (this.right != null) {
                return this.right.contains(value);
            }
        }

        return false;
    }

    public int depth() {
        if (this.left == null && this.right == null) {
            return 1;
        } else if (this.left == null) {
            return 1 + this.right.depth();
        } else if (this.right == null) {
            return 1 + this.left.depth();
        } else {
            int leftDepth = 1 + this.left.depth();
            int rightDepth = 1 + this.right.depth();

            return Math.max(leftDepth, rightDepth);
        }
    }

    @Override
    public String toString(){
        if (this.left == null && this.right == null) {
            return Integer.toString(this.value);
        } else if (this.left == null) {
            return Integer.toString(this.value) + "-" + this.right.toString();
        } else if (this.right == null) {
            return Integer.toString(this.value) + "-" + this.left.toString();
        } else {
            return this.left.toString() + "-" + Integer.toString(this.value) + "-" + this.right.toString();
        }
    }

}
