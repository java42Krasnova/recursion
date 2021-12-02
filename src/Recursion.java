public class Recursion {
	static public long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Number can't be a negative");
		}
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	/**
	 * 
	 * @param a any number(positive or negative)
	 * @param b - any positive number or 0(throwing illegaArgumentException in the
	 *          case b < 0)
	 * @return a ^ b requirements 1. No cycles; 2. Only Operator arithmetic
	 *         operations either +/-; 3. Additional methods(no standart) should
	 *         apply the #1 and #2 requirements 4. No additional static fields
	 */
//TODO DONE!!
	static public long pow(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException("Number can't be a negative");
		}
		if (a == 0) {
			return 0;
		}
		/* V.R.
		 * What about the case a=0 && b=0?
		 * As I know 0^0 isn't defined
		 */
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a;
		}
		// V.R. The operation % is prohibited. The method is required instead of.
		a = a < 0 && b % 2 == 0 ? -a : a;
		return multiplay(a, pow(a, b - 1));
	}

	private static long multiplay(int a, long multiplier) {
		return multiplier > 0 ? a + multiplay(a, multiplier - 1) : 0;
	}

	/**
	 * 
	 * @param array
	 * @return sum of the array's elements requirements: 1. No cycles 2.Additional
	 *         methods should apply the requirements #1
	 */
	static public long sum(int array[]) {
		return sum(0, array);
	}

	private static long sum(int firstIndex, int[] array) {
		return firstIndex < array.length ? array[firstIndex] + sum(firstIndex + 1, array) : 0;
	}

	/**
	 * 
	 * @param i
	 * @return x^2 1. No cycles 2. Allowed only operators +or - no additional
	 *         methods No static fields
	 */
//TODO Done!!
	// V.R. Why Integer? int is enough good
	public static Integer square(int x) {
		if (x == 1) {
			return 1;
		}
		// V.R. x = Math.abs(x) is also suitable
		x = x < 0 ? -x : x;
		//((x-1)+1)^2 = (x-1)^2 +2(x-1) +1= (x-1)^2 +2x-2+1 = (x-1)^+2x-1
		return x > 0 ? square(x - 1) + x + x - 1 : 0;
	}
	/* V.R. Compare with following
	public static int square(int x) {
	   x =  Math.abs(x);
	   if(x==1 || x==0) {
	   	return x;
	   }
	   return square(x - 1) + x + x - 1;
	 }  
	 */
}
