

public class HalfAdder {

    public AndGate a1 = new AndGate();
    public AndGate a2 = new AndGate();
    public OrGate o1 = new OrGate();
    public NotGate n1 = new NotGate();
    public String name;
    public Wire wire = new Wire();

    private boolean a;

    private boolean b;
    private boolean c = false;
    private boolean s = false;
    private boolean orOutput = false;
    private boolean andOutput = false;
    private boolean notOutput = false;

    public HalfAdder() {
    }


    public Wire execute() {
        o1.set(wire.getA(), wire.getB(), getOrOutput());
        a1.set(wire.getA(), wire.getB(), getAndOutput());
        orOutput = o1.execute();
        andOutput = a1.execute();

        // c=and1Out;
        wire.setC(andOutput);
        n1.set(getAndOutput(), getNotOutput());
        notOutput = n1.execute();

        a2.set(getOrOutput(), getNotOutput(), wire.getS());
        // s=a2.execute();
        wire.setS(a2.execute());

        // print();

        // wire.setS(s);
        // wire.setC(c);

        return wire;

    }


    public void set(boolean argA, boolean argB) {
        a = argA;
        b = argB;
        wire.set(argA, argB);
    }

    public void print() {
        System.out.println("Half Adder\nInput Values: " + wire.getA() + ", " + wire.getB() + "\nOutput: " + wire.getS()
                + "\nCarry: " + wire.getC() + "\n");

    }

    public void test() {
        set(false, false);
        execute();
        print();

        set(false, true);
        execute();
        print();

        set(true, false);
        execute();
        print();

        set(true, true);
        execute();
        print();
    }

    public boolean getA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean getB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean getC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean getS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public boolean getOrOutput() {
        return orOutput;
    }

    public void setOrOutput(boolean orOutput) {
        this.orOutput = orOutput;
    }

    public boolean getAndOutput() {
        return andOutput;
    }

    public void setAndOutput(boolean andOutput) {
        this.andOutput = andOutput;
    }

    public boolean getNotOutput() {
        return notOutput;
    }

    public void setNotOutput(boolean notOutput) {
        this.notOutput = notOutput;
    }

}
