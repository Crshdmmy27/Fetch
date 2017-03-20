
public class FetchCPU {

    public FetchRegister r0, r1, r2, r3, pc, sp,out;
    public FetchPSW psw;
    public FetchALU alu;
    public FetchMem data;
    public FetchMem prog;
    
    public String input;
    public String op="";
    public String mode1="";
    public String mode2="";
    public String regSel1="";
    public String regSel2="";

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
        pc.print();
        sp.print();
        psw.print();
    }
    //Reads a 16 bit string of all relavent data
     public void parseInput (String input){
    	 this.input= input;
    	
    	 
    	    for (int i = 0; i < 16; i++) {
                char temp = input.charAt(i);
                //op code
                if(i<4){
                	op+=temp;
                }
                //mode1
                else if (i>3&&i<6){
                	mode1+=temp;
                }
                //register Selection 1
                else if (i>5&&i<10){
                	regSel1+=temp;
                }
                //mode 2
                else if (i>9&&i<12){
                	mode2+=temp;
                }
                else if (i>11){
                	regSel2+=temp;
                }
                
             
            }
    	    System.out.println(input);
    	    System.out.println(op);
    	    System.out.println(mode1);
    	    System.out.println(regSel1);
    	    System.out.println(mode2);
    	    System.out.println(regSel2);
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
}
