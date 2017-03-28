
public class FetchCPU {

    public FetchRegister r0, r1, r2, r3,out,S,D;
    public FetchPSW psw;
    public FetchALU alu;
    public FetchMem data;
    public FetchMem prog;
    public boolean[] code, ssss,dddd;
    public String operation,regS,regD;
    
    public EightBitAND and;
    public EightBitOR or;
    public EightBitXOR xor;
    public EightBitNot not;
    public DataManip man;
    
    public FetchMulti mul;
    public FetchDiv div;
    public Branch b;
    
    public int wordSize = 8;
    public int index;

    //FetchCPU Constructor
    public FetchCPU(){
        //create ALU
        alu = new FetchALU();
        data = new FetchMem();//memory size is fixed to 1000 cells

        //create ALU
        r0 = new FetchRegister("r0");
        r1 = new FetchRegister( "r1");
        r2 = new FetchRegister( "r2");
        r3 = new FetchRegister( "r3");
        
        out=new FetchRegister("out");
        code = new  boolean[4];
        ssss = new  boolean[4];
        dddd = new  boolean[4];
        
        and = new EightBitAND();
        or = new EightBitOR();
        xor= new EightBitXOR();
        not = new EightBitNot();
        man = new DataManip();
        
        mul =new FetchMulti();
        div =  new FetchDiv();
        b=new Branch();
        
        
        //op = new FetchRegister ("op", 4);

        //pc = new FetchRegister( "pc");
       //sp = new FetchRegister("sp");

        //create 4-bit PSW
        psw = new FetchPSW();
    }

    public void print(){
        r0.print();
        r1.print();
        r2.print();
        r3.print();
//        pc.print();
//        sp.print();
        psw.print();
    }
     public FetchRegister getData (int index){
    	index =this.index;
    	code = data.getCode(index);
    	ssss=data.getS(index);
    	dddd= data.getD(index);
    	operation = booleanToInt(code);
    	regS=booleanToInt(ssss);
    	regD=booleanToInt(dddd);
    	selectRegister();
    	execute(S,D);
    	return out;
    	
     }
     
     public void selectRegister(){
    	  switch (regS){
    	  
    	  case"0000":
    		  S=r0;
    		  break;
    	  case "0001":
    	  	  S=r1;
    	  	  break;
    	  case "0010":
    		  S=r2;
    		  break;
    	  case "0011":
    	  	  S=r3;
    	  	  break;
    	  }
    	  
    	  switch (regD){
    	  
    	  case"0000":
    		  D=r0;
    		  break;
    	  case "0001":
    	  	  D=r1;
    	  	  break;
    	  case "0010":
    		  D=r2;
    		  break;
    	  case "0011":
    	  	  D=r3;
    	  	  break;
    	  }
    	  
    	  
     }

     
     
     public FetchRegister execute(FetchRegister in1, FetchRegister in2){
    	 switch (operation){

         //AND
         case "0000":
             out =and.execute(in1, in2, out);
             checkZ(out);
             break;

         //OR
         case "0001":
             out=or.execute(in1, in2, out);
             checkZ(out);
             break;

         //XOR
         case"0010":
             out=xor.execute(in1, in2, out);
             checkZ(out);
             break;

         //ADD
         case"0011":
             out=alu.execute(in1, in2, out, "0");
             
            if (alu.psw.getC()==true)
            	psw.setC();
            checkZ(out);
             break;
         //SUB
         case"0100":
             out=alu.execute(in1, in2, out, "1");
             if (alu.psw.getN()==true)
             	psw.setN();
             checkZ(out);
             break;
         //MUL
         case"0101":
             out=mul.execute(in1, in2, out, psw);
             if (alu.psw.getC()==true)
             	psw.setV();
             checkZ(out);
             break;
         //DIV
         case"0110":
             out=div.execute(in1, in2, out, psw);
             checkZ(out);
             break;
         //MOV   
         case"0111":
             out =man.move(in2, out);
             checkZ(out);
             break;  
         //Clear
         case"1000":
             in2.clrBits();
             checkZ(out);
             break;

         //Set
         case"1001":
             in2.setBits();
             checkZ(out);
             break;
         //INC
         case"1010":
             out = man.inc(in2);
             if (alu.psw.getC()==true)
             	psw.setC();
             checkZ(out);
             break;
         //DEC
         case"1011":
             out= man.dec(in2);
             if (alu.psw.getN()==true)
              	psw.setN();
             checkZ(out);
             break;
         //Negate
         case"1100":
            not.execute(in2, out);
            checkZ(out);
             break;
         //BNE
         case"1101":
             if(psw.getZ()==false)
            	index = b.branch(out);
             break;
         //BEQ
         case"1110":
        	 if(psw.getZ()==true)
             	index = b.branch(out);
             break;
         //HALT
         case"1111":
             man.halt();
             break;
             
             


     }
    	 
    	 return out;
     }
   /*testCPU is a method that constructs a CPU and preforms basic tests, such as
    setting/clearing/getting values in the registers,
    setting/clearing/getting flags in the PSW
    setting/clearing/getting values in memory
    executing the double operand and single operand OPs*/

    public void testCPU(){
        print();
        data.testMem();
    }
    
    public String booleanToInt(boolean[] opCode){
    	String op="";
    	for (int i =0;i<4; i++){
    		if (opCode[i]==false)
    			op+="0";
    		else
    			op+="1";
    	}
    	return op;
    	
    }
    public void checkZ(FetchRegister in){
    	if (booleanToInt(in.getBits())=="00000000")
    		psw.setZ();
    	else
    		psw.clrZ();
    }
    
    
    
    
}
