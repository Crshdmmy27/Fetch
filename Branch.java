
public class Branch {
	
	int index;
	
	public int branch(FetchRegister reg){
		index = booleanToInt(reg.getBits());
		return index; 
	}
	public int booleanToInt(boolean[] a){
		long result = 0;
		boolean [] b = new boolean [8];
		for (int i=7,j=0; i>=0; i--,j++)
			b[j]= a[i];
		for (boolean bit : b) {
		    result = result * 2 + (bit ? 1 : 0);
		}
		return (int) result;
	}
	

}
