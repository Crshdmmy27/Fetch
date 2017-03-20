


public class Wire {
    private boolean a;
    private boolean b;
    private boolean s;
    private boolean c;
    private boolean x;
    public boolean v;

    public boolean getX() {
        return x;
    }

    public void setX(boolean x) {
        this.x = x;
    }


    public void set(boolean a, boolean b) {
        this.a = a;
        this.b = b;

    }


    public void set(boolean a, boolean b, boolean x) {
        this.a = a;
        this.b = b;
        this.x = x;

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

    public boolean getS() {
        return s;
    }

    public void setS(boolean s) {
        this.s = s;
    }

    public boolean getC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

}
