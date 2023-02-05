import java.util.*;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root = null;

    void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            root.insert(value);
        }
    }

    List<T> getAsSortedList() {
        List<T> list = new ArrayList<>();
        if (root != null)
            root.appendToSortedList(list);
        return list;
    }

    List<T> getAsLevelOrderList() {
        List<T> list = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (queue.size() > 0) {
                var node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                list.add(node.data);
            }
        }
        return list;
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T extends Comparable<T>> {
        private final T data;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

        void insert(T data) {
            if (data.compareTo(this.data) <= 0) {
                if (left == null)
                    left = new Node<>(data);
                else
                    left.insert(data);
            } else {
                if (right == null) {
                    right = new Node<>(data);
                } else {
                    right.insert(data);
                }
            }
        }

        void appendToSortedList(List<T> list) {
            if (left != null) left.appendToSortedList(list);
            list.add(data);
            if (right != null) right.appendToSortedList(list);
        }
    }
}
