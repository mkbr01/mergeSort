// divides array into 2, left and right and creates more subs arrays
// and gradually sorts it.

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);


        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]+ " ");
        }
    }









//////////////////////////////////////////////////////////////////////////////////
// merge sort method  { 20, 35, -15, 7, 55, 1, -22 }
// arrays are called recursively until its partitioned down to 1 index array


        public static void mergeSort(int[] input, int start, int end){
// call method recursively
            if (end - start < 2) {
                return;    // breaks the recursion
            }


// partitioning part...partition the array thats been passed,
// figure out start/end indices
            if (end - start < 2) {     // getting whole the array 1st, then the sub array
                return;
            }

            int mid = (start + end) / 2;  // determining the mid point
            mergeSort(input, start, mid);  //left partition 0 - 3 (mid)
            // anything left over goes into the
            //right partition
            mergeSort(input, mid, end);    //right partition 4 - 7 (mid)
            merge(input, start, mid, end); //merges arrays
        }





        public static void merge(int[] input, int start, int mid, int end){

            if (input[ mid - 1] <= input[mid]) {
                return;
            }

            // sorting left and right arrays
            int i = start; //left array
            int j = mid;   //right array
            int tempIndex = 0; //keeps track of where you are in temp array

            //large enough to hold elements in
            int[] temp = new int[end - start];
            //the left and right partition

            // compare whats in i array with j and write back whats smallest into the
            //current position in temp & vice versa
            while (i < mid && j < end) {
                temp[tempIndex++] = input[i] <=input[j] ? input[i++] : input[j++];

            }


            //1st argument is the (source) input array,
            //2nd destination output array start+tempIndex
            //mid-1 left over indices in left array

            System.arraycopy(input, i, input, start+tempIndex, mid -i);
            System.arraycopy(temp, 0, input, start, tempIndex);


        }


    }
