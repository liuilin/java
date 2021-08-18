import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 递归二叉树
 *
 * @author liuqiang
 * @since 2021-08-18
 */
public class Code01_BinaryTreeWithRecursive {
    public static void main(String[] args) {
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, node10);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node8, node9);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        pre(node1);
    }

    private static void pre(BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        pre(head.left);
        pre(head.right);
    }
}

@Getter
@Setter
@AllArgsConstructor
class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
}