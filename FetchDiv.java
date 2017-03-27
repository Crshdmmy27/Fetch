
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
	
	public FetchRegister execute(FetchRegister in1, FetchRegister in2, FetchRegister out, FetchPSW p){
	
		input1=in1;
		input2=in2;
		output =out;
		psw=p;
		
		output=input1;
		for(int i = 0; i<8; i++){
			
			for(int j =0;j+i<8;j++){
				offset.setBit(ji, input1.getBit(j));
			}
			if(input2.getBit(i)==true)
			{
			output=alu.execute(output, offset, out, "1");
			System.out.println("LOL");
			}
			
			
			
		}
		
		return output;
	}
}