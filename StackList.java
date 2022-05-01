class Node{
    Node link;
    int data ;
    }
class Stack{

    //inner class Node :

    //top is obj of node :
    Node top;

    //stack contructor to intitalize top object as null :
    Stack(){
        this.top = null;
    }

    public void push(int no){
        Node tempNode = new Node();
        tempNode.data = no;
        tempNode.link = top;
        top = tempNode;

    }
    public int display(){
        if(top == null){
            System.out.println("Heap overflow : ");
            return 0;
        }
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.link;
        }
        return 1;
    }
    boolean isEmpty(){
        return top==null;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return 0;
        }
        top = (top).link;
        return 1;
    }
}
public class StackList {
        public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(60);
        obj.push(70);

        obj.pop();
        obj.display();
    }
}
