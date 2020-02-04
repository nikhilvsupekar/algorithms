package com.algorithms.trees;

import com.data.structures.trees.BinarySearchTree;
import com.data.structures.trees.BinaryTreeNode;

public class BinaryTreeAlgorithms {

    /**
     * Find the depth of the BST
     *
     * @param root      Root of the tree
     * @param <T>       Template parameter
     * @return          Depth
     */
    public static <T extends Comparable<T>>
    Integer findDepth(BinaryTreeNode<T> root) {
        if (root == null) return null;
        if (root.isLeaf()) return 0;

        Integer leftDepth = root.hasLeft() ? findDepth(root.left()) : 0;
        Integer rightDepth = root.hasRight() ? findDepth(root.right()) : 0;

        return (1 + (leftDepth > rightDepth ? leftDepth : rightDepth));
    }

    /**
     * Find the number of nodes below a node (including the root node)
     *
     * @param root      Root of the sub tree
     * @param <T>       Template parameter
     * @return          Node count
     */
    public static <T extends Comparable<T>>
    Integer getNodeCount(BinaryTreeNode<T> root) {
        if (root == null) return null;
        if (root.isLeaf()) return 1;

        Integer leftChildren = root.hasLeft() ? getNodeCount(root.left()) : 0;
        Integer rightChildren = root.hasRight() ? getNodeCount(root.right()) : 0;

        return 1 + leftChildren + rightChildren;
    }

    /**
     * Find the number of leaves below a node
     *
     * @param root      Root of the sub tree
     * @param <T>       Template parameter
     * @return          Leaf count
     */
    public static <T extends Comparable<T>>
    Integer getLeafCount(BinaryTreeNode<T> root) {
        if (root == null) return null;
        if (root.isLeaf()) return 1;

        Integer leftLeaves = (root.hasLeft() ? getLeafCount(root.left()) : 0);
        Integer rightLeaves = (root.hasRight() ? getLeafCount(root.right()) : 0);

        return leftLeaves + rightLeaves;
    }
}
