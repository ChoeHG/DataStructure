package search;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    private class TreeNode<E extends Comparable<E>> {
        private E data;
        private TreeNode<E> leftChild;
        private TreeNode<E> rightChild;

        public TreeNode(E data) {
            this.data = data;
        }
    }

    public E find(E element) {
        TreeNode<E> current = root;
        while (root != null) {
            if (element.compareTo(current.data) < 0) {
                current = current.leftChild;
            } else if (element.compareTo(current.data) > 0) {
                current = current.rightChild;
            } else {
                return current.data;
            }
        }

        return null;
    }

    public void insert(E element) {
        TreeNode newNode = new TreeNode(element);

        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null) {
                parent = current;
                if (current.data.compareTo(element) > 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                    }
                }
            }
        }
    }

    public boolean remove(E element) {
        TreeNode current = root;
        TreeNode parent = root;

        //move the pointer to the pointer to be deleted
        while (current.data.compareTo(element) != 0) {
            parent = current;
            if (current == null) {
                return false;
            }

            if (current.data.compareTo(element) > 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            }
            if (current == parent.leftChild) {
                parent.leftChild = null;
            }
            if (current == parent.rightChild) {
                parent.rightChild = null;
            }
            return true;
        } else if (current.leftChild == null && current.rightChild != null) {
            if (current == root) {
                root = current.rightChild;
            }
            if (current == parent.leftChild) {
                parent.leftChild = current.rightChild;
            }
            if (current == parent.rightChild) {
                parent.rightChild = current.rightChild;
            }
            return true;
        } else if (current.leftChild != null && current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            }
            if (current == parent.leftChild) {
                parent.leftChild = current.leftChild;
            }
            if (current == parent.rightChild) {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = null;
            }
            if (current == parent.leftChild) {
                parent.leftChild = successor;
            }
            if (current == parent.rightChild) {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
            return true;
        }
    }

    public TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TreeNode findMax() {
        TreeNode current = root;
        while (current != null) {
            current = current.rightChild;
        }
        return current;
    }

    public TreeNode findMin() {
        TreeNode current = root;
        while (current != null) {
            current = current.leftChild;
        }
        return current;
    }

    public void infixOrder(TreeNode current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.println(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    public void prefixOrder(TreeNode current) {
        if (current != null) {
            System.out.println(current.data + " ");
            prefixOrder(current.leftChild);
            prefixOrder(current.rightChild);
        }
    }

    public void postOrder(TreeNode current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.println(current.data + " ");
        }
    }
}
