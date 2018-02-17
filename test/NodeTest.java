import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {
    @Test
    public void testAdd() {
        Node node = new Node(8);

        node.add(5);
        node.add(17);
        node.add(2);
        node.add(7);
        node.add(12);
        node.add(20);
        node.add(4);

        assertEquals(8, node.value);
        assertEquals(5, node.left.value);
        assertEquals(17, node.right.value);
        assertEquals(2, node.left.left.value);
        assertEquals(7, node.left.right.value);
        assertEquals(12, node.right.left.value);
        assertEquals(20, node.right.right.value);
        assertEquals(4, node.left.left.right.value);
    }
}