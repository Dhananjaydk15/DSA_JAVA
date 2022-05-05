
public class CirculerQueueDemo {
    public static void main(String[] args) {
        CirculerQueue q = new CirculerQueue(5);
        q.enqueue(10);        
        q.enqueue(20);        
        q.enqueue(30);        
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("list : ");
        q.display();        
        System.out.println("dequeue :"+q.dequeue());
        System.out.println("dequeue :"+q.dequeue());
        System.out.println("dequeue : "+q.dequeue());
        System.out.println("dequeue : "+q.dequeue());
        System.out.println("dequeue : "+q.dequeue());
        //System.out.println("dequeue : "+q.dequeue());

        // q.dequeue();
        // q.dequeue();

        System.out.println("list after Dequeue : ");
        q.display();


    }
}