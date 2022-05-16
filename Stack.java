

class st{
    int top = -1;
    int size;
    int arr[];
    st(int size){
        this.size = size;
        arr = new int[size];
    }
    boolean isFull(){
        return top == (size-1);
    }
    boolean isEmpty(){
        return top == -1;
    }
    void push(int element){
        if(isFull()){
            System.out.println("\t* Stack Overflow : ");
            return;
        }
        top = top + 1;
        arr[top] = element;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("\t* Stack is Empty");
        }
        return arr[top--];
    }
    int peek(){
        if(isEmpty()){
            System.out.println("\t* Stack is empty : ");
            return 0;
        }
        return arr[top];
    }
    void displayStack(st Obj){
        if(isEmpty()){
            System.out.println("\t* Stack is Empty");
        }
        int i = 0;
        while(i <= top){
            System.out.println(Obj.arr[i]);
            i++;
        }
    }
}
public class Stack {
 public static void main(String[] args) {
     st obj = new st(5);
     obj.push(10);
     obj.push(11);
     obj.push(12);
     obj.push(13);
     obj.push(14);
     obj.push(24);
     int i = 0;
     obj.displayStack(obj);
     System.out.println(obj.pop()+" is poped : ");// remove 14 from stack :
     System.out.println("after pop :");
     obj.displayStack(obj);
     System.out.println("after push 16");
     obj.push(16); // add 16 instad of 14 in stack :
     obj.displayStack(obj);
     System.out.println("Top element : "+obj.peek());

 }   

}
