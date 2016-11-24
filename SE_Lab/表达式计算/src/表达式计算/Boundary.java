package 表达式计算;


import java.util.Scanner;

public class Boundary {
	public Expression thisExpression = new Expression();
	public String input;
	Scanner systemIn = new Scanner(System.in);
	
	public void Loop() {
		while(true) {
			input = getInput();
			String result;
			if (input.equals("!q"))
			{
				System.out.println("end");
				break;
			}
			else
			{
				result = OperationInput(input);
			}
			PutOut(result);
		}
	}
	
	private void PrintInfo() {
		System.out.println(
				"Welcome to the PolynomialaArithmetic monitor.\nServer version: 1.0.9\nCopyright (c) 2016¡£\nType '!h' for help. Type '!q' for exit.\n ");
	}
	
	private String getInput() {
		input = systemIn.nextLine();
		return input;
	}
	
	public String OperationInput(String input) {
		Operation operation = new Operation();
		String result = operation.command(input,thisExpression);
		return result;
	}
	
	private void PutOut(String result) {
		System.out.println(result);
	}
}