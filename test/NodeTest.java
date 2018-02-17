import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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

    @AfterEach
    public void afterEach() {
        this.tree = null;
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

    @Test
    public void testContains() {
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(17));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(7));
        assertTrue(tree.contains(12));
        assertTrue(tree.contains(20));
        assertTrue(tree.contains(4));

        assertFalse(tree.contains(10));
        assertFalse(tree.contains(1));
        assertFalse(tree.contains(70));
        assertFalse(tree.contains(65));
        assertFalse(tree.contains(90));
    }
}