package 表达式计算;

public class Operation {
	SimplifyVarList sVar = new SimplifyVarList();
	DerivativeVar dVar = new DerivativeVar();
	
	public String command(String input,Expression expression)
	{
		if(input.charAt(0)!='!')
		{
			try{
				//expression = new Expression();
				expression.set(input);
			}
			catch(ArithmeticException e){
				return "error";
			}
			String result = expression.printout();
			return result;
		}
		else if(input.substring(1,4).equals("d/d"))
		{
			dVar.set(input);
			Expression temp = expression.derivative(dVar);
			String result = temp.printout();
			return result;
		}
		else if(input.substring(1,9).equals("simplify"))
		{
			sVar.set(input);
			Expression temp = expression.simplify(sVar);
			String result = temp.printout();
			return result;
		}
		else
		{
			return "error";
		}
	}
}
