package LinearBinary01;
import java.util.Scanner;
import java.util.Random; 
import java.util.Arrays;
public class LinearBinary {
	public static void bubbleSort(int[]a) {
		int n = a.length;
		int temp = 0;
		  for(int i=0; i < n; i++){  
              for(int j=1; j < (n-i); j++){  
                       if(a[j-1] > a[j]){  
                              temp = a[j-1];  
                              a[j-1] = a[j];  
                              a[j] = temp;  
                      }       
              }  
      }  
		
	}
	public static int[] call(int n) {
		boolean loop = true;
		Scanner userInt = new Scanner(System.in); 
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(2000)-1000;
		}
		bubbleSort(a);
		return a;
		
	}
	public static int[] call2(int n) {
	
		Scanner userInt = new Scanner(System.in); 
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(a.length);
		}
		bubbleSort(a);
		return a;
		
	}
	public static int linearSearch(int[]a, int key) {
		int n = a.length;
		for (int i = 0; i < n; i++) 
        {
            if (a[i] == key)
                return i;
        }
		return -1;
		
	}
	public static int binarySearch(int[]a, int key) {
		int low = 0;
		int high = a.length-1;
		int position= -1;
		while(low <= high) {
			int middle = low+(high-1)/2;
			if (key == a[middle]) {
				position = middle;
				break;
			}
			else if(key <a[middle]) {
				high=middle-1;

			}
			else if(key >a[middle]) {
				low=middle+1;

			}
		}	
		return position;
		
		
	}

	public static int binarySearch2(int[]a) {
		int low = 0;
		int high = a.length-1;
		for(int i = 0;i<a.length;i++) {
			while(low<=high) {
				int middle = low+(high-1)/2;
				if(a[middle]==i) {
					return middle;
				}
				if(a[middle]<i) {
					low=middle+1;
				}
				else {
					high = middle-1;
				}
						
			}
		
		}
		return -1;
	}

	public static void main(String[] args) {
		//average-case
		boolean loop = true;
		Scanner userInt = new Scanner(System.in); 
		int n = 0;
		while(loop == true){
			System.out.println("Enter a valid positive integer: ");
			 n = userInt.nextInt();
			if(n<0) {
				System.out.println("Not valid positive integer");
				loop=true;
			}
			else {
				loop =false;
			}
		}
		System.out.println("Part A");
		Random rand = new Random(); 
		int[] a; 
		
		a = call(n);
		System.out.println(Arrays.toString(a));
		final long startTime = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			int randomNumber = rand.nextInt(a.length);
			int key = a[randomNumber];
			int lS =linearSearch(a, key);
		}
		
		final long endTime = System.nanoTime();
		
		System.out.println("Average execution time for Linear Search: " + (endTime - startTime)/100 +" nano seconds");
		final long startTime2 = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			int randomNumber = rand.nextInt(a.length);
			int key = a[randomNumber];
			binarySearch(a, key);
		}
		final long endTime2 = System.nanoTime();
		System.out.println("Average execution time for Binary Search: " + (endTime2 - startTime2)/100 +" nano seconds");
		System.out.println(Arrays.toString(a));

		//Worst-case scenario
		System.out.println("Part B");
		a = call(n);
		final long startTime3 = System.nanoTime();
		int key = 5000;
		linearSearch(a, key);
		final long endTime3 = System.nanoTime();
		System.out.println("Execution time for Linear Search part B: " + (endTime3 - startTime3) +" nano seconds");
		final long startTime4 = System.nanoTime();
		binarySearch(a, key);
		final long endTime4 = System.nanoTime();
		System.out.println("Execution time for Binary Search part B: " + (endTime4 - startTime4) +" nano seconds");
		System.out.println("How much time it takes to run one single line of binary search calc: "+(endTime4 - startTime4)/Math.log(a.length)+ " nanoseconds");
		System.out.println("How much time it takes to run one single line of binary search calc at n = 10^15: "+(Math.pow(10, 15)*(endTime4 - startTime4)/Math.log(a.length))/Math.pow(10, 5)+" nanoseconds" );
		System.out.println("part 4 is basically me using the knowledge that the time complexity of a binary search is O(log(n)) so in that idea of such I would divide the\n amount of time I recieved from part 3 by log(n) to figure out how much one line was worth. ");
		System.out.println("part 5 my calculations was c = the execution time that came out of 10^5, (c/10^5)(x/10^15) and then solve for x making it a proportional equivalance");
		System.out.println(Arrays.toString(a));
		System.out.println("Part C");
		a = call2(n);
		int result = binarySearch2(a);
		System.out.println(Arrays.toString(a));
		System.out.println("The range of random numbers is the length of the array");
		if(result==-1) {
			System.out.println("False!");
		}
		else {
			System.out.println("True! At index #"+result);
			
		}
		
		
		
		
	}
	

}
