import java.util.Scanner;

class Sort {
    int arr[];
    int size;
    Scanner in = new Scanner(System.in);

    Sort(int size) {
        this.size = size;
        arr = new int[size];
    }

    void setArray() {
        System.out.print("\t* Enter The Element : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
    }


    void printArray() {
        System.out.print("\t ");
        for (int j = 0; j < size; j++) {
            System.out.print(" " + arr[j]);
        }
        System.out.println();
    }

    //1. Bubble Sort :- 
    void bubbleSort(int[] arr) {
        int temp = 0, count = 0;
        boolean isSorted = false;
        for (int i = 0; i < arr.length - 1; i++) {
            isSorted = true;
            count++;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted == true) {
                break;
            }
        }
        System.out.println("\t* Passes : " + count);
    }
    /*
    ->Time Complexity :- O(n^2);
    ->Space :- O(1);
    ->Stability : Stable
    ->Adaptive :  Now Adaptive --> Best Case :- O(n);
    ------------------------------------------------------------------------------------*/


    //2. Insertion Sort :- 
    void insertionSort(int arr[]) {
        int count = 0;
        System.out.println();
        for (int i = 1; i < size; i++) {
            int key = arr[i], j;
            count++;
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        System.out.println("\t* Passes : " + count);
    }
    /*
    ->Time Complexity :- O(n^2);
    ->Space :- O(1);
    ->Stability : Stable
    ->Adaptive :  Adaptive --> Best Case :- O(n);
    ------------------------------------------------------------------------------------*/

    //3. Selection Sort :- 
    void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /*
    ->Time Complexity :- O(n^2);
    ->Space :- O(1);
    ->Stability : unStable
    ->Adaptive :  Not Adaptive --> Best Case :- O(n^2);
    ------------------------------------------------------------------------------------*/

    //3.1 Stable Selection sort :-

    void selectionSortStable(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int key = arr[min];
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }
            arr[min] = key;
        }
    }

    //4. Merge Sort :- 
    void merge(int arr[], int left, int middle, int right) {
        int llarr = middle - left + 1;
        int lrarr = right - middle;

        int[] Larr = new int[llarr];
        int[] Rarr = new int[lrarr];

        for (int i = 0; i < llarr; i++) {
            Larr[i] = arr[left + i];
        }
        for (int i = 0; i < lrarr; i++) {
            Rarr[i] = arr[middle + 1 + i];
        }

        int i, j, k;
        i = j = 0;
        k = left;
        while (i < llarr && j < lrarr) {
            if (Larr[i] <= Rarr[j]) {
                arr[k] = Larr[i];
                i++;
            } else {
                arr[k] = Rarr[j];
                j++;
            }
            k++;
        }

        while (i < llarr) {
            arr[k] = Larr[i];
            i++;
            k++;
        }
        while (j < lrarr) {
            arr[k] = Rarr[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arr[], int left, int right) {
        if (left < right) {
        int middle = left + ((right - left) / 2);
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }

    }

    /*
    ->Time Complexity :- O(nlogn);
    ->Space :- O(n);
    ->Stability : Stable
    ->Adaptive :  Not Adaptive --> Best Case :- O(nlogn);
    ------------------------------------------------------------------------------------*/

    //5.Quick Sort :
    int Partition(int arr[],int l, int h)
    {
        int temp = 0;
        int pivot = arr[h];
        int i = (l-1);
        int j = l;
        while(j<h)
        {
            if(arr[j]<pivot)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        temp = arr[i+1];
        arr[i+1] = arr[j];
        arr[j] = temp;
        return (i+1);
    }
    void quickSort(int arr[], int l , int h){
        if(l < h)
        {
            int pi = Partition(arr, l, h);

            quickSort(arr, l, pi-1);
            quickSort(arr, pi+1, h);
        }
    }

     /*
    ->Time Complexity :- 
    1. Average Case and Best Case : O(nlogn);
    2. Worst Case : O(n^2) ;
    ->Space :- O(log(n));
    ->Stability : unStable
    ------------------------------------------------------------------------------------*/
}

public class SortingAlgo {
    public static void main(String[] args) {
        Sort s = new Sort(7);
        s.setArray();
        System.out.print("\t* Array :- ");
        s.printArray();

        // System.out.print("\t* Bubble Sort : ");
        // s.bubbleSort(s.arr);
        // s.printArray();

        // System.out.print("\t* Insertion Sort : ");
        // s.insertionSort(s.arr);
        // s.printArray();

        // System.out.print("\t* Selection Sort : ");
        // s.selectionSortStable(s.arr);
        // s.printArray();

        // System.out.println("\t* Merge Sort : ");
        // s.mergeSort(s.arr, 0, s.arr.length - 1);
        // s.printArray();

        // System.out.println("\t* Quick Sort : ");
        // s.quickSort(s.arr, 0, s.arr.length-1);
        // s.printArray();
    }
}
