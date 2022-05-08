//----------------------------------------: Node :---------------------------------------------
class Node {
    Node next;
    int data;

    Node(int data) { // ___________
        next = null; // | | |
        this.data = data; // --->| data|next |---->null
    } // |_____|_____|
} // Node

// ---------------------------------------------------------------------------------------------
// ----------------------------------: Linked list implimentation
// :-----------------------------
class LinkedList {
    Node head = null;

    void insertFront(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else
            temp.next = head;// null :
        head = temp;
    }

    void insertEnd(int data) {
        Node temp = new Node(data);
        temp.next = null;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    void insertAfter(int data, int element) {
        Node temp = new Node(data);
        temp.next = null;
        Node curr = head;
        while ((curr.next != null) && curr.data != element) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
    }

    void insertBefore(int data, int element) {
        Node temp = new Node(data);
        temp.next = null;
        Node curr = head;
        if (element == head.data) {
            temp.next = head;
            head = temp;
            return;
        }
        while (curr.next.data != element) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
    }

    int deleteFront() {
        if (head == null) {
            System.out.println("\t* List is Empty : ");
            return -1;
        }
        int x = head.data;
        head = head.next;
        return x;
    }

    int deleteEnd() {
        if (head == null) {
            System.out.println("\t* List is Empty : ");
            return -1;
        }
        if (head.next == null) {
            int x = head.data;
            head = null;
            return x;
        }
        Node temp = head.next;
        Node prev = head;
        while (temp.next != null) {
            temp = temp.next;
            prev = prev.next;
        }
        int x = temp.data;
        prev.next = null;
        return x;
    }

    int delete(int element) {
        Node temp = head.next, prev = head;
        if (head.data == element) {
            int x = head.data;
            head = head.next;
            return x;
        }
        while (temp.data != element) {
            temp = temp.next;
            prev = prev.next;
        }
        int x = temp.data;
        temp = temp.next;
        prev.next = temp;
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

    void resetList() {
        head = null;
        System.out.println("\t* List Reset : ");
    }

    int listLenght() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void reverseList() {
        Node prev = null;
        Node curr = head;
        Node tempnext = null;
        while (curr != null) {
            tempnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempnext;
        }
        head = prev;
    }

    void sortList() {
        Node temp;
        Node tempNode = head;
        int t = 0;
        while (tempNode.next != null) {
            temp = head;
            while (temp.next != null) {
                if (temp.data > temp.next.data) {
                    t = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = t;
                }
                temp = temp.next;
            }
            tempNode = tempNode.next;
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.insertFront(50); // Node 4 : // 50
        ls.insertFront(60); // Node 2 : // 60 50
        ls.insertFront(70); // Node 1 : // 70 60 50 :
        ls.insertEnd(80); // Node 6 : last Node : // 70 60 50 80
        ls.insertAfter(25, 50); // after 50 : Node 5 : 70 60 50 25 80
        ls.insertBefore(65, 50); // before 50 : Node 3 : 70 60 65 50 25 80
        ls.insertBefore(90, 70); // before 70 : Node 0 : or head : 90 70 60 65 50 25 80
        System.out.println("\t* List : ");
        ls.display(); //
        System.out.println("\t* Sorted list : ");
        ls.sortList();

        ls.display();
        // System.out.println("\t* Lenght of String : "+ls.listLenght());
        // ls.deleteFront(); // delete 90:
        // ls.deleteEnd(); // delete 80:
        // ls.delete(65); // delete 65 ;
        // System.out.println("\t* head : "+ls.head.data); //head node : 70
        // System.out.println("\t* List after deletion : ");
        // ls.display(); // list traversal after deletion :
        // ls.listLenght();
        // System.out.println("\t* Lenght of String : "+ls.listLenght());
        // System.out.println(ls.head.data);
        // System.out.println("\t* List become permanently reverse : ");
        // ls.reverseList(); // reverse the list permanently :
        // ls.display();
    }
}