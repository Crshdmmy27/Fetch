
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FetchCPU test = new FetchCPU();
		
		
		FetchRegister r1 = new FetchRegister();
		r1.setBit(0);
		r1.setBit(2);
		r1.setBit(4);
		r1.setBit(6);
		
		FetchRegister r2 = new FetchRegister();
		r2.setBit(1);
		r2.setBit(3);
		r2.setBit(5);
		r2.setBit(7);
		
		FetchRegister out = new FetchRegister();
		
		FetchALU alu = new FetchALU();
		alu.execute(r1, r2, out, "1");

	}

}
