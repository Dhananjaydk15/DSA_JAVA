class CirculerLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node head;
    Node LastNode = null;
    void insertFront(int data) {
        Node temp = new Node(data);
        if (LastNode == null) {
            LastNode = temp;
            LastNode.next = LastNode;
            head = LastNode.next;
        }
        temp.next = LastNode.next;
        LastNode.next = temp;
        //head = LastNode.next;
    }

    void insertEnd(int data) {
        Node temp = new Node(data);
        if (LastNode == null) {
            LastNode = temp;
            LastNode.next = LastNode;
            head = LastNode.next;
        }
        temp.next = LastNode.next;
        LastNode.next = temp;
        LastNode = temp;
    }

    void insertBefore(int data, int element) {
        if (head.data == element) {
            insertFront(data);
            return;
        }
        Node temp = new Node(data);
        Node curr = head;
        while (curr.next.data != element) {
            if (curr.next == head) {
                System.out.println("\t* Element is not Found : ");
                return;
            }
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;
    }

    void insertAfter(int data, int element) {
        Node temp = new Node(data);
        Node curr = head;
        while (curr.data != element) {
            if (curr.next == head) {
                System.out.println("\t* Element is not Found : ");
                return;
            }
            curr = curr.next;
        }
        if (curr == LastNode) {
            temp.next = curr.next;
            curr.next = temp;
            LastNode = temp;
            head = LastNode.next;
            return;
        }
        temp.next = curr.next;
        curr.next = temp;
    }
    int deleteFront(){
        int x = 0;
        if(head==null)
        {
            System.out.println("\t* List is Empty : ");
            return 0;
        }
        if(head == LastNode )
        { 
            x = head.data;
            head = null;
            return x;
        }
        x = head.data;
        LastNode.next = head.next;
        head = LastNode.next;
        return x ;
    }
    int deleteEnd(){
        int x = 0;
        if(head == null)
        {
            System.out.println("\t* List is Empty : ");
            return 0;
        }
        if(head == LastNode )
        { 
            x = head.data;
            head = null;
            return x;
        }
        Node curr = head;
        while(curr.next!=LastNode)
        {
            curr = curr.next;
        }
        x= curr.next.data;
        LastNode = curr;
        LastNode.next = head;
        return x;
    }

    int delete(int element)
    {
        int x = 0;
        if(head == null)
        {
            System.out.println("\t* List is Empty : ");
            return 0;
        }
        if(element==head.data)
        {
            if(head==LastNode)
            {
                x = head.data;
                head = null;
                return x;
            }
            else
            x = head.data;
            head = head.next;
            LastNode.next = head;
            return x;
        }
        Node curr = head.next;
        Node prev = head;
        while(curr.data!=element)
        {
            if(curr.next==head)
            {
                System.out.println("\t* Element is not found : ");
                return 0;
            }
            prev = prev.next;
            curr = curr.next;
        }
        x = curr.data;
        if(curr==LastNode)
        {
            LastNode = prev;
            LastNode.next = head;
            return x;
        }
        prev.next = curr.next;
        return x;
    }
    void display() {
        if(head == null)
        {
            System.out.println("\t* Cant Display Because List is Empty : ");
            return;
        }
        int i = 0;
        Node temp = head;
        while (temp.next != head) {
            System.out.println("\t-> Node " + i + " : " + temp.data);
            temp = temp.next;
            i++;
        }
        System.out.println("\t-> Node " + i + " : " + temp.data);
    }
}

public class CirculerLinkedListDemo {
    public static void main(String[] args) {
        CirculerLinkedList ls = new CirculerLinkedList();
        System.out.println("\t* Delete : "+ls.deleteEnd());
        System.out.println("\t* Delete : "+ls.deleteFront());
        ls.insertFront(20); // 20
        ls.insertFront(10); // 10 20
        ls.insertEnd(30); // 10 20 30
        ls.insertEnd(40); // 10 20 30 40
        ls.insertAfter(15, 11); // element not found :
        ls.insertAfter(25, 20); // 10 20 25 30 40 :
        ls.insertBefore(35, 45);// element not found :
        ls.insertBefore(35, 40);// 10 20 25 30 35 40 :
        ls.insertAfter(45, 40);//// 10 20 25 30 35 40 45 :
        System.out.println("\t* List : ");
        ls.display();
        System.out.println("\t* List after deletion : ");
        // System.out.println("\t* Delete : "+ls.deleteFront());
        // System.out.println("\t* Delete : "+ls.deleteFront());
        // System.out.println("\t* Delete : "+ls.deleteEnd());
        // System.out.println("\t* Delete : "+ls.deleteFront());
        // System.out.println("\t* Delete : "+ls.deleteEnd());
        // System.out.println("\t* Delete : "+ls.deleteEnd());
        // System.out.println("\t* Delete : "+ls.deleteEnd());
        // System.out.println("\t* Delete : "+ls.deleteEnd());
        // System.out.println("\t* Delete : "+ls.deleteFront());
        System.out.println("\t* Delete : "+ls.delete(25));
        System.out.println("\t* Delete : "+ls.delete(10));
        System.out.println("\t* Delete : "+ls.delete(45));

        
        ls.display();

    }
}