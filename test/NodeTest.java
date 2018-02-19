import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    private Node firstTree;

    private Node secondTree;

    private Node thirdTree;


    @BeforeEach
    public void beforeEach() {
        this.firstTree = new Node(10);

        firstTree.add(15);
        firstTree.add(0);
        firstTree.add(10);
        firstTree.add(20);
        firstTree.add(5);
        firstTree.add(8);

        this.secondTree = new Node(8);

        secondTree.add(5);
        secondTree.add(17);
        secondTree.add(2);
        secondTree.add(7);
        secondTree.add(12);
        secondTree.add(20);
        secondTree.add(4);

        this.thirdTree = new Node(50);
    }

    @AfterEach
    public void afterEach() {
        this.firstTree = null;

        this.secondTree = null;

        this.thirdTree = null;
    }

    @Test
    public void testAdd() {
        // First tree asserts
        assertEquals(10, firstTree.value);
        assertEquals(15, firstTree.right.value);
        assertEquals(0, firstTree.left.value);
        assertEquals(20, firstTree.right.right.value);
        assertEquals(5, firstTree.left.right.value);
        assertEquals(8, firstTree.left.right.right.value);

        // Second tree asserts
        assertEquals(8, secondTree.value);
        assertEquals(5, secondTree.left.value);
        assertEquals(17, secondTree.right.value);
        assertEquals(2, secondTree.left.left.value);
        assertEquals(7, secondTree.left.right.value);
        assertEquals(12, secondTree.right.left.value);
        assertEquals(20, secondTree.right.right.value);
        assertEquals(4, secondTree.left.left.right.value);

        // Third tree asserts
        assertEquals(50, thirdTree.value);

    }

    @Test
    public void testContains() {
        // First tree asserts
        assertTrue(firstTree.contains(10));
        assertTrue(firstTree.contains(15));
        assertTrue(firstTree.contains(0));
        assertTrue(firstTree.contains(20));
        assertTrue(firstTree.contains(5));
        assertTrue(firstTree.contains(8));

        assertFalse(firstTree.contains(70));

        // Second tree asserts
        assertTrue(secondTree.contains(8));
        assertTrue(secondTree.contains(5));
        assertTrue(secondTree.contains(17));
        assertTrue(secondTree.contains(2));
        assertTrue(secondTree.contains(7));
        assertTrue(secondTree.contains(12));
        assertTrue(secondTree.contains(20));
        assertTrue(secondTree.contains(4));

        assertFalse(secondTree.contains(10));

        // Third tree asserts
        assertTrue(thirdTree.contains(50));

        assertFalse(thirdTree.contains(10));
    }

    @Test
    public void testDepth() {
        // First tree asserts
        assertEquals(4, firstTree.depth());

        // Second tree asserts
        assertEquals(4, secondTree.depth());

        // Third tree asserts
        assertEquals(1, thirdTree.depth());
    }

    @Test
    public void testToString() {
        // First tree asserts
        assertEquals("0-5-8-10-15-20", firstTree.toString());

        // Second tree asserts
        assertEquals("2-4-5-7-8-12-17-20", secondTree.toString());

        // Third tree asserts
        assertEquals("50", thirdTree.toString());
    }
}