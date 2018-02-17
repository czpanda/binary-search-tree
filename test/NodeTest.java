import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    private Node tree;

    @BeforeEach
    public void beforeEach() {
        this.tree = new Node(8);

        tree.add(5);
        tree.add(17);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);
        tree.add(4);
    }

    @Test
    public void testAdd() {
        assertEquals(8, tree.value);
        assertEquals(5, tree.left.value);
        assertEquals(17, tree.right.value);
        assertEquals(2, tree.left.left.value);
        assertEquals(7, tree.left.right.value);
        assertEquals(12, tree.right.left.value);
        assertEquals(20, tree.right.right.value);
        assertEquals(4, tree.left.left.right.value);
    }
}