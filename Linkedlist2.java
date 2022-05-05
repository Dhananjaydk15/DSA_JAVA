class linkedList{
    class Node{
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
        }
    }
    Node head ;
    void insertFront(int data){
        Node temp = new Node(data);
        if(temp==null)
        {
            System.out.println("\t* Heap overflow : ");
        }
        temp.next = head;
        head = temp; 
    }
    void insertEnd(int data){
        Node temp = new Node(data);
        if(temp==null){
            System.out.println("\t* Heap overflow : ");
        }
        Node tempNode = head;
        while(tempNode.next!=null){
            tempNode = tempNode.next;
        }
        tempNode.next = temp;
        //temp.next = null;
    }
    void display(){
        Node temp = head ;
        while(temp!=null){
            System.out.println(" "+temp.data);
            temp = temp.next;
        }
    }
}
public class Linkedlist2 {
    public static void main(String[] args) {
        linkedList ls = new linkedList();
        ls.insertFront(10);  // 10
        ls.insertFront(20); // 20 10
        ls.insertFront(30); // 30 20 10
        ls.insertFront(40); // 40 30 20 10
        ls.display();
        ls.insertEnd(11);
        System.out.println("After insertion : ");
        ls.display();

    }
}
