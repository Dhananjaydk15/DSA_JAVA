class CirculerQueue{
    int front=-1 , rear=-1 ,size ;
    int arr[];
    CirculerQueue(int size){
        this.size = size;
        arr = new int[size];
    }
    boolean isEmpty(){

        return rear == -1 ;
    }
    boolean isFull(){
        return ((rear + 1)%size) == front;
    }
    int enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full : ");
            return -1;
        }
        if(rear == -1){
            front = front + 1;
        }
        rear = (rear + 1)%size;
        arr[rear] = data;
        return 1;
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty : ");
            return 0;
        }
        int x = arr[front];
        if(front==rear)
        {
            front=0;
            rear = -1;
            return x;
        }
        front = (front + 1)%size;
        //if(front==rear){front = 0; rear = -1;}//Reset the Queue : 
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

