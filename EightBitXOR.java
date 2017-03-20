

/**
 * Created by Adam on 2/18/2017.
 */

public class EightBitXOR {
    private String inA;
    private String inB;
    private String out;

    boolean[] inputA= new boolean[8];
    boolean[] inputB= new boolean[8];
    boolean[] output = new boolean[8];

    String[] outArray= new String[8];

    XOrGate[] xor = new XOrGate[8];

    public void set(String inA, String inB){
        this.inA = inA;
        this.inB = inB;

    }

    public void execute(){
        inputA = toBoolean(inA);
        inputB = toBoolean(inB);

        for(int i = 7; i>=0;i--){
            xor[i]= new XOrGate();
            xor[i].set(inputA[i], inputB[i],output[i]);
            output[i]=xor[i].execute();
        }

        outArray=toInt(output);
        out="";
        for (int i = 0; i < 8; i++) {
            out += outArray[i];
        }


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


    public String getInA() {
        return inA;
    }

    public String getInB() {
        return inB;
    }

    public String getOut() {
        return out;
    }


    public void setInA(String inA) {
        this.inA = inA;
    }

    public void setInB(String inB) {
        this.inB = inB;
    }

    public void setOut(String out) {
        this.out = out;
    }
}
