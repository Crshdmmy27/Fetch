
public class FetchDiv {
	FetchRegister input1,input2, output,offset;
	int count;
	FetchPSW psw;
	FetchALU alu;
	
	FetchDiv(){
		input1=new FetchRegister();
		input2=new FetchRegister();
		output=new FetchRegister();
		offset = new FetchRegister();
		psw= new FetchPSW();
		alu= new FetchALU();
	}
	
	public int divide(int a, int b, int c){
	    c = a/b;
	    return c;
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
	
	public FetchRegister stringToBoolean(String a, FetchRegister reg) {
		if (a.length() == 8) {
            a = a;
        } else if (a.length() == 7) {
            a = "0" + a;
        } else if (a.length() == 6) {
            a = "00" + a;
        } else if (a.length() == 5) {
            a = "000" + a;
        } else if (a.length() == 4) {
            a = "0000" + a;
        } else if (a.length() == 3) {
            a = "00000" + a;
        } else if (a.length() == 2) {
            a = "000000" + a;
        } else if (a.length() == 1) {
            a = "0000000" + a;
        }
            
		for (int i = 7,j=0; i >=0; i--,j++) {
			if(a.charAt(i)=='0')
				reg.setBit(j, false);
			else
				reg.setBit(j);
		}
		reg.print();
		return reg;

	}
	
	public FetchRegister execute(FetchRegister in1, FetchRegister in2, FetchRegister out, FetchPSW p){
	
//		input1=in1;
//		input2=in2;
//		output =out;
//		psw=p;	
		
		int a = booleanToInt(in1.getBits());
		int b = booleanToInt(in2.getBits());
		int c = 0;
		System.out.println(a + " / "+ b );
		int d = divide(a, b, c);
		
		String e = Integer.toBinaryString(d);
		
		out = stringToBoolean(e,output);
		
		return out;
		
		
		
		
//		output=input1;
//		for(int i = 0; i<8; i++){
//			
//			for(int j =0;j+i<8;j++){
//				offset.setBit(ji, input1.getBit(j));
//			}
//			if(input2.getBit(i)==true)
//			{
//			output=alu.execute(output, offset, out, "1");
//			System.out.println("LOL");
//			}
//			
//			
//			
//		}
//		
//		return output;
	}
}