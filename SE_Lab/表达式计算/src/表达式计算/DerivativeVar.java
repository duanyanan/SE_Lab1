package 表达式计算;

public class DerivativeVar {
	
	String var ;
	
    /**
     * 
     */
    public void set(String input) {
        // TODO implement here
		int j;
		for(j=4;j<input.length()&&input.charAt(j)!= ' ';j++);
		var = input.substring(4,j);
    }

    /**
     * 
     */
    public String get() {
        // TODO implement here
    	return var;
    }

}
