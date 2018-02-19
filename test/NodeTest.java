import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node firstTree;

    private Node secondTree;

    private Node thirdTree;

    private Node fourthTree;


    @BeforeEach
    public void beforeEach() {
        firstTree = new Node(10);

        firstTree.add(15);
        firstTree.add(0);
        firstTree.add(10);
        firstTree.add(20);
        firstTree.add(5);
        firstTree.add(8);

        secondTree = new Node(8);

        secondTree.add(5);
        secondTree.add(17);
        secondTree.add(2);
        secondTree.add(7);
        secondTree.add(12);
        secondTree.add(20);
        secondTree.add(4);
        secondTree.add(1);
        secondTree.add(25);
        secondTree.add(15);

        thirdTree = new Node(50);

        thirdTree.add(20);
        thirdTree.add(15);
        thirdTree.add(22);
        thirdTree.add(10);
        thirdTree.add(25);
        thirdTree.add(90);
        thirdTree.add(70);
        thirdTree.add(95);
        thirdTree.add(100);
        thirdTree.add(92);

        fourthTree = new Node(50);

    }

    @AfterEach
    public void afterEach() {
        this.firstTree = null;

        this.secondTree = null;

        this.thirdTree = null;

        this.fourthTree = null;
    }

    @Test
    public void testAdd() {
        assertEquals(10, firstTree.value);
        assertEquals(15, firstTree.right.value);
        assertEquals(0, firstTree.left.value);
        assertEquals(20, firstTree.right.right.value);
        assertEquals(5, firstTree.left.right.value);
        assertEquals(8, firstTree.left.right.right.value);

        assertEquals(8, secondTree.value);
        assertEquals(5, secondTree.left.value);
        assertEquals(17, secondTree.right.value);
        assertEquals(2, secondTree.left.left.value);
        assertEquals(7, secondTree.left.right.value);
        assertEquals(12, secondTree.right.left.value);
        assertEquals(20, secondTree.right.right.value);
        assertEquals(4, secondTree.left.left.right.value);
        assertEquals(1, secondTree.left.left.left.value);
        assertEquals(15, secondTree.right.left.right.value);
        assertEquals(25, secondTree.right.right.right.value);

        assertEquals(50, thirdTree.value);
        assertEquals(20, thirdTree.left.value);
        assertEquals(15, thirdTree.left.left.value);
        assertEquals(10, thirdTree.left.left.left.value);
        assertEquals(22, thirdTree.left.right.value);
        assertEquals(25, thirdTree.left.right.right.value);
        assertEquals(90, thirdTree.right.value);
        assertEquals(70, thirdTree.right.left.value);
        assertEquals(95, thirdTree.right.right.value);
        assertEquals(92, thirdTree.right.right.left.value);
        assertEquals(100, thirdTree.right.right.right.value);

        assertEquals(50, fourthTree.value);

    }

    @Test
    public void testContains() {
        assertTrue(firstTree.contains(10));
        assertTrue(firstTree.contains(15));
        assertTrue(firstTree.contains(0));
        assertTrue(firstTree.contains(20));
        assertTrue(firstTree.contains(5));
        assertTrue(firstTree.contains(8));
        assertFalse(firstTree.contains(70));

        assertTrue(secondTree.contains(8));
        assertTrue(secondTree.contains(5));
        assertTrue(secondTree.contains(17));
        assertTrue(secondTree.contains(2));
        assertTrue(secondTree.contains(7));
        assertTrue(secondTree.contains(4));
        assertTrue(secondTree.contains(1));
        assertTrue(secondTree.contains(12));
        assertTrue(secondTree.contains(20));
        assertTrue(secondTree.contains(25));
        assertFalse(secondTree.contains(10));

        assertTrue(thirdTree.contains(50));
        assertTrue(thirdTree.contains(20));
        assertTrue(thirdTree.contains(15));
        assertTrue(thirdTree.contains(10));
        assertTrue(thirdTree.contains(90));
        assertTrue(thirdTree.contains(70));
        assertTrue(thirdTree.contains(95));
        assertTrue(thirdTree.contains(92));
        assertTrue(thirdTree.contains(100));
        assertFalse(thirdTree.contains(150));

        assertTrue(fourthTree.contains(50));
        assertFalse(fourthTree.contains(10));
    }

    @Test
    public void testDepth() {
        assertEquals(4, firstTree.depth());

        assertEquals(4, secondTree.depth());

        assertEquals(4, thirdTree.depth());

        assertEquals(1, fourthTree.depth());
    }

    @Test
    public void testToString() {
        assertEquals("0-5-8-10-15-20", firstTree.toString());

        assertEquals("1-2-4-5-7-8-12-15-17-20-25", secondTree.toString());

        assertEquals("10-15-20-22-25-50-70-90-92-95-100", thirdTree.toString());

        assertEquals("50", fourthTree.toString());
    }

    @Test
    public void testMin() {
        assertEquals(0, firstTree.min());

        assertEquals(1, secondTree.min());

        assertEquals(10, thirdTree.min());

        assertEquals(50, fourthTree.min());
    }

    @Test
    public void testRemove() {
        // Test removing node which doesn't have any children
        firstTree.remove(8);
        firstTree.remove(20);

        assertFalse(firstTree.contains(8));
        assertFalse(firstTree.contains(20));

        // Test removing node which has one left leaf
        secondTree.remove(2);
        secondTree.remove(7);

        assertFalse(secondTree.contains(2));
        assertFalse(secondTree.contains(7));

        // Test removing node which has one right leaf
        secondTree.remove(12);
        secondTree.remove(20);

        assertFalse(secondTree.contains(12));
        assertFalse(secondTree.contains(20));

        // Test removing node which has two children
        thirdTree.remove(20);
        thirdTree.remove(90);

        assertFalse(thirdTree.contains(20));
        assertFalse(thirdTree.contains(90));
    }
}