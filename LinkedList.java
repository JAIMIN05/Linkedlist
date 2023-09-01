import java.util.*;

public class LinkedList {
    public static class Node {
        int data;
        Node next;// refrence variable (point to next node)

        public Node(int data) {// create single node
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;// by default 0

    public void addFirst(int data)// TC = O(1)
    {
        // s1-create new node
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        // s2-newnode = head
        newnode.next = head;// link

        // s3-head = newnode
        head = newnode;
    }

    public void addLast(int data)// TC = O(1)
    {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        }
        tail.next = newnode;
        tail = newnode;
    }

    public void Print()// TC = O(n)
    {
        Node temp = head;// temp point to head
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void Middle(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newnode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1)// find previous element
        {
            temp = temp.next;
            i++;
        }
        // i = idx-1;temp->prev
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linkedlist is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        // for(int i=0;i<size-2;i++)
        // {
        while (prev.next.next != null) {
            prev = prev.next;
        }
        int val = prev.next.data;// tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key)// TC = O(n)
    {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Search using recursion
    public int helper(Node head, int key)// head ko change karne ke liye
    {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        if (index == -1) {
            return -1;
        }
        return index + 1;
    }

    public int recsearch(int key) {
        return helper(head, key);
    }

    public void Reverse() {
        Node pre = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        head = pre;
    }

    public static void main(String arg[]) {
        LinkedList ll = new LinkedList();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.Print();
        // ll.Middle(2, 5);
        // ll.Print();
        // System.out.println("size of LinkedList = " + size);

        // int R = ll.removeFirst();

        // System.out.println("Remove First element = " + R);
        // ll.removeFirst();
        // ll.Print();
        // System.out.println("size of LinkedList = " + size);

        int R = ll.removeLast();
        System.out.println("Remove last element  = " + R);
        // ll.removeLast();
        ll.Print();
        System.out.println("Remove last element  = " + size);

        // System.out.println("Key index = " + ll.itrSearch(3));

        // System.out.println("Key index(Recursion) = " + ll.recsearch(5));

        // ll.Reverse();
        // ll.Print();
    }
}