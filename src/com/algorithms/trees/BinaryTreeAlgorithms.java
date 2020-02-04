package com.algorithms.trees;

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
        if (!root.hasChildren()) return 0;

        Integer leftDepth = root.hasLeft() ? findDepth(root.left()) : 0;
        Integer rightDepth = root.hasRight() ? findDepth(root.right()) : 0;

        return (1 + (leftDepth > rightDepth ? leftDepth : rightDepth));
    }
}
