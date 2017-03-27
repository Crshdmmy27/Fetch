


public class FullAdder {

    HalfAdder h1 = new HalfAdder();
    HalfAdder h2 = new HalfAdder();
    OrGate o1 = new OrGate();
    Wire wire = new Wire();

    private boolean a;
    private boolean b;
    private boolean c;

    private boolean h1S = false;
    private boolean h1C = false;
    private boolean h2C = false;

    public Wire execute() {

        Wire w1 = new Wire();
        //System.out.println(w1.getA() + "," + w1.getB() + "," + w1.getC() + "," + w1.getS() + "," + w1.getX());
        w1.set(wire.getB(), wire.getX());
        // System.out.println(w1.getA());
        h1.set(w1.getA(), w1.getB());
        w1 = h1.execute();

        Wire w2 = new Wire();
        w2.set(wire.getA(), w1.getS());
        h2.set(w2.getA(), w2.getB());
        w2 = h2.execute();
        wire.setS(w2.getS());

        o1.set(w2.getC(), w1.getC(), wire.getC());
        wire.setC(o1.execute());

        return wire;
    }

    public void Print() {
        System.out.println("Full adder\ninputs: " + wire.getA() + ", " + wire.getB() + ", " + wire.getX() + "\noutput: "
                + wire.getS() + "\ncarry: " + wire.getC() + "\n");
    }

    public void set(boolean argA, boolean argB, boolean argC) {
        a = argA;
        b = argB;
        c = argC;
        wire.set(argA, argB, argC);

    }

    public void test() {
        set(false, false, false);
        execute();
        Print();
        set(false, false, true);
        execute();
        Print();
        set(false, true, false);
        execute();
        Print();
        set(false, true, true);
        execute();
        Print();
        set(true, false, false);
        execute();
        Print();
        set(true, false, true);
        execute();
        Print();
        set(true, true, false);
        execute();
        Print();
        set(true, true, true);
        execute();
        Print();
    }

}
