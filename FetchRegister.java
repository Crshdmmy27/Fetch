
public class FetchRegister {

    public int wordSize = 0;
    public boolean[] v;
    public String name;

    public FetchRegister(){
        v = new boolean[wordSize];
        name = "NA";
    }

    public FetchRegister (String aName){
        this();
        name= aName;
    }

    public void setBit (int index){
        if(index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else
            v[index] = true;
    }
    
    public void setBit (int index,boolean value){
        if(index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else
            v[index] = value;
    }

    public void clrBit (int index){
        if (index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else
            v[index] = false;
    }

    public boolean getBit (int index){
        if(index > v.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else
            return v [index];
    }


    public void setBits(){
        for (int i = 0; i < v.length; i++)
            v[i] = true;
    }

    public boolean[] getBits(){
        return v;
    }

    public void print(){
        System.out.print(this.name + " ");
        for (int i = 0; i < v.length; i++)
            System.out.print(v[i] + " ");
        System.out.println();
    }
}
