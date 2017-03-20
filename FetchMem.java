public class FetchMem {

    public byte[]v;
    public int offset = 0000;
    public int size = 1000;
    public boolean type; //{prog=1, data=0}

    public FetchMem(){
        v = new byte[size];
    }

    public void setByte(int index){
        if (index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else v[index] = 127;
    }

    public void clrByte(int index){
        if (index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else
            v[index] = 0;
    }

    public void print(int index){
        if (index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else
            System.out.println("MEM: " + index + ": " + v[index]);
    }

    public void testMem(){
        print(10);
        print(20);

        setByte(10);
        setByte(20);

        print(10);
        print(20);
    }


}
