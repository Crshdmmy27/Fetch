

/**
 * Created by Adam on 2/18/2017.
 */

public class EightBitNot {
	private FetchRegister inputA, output;
	

    //String[] outArray= new String[8];

    NotGate[] not = new NotGate[8];
    GateCounter Gcount = new GateCounter();
    public EightBitNot(){
    	inputA= new FetchRegister();
    	output= new FetchRegister();
    }

    public void set(FetchRegister input){
       inputA=input;


    }

    public FetchRegister execute(FetchRegister first, FetchRegister out){
        inputA = first;
        output = out;
        Gcount.tallyIn();
        for(int i = 7; i>=0;i--){
            not[i]= new NotGate();
            not[i].set(inputA.getBit(i), output.getBit(i));
            output.setBit(i,not[i].execute());
        }

        
        return output;


    }

	public FetchRegister getInputA() {
		return inputA;
	}

	public void setInputA(FetchRegister inputA) {
		this.inputA = inputA;
	}

	public FetchRegister getOutput() {
		return output;
	}

	public void setOutput(FetchRegister output) {
		this.output = output;
	}

//	public String[] getOutArray() {
//		return outArray;
//	}
//
//	public void setOutArray(String[] outArray) {
//		this.outArray = outArray;
//	}

	public NotGate[] getNot() {
		return not;
	}

	public void setNot(NotGate[] not) {
		this.not = not;
	}

 
}