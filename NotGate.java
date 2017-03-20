


public class NotGate extends Gate {


    private boolean inputA;
    private boolean output;

    public void set(boolean a, boolean c) {
        this.inputA = a;
        this.output = c;
    }

    boolean getA() {
        return inputA;
    }

    boolean getOutput() {
        return output;
    }

    boolean equals(NotGate n1) {
        if (inputA == n1.inputA && output == n1.output) {
            return true;
        } else {
            return false;
        }
    }


    void makeEqual(NotGate nGate) {
        nGate.inputA = inputA;
        nGate.output = output;
    }

    boolean execute() {
        if (getA() == true) {
            output = false;
        } else {
            output = true;
        }
        // print();
        return output;
    }

    void print() {
        System.out.println("Not Gate\ninput value: " + inputA + "\nOutput: " + output + "\n");
    }

}

