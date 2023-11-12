package LinkedLists;

class Node{
    int data;
    Node next;

    Node(int num){
        this.data = num;
    }
}

public class Demo {

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);

        Node res = insertBegin(head, 1);
//        res = insertBegin(res, 202);
        res = insertEnd(res, 12);

        res = insertAtPosition(res, 4, 202);
        res = insertAtPosition(res, 1, 11);
        res = deleteHead(res);
        res = deleteTail(res);
        printList(res);
        System.out.println(searchVal(res, 202));
    }

    static int searchVal(Node head, int val){

        if(head == null) return -1;
        if(head.data == val) return 1;
        else {
            int res = searchVal(head.next, val);
            if(res == -1) return -1;
            else return res + 1;
        }
    }

    static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;

        Node cur = head;

        while(cur.next.next != null){
            cur = cur.next;
        }

        cur.next = null;

        return head;
    }
    static Node deleteHead(Node head){
        return head.next;
    }

    static Node insertAtPosition(Node head, int pos, int val){

        Node temp = new Node(val);

        if(pos == 1){
            temp.next = head;
            return temp;
        }

        Node cur = head;
        for (int i = 1; i <= pos - 2 && cur != null; i++) {
            cur = cur.next;
        }

        if(cur == null) return head;

        temp.next = cur.next;
        cur.next = temp;


        return head;
    }

    static Node insertEnd(Node head, int val){
        Node temp = new Node(val);

        if(head == null) return temp;

        Node cur = head;

        while(cur.next != null){
            cur = cur.next;
        }

        cur.next = temp;

        return head;
    }


    static Node insertBegin(Node head, int val){

        Node newH = new Node(val);
        newH.next = head;

        return newH;
    }

    static void printList(Node h){

        while(h != null){
            System.out.println(h.data);

            h = h.next;
        }
    }



}
