import java.util.LinkedList;

public class MergeSort {
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

    public void addFirst(int data)// TC = O(1)
    {
        // s1-create new node
        Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode;
            return;
        }
        // s2-newnode = head
        newnode.next = head;// link

        // s3-head = newnode
        head = newnode;
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;// mid node
    }

    public Node merge(Node Left, Node Right) {
        Node Mergedll = new Node(-1);
        Node temp = Mergedll;

        while (Left != null && Right != null) {
            if (Left.data <= Right.data) {
                temp.next = Left;
                Left = Left.next;
                temp = temp.next;
            } else {
                temp.next = Right;
                Right = Right.next;
                temp = temp.next;
            }
        }

        while (Left != null) {
            temp.next = Left;
            Left = Left.next;
            temp = temp.next;
        }
        while (Right != null) {
            temp.next = Right;
            Right = Right.next;
            temp = temp.next;
        }
        return Mergedll.next;
    }

    public Node mergesort(Node head) {
        // Base Case
        if (head == null || head.next == null) {
            return head;
        }
        // 1->find Mid
        Node mid = getMid(head);// we find mid -> head

        // 2->divide 2 part left and right
        Node right = mid.next;
        mid.next = null;
        Node newLeft = mergesort(head);
        Node neeRight = mergesort(right);
        // 3->Merge 3 part
        return merge(newLeft, neeRight);
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

    public static void main(String arg[]) {
        MergeSort ll = new MergeSort();
        // LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        // System.out.println(ll);
        ll.Print();
        ll.head = ll.mergesort(ll.head);
        ll.Print();
    }
}
