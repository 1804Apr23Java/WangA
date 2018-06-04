package Week01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}
	public static List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		int j = 0;

		List<Long> PrimeFactor = new ArrayList<Long>();

		for (int i = 2; i <= l; i++) {

			while (l % i == 0) {
				PrimeFactor.add((long) i);

				l /= i;

			}

		}
		
		return PrimeFactor;
	}
	
	public static int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		

		
		
		return i;
	}
	
	

		
	public static void main (String[] args ) {
	//	reverse("shivam");
/*		System.out.println(reverse("shivam"));
		System.out.println(acronym("This is test shivam"));
		
		Triangle t= new Triangle();
		t.sideOne=10;
		t.sideTwo=20;
		t.sideThree=30;
		t.isEquilateral();
		t.isIsosceles();
		t.isScalene();	*/	
		
		//calculatePrimeFactorsOf(9);
		calculateNthPrime(1);
		/*Test t1 = new Test();
		t1.getScrabbleScore("shdksivam");
		cleanPhoneNumber("()-.1024999458");
	*/

		//wordCount("one two three");
		
		
		toPigLatin("apple shivam");
		
		
	}
	public static String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String[] newString=string.split(" ");
		String[] Vowel= {"a","e","i","o","u"};
		int getIndex;
		for(int i=0;i<newString.length;i++) {
			for(int j=0;j<Vowel.length;j++) {
			if(newString[i].startsWith(Vowel[j])) {
				
				//System.out.println(newString[i].concat("ay"));
				}
			else {
				//System.out.println(newString[i]= newString[i].substring(i+1) + newString[i].substring(0, i) + "ay");
			break;	
			}
			}
		
		}		
		
		return newString.toString();
	}
	public static Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] newString =string.split(" ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s: newString) {
			if (map.containsKey(s)) {
				System.out.println(map.put(string, 1));
			} else {
				int count = map.get(s);
				System.out.println(map.put(s, count + 1));
			}

		}
		return map;

	}

	@SuppressWarnings("unlikely-arg-type")
	public  int getScrabbleScore(String string) {

		
		String[] charToNum1= {"A","E","I"};
		for (int i=0;i<string.length();i++) {
			for (int j=0;j<charToNum1.length;j++) {
				
			}
		
		
		}
		System.out.println(string);
		return 0;
	}
	




	public static String acronym (String phrase) {
	
		// TODO Write an implementation for this method declaration
		//In this part we are taking the phrase.
		//Need to take the first index of every word
		
		//The word would be seperated by space
		
		//String str = "revature fine";	
		String initialLetter = " "; // Creating an empty String
		for (String s : phrase.split(" ")) {
			initialLetter += s.charAt(0);
		}
		
		String acronym=initialLetter.substring(1, 4);
		
		return acronym.toUpperCase();	
		
		
	}
	
	public static String cleanPhoneNumber(String string) {
		
		String UserInput = "";		
		try {

			UserInput = string.trim();
			UserInput = string.replaceAll("[(-.)]", "");
			System.out.println(UserInput);
						
				if (UserInput.length() < 10) {
					System.out.println("Invalid Number");
				}
				if (!UserInput.matches(".*[0-9].*")) {

					throw new IllegalArgumentException();
				}
				if (UserInput.length() == 11 && UserInput.charAt(0) != '1') {

					System.out.println("Not a valid number");
				}

				if (UserInput.length() == 10 && UserInput.charAt(0) == '1' || UserInput.charAt(3) == '1') {

					System.out.println("Not a valid number");
				}				
		

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return UserInput;
	}
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()==this.getSideTwo() && this.getSideOne()==this.getSideThree()){
			System.out.println("Trianle is Equilateral");
			}
			return true;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()==this.getSideTwo() || this.getSideOne()==this.getSideThree()||this.getSideTwo()==this.getSideThree()){
				System.out.println("Trianle is isIsoceles");
				}
			return true;
			
				
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(this.getSideOne()!=this.getSideTwo() || this.getSideOne()!=this.getSideThree()||this.getSideTwo()!=this.getSideThree()){
				System.out.println("Trianle is isScalene");
				}
			return true;
		}



	}
}
