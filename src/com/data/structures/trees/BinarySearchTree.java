package com.data.structures.trees;

public class BinarySearchTree<T extends Comparable<T>> {
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


    public void removeElement(T t) {
        if (root == null) {
            return;
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
}
