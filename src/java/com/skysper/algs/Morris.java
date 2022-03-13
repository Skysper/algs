package com.skysper.algs;

/**
 * @author skysper
 * @date 2022-03-13 09:59
 */
public class Morris {

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int v) {
            this.val = v;
        }
    }

    public static void pre(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.val + " ");
        pre(root.left);
        pre(root.right);
    }

    public static void in(Node root) {
        if(root == null) {
            return;
        }

        in(root.left);
        System.out.print(root.val + " ");
        in(root.right);
    }

    public static void post(Node root) {
        if(root == null) {
            return;
        }

        post(root.left);
        post(root.right);
        System.out.print(root.val + " ");
    }

    public static void doMorris(Node node) {
        if(node == null) {
            return;
        }

        Node mostRight = null;
        Node cur = node;
        while(cur != null) {
            mostRight = cur.left;
            if(mostRight!= null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            cur = cur.right;
        }
    }


    public static void morrisPre(Node node) {
        Node mostRight = null;
        Node cur = node;
        while(cur != null) {
            mostRight = cur.left;
            if(mostRight!= null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    System.out.print(cur.val + " ");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.print(cur.val + " ");
            }

            cur = cur.right;
        }
    }


    public static void morrisIn(Node node) {
        Node mostRight = null;
        Node cur = node;
        while(cur != null) {
            mostRight = cur.left;
            if(mostRight!= null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            System.out.print(cur.val + " ");

            cur = cur.right;
        }
    }


    public static void morrisPost(Node node) {
        Node mostRight = null;
        Node cur = node;
        while(cur != null) {
            mostRight = cur.left;
            if(mostRight!= null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }

            cur = cur.right;
        }

        printEdge(node);
    }

    /**
     * 打印右边界
     * @param node
     */
    private static void printEdge(Node node) {
        Node pre = null;
        Node cur = node;
        while(cur != null) {
            Node temp = cur;
            cur = cur.right;

            temp.right = pre;
            pre = temp;
        }

        Node head = pre;
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }

        cur = pre;
        pre = null;

        while(cur != null) {
            Node temp = cur;
            cur = cur.right;

            temp.right = pre;
            pre = temp;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.left.right.left = new Node(7);
        root.left.right.left.right = new Node(9);
        root.left.right.left.right.right = new Node(1);

        root.right.left = new Node(22);
        root.right.right = new Node(4);
        root.right.right.left = new Node(18);


        System.out.println("\n前序遍历");
        pre(root);
        System.out.println();
        morrisPre(root);


        System.out.println("\n\n中序遍历");
        in(root);
        System.out.println();
        morrisIn(root);


        System.out.println("\n\n后序遍历");
        post(root);
        System.out.println();
        morrisPost(root);

    }



}
