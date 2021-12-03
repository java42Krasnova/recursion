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
	static public long pow(int a, int b) {
		if (a == 0 && b == 0) {
			throw new IllegalArgumentException("Arguments canot be zero");
		}
		if (b < 0) {
			throw new IllegalArgumentException("Number can't be a negative");
		}
		if (a == 0 && b != 0) {
			return 0;
		}
		if (b == 0 & a != 0) {
			return 1;
		}
		if (b == 1 && a != 0) {
			return a;
		}
		a = a < 0 && even(b) ? -a : a;
		return multiplay(a, pow(a, b - 1));
	}

	private static boolean even(int b) {
		if (b == 2) {
			return true;
		}
		return b > 2 ? even(b - 2) : false;
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

	public static int square(int x) {
		if (x == 1 || x == 0) {
			return x;
		}
		x = x < 0 ? -x : x;
		// ((x-1)+1)^2 = (x-1)^2 +2(x-1) +1= (x-1)^2 +2x-2+1 = (x-1)^2+2x-1=x^2
		return square(x - 1) + x + x - 1;
	}

//	boolean isSubstring (String str, String substr)
//	 returns true if a given 'substr' is indeed the substring of a given 'string'.
//	Challenges: 1. From class String to apply only following methods :
//	charAt(int ind); String substring(int ind); int length(); 2. No cycles;
//	
	// TODO Done!! ver 1 with out String substring
	public static boolean isSubstring1(String str, String substr) {
		if (str.length() == 0 || substr.length() == 0) {
			throw new IllegalArgumentException("Wrong arguments");
		}
		if (str.length() < substr.length()) {
			return false;
		}
		return isEqualdByInd1(str, substr, 0, 0);
	}

	// TODO Done!! ver 2 with String substring
	public static boolean isSubstring2(String str, String substr) {
		if (str.length() == 0 || substr.length() == 0) {
			throw new IllegalArgumentException("Wrong arguments");
		}
		if (str.length() < substr.length()) {
			return false;
		}
		return isEqualdByInd2(str, substr, 0);

	}

	private static boolean isEqualdByInd1(String str, String substr, int strIndex, int subIndex) {
		if ((str.length() - strIndex) < substr.length() && subIndex == 0) {
			return false;
		}
		if (str.charAt(strIndex) != substr.charAt(subIndex) && subIndex != 0) {
			subIndex = 0;
		} else if (str.charAt(strIndex) == substr.charAt(subIndex)) {
			subIndex++;
			if (subIndex == substr.length()) {
				return true;
			}
		}
		return strIndex < str.length() ? isEqualdByInd1(str, substr, strIndex + 1, subIndex) : false;
	}

	private static boolean isEqualdByInd2(String str, String substr, int subIndex) {
		if (str.charAt(subIndex) != substr.charAt(subIndex)) {
			if (subIndex > 0) {
				subIndex = 0;
			}
			str = str.substring(1);
		} else if (str.charAt(subIndex) == substr.charAt(subIndex++)) {
			if (subIndex == substr.length()) {
				return true;
			}
		}
		return str.length() >= substr.length() ? isEqualdByInd2(str, substr, subIndex) : false;

	}
}
