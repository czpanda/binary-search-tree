public class Node {

    public int value;

    public Node left;

    public Node right;

    Node (int value) {
        this.value = value;
    }

    public void add(int value) {
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

    public int min() {
        if (this.left == null) {
            return this.value;
        }

        return this.left.min();
    }

    public void remove(int value) {
        // Value to be removed is the left link of current node
        if (this.left != null && this.left.value == value) {
            // Node has no children
            if (this.left.left == null && this.left.right == null) {
                this.left = null;
                return;
            }

            // Node has one child
            if (this.left.left != null && this.left.right == null || this.left.left == null) {
                this.left = this.left.left;
                return;
            }

            // Node has two children
            int min = this.left.right.min();
            this.left.value = min;
            this.left.remove(min);
        }

        // Value to be removed is the right link of current node
        if (this.right != null && this.right.value == value) {
            // Node has no children
            if (this.right.left == null && this.right.right == null) {
                this.right = null;
                return;
            }

            // Node has one child
            if (this.right.left != null && this.right.right == null || this.right.left == null) {
                this.right = this.right.right;
                return;
            }

            // Node has two children
            int min = this.right.min();
            this.right.value = min;
            this.right.right.remove(min);
        }

        if (this.value < value && this.right != null) {
            this.right.remove(value);
        } else if (this.value > value && this.left != null){
            this.left.remove(value);
        }
    }

    @Override
    public String toString(){
        if (this.left != null && this.right != null) {
            return this.left.toString() + "-" + Integer.toString(this.value) + "-" + this.right.toString();
        } else if (this.left != null) {
            return this.left.toString() + "-" + Integer.toString(this.value);
        } else if (this.right != null) {
            return Integer.toString(this.value) + "-" + this.right.toString();
        } else {
            return Integer.toString(this.value);
        }
    }

}
