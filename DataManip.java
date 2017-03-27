public class DataManip {
	FetchRegister one,out;
	FetchALU alu;
	public void halt(){
		System.exit(0);
	}
	
	public void move(FetchRegister fr1, FetchRegister out){
		for(int i = 0; i < 8; i++){
		out.setBit(i,fr1.getBit(i));
		}
	}
	
	public void inc(FetchRegister fr1){
		one = new FetchRegister();
		out=new FetchRegister();
		alu=new FetchALU();
		one.setBit(0);
		alu.execute(fr1, one, out,"0");
		out.print();
	}
	
	public void dec(FetchRegister fr1){
		one = new FetchRegister();
		out=new FetchRegister();
		alu=new FetchALU();
		one.setBit(0);
		alu.execute(fr1, one, out,"1");
		out.print();
	}
	
}