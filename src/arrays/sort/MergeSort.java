package arrays.sort;

// time complexity - nlogn

// Time Complexity: Sorting arrays on different machines.
// Merge Sort is a recursive algorithm and time complexity can be expressed as following recurrence relation.
//T(n) = 2T(n/2) + \Theta(n)
//The above recurrence can be solved either using Recurrence Tree method or Master method.
// It falls in case II of Master Method and solution of the recurrence is \Theta(nLogn).

//Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and best)
// as merge sort always divides the array into two halves and take linear time to merge two halves.


// TODO - https://www.geeksforgeeks.org/analysis-algorithm-set-4-master-method-solving-recurrences/
public class MergeSort {
    public static void main(String[] args) {
        // recursivly half the array into two - divide

        int  a[] = { 5, 1, 6, 2, 3, 4 };

        // then sort the two sub arrays. - conquer
        mergeSort(a, a.length);

        System.out.println(a[1] + " "  + a[4]);


    }

    public static void mergeSort(int a[], int n){
        if(n == 1){
            return;
        }
        // divide
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        // divide
        mergeSort(l, mid);
        mergeSort(r, n-mid);

        // conquer
        merge(a, l, r, mid, n-mid);
    }




    // this is conquer
    public static void  merge(int a[], int l[], int r[], int m, int n){
        int i=0,j =0,k =0;
        while(i < m && j < n){
            if(l[i] <= r[j]){
                a[k] = l[i];
                k++;
                i++;
            }else{
                a[k] = r[j];
                k++;
                j++;
            }
        }

        // copy the left over elememts to sub array to output
        while(i<m){
            a[k] = l[i];
            k++;
            i++;
        }

        while (j<n){
            a[k] = r[j];
            k++;
            j++;
        }
    }
}
