package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IntervalTree<K extends Comparable<K>> {

    Node root;

    public void insert(Node n) {
        if (root == null) {
            root = n;
            root.max = n.end;
        } else {
            Node parent = null;
            Node node = root;
            while (node != null) {
                parent = node;
                if (node.start.compareTo(n.start) > 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }

                if (parent.max.compareTo(n.end) < 0) {
                    parent.max = n.end;
                }
            }

            if (parent.start.compareTo(n.start) > 0) {
                parent.left = n;
            } else {
                parent.right = n;
            }
        }
    }

    public void printAllOverlaps(K startPos, K endPos) {
        Node node = root;
        Queue<Node> Q = new LinkedList<>();
        Q.add(node);

        while (!Q.isEmpty()) {
            node = Q.poll();
            if (isIntersecting(node, startPos, endPos))
                System.out.println(node.toString());

            if (node.left != null && node.left.max.compareTo(startPos) >= 0)
                Q.add(node.left);

            if (node.right != null && node.right.max.compareTo(startPos) >= 0)
                Q.add(node.right);
        }
    }

    public boolean isIntersecting(Node node, K startPos, K endPos) {
        if (endPos.compareTo(node.start) < 0)
            return false;
        else if (node.end.compareTo(startPos) < 0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        IntervalTree<Integer> o = new IntervalTree<>();
        o.insert(o.new Node(6, 9));
        o.insert(o.new Node(5, 8));
        o.insert(o.new Node(2, 7));
        o.insert(o.new Node(3, 8));
        o.insert(o.new Node(8, 15));
        o.insert(o.new Node(9, 20));
        o.insert(o.new Node(7, 50));

        System.out.println(o);

        o.printAllOverlaps(10, 21);

    }


    class Node implements Comparable<Node> {
        K start;
        K end;
        K max;

        Node left;
        Node right;

        public Node(K start, K end) {
            this.start = start;
            this.end = end;
            this.max = end;
        }

        @Override
        public int compareTo(Node o) {
            return start.compareTo(o.start);
        }

        @Override
        public String toString() {
            return "Node [" + start + ", " + end + "]";
        }


    }
}



