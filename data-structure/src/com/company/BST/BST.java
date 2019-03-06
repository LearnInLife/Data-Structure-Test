package com.company.BST;

import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node leftChild;
        private Node rightChild;

        public Node(E e) {
            this.e = e;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
//    }
//
//    // 向以node为根的二分搜索树中插入元素e，递归算法
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.rightChild == null) {
//            node.rightChild = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.leftChild == null) {
//            node.leftChild = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) > 0) {
//            add(node.rightChild, e);
//        } else if (e.compareTo(node.e) < 0) {
//            add(node.leftChild, e);
//        }
//    }


    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.rightChild = add(node.rightChild, e);
        } else if (e.compareTo(node.e) < 0) {
            node.leftChild = add(node.leftChild, e);
        }
        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) > 0)
            return contains(node.rightChild, e);
        else
            return contains(node.leftChild, e);
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.leftChild);
        System.out.print(node.e + " ");
        preOrder(node.rightChild);
    }

    //二分搜索的非递归前序遍历
    public void preOderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.print(cur.e + " ");
            if (cur.rightChild != null)
                stack.push(cur.rightChild);
            if (cur.leftChild != null)
                stack.push(cur.leftChild);
        }
    }

    //二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)return;
        inOrder(node.leftChild);
        System.out.print(node.e + " ");
        inOrder(node.rightChild);
    }

    //二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)return;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.e + " ");
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.leftChild, depth + 1, res);
        generateBSTString(node.rightChild, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    //二分搜索树的中序遍历非递归
    public void inOrderNR() {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
//        stack.push(root);
        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.leftChild;
            }

            Node node = stack.pop();
            System.out.print(node.e + " ");
            cur = node.rightChild;
//            if (node.rightChild != null) {
//                cur = node.rightChild;
//                stack.push(cur);
//            }

        }
    }

    //二分搜索树的后序遍历非递归
    public void postOrderNR() {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2, 7, 12};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        bst.preOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.inOrderNR();
        System.out.println();
//        System.out.println(bst);
    }
}


