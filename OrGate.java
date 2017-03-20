


public class OrGate extends Gate {

    private boolean inputA;
    private boolean inputB;
    private boolean output;

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

    boolean equals(OrGate o1) {
        if (inputA == o1.inputA && inputB == o1.inputB && output == o1.output) {
            return true;
        } else {
            return false;
        }
    }


    void makeEqual(OrGate oGate) {
        oGate.inputA = inputA;
        oGate.inputB = inputB;
        oGate.output = output;
    }

    boolean execute() {
        if (getA() == false && getB() == false) {
            output = false;
        } else {
            output = true;
        }
        // print();
        return output;
    }

    void print() {
        System.out.println("Or Gate\ninput values: " + inputA + ", " + inputB + "\nOutput: " + output + "\n");
    }

}

