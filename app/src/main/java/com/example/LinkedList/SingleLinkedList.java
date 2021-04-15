package com.example.LinkedList;

/**
 * bajie on 2021/4/15 17:35
 */
public class SingleLinkedList {

    private Node head = null;    // 链头

    public SingleLinkedList() {
    }

    public Node findByValue(int value) {
        Node node = head;
        // 优化写法
        while (node != null && node.data != value) {
            node = node.next;
        }
        return node;
        // 开始写法
//        do {
//            if(node.data == value) {
//                return node;
//            }
//            if(node.next==null) return null;
//            node = node.next;
//
//        }while (true);
    }

    public Node findByIndex(int index) {
        if(index < 0) {
            System.out.println("LinkedList::index不合法::" + index);
            return null;
        }
        Node node = head;
        int i = 0;
        while (node!= null && i != index) {
            node = node.next;
            i ++;
        }
        if(node == null) {
            System.out.println("LinkedList::index不合法::" + index);
            return null;
        }
        return node;
    }

    // 在链头插入
    public void insertAtHead(int value) {
        Node newNode = new  Node(value, null);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 在链尾插入
    public void insert(int value) {
        Node newNode = new  Node(value, null);
        if(head == null) {
            head = newNode;
            return;
        }
        // 找到顶部节点
        Node topNode = head;
        while (topNode.next != null) {
            topNode = topNode.next;
        }
        topNode.next = newNode;

    }

    public static void test() {
        SingleLinkedList list = new SingleLinkedList();
        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insertAtHead(-1);
        Node node =list.findByValue(0);
        if(node == null) {
            System.out.println("LinkedList::没有找到值为0的节点");
        }
        else {
            System.out.println("LinkedList::找到值为0的节点::"+node.data);
        }
        node =list.findByValue(5);
        if(node == null) {
            System.out.println("LinkedList::没有找到值为5的节点");
        }
        else {
            System.out.println("LinkedList::找到值为5的节点::"+node.data);
        }

        node = list.findByIndex(0);
        if(node != null) {
            System.out.println("LinkedList::index=0::node=" + node.data);
        }
        node = list.findByIndex(5);
        if(node != null) {
            System.out.println("LinkedList::index=5::node=" + node.data);
        }
        node = list.findByIndex(6);
        if(node != null) {
            System.out.println("LinkedList::index=6::node=" + node.data);
        }
    }

}

class Node {
    int data;
    Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
