package ajp.learning.java.operators;

public class TernaryOperator {

	public static void main(String[] args) {
		int num = 345;
		String result = (num%2==0) ? "is even number" : "is odd number";
		System.out.println(num + " " + result);
		
		String res = (num>0) ? "is positive number" : (num<0) ? "is negative number": "is zero";
		System.out.println(num + " "+ res);
	}

}
