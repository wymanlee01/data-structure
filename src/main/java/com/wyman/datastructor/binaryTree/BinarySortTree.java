package com.wyman.datastructor.binaryTree;

/**
 * @author liweiwen
 * @since 2021-11-09
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.addNode(new Node(i));
        }
        System.out.println("中序遍历：");
        binarySortTree.midTraverse();
    }

    private Node root;

    public void addNode(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        root.add(node);
    }

    public void preTraverse() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.preTraverse();
        }
    }

    public void midTraverse() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.midTraverse();
        }
    }

    public Node getTargetNode(int targetValue) {
        if (root == null) {
            System.out.println("请先创建二叉树");
            return null;
        } else {
            return root.getTargetNode(targetValue);
        }
    }

    public Node getParentNode(int targetValue) {
        if (root == null) {
            System.out.println("请先创建二叉树");
            return null;
        } else {
            return root.getParentNode(targetValue);
        }
    }

    public void deleteNode(int targetValue) {
        if (root == null) {
            System.out.println("请先创建二叉树");
            return;
        }
        // 待删除的节点
        Node targetNode = getTargetNode(targetValue);
        if (targetNode == null) {
            System.out.println("没有找到节点");
            return;
        }
        // 只有一个节点
        if (root.left == null && root.right == null) {
            root = null;
            System.out.println("删除成功");
            return;
        }


    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        /**
         * 二叉查找树添加节点
         *
         * @param node
         */
        public void add(Node node) {
            if (node == null) {
                return;
            }
            if (value > node.value) {
                if (left == null) {
                    left = node;
                } else {
                    left.add(node);
                }
            } else {
                if (right == null) {
                    right = node;
                } else {
                    right.add(node);
                }
            }
        }

        /**
         * 前序遍历
         */
        public void preTraverse() {
            System.out.println(this);
            if (left != null) {
                left.preTraverse();
            }
            if (right != null) {
                right.preTraverse();
            }
        }

        /**
         * 中序遍历
         */
        public void midTraverse() {
            if (left != null) {
                left.midTraverse();
            }
            System.out.println(this);
            if (right != null) {
                right.midTraverse();
            }
        }

        /**
         * 获取目标节点
         */
        public Node getTargetNode(int targetValue) {
            if (value == targetValue) {
                return this;
            }
            // 目标节点小于当前节点
            if (targetValue < value) {
                if (left == null) {
                    return null;
                } else {
                    return left.getTargetNode(targetValue);
                }
            } else {
                if (right == null) {
                    return null;
                } else {
                    return right.getTargetNode(targetValue);
                }
            }

        }

        /**
         * 获取目标节点的父节点
         */
        public Node getParentNode(int targetValue) {
            if (left != null && left.value == targetValue) {
                return this;
            }
            if (right != null && right.value == targetValue) {
                return this;
            }
            if (left != null && targetValue < value) {
                return left.getParentNode(targetValue);
            }
            if (right != null && targetValue >= value) {
                return right.getParentNode(targetValue);
            }
            // 没有父节点
            return null;
        }
    }
}
