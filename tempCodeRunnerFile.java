        ls.insertFront(70); // Node 1 : //  70 60 50 : 
        ls.insertEnd(80); // Node 6 : last Node :  // 70 60 50 80
        ls.insertAfter(25, 50); // after 50 : Node 5 :  70 60 50 25 80
        ls.insertBefore(65, 50); // before 50 : Node 3 : 70 60 65 50 25 80
        ls.insertBefore(90, 70); // before 70 : Node 0 : or head : 90 70 60 65 50 25 80
        System.out.println("\t* List : ");
        ls.display(); // 