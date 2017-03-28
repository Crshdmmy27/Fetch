public class DataManip {
	FetchRegister one,out;
	FetchALU alu;
	public void halt(){
		System.exit(0);
	}
	
	public FetchRegister move(FetchRegister fr1, FetchRegister out){
		for(int i = 0; i < 8; i++){
		out.setBit(i,fr1.getBit(i));
		}
		return out;
	}
	
	public FetchRegister inc(FetchRegister fr1){
		one = new FetchRegister();
		out=new FetchRegister();
		alu=new FetchALU();
		one.setBit(0);
		alu.execute(fr1, one, out,"0");
		return out;
	}
	
	public FetchRegister dec(FetchRegister fr1){
		one = new FetchRegister();
		out=new FetchRegister();
		alu=new FetchALU();
		one.setBit(0);
		alu.execute(fr1, one, out,"1");
		out.print();
		return out;
	}
	
	
	
}