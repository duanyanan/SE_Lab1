package 表达式计算;

import java.util.*;

public class PolynomialaArithmetic {

	public static void main(String[] args) {
		
		Scanner lalala = new Scanner(System.in);
		String Input ;
		int la=0;
		Expression a=new Expression();
		System.out.println("Welcome to the PolynomialaArithmetic monitor.\nServer version: 1.0.9\nCopyright (c) 2016隆拢\nType '!h' for help. Type '!q' for exit.\n ");
		while(true){
			Input = lalala.nextLine();
			try{
			if(Input.length()>0&&Input.charAt(0)=='!')
			{
				if(Input.equals("!q")){
					System.out.println("end");
					break;
				}
				else if (Input.equals("!h"))
					System.out.println("杈撳叆琛ㄨ揪寮廫n!鍖栫畝!simplify a=1  !d/dx \n卤脴脨毛脩脧赂帽掳麓脮脮鹿忙脭貌脢盲脠毛拢隆");

				else if(Input.substring(0,4).equals("!d/d")||Input.substring(0,9).equals("!simplify"))
				{
					if(la==0)
						//涔辩爜浜嗐�傘�傘��
						System.out.println("脡脨脦麓脢盲脠毛脠脦潞脦卤铆麓茂脢陆拢卢脦脼路篓脰麓脨脨脙眉脕卯隆拢\n");
					else 
						a.Command(Input);
				}
			}
			else 
			{
				la=1;
				a.Set(Input);
				a.printout();
				System.out.print("\n");
			}
		}
			catch(Exception e)
			{
				System.out.println("脢盲脠毛虏禄潞脧路篓拢隆\n"+e);
			}
		}
		lalala.close();
	}
}
