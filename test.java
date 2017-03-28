
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FetchCPU test = new FetchCPU();
		FetchMem mem = new FetchMem();
		
		FetchRegister r1 = new FetchRegister();
		r1.setBit(1);
		r1.setBit(3);
		
		
		FetchRegister r2 = new FetchRegister();	
		r2.setBit(2);
		r2.setBit(3);
		
		FetchRegister out = new FetchRegister();
		
		
		//and SSSS DDDD
//		EightBitAND EightAnd = new EightBitAND();
//		EightAnd.execute(r1, r2, out);
//		out.print();
		
		//Or SSSS DDDD
//		EightBitOR EightOr = new EightBitOR();
//		EightOr.execute(r1, r2, out);
//		out.print();
		
		//XOR SSSS DDDD
//		EightBitXOR EightXOR = new EightBitXOR();
//		EightXOR.execute(r1, r2, out);
//		out.print();
		
		//add SSSS DDDD
//		FetchALU alu = new FetchALU();
//		out=alu.execute(r1, r2, out, "0");
//		r1.print();
//		out.print();
		
		//sub SSSS DDDD
//		FetchALU alu = new FetchALU();
//		alu.execute(r1, r2, out, "1");
//		r1.print();
		
		//MUL SSSS DDDD
		
		//DIV SSSS DDDD
		
		//Move contents from SSSS to DDDD
//		DataManip ran = new DataManip();
//		r1.print();
//		r2.print();
//		ran.move(r1, r2);
//		r1.print();
//		r2.print();
		
		//clr bits
//		r1.print();
//		r1.clrBits();
//		r1.print();
		
		//set bits
//		r1.print();
//		r1.setBits();
//		r1.print();
		
		//Inc DDDD
//		DataManip ran1 = new DataManip();
//		r1.print();
//		ran1.inc(r1);
//		r1.print();
		
		//Dec DDDD
//		DataManip ran2 = new DataManip();
//		r2.print();
//		ran2.dec(r2);
//		r2.print();
		
		//negate bits
//		r1.print();
//		r1.negBits();
//		r1.print();
		
		//BNE DDDD
		
		//BEQ DDDD
		
		//halt
//		DataManip r = new DataManip();
//		r.halt();
//		r1.print();
		
//		FetchMulti m = new FetchMulti();
//		FetchPSW psw = new FetchPSW();
//		out= m.execute(r1, r2, out, psw);
//		r1.print();
//		r2.print();
//		out.print();
//		
		//INC
		boolean[] code = {true, false, true, false};
		boolean[] ssss = {false, false, false, false};
		boolean[] dddd = {false, false, false, false};
		
		test.data.setCell(0, code, ssss, dddd);
		
		out = test.getData(0);
		out.print();
		
		//dec
		code[3] = true;
		
				
		test.data.setCell(0, code, ssss, dddd);
		test.r0.setBit(0);
		out = test.getData(0);
		out.print();
		
		
		
		
		
		
	}

}
