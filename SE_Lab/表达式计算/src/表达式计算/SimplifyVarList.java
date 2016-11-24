package 表达式计算;

public class SimplifyVarList {
	
	String[][] varList = new String[100][2];
	int n;
    /**
     * 
     */
    public void set(String input) {
        // TODO implement here
		for(int i=9;i<input.length();i++)
		{
			if((input.charAt(i)>='A'&&input.charAt(i)<='Z') || (input.charAt(i)>='a'&&input.charAt(i)<='z'))
			{
				int j;
				for(j=i;input.charAt(j)!= '=';j++);
				varList[n][0] = input.substring(i,j);
				i = j;
			}
			else if(input.charAt(i)>='0'&&input.charAt(i)<='9')
			{
				int j;
				for(j=i;j <input.length()&&input.charAt(j)!= ' ';j++);
				varList[n][1] = input.substring(i,j);
				i = j;
				n++;
			}
		}
    }

    /**
     * 
     */
    public String[][] get() {
        // TODO implement here
    	return varList;
    }
    
    public int length(){
    	return n;
    }
}
