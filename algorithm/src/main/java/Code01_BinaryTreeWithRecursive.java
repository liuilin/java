import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Node {
    public int value;
    public Node left;
    public Node right;
}


/**
 * 递归遍历二叉树
 *
 * @author liuqiang
 * @since 2021-08-18
 */
public class Code01_BinaryTreeWithRecursive {
    public static void main(String[] args) {
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, null, null);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, null, null);
        Node node3 = new Node(3, node6, node7);
        Node node2 = new Node(2, node4, node5);
        Node node1 = new Node(1, node2, node3);

        System.out.println("==================== 前序 ====================");
        pre(node1); System.out.println();
        System.out.println("==================== 中序 ====================");
        middle(node1); System.out.println();
        System.out.println("==================== 后序 ====================");
        post(node1);
    }

    private static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + "\t");
        pre(head.left);
        pre(head.right);
    }

    private static void middle(Node head) {
        if (head == null) {
            return;
        }
        middle(head.left);
        System.out.print(head.value + "\t");
        middle(head.right);
    }

    private static void post(Node head) {
        if (head == null) {
            return;
        }
        post(head.left);
        post(head.right);
        System.out.print(head.value + "\t");
    }
}