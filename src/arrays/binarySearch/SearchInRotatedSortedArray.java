package arrays.binarySearch;

// https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

        int arr [] = {4,5,6,0,1,2,3};
        int target = 5;

        int start = 0;
        int end = arr.length - 1;



        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                System.out.println("got the target");
                return ;
            }else if(arr[start] < arr[mid]){ // If arr[start....mid] is sorted

                if( arr[start] <= target && target < arr[mid] ){ // if target les between start and mid
                   end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{ //  else arr[mid....end] is sorted

                if(arr[mid] < target && target <= arr[end]){ // if target lies in between mid and end
                    start = mid+1;
                }else {
                    end = mid -1;
                }
            }
        }


    }
}
