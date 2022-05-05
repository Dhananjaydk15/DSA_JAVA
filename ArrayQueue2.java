class QueueF{
    int front=0 , rear=-1 ,size ;
    int arr[],currentS=0;
    QueueF(int size){
        this.size = size;
        arr = new int[size];
    }
    boolean isEmpty(){

        return front == currentS;
    }
    boolean isFull(){
        return rear == (size -1) ;
    }
    int enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full : ");
            return -1;
        }
        currentS++;
        rear = rear + 1;
        arr[rear] = data;
        return 1;
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty : ");
        }
        int x = arr[front];
        front = front + 1;
        if(front==size){front = 0; rear = -1;} //Queue Reset : 
        currentS--;
        return x;
    }
    int display(){
        if(isEmpty()){
            System.out.println("\t* Queue is Empty : ");
            return -1;
        }
        for (int i = front; i <= rear; i++) {
            System.out.println("\t"+arr[i]);
        }
        return 1;
    }
    int FirstElement(){
        if(isEmpty()){return 0;}
        return arr[front];
    }
}
public class ArrayQueue2 {
    public static void main(String[] args) {
        QueueF ql = new QueueF(5);
        System.out.println("\t* is Empty : "+ql.isEmpty());
        ql.enqueue(10);
        ql.enqueue(20);
        ql.enqueue(30);
        ql.enqueue(40);
        ql.enqueue(50);
        System.out.println("\t* Display : ");
        ql.display();
        System.out.println("\t* is Full : "+ql.isFull());

        System.out.println("\t* Dequeue : "+ql.dequeue());//10 = front : 1
        System.out.println("\t* Dequeue : "+ql.dequeue());//20 = front : 2
        System.out.println("\t* Dequeue : "+ql.dequeue());//30 = front : 3 
        System.out.println("\t* Dequeue : "+ql.dequeue());//40 = front : 4
        System.out.println("\t* Dequeue : "+ql.dequeue());//50 = but ( front == size ) front = 0;

        System.out.println("\t* After Dequeue : ");
        ql.display();
        System.out.println("\t* First element : "+ql.FirstElement());
        ql.enqueue(70);
        ql.enqueue(80);
        ql.enqueue(90);
        ql.enqueue(100);

        System.out.println("\t* First element : "+ql.FirstElement());
        System.out.println("\t* Display : ");
        ql.display();


    }
}
