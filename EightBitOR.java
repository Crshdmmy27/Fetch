

/**
 * Created by Adam on 2/18/2017.
 */

public class EightBitOR {

    private FetchRegister inputA,inputB,output;

    String[] outArray= new String[8];

    OrGate[] or = new OrGate[8];
    GateCounter Gcount = new GateCounter();

    public void set(FetchRegister A, FetchRegister B){
    	inputA = A;
    	inputB=B;
        

    }

    public FetchRegister execute(FetchRegister r1, FetchRegister r2, FetchRegister out){
//        inputA = toBoolean(inA);
//        inputB = toBoolean(inB);
    	Gcount.tallyIn();
        for(int i = 7; i>=0;i--){
            or[i]= new OrGate();
            or[i].set(r1.getBit(i), r2.getBit(i),out.getBit(i));
            out.setBit(i,or[i].execute());
        }
        return out;

//        outArray=toInt(output);
//        out="";
//        for (int i = 0; i < 8; i++) {
//            out += outArray[i];
//        }


    }

    private boolean[] toBoolean(String in) {
        boolean[] input = new boolean[8];
        int c = 7;

        for (int i = 0; i < 8; i++) {
            char temp = in.charAt(c);
            if (temp=='0')
                input[c] = false;
            else if (temp=='1')
                input[c] = true;
            c--;
        }
        return input;
    }


    private String[] toInt(boolean[] outputBoolean) {
        String[] output = new String[8];

        for (int i = 0; i < 8; i++) {
            if (outputBoolean[i] == false) {
                output[i] = "0";
            } else {
                output[i] = "1";
            }
        }
        return output;
    }

	public FetchRegister getInputA() {
		return inputA;
	}

	public void setInputA(FetchRegister inputA) {
		this.inputA = inputA;
	}

	public FetchRegister getInputB() {
		return inputB;
	}

	public void setInputB(FetchRegister inputB) {
		this.inputB = inputB;
	}

	public FetchRegister getOutput() {
		return output;
	}

	public void setOutput(FetchRegister output) {
		this.output = output;
	}

	public String[] getOutArray() {
		return outArray;
	}

	public void setOutArray(String[] outArray) {
		this.outArray = outArray;
	}

	public OrGate[] getOr() {
		return or;
	}

	public void setOr(OrGate[] or) {
		this.or = or;
	}



}
