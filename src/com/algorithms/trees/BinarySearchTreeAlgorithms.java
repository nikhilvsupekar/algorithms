package com.algorithms.trees;

import com.data.structures.Queue;
import com.data.structures.Stack;
import com.data.structures.lists.ArrayList;
import com.data.structures.lists.IList;
import com.data.structures.trees.BinarySearchTree;
import com.data.structures.trees.BinaryTreeNode;

import javax.management.ConstructorParameters;

public class BinarySearchTreeAlgorithms {

    /**
     * Perform an iterative inorder traversal of the tree
     *
     * @return  List of elements visited inorder
     */
    public static <T extends Comparable<T>>
    IList<T> inorderTraversal(BinaryTreeNode<T> root) {
        IList<T> traversal = new ArrayList<>();

        if (root == null) return null;
        if (!root.hasChildren()) {
            traversal.addElement(root.value());
            return traversal;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;

        while (current != null) {
            if (current.hasLeft()) {
                stack.push(current);
                current = current.left();
            } else if (current.hasRight()) {
                traversal.addElement(current.value());
                current = current.right();
            } else {
                traversal.addElement(current.value());
                if (stack.isEmpty()) {
                    break;
                }

                current = stack.pop();
                traversal.addElement(current.value());

                boolean breakFlag = false;
                while (!current.hasRight()) {
                    if (stack.isEmpty()) {
                        breakFlag = true;
                        break;
                    }

                    current = stack.pop();
                    traversal.addElement(current.value());
                }

                if (breakFlag) break;

                if (current.hasRight()) {
                    current = current.right();
                }
            }

        }

        return traversal;
    }

    /**
     * Perform an iterative preorder traversal of the tree
     *
     * @return  List of elements visited preorder
     */
    public static <T extends Comparable<T>> IList<T> preorderTraversal(BinaryTreeNode<T> root) {
        IList<T> traversal = new ArrayList<>();

        if (root == null) return null;
        if (!root.hasChildren()) {
            traversal.addElement(root.value());
            return traversal;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;

        while (current != null) {
            traversal.addElement(current.value());

            if (current.hasLeft()) {
                stack.push(current);
                current = current.left();
            } else if (current.hasRight()) {
                current = current.right();
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                current = stack.pop();

                boolean breakFlag = false;
                while (!current.hasRight()) {
                    if (stack.isEmpty()) {
                        breakFlag = true;
                        break;
                    }

                    current = stack.pop();
                }

                if (breakFlag) break;

                current = current.right();
            }
        }

        return traversal;
    }

    /**
     * Perform an iterative postorder traversal of the tree
     *
     * @return  List of elements visited postorder
     */
    public static <T extends Comparable<T>> IList<T> postorderTraversal(BinaryTreeNode<T> root) {
        IList<T> traversal = new ArrayList<>();

        if (root == null) return null;
        if (!root.hasChildren()) {
            traversal.addElement(root.value());
            return traversal;
        }

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;

        while (current != null) {

            if (current.hasRight()) {
                if (current.hasLeft()) {
                    stack.push(current.right());
                    stack.push(current);
                    current = current.left();
                } else {
                    stack.push(current);
                    current = current.right();
                }

            } else if (current.hasLeft()) {
                stack.push(current);
                current = current.left();

            } else {
                traversal.addElement(current.value());

                if (stack.isEmpty()) break;
                current = stack.pop();

                if (stack.peek() != current.right()) {
                    boolean breakFlag = false;
                    while (stack.peek() != current.right()) {
                        traversal.addElement(current.value());

                        if (stack.isEmpty()) {
                            breakFlag = true;
                            break;
                        }
                        current = stack.pop();

                        if (stack.isEmpty()) {
                            traversal.addElement(current.value());
                            breakFlag = true;
                            break;
                        }
                    }

                    traversal.addElement(current.value());
                    if (!stack.isEmpty()) current = stack.pop();

                    if (breakFlag) break;
                } else {
                    BinaryTreeNode<T> temp = current;

                    if (stack.isEmpty()) break;
                    current = stack.pop();
                    stack.push(temp);
                }

            }
        }

        return traversal;
    }

    /**
     * Returns a reference to the node containing the value to be searched
     *
     * @param root      Root of the tree to be searched
     * @param value_    Value to be searched in the tree
     * @param <T>       Type parameter
     * @return          Reference to the tree node containing the value
     */
    public static <T extends Comparable<T>>
    BinaryTreeNode<T> searchNodeByValue(
            BinaryTreeNode<T> root,
            T value_
    ) {
        if (root == null) return null;

        BinaryTreeNode<T> current = root;

        while (current != null) {
            if (value_.equals(current.value())) {
                return current;
            }

            if (current.value().compareTo(value_) > 0) {
                current = current.left();
            } else {
                current = current.right();
            }
        }

        return null;
    }

    public static <T extends Comparable<T>>
    BinaryTreeNode<T> inorderSuccessor(
            BinaryTreeNode<T> root,
            BinaryTreeNode<T> node
    ) {
        if (root == null || node == null) return null;



        return null;
    }

    /**
     * Perform a recursive inorder traversal of the tree
     *
     * @return  List of elements visited inorder
     */
    public static <T extends Comparable<T>>
    IList<T> inorderTraversal_recursive(BinaryTreeNode<T> node) {
        return genericTraversal_recursive(node, "inorder");
    }

    /**
     * Perform a recursive preorder traversal of the tree
     *
     * @return  List of elements visited preorder
     */
    public static <T extends Comparable<T>>
    IList<T> preorderTraversal_recursive(BinaryTreeNode<T> node) {
        return genericTraversal_recursive(node, "preorder");
    }

    /**
     * Perform a recursive postorder traversal of the tree
     *
     * @return  List of elements visited postorder
     */
    public static <T extends Comparable<T>>
    IList<T> postorderTraversal_recursive(BinaryTreeNode<T> node) {
        return genericTraversal_recursive(node, "postorder");
    }


    /**
     * Generic recursive method for inorder/preorder/postorder traversal
     *
     * @param node          Starting node in recursion
     * @param traversalType inorder/preorder/postorder
     * @return              List of elements visited in the specified order
     */
    private static <T extends Comparable<T>>
    IList<T> genericTraversal_recursive(BinaryTreeNode<T> node, String traversalType) {
        IList<T> fullTraversal = new ArrayList<>();
        if (node == null) return null;

        IList<T> leftTraversal = genericTraversal_recursive(node.left(), traversalType);
        IList<T> rightTraversal = genericTraversal_recursive(node.right(), traversalType);

        switch (traversalType) {
            case "inorder":
                fullTraversal.addListElements(leftTraversal);
                fullTraversal.addElement(node.value());
                fullTraversal.addListElements(rightTraversal);

                break;

            case "preorder":
                fullTraversal.addElement(node.value());
                fullTraversal.addListElements(leftTraversal);
                fullTraversal.addListElements(rightTraversal);

                break;

            case "postorder":
                fullTraversal.addListElements(leftTraversal);
                fullTraversal.addListElements(rightTraversal);
                fullTraversal.addElement(node.value());

                break;
        }

        return fullTraversal;
    }

    /**
     * Perform a level-order traversal of the tree
     *
     * @param root      Root of the tree
     * @param <T>       Type parameter
     * @return          List containing the level-order traversal
     */
    public static <T extends Comparable<T>>
    IList<T> levelOrderTraversal (BinaryTreeNode<T> root) {
        IList<T> traversal = new ArrayList<>();

        if (root == null) return null;
        if (!root.hasChildren()) {
            traversal.addElement(root.value());
            return traversal;
        }

        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.dequeue();
            traversal.addElement(current.value());

            if (current.hasLeft()) queue.enqueue(current.left());
            if (current.hasRight()) queue.enqueue(current.right());
        }

        return traversal;
    }

    /**
     * Find the minimum value in a BST
     *
     * @param root      Root of the tree
     * @param <T>       Template parameter
     * @return          Minimum value
     */
    public static <T extends Comparable<T>>
    T findMin(BinaryTreeNode<T> root) {
        if (root == null) return null;

        BinaryTreeNode<T> current = root;
        while (current.hasLeft()) current = current.left();

        return current.value();
    }

    /**
     * Find the maximum value in a BST
     *
     * @param root      Root of the tree
     * @param <T>       Template parameter
     * @return          Maximum value
     */
    public static <T extends Comparable<T>>
    T findMax(BinaryTreeNode<T> root) {
        if (root == null) return null;

        BinaryTreeNode<T> current = root;
        while (current.hasRight()) current = current.right();

        return current.value();
    }

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

        return (1 + leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
