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

    // 在节点P后面插入
    public void insertAfter(Node p, int value) {
        if(p == null) return;
        Node newNode = new Node(value, null);
        newNode.next = p.next;
        p.next = newNode;
    }

    // 在节点P前面插入
    public void insertBefore(Node p, int value) {
        if (p == null) return;
        // 如果p节点是头结点
        if(p.equals(head)) {
            insertAtHead(value);
            return;
        }
        Node newNode = new Node(value, null);
        // 找到P的前面一个节点
       Node pPre = head;
       while (pPre != null && !pPre.next.equals(p)) {
           pPre = pPre.next;
       }
       if(pPre!=null) {
           pPre.next = newNode;
           newNode.next = p;
       }
    }

    // 删除节点
    public void deleteNode(Node p) {
        if(p == null || head == null) return;
        if(head.equals(p)) {    // 如果要删除的节点是链头
            head = head.next;
            return;
        }
        // 找出要删除节点的前一个节点
        Node beforeOfDeleteNode = head;
        while (beforeOfDeleteNode != null && !beforeOfDeleteNode.next.equals(p)) {
            beforeOfDeleteNode = beforeOfDeleteNode.next;
        }
        if(beforeOfDeleteNode != null) {
            beforeOfDeleteNode.next = p.next;
        }
    }

    public void deleteByValue(int value) {
        if(head == null) return;
        Node p = head;
        while (p != null && p.next != null) {
            if(p.next.data == value) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        if(head.data == value) {
            head = head.next;
        }
    }

    public void printList() {
        Node newNode = head;
        System.out.print("LinkedList::");
        while (newNode != null) {
            System.out.print(newNode.data+ " ");
            newNode = newNode.next;
        }
        System.out.println("");
    }

    // 是否为回文
    public boolean palindrome() {
        if(head == null) return false;
        if(head.next == null) return true; // 链表只有一个节点

        // 更巧妙一些的解法
        // 快慢双指针获取中间结点
        Node slow = head;
        Node quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        Node rightNode = null;
        Node leftNode = null;
        // 链表结点数量为奇数，quick为最后一个节点，slow为中间结点
        if(quick.next == null) {
            rightNode = slow.next;
            // 翻转链表
            leftNode = inverseLinkList(slow).next;

        } else {    // 链表结点数量为双数
            rightNode = slow.next;
            leftNode = inverseLinkList(slow);
        }

        while (leftNode != null && rightNode != null) {
            // 不是回文
            if(leftNode.data != rightNode.data) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        return true;

        // 我的解法


//        Node top = head;
//        int topIndex = 0;
//        while (top.next != null) {
//            top = top.next;
//            topIndex ++;
//        }
//        int size = topIndex + 1;
//        Node h = head;
//        int hIndex = 0;
//
//
//        boolean isEven = size % 2 == 0;
//        int center = size / 2;
//        while (isEven ? hIndex-topIndex!=1 : !(topIndex == center && center == hIndex)) {
//            if(h.data != top.data) {
//                return false;
//            }
//            hIndex ++;
//            h = h.next;
//            topIndex --;
//            top = findByIndex(topIndex);
//        }
//
//        return true;
    }

    public Node inverseLinkList(Node p){
        // 更优解法
        Node pre = null;
        Node newHead = head;
        Node next = null;
        while (newHead != p) {
            next = newHead.next;
            // 遍历到原本链表的尾部还没发现p结点
            if(next == null) {
                return null;
            }
            newHead.next = pre;
            pre = newHead;
            newHead = next;
        }
        newHead.next = pre;
        return newHead;


        // 我的解法
//        if(head == null) return null;       // 链表为空
//        if(head.next == null) return new Node(head.data, null); // 链表只有一个链头
//
//        // 新链表头结点
//        Node newListHeader = new Node(p.data, null);
//        Node newListNode = null;
//        // 当前链表指向
//        Node currentNode = p;
//
//
//        while (!currentNode.equals(head)) {
//            Node q = head;
//            while (!q.next.equals(currentNode)) {
//                q = q.next;
//            }
//            Node n = new Node(q.data, null);
//            newListNode = newListHeader;
//            while (newListNode.next != null) {
//                newListNode = newListNode.next;
//            }
//            newListNode.next = n;
//
//            Node t = head;
//            while (!t.next.equals(currentNode)) {
//                t = t.next;
//            }
//            currentNode = t;
//        }
//        return newListHeader;
    }

    public static void test() {
        SingleLinkedList list = new SingleLinkedList();
        list.insert(0);
        list.insert(1);
        list.insert(1);
        list.insert(0);
//        list.insert(3);
//        list.insert(4);
//        list.insert(1);
//        list.insert(0);
//        list.insertAtHead(-1);
//        Node node =list.findByValue(0);
//        if(node == null) {
//            System.out.println("LinkedList::没有找到值为0的节点");
//        }
//        else {
//            System.out.println("LinkedList::找到值为0的节点::"+node.data);
//        }
//        node =list.findByValue(5);
//        if(node == null) {
//            System.out.println("LinkedList::没有找到值为5的节点");
//        }
//        else {
//            System.out.println("LinkedList::找到值为5的节点::"+node.data);
//        }
//
//        Node node0 = list.findByIndex(0);
//        if(node0 != null) {
//            System.out.println("LinkedList::index=0::node=" + node0.data);
//        }
//        node = list.findByIndex(5);
//        if(node != null) {
//            System.out.println("LinkedList::index=5::node=" + node.data);
//        }
//        Node node6 = list.findByIndex(6);
//        if(node6 != null) {
//            System.out.println("LinkedList::index=6::node=" + node6.data);
//        }
//
//        list.printList();
//
//        list.insertAfter(node6, 7);
//        System.out.print("insertAfter::");
//        list.printList();
//        list.insertAfter(node0, -2);
//        System.out.print("insertAfter::");
//        list.printList();
//
//        list.insertBefore(node0, -3);
//        System.out.print("insertBefore::");
//        list.printList();
//        list.insertBefore(list.findByIndex(9), 8);
//        System.out.print("insertBefore::");
//        list.printList();
//
//        list.deleteNode(list.findByIndex(0));
//        System.out.print("deleteNode::");
//        list.printList();
//        list.deleteNode(list.findByIndex(9));
//        System.out.print("deleteNode::");
//        list.printList();
//
//        list.insert(-1);
//        System.out.print("insert::");
//        list.printList();
//        list.deleteByValue(-1);
//        System.out.print("deleteByValue::");
//        list.printList();
//
//        list.deleteByValue(8);
//        System.out.print("deleteByValue::");
//        list.printList();
        list.printList();
        boolean result = list.palindrome();
        System.out.println("LinkedList::palindrome::" + result);

        Node node = list.inverseLinkList(list.findByIndex(4));
        list.printList();
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
