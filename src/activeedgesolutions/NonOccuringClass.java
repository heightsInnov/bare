/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activeedgesolutions;

/**
 *
 * @author aojinadu
 */
public class NonOccuringClass {

	static int smallestNonOccuring(int arr[], int size) {
		int a = 0, b=0,  i, k;
		//Sort array for positive and non positive integers
		for (i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				int temp;
				temp = arr[i];
				arr[i] = arr[a];
				arr[a] = temp;
				a++;
			}
		}
		//Find the smallest number from initial array
		int arr2[] = new int[size - a];
		for (int j = a; j < size; j++) {
			arr2[b] = arr[j];
			b++;
		}
		for (k = 0; k < b; k++) {
			int x = Math.abs(arr2[k]);
			if (x - 1 < b && arr2[x - 1] > 0) {
				arr2[x - 1] = -arr2[x - 1];
			}
		}
		for (k = 0; k < b; k++) {
			if (arr2[k] > 0) {
				return k + 1; 
			}
		}
		return b + 1;
	}
	
	public static void main(String[] args) 
    { 
        int arr[] = { 5, -1, -3 }; 
        int arr_size = arr.length; 
        int missing = smallestNonOccuring(arr, arr_size); 
        System.out.println("The smallest integer is " + missing); 
    } 
}
