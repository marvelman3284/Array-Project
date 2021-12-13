package shah.jeevan;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        System.out.print("\f");
        int[] numberArray={221, 17, 170, 136, 68, 85, 34, 17, 187, 51, 102, 119, 153, 85, 204, 85, 221};
        int[] sortedArray=selectionSort(numberArray);
        //int[] sortedArray=bubbleSort(numberArray);
        System.out.println("The sorted array is: ");
        printArray(sortedArray);
        System.out.println();
        System.out.println("Search value found at index "  + linearSearch(numberArray, 34));
        //System.out.println("Search value found at "  + binarySearch(numberArray, 34));
        System.out.println("The mean is "  + mean(numberArray));
        System.out.println("The median is "  + median(numberArray));
        System.out.println("The mode is "  + mode(numberArray));
        System.out.println("The gcf is "  + gcf(numberArray));
        System.out.println("The min is "  + min(numberArray));
        System.out.println("The max is "  + max(numberArray));
        System.out.println("The sum is "  + sum(numberArray));
        numberArray=reverse(numberArray);
        System.out.println("Is the function a palindrome: "  + isPalindrome(numberArray));
        printArray(numberArray);
        System.out.println();
        System.out.println("The smallest difference between adjacent numbers is "  + smallestDifference(numberArray));
    }

    public static void printArray(int[] array)
    {
        System.out.println(Arrays.toString(array));
    }

    public static int[] selectionSort(int[] array)
    {
        //sorts the array (selection sort)
        int min;
        int temp;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i+1; j < array.length; j++ ) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] bubbleSort(int[] array)
    {
        //sorts the array (bubble sort)
        int n = array.length;
        for (int i = 0; i < n - 1; i++ ) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int linearSearch(int[] array, int searchValue)
    {
        //returns the position of the element or -1 if it is not in the list
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int searchValue)
    {
        //returns the position of the element or -1 if it is not in the list
        int min = 0;
        int max = array.length;

        for (int i = 0; i<array.length; i++) {
            int mid = Math.floorDiv(min, max);

            if (array[mid] == searchValue) {
                return mid;
            } else if (array[mid] > searchValue) {
                max = mid - 1;
            } else if (array[mid] < searchValue) {
                min = mid + 1;
            }
        }
        return -1;
    }

    public static int mean(int[] array)
    {
        //returns the average
        return sum(array) / array.length;
    }

    public static int median(int[] array)
    {
        //returns the median or midpoint of the sorted array
        return array[Math.floorDiv(array.length, 2)];
    }

    public static int mode(int[] array)
    {
        // returns the number that occurs the most frequent amount of times
        //maybe a function that determines how many times a particular element appears would be helpful
        int mode = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i+1] == array[array.length - 1]) {
                break;
            } else if (count(array, array[i]) > count(array, array[i+1])) {
                mode = array[i];
            }
        }
        return mode;
    }

    public static int count(int[] array, int elem) {
        int count = 0;
        for (int i : array) {
            if (i == elem) {
                count++;
            }
        }
        return count;
    }

    public static int gcf(int[] array)
    {
        //returns the greatest common factor
        array = selectionSort(array);
        int gcf = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i]%array[0] != 0) {
                for (int j = array[0] - 1; j > 0; j--) {
                    if (array[i]%j == 0) {
                        gcf = j;
                    }
                }
                break;
            }
            gcf = array[0];
        }
        return gcf;
    }

    public static int max(int[]array)
    {
        //returns the largest number in the array
        return selectionSort(array)[array.length-1];
    }

    public static int min(int[]array)
    {
        //returns the smallest number in the array
        return selectionSort(array)[0];
    }

    public static int sum(int[]array)
    {
        //returns the sum of all the numbers
        int sum=0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPalindrome(int[]array)
    {
        //determines if the array is a palindrome or not
        //for example, {1, 2, 3, 2, 1} would return true
        int[] newArr = reverse(array);

        for (int i : array) {
            for (int j: newArr) {
                if (i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] reverse(int[]array)
    {
        //returns the reversed array
        //{1, 2, 3, 4, 5, 6} would return {6, 5, 4, 3, 2, 1}
        int i, t;
        int n = array.length;
        for (i = 0; i < n / 2; i++) {
            t = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = t;
        }

        return array;
    }

    public static int smallestDifference(int[]array)
    {
        int diff = 0;
        array=selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            if (!(array[i] == array[i+1])) {
                diff = Math.abs(array[i] - array[i+1]);
                break;
            }
        }
        return diff;
    }
}
