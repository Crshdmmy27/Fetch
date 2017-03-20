


public class XOrGate extends Gate {

    // has 2 inputs and 1 output
    private boolean inputA;
    private boolean inputB;
    private boolean output;

    // set method
    public void set(boolean a, boolean b, boolean c) {
        this.inputA = a;
        this.inputB = b;
        this.output = c;
    }

    boolean getA() {
        return inputA;
    }

    boolean getB() {
        return inputB;
    }

    boolean getOutput() {
        return output;
    }


    boolean equals(XOrGate xo1) {
        if (inputA == xo1.inputA && inputB == xo1.inputB && output == xo1.output) {
            return true;
        } else {
            return false;
        }
    }

    void makeEqual(XOrGate XGate) {
        XGate.inputA = inputA;
        XGate.inputB = inputB;
        XGate.output = output;
    }

    boolean execute() {
        if (getA() == getB()) {
            output = false;
        } else {
            output = true;
        }
        // print();
        return output;
    }

    void print() {
        System.out.println("XOr Gate\ninput values: " + inputA + ", " + inputB + "\nOutput: " + output + "\n");
    }

}
