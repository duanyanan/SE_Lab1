package 表达式计算;

public class Expression {
	private static final String[][] String = null;

	private String thisExpression;
	
	private boolean simpleOrComplex;
	
	private Expression  head;
	
	private boolean abcOrNum;
	private String abc;
	private long num;
	private long pow;
	private boolean positiveOrNegative;
	
	private Expression down;
	private Expression right;
	
	public void Set(String expressionInput) throws ArithmeticException
	{
		//¸³³õÊ¼Öµ
		thisExpression=expressionInput;
		simpleOrComplex = false;
		
		head = new Expression();
		
		
		Expression temp = head;
		Expression leftTemp = head;
		Expression next =new Expression();
		for(int i=0;i<expressionInput.length();)
		{
			if(expressionInput.charAt(i)=='+')
			{
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)
				{
					System.out.println("ERROR!1");
					throw new ArithmeticException();
				}
				next = new Expression();
				leftTemp.down=next;
				next.positiveOrNegative=true;
				leftTemp=next;
				temp=next;
			}
			else if (expressionInput.charAt(i)=='-')
			{
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)
				{
					System.out.println("ERROR!2");
					throw new ArithmeticException();
				}
				next = new Expression();
				leftTemp.down=next;
				next.positiveOrNegative=false;
				leftTemp=next;
				temp=next;
			}
			else if (expressionInput.charAt(i)=='*')
			{
				if((leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)||(temp.simpleOrComplex&&temp.abc==null&&temp.num==-1))
				{
					System.out.println("ERROR!3");
					throw new ArithmeticException();
				}
				next = new Expression();
				temp.right=next;
				temp=next;
			}
			
			
			
			else if (expressionInput.charAt(i)=='^')
			{
				int j;
				i++;
				for(;expressionInput.charAt(i)==' ';i++);
				for (j=i;(expressionInput.charAt(j)>='0'&&expressionInput.charAt(j)<='9');)
				{
					j++;
					if((j-i)>=18)
					{
						System.out.println("ERROR!4");
						throw new ArithmeticException();
					}
					if (j==expressionInput.length())
						break;
				}
				if(i==j)
				{
					System.out.println("ERROR!5");
					throw new ArithmeticException();
				}
				temp.pow=Long.parseLong(expressionInput.substring(i,j));
				i=j;
				continue;
			}
			else if (expressionInput.charAt(i)=='(')
			{
				int x=1;
				int j;
				for (j=i;expressionInput.charAt(j)!=')'||x>0;)
				{
					j++;
					if(expressionInput.charAt(j)=='(')
						x++;
					if(expressionInput.charAt(j)==')')
						x--;
					if (j==expressionInput.length())
					{
						if (x>0)
						{
							System.out.println("ERROR!6");
							throw new ArithmeticException();
						}
						break;
					}
				}
				if(next.num!=-1||next.abc!=null||next.simpleOrComplex==false)
				{
					next = new Expression();
					temp.right=next;
					temp=next;
				}
				next.Set(expressionInput.substring(i+1,j));
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=j;
				//ÒÔºóÔÙµ÷Õû·¶Î§
			}
			
