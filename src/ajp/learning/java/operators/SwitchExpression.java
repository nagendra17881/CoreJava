package ajp.learning.java.operators;

public class SwitchExpression {

	public static void main(String[] args) {
		int num = 345;
//		int result = (num>0)? 1 : (num<0) ? 2 : 3;
//		System.out.println(result);
		String result = switch (Integer.compare(num, 0)) {
		case 1-> {
			if(num%2==0)
				yield "positive and even";
			else
				yield "positive and odd";
		}
		case -1-> "negative";
		case 0-> "zero";
		default -> throw new IllegalArgumentException("Unexpected value: " + Integer.compare(num, 0));
		};
		System.out.println("The given number is : " +result);
		System.out.println("***************");
		String day = "sunday";
		switch (day) {
		case "monday","tuesday","wednesday","thursday","friday"-> System.out.println("It's a week day");
		case "saturday","sunday" -> System.out.println("It's a weekend");
		default->throw new IllegalArgumentException("Unexpected value: " + day);
		};

	}

}
