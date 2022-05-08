
class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    Node head;

    void insertFront(int data) { // Time complexcity :- O(1) :
        Node temp = new Node(data);
        temp.next = head;
        temp.prev = null;
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
        // head.prev = null;
    }

    void insertEnd(int data) {
        Node temp = new Node(data);
        Node curr = head;
        if (head == null) { // Time complexity in best case :- O(1)
            temp.prev = null;
            head = temp;
            return;
        }
        while (curr.next != null) // Time complexity is best case :- O(n):
        {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        temp.next = null;

    }

    void insertBefore(int data, int element) {
        Node temp = new Node(data);
        Node curr = head;
        while (curr.data != element) {
            curr = curr.next;
            if (curr.next == null) {
                System.out.println("\t* Element is not found : ");
                return;
            }
        }
        temp.prev = curr.prev;
        curr.prev = temp;
        temp.next = curr;
        if (temp.prev != null) {
            temp.prev.next = temp;
        } else
            head = temp;
    }

    void insertAfter(int data, int element) {
        Node temp = new Node(data);
        Node curr = head;
        while (curr.data != element) {
            if (curr.next == null) {
                System.out.println("\t* Element is not found : ");
                return;
            }
            curr = curr.next;
        }
        if (curr.next == null) {
            curr.next = temp;
            temp.prev = curr;
            return;
        }
        curr = curr.next;
        temp.prev = curr.prev;
        curr.prev = temp;
        temp.next = curr;
        temp.prev.next = temp;
    }

    int deleteFront() {
        if (head == null) {
            System.out.println("\t* List is Empty : ");
            return -1;
        }
        int x = 0;
        if (head.next == null) {
            x = head.data;
            head = null;
            return x;
        }
        x = head.data;
        head.next.prev = null;
        head = head.next;
        return x;
    }

    int deleteEnd() {
        if (head == null) {
            System.out.println("\t* List is Empty : ");
            return -1;
        }
        int x = 0;
        Node curr = head;
        if (head.next == null) {
            x = head.data;
            head = null;
            return x;
        }
        while (curr.next != null) {
            curr = curr.next;
        }
        x = curr.data;
        curr.prev.next = null;
        return x;
    }
    int delete(int element)
    {
        int x = 0;
        if(head==null)
        {
            System.out.println("\t* List is Empty : ");
            return x;
        }
        if(head.data==element)
        {
            x = head.data;
            head = head.next;
            return x;
        }
        Node curr = head;
        while(curr.data!=element)
        {
            curr = curr.next;
        }
        x = curr.data;
        if(curr.next==null)
        {
            x = deleteEnd();
            return x ;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        return x;

    }
    void display() {

        if (head == null) {
            System.out.println("\t* List is Empty : ");
            return;
        }
        int i = 0;
        Node temp = head;
        while (temp != null) {
            System.out.println("\t-> Node " + i + " : " + temp.data);
            temp = temp.next;
            i++;
        }
    }

    void displayrev() {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // System.out.println(curr.data);
        int i = 0;
        while (curr != head) {
            System.out.println("\t-> Node " + i + " : " + curr.data);
            curr = curr.prev;
            i++;
        }
        System.out.println("\t-> Node " + i + " : " + curr.data);

    }
}

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList ls = new DoublyLinkedList();
        ls.insertFront(40);  // 40
        ls.insertFront(30);  // 30 40
        ls.insertEnd(50);    // 30 40 50
        ls.insertEnd(60);    // 30 40 50 60
        ls.insertBefore(23, 100); // 30 40 50 60
        ls.insertAfter(35, 30);   // 30 35 40 50 60
        System.out.println("\t* List : ");
        ls.display();
        System.out.println("\t* Delete : "+ls.deleteFront()); //35 40 50 60
        System.out.println("\t* Delete : "+ls.delete(50));   //35 40 60 
        System.out.println("\t* Delete : "+ls.deleteEnd());   //35 40 
        System.out.println("\t* Delete : "+ls.delete(40));   //35 
        System.out.println("\t* List after deletion : ");
        ls.display();
        System.out.println("\t* Reverse List: ");
        ls.displayrev();
    }
}