			else if ((expressionInput.charAt(i)>='A'&&expressionInput.charAt(i)<='Z') || (expressionInput.charAt(i)>='a'&&expressionInput.charAt(i)<='z'))
			{
				int j;
				for(j=i;(expressionInput.charAt(j)>='A'&&expressionInput.charAt(j)<='Z') || (expressionInput.charAt(j)>='a'&&expressionInput.charAt(j)<='z');)
				{
					j++;
					if (j==expressionInput.length())
						break;
				}
				if(next.num!=-1||next.abc!=null||next.simpleOrComplex==false)
				{
					next = new Expression();
					temp.right=next;
					temp=next;
				}
				next.abc=expressionInput.substring(i, j);
				next.abcOrNum=true;
				next.pow=1;
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=j;
				continue;
			}
			else if (expressionInput.charAt(i)>='0' && expressionInput.charAt(i)<='9')
			{
				int j;
				for(j=i;expressionInput.charAt(j)>='0' && expressionInput.charAt(j)<='9';)
				{
					j++;
					if((j-i)>=18)
					{
						System.out.println("ERROR!7");
						throw new ArithmeticException();
					}
					if (j==expressionInput.length())
						break;
				}
				if(next.num!=-1||next.abc!=null||next.simpleOrComplex==false)
				{
					next = new Expression();
					temp.right=next;
					temp=next;
				}
				next.num=Long.parseLong(expressionInput.substring(i, j));
				next.abcOrNum=false;
				next.pow=1;
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=j;
				continue;
			}
			else if (expressionInput.charAt(i)!='\t'&&expressionInput.charAt(i)!=' ')
			{
				System.out.println("ERROR!8");
				throw new ArithmeticException();
			}
			i++;
		}
		if(next.simpleOrComplex&&next.abc==null&&next.num==-1)
		{
			System.out.println("ERROR!9");
			throw new ArithmeticException();
		}
	}
	public Expression()
	{
		simpleOrComplex=true;
		head=null;
		down=null;
		right=null;
		abc=null;
		pow=1;
		num=-1;
		abc=null;
		abcOrNum=true;
		positiveOrNegative=true;
		thisExpression=null;
	}
	public void printout()
	{
		if (simpleOrComplex)
		{
			if(abcOrNum)
				System.out.print(abc);
			else 
				System.out.print(num);
		}
		else
		{
			Expression next,leftHead;
			leftHead=head.down;
			while(leftHead != null)
			{
				if(leftHead.simpleOrComplex==false)
				{
					System.out.print('(');
					leftHead.printout();
					System.out.print(')');
				}
				else
					leftHead.printout();
				if(leftHead.pow!=1)
				{
					System.out.print('^');
					System.out.print(leftHead.pow);
				}
				
				next=leftHead.right;
				while(next != null)
				{
					System.out.print('*');
					if(next.simpleOrComplex==false)
					{
						System.out.print('(');
						next.printout();
						System.out.print(')');
					}
					else
						next.printout();
					if(next.pow!=1)
					{
						System.out.print('^');
						System.out.print(next.pow);
					}
					next=next.right;
				}
				leftHead=leftHead.down;
				if (leftHead!=null)
				{	
					if(leftHead.positiveOrNegative)
						System.out.print('+');
					else
						System.out.print('-');
				}
			}
		}
		
		
		
		

	}

	public void change(String[][] x,int n)
	{
		if(simpleOrComplex)
		{
			if(abcOrNum)
			{
				for(int i=0;i<n;i++)
				{
					if(x[i][0].equals(abc))
					{
						num=Long.parseLong(x[i][1]);
						abcOrNum=false;
						abc=null;
					}
				}
			}
		}
		else
		{
			for(Expression i=head.down;i!=null;i=i.down)
			{
				for(Expression j=i;j!=null;j=j.right)
				{
					j.change(x, n);
				}
			}
		}
	}
	public void simplify()
	{
		if(simpleOrComplex)
		{
			if(!abcOrNum)
			{
				num= (long) Math.pow(num, pow);
				pow=1;
			}
		}
		else
		{
			Expression i,j;
			Expression leftTemp=null;
			Expression plusTemp=null;
			for(i=head.down;i!=null;i=i.down)
			{
				leftTemp=null;
				Expression lalalaTemp=null;
				for(j=i;j!=null;j=j.right)
				{
					j.simplify();
					if(!j.abcOrNum&&j.simpleOrComplex)
					{
						if(leftTemp==null)
							leftTemp=j;
						else
						{
							leftTemp.num=leftTemp.num*j.num;
							lalalaTemp.right=j.right;
							//j=lalalaTemp;
							continue;
						}
					}
					lalalaTemp=j;
				}
				if(leftTemp!=null&&leftTemp!=i)
				{
					Expression preTemp,topTemp,temp;
					for(preTemp=i;preTemp.right!=leftTemp;preTemp=preTemp.right);
					for(topTemp=head;topTemp.down!=i;topTemp=topTemp.down);
					topTemp.down=leftTemp;
					leftTemp.down=i.down;
					i.down=null;
					preTemp.right=i;
					temp=i.right;
					i.right=leftTemp.right;
					leftTemp.right=temp;
					leftTemp.positiveOrNegative=leftTemp.positiveOrNegative&&i.positiveOrNegative;
					i=leftTemp;
				}
				if(!i.abcOrNum&&i.simpleOrComplex&&i.right==null)
				{
					if(plusTemp==null)
						plusTemp=i;
					else
					{
						if(i.positiveOrNegative)
							plusTemp.num=plusTemp.num+i.num;
						else
							plusTemp.num=plusTemp.num-i.num;
						Expression topTemp=null;
						for(topTemp=head;topTemp.down!=i;topTemp=topTemp.down);
						topTemp.down=i.down;
					}
				}
			}
			
			if(head.down.down==null&&head.down.right==null&&head.down.pow==1)
			{
				simpleOrComplex=head.down.simpleOrComplex;
				abc=head.down.abc;
				pow=pow*head.down.pow;
				num=head.down.num;
				abc=head.down.abc;
				abcOrNum=head.down.abcOrNum;
				positiveOrNegative=head.down.positiveOrNegative;
				thisExpression=head.down.thisExpression;	
				head=head.down.head;
				if(!abcOrNum)
				{
					num= (long) Math.pow(num, pow);
					pow=1;
				}
			}
			
		}
	}
	
	public int derivative(String var)
	{
		int flag =1;
		if(simpleOrComplex)
		{
			if(abcOrNum)
			{
				if(abc.equals(var))
					flag=0;
			}
		}
		else
		{
			int flag2=1;
			for(Expression i=head.down;i!=null;i=i.down)
			{
				flag=1;
				int flag3=1;
				for(Expression j=i;j!=null;j=j.right)
				{
					if(!j.simpleOrComplex)
					{
						Expression copy = new Expression();
						copy.pow=j.pow;
						copy.Set(j.thisExpression);
						copy.right = j.right;
						j.right = copy;
						j.pow=1;
						flag *= j.derivative(var);
						j=j.right;
					}
					else 
						flag = j.derivative(var);
					if (flag == 0)
					{
						flag2=0;
						flag3=0;
						if(j.pow==1)
						{
							j.num=1;
							j.abcOrNum=false;
						}
						else
						{
							Expression powTemp = new Expression();
							powTemp.right=j.right;
							j.right=powTemp;
							powTemp.abcOrNum=false;
							powTemp.num=j.pow;
							j.pow--;
							j=j.right;
						}
					}
					
				}
				if(flag3==1)
				{
					i.num=0;
					i.abcOrNum=false;
				}
			}
			flag *=flag2;
		}
		return flag;
	}
	
	public void Command(String commandInput)
	{
		Expression lalala=new Expression();
		lalala.Set(thisExpression);
		lalala.simplify();
		if(commandInput.substring(1,4).equals("d/d"))
		{
			String var = new String();
			int j;
			for(j=4;j<commandInput.length()&&commandInput.charAt(j)!= ' ';j++);
			var = commandInput.substring(4,j);
			lalala.derivative(var);
		}
		else if (commandInput.substring(1,9).equals("simplify"))
		{
			String[][] x=new String[100][2];
			int n=0;
			for(int i=9;i<commandInput.length();i++)
			{
				if((commandInput.charAt(i)>='A'&&commandInput.charAt(i)<='Z') || (commandInput.charAt(i)>='a'&&commandInput.charAt(i)<='z'))
				{
					int j;
					for(j=i;commandInput.charAt(j)!= '=';j++);
					x[n][0] = commandInput.substring(i,j);
					i = j;
				}
				else if(commandInput.charAt(i)>='0'&&commandInput.charAt(i)<='9')
				{
					int j;
					for(j=i;j <commandInput.length()&&commandInput.charAt(j)!= ' ';j++);
					x[n][1] = commandInput.substring(i,j);
					i = j;
					n++;
				}
			}
			lalala.change(x,n);
		}
		lalala.simplify();
		lalala.printout();
		System.out.print("\n");

	}
	
}
