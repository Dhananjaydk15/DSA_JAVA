import java.lang.*;
import java.util.Arrays;



class StackList<T> {
    class Node {
        Object value;
        Node next;
    }
    Node top;
    int size = 1;
    StackList() {
        this.top = null;
    }

    // generic method :
    public <T> void push(T value) {
        size++;
        // need to create temperory Node :
        Node tempNode = new Node();
        tempNode.value = value;
        tempNode.next = top; // tempNode->next node is become null :
        top = tempNode;
    }

    public Object pop() {
        size--;
        if (isEmpty()) {
            System.out.print("\t* Stack is underflow :");
            Object y = 0;
            return y;
        }
        Object x = top.value;
        top = (top).next;
        return x;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int displayStack() {
        if (isEmpty()) {
            System.out.print("\t* Stack is underflow : ");
            return -1;
        }
        Node tempNode = top;
        while (tempNode != null) {
            System.out.println("\t " + tempNode.value);
            tempNode = tempNode.next;
        }
        return 0;
    }
    public Object peek(){
    Node tempNode = top;
    Object val = tempNode.value;
    return  val;
    }

    public <T> void listToArray(StackList obj){
        Node temp = top;
        int i = 0;
        Object[] arr = new Object[this.size];
        while(temp != null){
           arr[i] =  temp.value;
           temp = temp.next;
           i++;
        }
        System.out.println(Arrays.toString(arr));
    }
}

public class GenericStack {
    @SuppressWarnings("unchecked")
        public static void main(String[] args) {
            StackList st = new StackList();
            
            //pop before making list :
            System.out.println(st.pop());
            st.push("Akash");
            st.push("Shitlesh");
            st.push("Nikita");
            st.push("Amol");
            st.push("Shashi");
            
            //list before pop():
            st.displayStack();
            System.out.println("\t* pop : "+st.pop());
            
            //list after pop();
            System.out.println("\t* List after pop : ");
            st.displayStack();
            System.out.println("\t* peek last element from stack : "+st.peek());
            
            //print array of stack:
            System.out.print("\t* List as Array : ");
            st.listToArray(st);


        }
}
