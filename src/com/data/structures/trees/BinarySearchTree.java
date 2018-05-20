package com.data.structures.trees;

import com.data.structures.Stack;
import com.data.structures.lists.ArrayList;
import com.data.structures.lists.IList;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void addElement(T t) {
        if (root == null) {
            root = new BinaryTreeNode<>(t, null, null);
        } else {
            BinaryTreeNode<T> currentNode = root;

            while (currentNode != null) {
                if (t.compareTo(currentNode.getData()) <= 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(new BinaryTreeNode<>(t, null, null));
                        break;
                    } else {
                        currentNode = currentNode.getLeft();
                    }
                } else {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(new BinaryTreeNode<>(t, null, null));
                        break;
                    } else {
                        currentNode = currentNode.getRight();
                    }
                }
            }
        }
    }


    private void deleteRoot() {
        if (root.getLeft() == null) {
            root = root.getRight();
        } else if (root.getRight() == null) {
            root = root.getLeft();
        } else {
            BinaryTreeNode<T> rightMost = root.getLeft();

            while (rightMost.getRight() != null) {
                rightMost = rightMost.getRight();
            }

            rightMost.setRight(root.getRight());
            root = root.getLeft();
        }
    }

    public void removeElement(T t) {
        if (root == null) {
            return;
        }

        if (t.compareTo(root.getData()) == 0) {
            deleteRoot();
        }

        BinaryTreeNode<T> currentNode = root;

        while (currentNode != null) {
            if (t.compareTo(currentNode.getData()) < 0) {
                if (currentNode.getLeft() == null) {
                    return;
                }

                if (t.compareTo(currentNode.getLeft().getData()) == 0) {
                    if (currentNode.getLeft().getLeft() == null) {
                        currentNode.setLeft(currentNode.getLeft().getRight());
                    } else if (currentNode.getLeft().getRight() == null) {
                        currentNode.setLeft(currentNode.getLeft().getLeft());
                    } else {
                        BinaryTreeNode<T> rightMost = currentNode.getLeft().getLeft();

                        while (rightMost.getRight() != null) {
                            rightMost = rightMost.getRight();
                        }

                        rightMost.setRight(currentNode.getLeft().getRight());
                        currentNode.setLeft(rightMost);
                    }

                    return;
                } else {
                    currentNode = currentNode.getLeft();
                }
            } else if (t.compareTo(currentNode.getData()) > 0) {
                if (currentNode.getRight() == null) {
                    return;
                }

                if (t.compareTo(currentNode.getRight().getData()) == 0) {
                    if (currentNode.getRight().getLeft() == null) {
                        currentNode.setRight(currentNode.getRight().getRight());
                    } else if (currentNode.getRight().getLeft() == null) {
                        currentNode.setRight(currentNode.getRight().getLeft());
                    } else {
                        BinaryTreeNode<T> rightMost = currentNode.getRight().getLeft();

                        while (rightMost.getRight() != null) {
                            rightMost = rightMost.getRight();
                        }

                        rightMost.setRight(currentNode.getRight().getRight());
                        currentNode.setRight(rightMost);
                    }

                    return;
                } else {
                    currentNode = currentNode.getRight();
                }
            }
        }
    }


    public IList<T> preOrderTraversal() {
        IList<T> preOrderList = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        if (root == null) {
            return preOrderList;
        }

        BinaryTreeNode<T> currentNode = root;

        while (true) {
            preOrderList.addElement(currentNode.getData());

            if (currentNode.getLeft() != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else if (currentNode.getRight() != null) {
                currentNode = currentNode.getRight();
            } else {

                currentNode = stack.pop().getRight();
                while (currentNode == null && !stack.isEmpty()) {
                    currentNode = stack.pop().getRight();
                }

                if (stack.isEmpty() && currentNode == null) {
                    break;
                }
            }
        }


        return preOrderList;
    }
}
