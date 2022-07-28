//Without Front Pointer :
complexity of Deletion : O(n);
more mamory effieciant : 
class Queue{
    int rear = -1 ,size;
    int arr[];
    Queue(int size){
        this.size = size;
        arr = new int[size];
    }
    boolean isFull(){
        return rear == (size-1);
    }
    void isEmpty() throws EmptyQueueException{
        if(rear == -1){
            throw new EmptyQueueException();
        }
    }
    int enqueue(int data){
        if(isFull()){
            System.out.println("\t* Queue is Full : ");
            return -1;
        }
        rear = ++rear;
        arr[rear] = data;
        return 1;
    }
    int dequeueFront() throws EmptyQueueException{   //Time complexity : O(n);
        isEmpty();
        int i =0;
        while(i<rear){
            arr[i]=arr[i+1];
            i++;
        }
        if(rear < size){
            arr[rear] = 0;
        }
        return rear = rear - 1;
    }
    void display(){
        int i = 0;
        while(i <= rear){
            System.out.println(arr[i]);
            i++;
        }
    }
    int fistElement(){
        return arr[0];
    }
    int lastElement(){
        
        return arr[rear];
    }
}
public class ArrayQueue {
    public static void main(String[] args) throws EmptyQueueException{
        Queue ql = new Queue(7);
        System.out.println("\t* is Full : "+ql.isFull());
        try{
        ql.isEmpty();
        }catch(EmptyQueueException e){System.out.println(e.getMessage());};
        ql.enqueue(10);
        ql.enqueue(20);
        ql.enqueue(30);
        ql.enqueue(40);
        ql.enqueue(50);
        ql.enqueue(60);
        System.out.println("\t* First element : "+ql.fistElement());
        System.out.println("\t* Last element : "+ql.lastElement());
        System.out.println("\t* List : ");
        ql.display();
        System.out.println("\t* list after deqeue front element : ");
        ql.dequeueFront();
        System.out.println("\t* First element : "+ql.fistElement());
        System.out.println("\t* Last element : "+ql.lastElement());
        ql.display();
        ql.enqueue(70);
        try{
        ql.dequeueFront();
        ql.dequeueFront();
        ql.dequeueFront();
        ql.dequeueFront();
        ql.dequeueFront();
        //ql.dequeueFront();
        // ql.dequeueFront();
        }catch(EmptyQueueException e2){};

        System.out.println("\t* Last element : "+ql.lastElement());
        ql.isEmpty();
    }
}
