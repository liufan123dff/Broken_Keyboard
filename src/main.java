public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("the broken keys are:" +func("7_This_is_a_test", "_hs_s_a_es"));
	}

	/* characters typed:
	 * 7_This_is_a_test
	 * ---------------
	 * characters on screen:
	 * _hs_s_a_es
	 */
	
	static public String func(String input, String output) {
		String missingPart = "";
		String inputUpcase = input.toUpperCase();
		String outputUpcase = output.toUpperCase();
		String longestSubString = MyLCS(inputUpcase, outputUpcase);
		while (longestSubString.compareTo(inputUpcase) != 0) {
			int posStart = inputUpcase.indexOf(longestSubString);
//			System.out.println(" ================== ");
			System.out.println("posStart = " + posStart + ",lenth = "
					+ longestSubString.length());

//			System.out.println("longestSubString = " + longestSubString);
//			System.out.println(" ================== ");
			if (posStart + longestSubString.length() < inputUpcase.length()) {

				if (outputUpcase.indexOf(inputUpcase.charAt(posStart
						+ longestSubString.length())) < 0
						&& missingPart
								.indexOf(inputUpcase.charAt(posStart - 1)) < 0) {
					missingPart += inputUpcase.charAt(posStart
							+ longestSubString.length());
				}
				longestSubString += inputUpcase.charAt(posStart
						+ longestSubString.length());
			}

//			System.out.println("longestSubString = " + longestSubString);
			if (posStart > 0) {
				longestSubString = inputUpcase.charAt(posStart - 1)
						+ longestSubString;
				if (outputUpcase.indexOf(inputUpcase.charAt(posStart - 1)) < 0
						&& missingPart
								.indexOf(inputUpcase.charAt(posStart - 1)) < 0) {
					missingPart += inputUpcase.charAt(posStart - 1);
				}
			}
//			System.out.println("longestSubString = " + longestSubString);
			// longestSubString = MyLCS(inputUpcase, outputUpcase);
//			System.out.println(" ================== ");
		}
		return missingPart;
	}

	public static String MyLCS(String s1, String s2) {
		// if (String.IsNullOrEmpty(s1) || String.IsNullOrEmpty(s2))
		// {
		// return null;
		// }
		// else
		if (s1 == s2) {
			return s1;
		}
		int length = 0;
		int end = 0;
		int a[][] = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				int n = (i - 1 >= 0 && j - 1 >= 0) ? a[i - 1][j - 1] : 0;
				a[i][j] = s1.charAt(i) == s2.charAt(j) ? 1 + n : 0;
				if (a[i][j] > length) {
					length = a[i][j];
					end = i;
				}
			}
		}
		return s1.substring(end - length + 1, end + 1);
	}
}
