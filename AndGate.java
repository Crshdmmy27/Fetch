

public class AndGate extends Gate{

    //has 2 inputs and 1 output
    private boolean inputA;
    private boolean inputB;
    private boolean output;

    // set method
    public void set(boolean a, boolean b, boolean c){
        this.inputA = a;
        this.inputB = b;
        this.output = c;
    }

    boolean getA(){
        return inputA;
    }

    boolean getB(){
        return inputB;
    }

    boolean getOutput(){
        return output;
    }

    //checks to see if the inputs and outputs of the 2 gates are equal
    boolean equals(AndGate a1){
        if(inputA == a1.inputA && inputB == a1.inputB && output == a1.output){
            return true;
        }
        else {
            return false;
        }
    }

    //makes the inputs/outputs of one gate to the inputs/outputs of the other gates
    void makeEqual(AndGate aGate){
        aGate.inputA = inputA;
        aGate.inputB = inputB;
        aGate.output = output;
    }

    //the actual implementation of the gate
    boolean execute(){
        if (getA() == true && getB() == true ){
            output = true;
        }
        else{
            output = false;
        }
        //print();
        return output;
    }

    void print(){
        System.out.println("And Gate\ninput values: " + inputA + ", " + inputB + "\nOutput: " + output + "\n");
    }
}

