

public class FetchALU {

    public String name;

    //number of bits that FETCH ALU can work with.
    public int fetchWordSize = 8;
    //max decimal number that FETCH ALU can work with.
    public int fetchMaxNumber = (int) Math.pow(2, fetchWordSize);

    public XOrGate[] xOrGates;
    public AndGate[] andGates;
    public OrGate[] orGates;
    public NotGate[] notGates;
    public Wire [] aWires;
    public Wire [] bWires;
    public Wire [] cWires;
    public Wire[] sWires;
    public FullAdder [] fullAdders;

    public Wire c;
    public Wire op;

    public FetchPSW psw;
    public boolean [] test;
    public boolean [] aTest;
    public boolean [] bTest;
    
    private String first;
    private String second;
    private String operation;
    private String output;

    public FetchALU(){
        name = "FetchALU";

        psw = new FetchPSW();
        test = new boolean[fetchWordSize];
        aTest = new boolean[fetchWordSize];
        bTest = new boolean[fetchWordSize];

        //op is the "op" bit; op=1=> A-B; op=O=> A+B
        op = new Wire();

//        fullAdders = new FullAdder[fetchWordSize];
//        xOrGates = new XOrGate[fetchWordSize];
//        andGates = new AndGate[fetchWordSize];
//        orGates = new OrGate[fetchWordSize];
//        notGates = new NotGate[fetchWordSize];
//        aWires = new Wire[fetchWordSize];
//        bWires = new Wire[fetchWordSize];
//        cWires = new Wire[fetchWordSize];
//        sWires = new Wire[fetchWordSize];
//
//        for (int i=0; i < fetchWordSize; i++){
//            //String s = Integer.toString(i);
//            fullAdders[i] = new FullAdder();
//            andGates[i] = new AndGate();
//            orGates[i] = new OrGate();
//            notGates[i] = new NotGate();
//            xOrGates[i] = new XOrGate();
//            aWires[i] = new Wire();
//            bWires[i] = new Wire();
//            cWires[i] = new Wire();
//            sWires[i] = new Wire();
//        }
        FullAdder[] adders = new FullAdder[8];
        XOrGate xor = new XOrGate();
        Wire[] wires = new Wire[8];
        boolean[] xorOut = new boolean [8];

        for(int i = 0; i<8;i++){
            xorOut[i]=false;
            wires[i]= new Wire();
            adders[i]= new FullAdder();

        }
    }
        //makeConnections();
        
        //these are strings for the first 4-bit binary number, second 4-bit binary number, true or false for adding or subtracting, and the output
        


        // set method. It declares the order of adding the 4-bit binary numbers
        public void set(String First, String Op, String Second) {
            if (First.length() == 8) {
                first = First;
            } else if (First.length() == 7) {
                first = "0" + First;
            } else if (First.length() == 6) {
                first = "0" + First;
            } else if (First.length() == 5) {
                first = "0" + First;
            } else if (First.length() == 4) {
                first = "0" + First;
            } else if (First.length() == 3) {
                first = "0" + First;
            } else if (First.length() == 2) {
                first = "0" + First;
            } else if (First.length() == 1) {
                first = "0" + First;
            } else {
                first = "00000000";
            }

            if (Second.length() == 8) {
                second = Second;
            } else if (First.length() == 7) {
                first = "0" + First;
            } else if (Second.length() == 6) {
                second = "0" + Second;
            } else if (Second.length() == 5) {
                second = "0" + Second;
            } else if (Second.length() == 4) {
                second = "0" + Second;
            } else if (Second.length() == 3) {
                second = "0" + Second;
            } else if (Second.length() == 2) {
                second = "0" + Second;
            } else if (Second.length() == 1) {
                second = "0" + Second;
            } else {
                second = "00000000";
            }

            operation = Op;
        }
        
      //actual execution for the 4-bit alu
        public void execute() {
//            boolean[] firstBoolean = toBoolean(first);
//            boolean[] secondBoolean = toBoolean(second);
//            boolean operationBoolean;
//
//            boolean[] outputBoolean = new boolean[9];
//            String[] outputNum = new String[9];

            if (operation.equals("0"))
                operationBoolean = false;
            else
                operationBoolean = true;

         

            int b = 7;
            int c = 8;





            //Character 8
            Wire w8 =new Wire();
            xor.set(operationBoolean, secondBoolean[b], xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(operationBoolean, firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=6
            c--;


            //Character 7
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=5
            c--;

            ///Character 6
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=4
            c--;

            //Character 5
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=3
            c--;

            //Character 4
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=2
            c--;

            //Character 3
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=1
            c--;

            //Character 2
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();

            b--;//b=0
            c--;

            //Character 1
            xor.set(operationBoolean, secondBoolean[b],xorOut[b]);
            xorOut[b] = xor.execute();

            wires[b].set(wires[b+1].getC(), firstBoolean[b], xorOut[b]);
            adders[b].set(wires[b].getA(), wires[b].getB(), wires[b].getX());
            wires[b] = adders[b].execute();
            outputBoolean[c] = wires[b].getS();


            c--;
            outputBoolean[c] = wires[b].getC();

            if (operationBoolean == true) {
                boolean done = false;
                int count = 0;
                while (done == false && count < 9) {
                    if (outputBoolean[count] == true) {
                        outputBoolean[count] = false;
                        done = true;
                    } else {
                        count++;
                    }
                }
            }

            outputNum = toInt(outputBoolean);
            String value = "";

            for (int i = 0; i < 9; i++) {
                value += outputNum[i];
            }

            output = value;
            setOutput(output);
           // print();
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
        String[] output = new String[9];

        for (int i = 0; i < 9; i++) {
            if (outputBoolean[i] == false) {
                output[i] = "0";
            } else {
                output[i] = "1";
            }
        }
        return output;
    }

    public void print() {
        System.out.println(first + " " + operation + " " + second + " = " + output);

    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
}
