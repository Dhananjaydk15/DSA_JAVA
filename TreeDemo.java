class Tree {
    class Node {
        int data;
        Node right;
        Node left;
        public boolean visited;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;
    static Node prev;

    //Method to insert Node without recursion : 
    // void insert(int data) {
    //     if (root == null) {
    //         root = new Node(data);
    //         return;
    //     }
    //     Node curr = root;
    //     while (true) {
    //         if (data < curr.data) {
    //             if (curr.left == null) {
    //                 curr.left = new Node(data);
    //                 break;
    //             }
    //             curr = curr.left;
    //         } else {
    //             if (curr.right == null) {
    //                 curr.right = new Node(data);
    //                 break;
    //             }
    //             curr = curr.right;
    //         }
    //     }
    // }

    //Method to insert data using recursive function : 
    void insert(int data)
    {
        root = insert(root, data);
    }
    Node insert(Node temp ,int data){
        

        if(temp==null)
        {
            temp = new Node(data);
            return temp;
        }
        if(data>=temp.data)
        {
            temp.right = insert(temp.right, data);
        }
        else if(data<temp.data)
        {
            temp.left = insert(temp.left,data);
        }
        return temp;
    }

    //Method to check Tree is BST or Not : 
    boolean isBST() {
        prev = null;
        return isBST(root);
    }

    boolean isBST(Node root) {
        if (root != null) {
            if (!isBST(root.left)) {
                return false;
            }
            if (prev != null && root.data <= prev.data) {
                return false;
            }
            prev = root;
            return isBST(root.right);
        } else {
            return true;
        }

    }

    //Inorder Traversal using recursion : 
    void inOrderTrav(Node trav) {
        if (trav != null) {
            inOrderTrav(trav.left);
            System.out.print(trav.data + " -> ");
            inOrderTrav(trav.right);
        }
    }
    //Preorder Traversal using recursion : 
    void PreOrderTrav(Node trav) {
        if (trav != null) {
            System.out.print(trav.data + " -> ");
            PreOrderTrav(trav.left);
            PreOrderTrav(trav.right);
        }
    }
    //Postorder Traversal using recursion : 
    void postOrderTrav(Node trav) {
        if (trav != null) {
            postOrderTrav(trav.left);
            postOrderTrav(trav.right);
            System.out.print(trav.data + " -> ");
        }
    }

    // Non-Recursive method of PreOrder Traversal using stack :
    void preOrder(Node root) {
        Node trav = root;
        GStack<Object> st = new GStack<>();
        while (trav != null || !st.isEmpty()) {
            while (trav != null) {
                System.out.print(trav.data + " -> ");
                if (trav.right != null)
                    st.push(trav.right);
                trav = trav.left;
            }
            if (!st.isEmpty()) {
                trav = (Tree.Node) st.peek();
                st.pop();
            }
        }
    }
    // Non-Recursive method of inOrder Traversal using stack :

    void inOrder(Node root) {
        Node trav = root;
        GStack<Object> st = new GStack<>();
        while (trav != null || !st.isEmpty()) {
            while (trav != null) {
                st.push(trav);
                trav = trav.left;
            }
            if (!st.isEmpty()) {
                trav = (Tree.Node) st.peek();
                st.pop();
                System.out.print(trav.data + " -> ");
                trav = trav.right;
            }
        }
    }
    // Non-Recursive method of postOrder Traversal using stack :

    void postOrder(Node root) {
        Node trav = root;
        GStack<Object> st = new GStack<>();
        while (trav != null || !st.isEmpty()) {
            while (trav != null) {
                st.push(trav);
                trav = trav.left;
            }
            if (!st.isEmpty()) {
                trav = (Tree.Node) st.peek();
                st.pop();
                if (trav.right == null || trav.right.visited == true) {
                    System.out.print(trav.data + " -> ");
                    trav.visited = true;
                    trav = null;
                } else {
                    st.push(trav);
                    trav = trav.right;
                }
            }
        }
    }

    //Search element From Tree : 
    boolean search(Node root, int key) {
        if (root.data == key) {
            return true;
        } else if (root.data > key && (root.right != null || root.left != null)) {
            return search(root.left, key);
        } else if (root.data < key && (root.left != null || root.right != null)) {
            return search(root.right, key);
        }
        return false;
    }

    //Deletion : 
    Node delete(Node root,int value)
    {
        //if root Node is null then print Node is not present : 
        if(root==null)
        {
            System.out.println("\n\t* Node is not present : ");
            return root;
        }
        Node temp = root ;
        //search Node who want to deleted : 
        if(value > temp.data)
        {
            temp.right = delete(temp.right, value);
            return temp;
        }
        else if(value <temp.data){
            temp.left = delete(temp.left, value);
            return temp;
        }

        //Delete Node who has only one child or this node leaf it self : 
        if(temp.left == null)
        {
            Node t = temp.right;
            return t;
        }
        else if(temp.right == null)
        {
            Node t = temp.left;
            return t;
        }

        //delete no leaf or internal node : 
        else{
            Node succparant = temp ;
            Node succ = temp.right;
            while(succ.left!=null)
            {
                succparant = succ;
                succ = succ.left;
            }
            if(succparant != temp)
            {
                succparant.left = succ.right;
            }
            else
                succparant.right = succ.right;
            temp.data = succ.data;
        }
        return temp;
    }

    //Find Minimum value from Tree : 
    Node minValue(Node root){
        Node temp = root;
        if(temp.left!=null)
        {
            temp.left = minValue(temp.left);
            return temp;
        }
        System.out.println("\n\t* Minimum Value : "+temp.data);
        return temp;
    }

    //Find Maximum value From Tree : 
    Node maxValue(Node root){
        Node temp = root;
        if(temp.right!=null)
        {
            temp.right = maxValue(temp.right);
            return temp;
        }
        System.out.println("\n\t* Maximum Value : "+temp.data);
        return temp;
    }

    //Calculate Height Tree : 
    int height(Node root){
        // if root is null then height of tree is 0;
        if(root==null)
        {
            return 0;
        }
        else{
            // compute height of Both sub tree : 
            int lheight = height(root.left);
            int Rheight = height(root.right);

            //Compaire height of both sub tree : 
            if(lheight > Rheight )
            {
                return lheight+1 ;
            }
            else
            {
                return Rheight+1;
            }
        }
    }

    //Level order Traversal :- (BFS)
    void BFS(Node root){
        Node temp  = root;
        Gqueue<Node> q = new Gqueue<>();
        q.enqueue(temp);
        //System.out.println(temp.data);
        while(!q.isEmpty())
        {
            temp = (Tree.Node)q.dequeue();
            System.out.print(temp.data + " -> ");
            if(temp.left!=null)
            {
                q.enqueue(temp.left);
            }
            if(temp.right!=null)
            {
                q.enqueue(temp.right);
            }
        }
    }
}

public class TreeDemo {
    public static void main(String[] args) {
        Tree obj = new Tree();
        obj.insert(50);
        obj.insert(70);
        obj.insert(45);
        obj.insert(15);
        obj.insert(100);
        obj.insert(25);
        obj.insert(55);

        //Find 100 in Tree : 
        if (obj.search(obj.root, 100)) {
            System.out.println("\t* 100 is founded : ");
        } else {
            System.out.println("\t* 100 is not founded : ");
        }

        //Tree : 
        /*
         *    50
         *    / \
         *   45 70
         *  /   / \
         * 15  55 100
         *  \
         *   25
         */

         //Check Tree is BST or  Not : 
        if (obj.isBST()) {
            System.out.println("\t* Tree is BST : ");
        } else
            System.out.println("\t* Tree is Not BST : ");

        System.out.println("\n\t* Inorder Traversal : ");
        obj.inOrderTrav(obj.root);
        System.out.println("\n* Postorder Traversal : ");
        obj.postOrderTrav(obj.root);
        System.out.println("\n* preorder Traversal : ");
        obj.PreOrderTrav(obj.root);

        // System.out.println("\n* preorder Traversal Non-recursive : ");
        // obj.preOrder(obj.root);
        // System.out.println("\n* Inorder Traversal Non-recursive : ");
        // obj.inOrder(obj.root);
        // System.out.println("\n* postorder Traversal Non-recursive : ");
        // obj.postOrder(obj.root);

        

        obj.delete(obj.root, 50);
        System.out.println("\n\t* Inorder after Deletion : ");
        obj.inOrder(obj.root);
        obj.minValue(obj.root);
        obj.maxValue(obj.root);

        //Height of tree : 
        System.out.println("\t* Height of The Tree : "+obj.height(obj.root));

        //level order Traversal of tree : 
        System.out.println("\t* Level Order Traversal : ");
        obj.BFS(obj.root);
    }
}
