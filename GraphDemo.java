import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

}

class Graph {
    void addEdge(ArrayList<LinkedList<Integer>> adj, int v1, int v2) {
        // adj.get(v1).add(v1);
        adj.get(v1).add(v2);
        // adj.get(v2).add(v1);
    }

    void display(ArrayList<LinkedList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("vertex : " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("--> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    void BFS(ArrayList<LinkedList<Integer>> adj,int start)
    {
        boolean visited[] = new boolean[5];
        Gqueue<Integer> queue = new Gqueue<>();
        visited[start]=true;
        queue.enqueue(start);
 
        while (!queue.isEmpty())
        {
            start = (int) queue.dequeue();
            System.out.print(start+" ");

            Iterator<Integer> i = adj.get(start).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.enqueue(n);
                }
            }
        }
    }
    // void DFSimp(ArrayList<LinkedList<Integer>> adj,int v,boolean[] visited){
    //     visited[v] = true;
    //     System.out.print(" "+v);
    //     Iterator itr = adj.get(v).iterator();
    //     while(itr.hasNext())
    //     {
    //         int no = (int) itr.next();
    //         if(!visited[no])
    //         {
    //             DFSimp(adj, no,visited);
    //         }
    //     }

    // }
    // void DFS(ArrayList<LinkedList<Integer>> adj,int v)
    // {
    //     boolean visited[] = new boolean[5];
    //     DFSimp(adj,v,visited);
    // }

    void DFS(ArrayList<LinkedList<Integer>> adj,int start){
        GStack<Integer> st = new GStack<>();
        boolean visited[] = new boolean[5];
        visited[start] = true;
        st.push(start);
        while(!st.isEmpty())
        {
            start = (int)st.peek();
            System.out.print(" "+start);
            st.pop();
            Iterator itr = adj.get(start).iterator();

            while(itr.hasNext()){
                int no = (int)itr.next();
                if(!visited[no])
                {
                    visited[no] = true;
                    st.push(no);
                }
            }
        }
    }

}

public class GraphDemo {
    public static void main(String[] args) {
    int vertex = 4;

        ArrayList<LinkedList<Integer>> adj = new ArrayList<>(vertex);
        int i = 0;
        while (i <= vertex) {
            adj.add(new LinkedList<Integer>());
            i++;
        }

        Graph g = new Graph();
        g.addEdge(adj, 0, 1);
        g.addEdge(adj, 0, 2);
        g.addEdge(adj, 1, 2);
        g.addEdge(adj, 2, 0);
        g.addEdge(adj, 2, 4);
        g.addEdge(adj, 2, 3);
        g.addEdge(adj, 3, 3);
        g.addEdge(adj, 4, 3);


        g.display(adj);

        System.out.print("BFS : ");
        g.BFS(adj, 0);
        System.out.print("\nDFS : ");
        g.DFS(adj, 2);

    }
}
