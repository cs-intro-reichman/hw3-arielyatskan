// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int i = 0;
		if(x2 >= 0) {
			while(i < x2) {
				x1++;
				i++;
			}
		}
		else {
			while(i > x2) {
				x1--;
				i--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int i = 0;
		if(x2 >= 0) {
			while(i < x2) {
				x1--;
				i++;
			}
		}
		else {
			while(i > x2) {
				x1++;
				i--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int i = 1;
		int firstX1 = x1;
		if(x2 == 0)  return 0;
		else {
			if(x2 > 0){
				while(i < x2) {
					x1 = plus(x1, firstX1);
					i++;	
				}	
			}
			else {
				while (i > x2) {
					x1 = plus(x1, firstX1);
					i--;		
				}
				x1 = minus(0, x1);
			}
		}
		return x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int i = 1;
		int firstX = x;
		if(n == 0)  return 1;
		else {
			while(i < n) {
				x = times(x, firstX);
				i++;
			}
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if(x2 == 0) return 0;
		int counter = 0;
		if(x2 > 0) {
			while(x1 >= x2){
				x1 = minus(x1, x2);
				counter++;
			}
		}
		else {
			int newX2 = minus(0, x2);
			while(x1 >= newX2){
				x1 = minus(x1, newX2);
				counter--;
			}
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divCounter = div(x1, x2);
		int roundDiv = times(x2, divCounter);
		int leftover = minus(x1, roundDiv);
		return leftover;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		double epsilon = 0.01;
		double g = x / 2;
		while (Math.abs(g * g - x) > epsilon) {
			g = g - (g * g - x) / (2 * g);
		}
		int g1 = (int) g;
		return g1;
	}	  	  
}