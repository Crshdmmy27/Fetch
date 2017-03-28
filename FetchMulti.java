
public class FetchMulti {
	FetchRegister input1,input2, output,offset;
	int count;
	FetchPSW psw;
	FetchALU alu;
	
	FetchMulti(){
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
			
			for(int j =1;j+i<8;j++){
				offset.setBit(j+i, input1.getBit(j));
			}
			if(input2.getBit(i)==true)
			{
			output=alu.execute(output, offset, out, "0");
			
			if(alu.psw.getC()==true)
				p.setV();
			
			System.out.println("LOL");
			}
			
			
			
		}
		
		return output;
	}

	public FetchRegister getInput1() {
		return input1;
	}

	public void setInput1(FetchRegister input1) {
		this.input1 = input1;
	}

	public FetchRegister getInput2() {
		return input2;
	}

	public void setInput2(FetchRegister input2) {
		this.input2 = input2;
	}

	public FetchRegister getOutput() {
		return output;
	}

	public void setOutput(FetchRegister output) {
		this.output = output;
	}

	public FetchRegister getOffset() {
		return offset;
	}

	public void setOffset(FetchRegister offset) {
		this.offset = offset;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public FetchPSW getPsw() {
		return psw;
	}

	public void setPsw(FetchPSW psw) {
		this.psw = psw;
	}

	public FetchALU getAlu() {
		return alu;
	}

	public void setAlu(FetchALU alu) {
		this.alu = alu;
	}


}