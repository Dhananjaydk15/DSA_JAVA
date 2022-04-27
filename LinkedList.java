class Node {
    Node head, next;
    int data;
    Node(int d) {
        data = d;
        next = null;
    }
}
public class LinkedList {
    public static void main(String[] args) {
        int i = 0;
        Node list = new Node(0);

        Node head = list.head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(5);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        
        while (head != null) {
            
            System.out.println("Node " + i + " : " +   head.data);
            head = head.next;
            i++;
        }

    }

}