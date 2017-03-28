public class FetchMem {

    public cell[] mem;
    public int offset = 0000;
    public int size = 1000;
   // public boolean type; //{prog=1, data=0}

    public FetchMem(){
       mem = new cell[size];
       for (int i = 0 ; i<mem.length; i++)
       		mem[i] = new cell();
    }

    public void setCell(int index){
        if (index > mem.length)
            throw new IndexOutOfBoundsException("index is out of bounds");
        else mem[index].set();
    }
    public void setCell(int index, boolean[]code, boolean [] ssss, boolean [] dddd){
    	if (index>mem.length)
    		throw new IndexOutOfBoundsException("Out of Bounds!");
    	else if (code.length!=4)
    		throw new IndexOutOfBoundsException("OpCout not 4 Bits");
    	else if (ssss.length!=4)
    		throw new IndexOutOfBoundsException("SSSS not 4 Bits");
    	else if (dddd.length!=4)
    		throw new IndexOutOfBoundsException("DDDD not 4 Bits");
    	else 
    		mem[index].set(code, ssss, dddd);
    }
    
    public void clrCell(int index){
    	if (index>mem.length)
    		throw new IndexOutOfBoundsException("Out of Bounds!");
    	else
    		mem[index].clr();
    		
    }
    
    public boolean[] getCode(int index){
    	if (index>mem.length)
    		throw new IndexOutOfBoundsException("Out of Bounds!");
    	else {
    		cell c = mem[index];
    		return (boolean[]) c.getC();
    	}
    }
    public boolean[] getD(int index){
        if(index > mem.length){
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        else{
            cell c = mem[index];
            return(boolean[]) c.getD();
    }
    }
    public boolean[] getS(int index){
        if(index > mem.length){
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        else{
            cell c = mem[index];
            return(boolean[]) c.getS();
    }
    }
    public void print(int index){
        if(index > mem.length){
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        else{
            cell c = mem[index];
            System.out.print("MEM: " + ": ");
            c.print();
            System.out.println();
        }
    }
    


//    public void clrByte(int index){
//        if (index > v.length)
//            throw new IndexOutOfBoundsException("index is out of bounds");
//        else
//            v[index] = 0;
//    }
//
//    public void print(int index){
//        if (index > v.length)
//            throw new IndexOutOfBoundsException("index is out of bounds");
//        else
//            System.out.println("MEM: " + index + ": " + v[index]);
//    }
//
//    public void testMem(){
//        print(10);
//        print(20);
//
//        setByte(10);
//        setByte(20);
//
//        print(10);
//        print(20);
    
    
    private void intToBoolean (int number, boolean[] dddd){
        for (int i = 0; i < 4; i++){
            dddd[4 - 1 - i] = (1 << i & number) != 0;
        }
    }

    public void testMem(){
        boolean[] code;
        boolean[] ssss;
        boolean[] dddd;
        code = new boolean[4];
        ssss = new boolean[4];
        dddd = new boolean[4];

        for(int i = 0; i < 8; i++){
            intToBoolean(i, code);
            for(int j = 0; j < code.length; j++){
                System.out.print(code[j] + " ");
            System.out.println();
            }
        }

        for(int i = 0; i < 8; i++){
            intToBoolean(i, code);
            intToBoolean(i, ssss);
            intToBoolean(i, dddd);
            setCell(i, code, ssss, dddd);
            print(i);
        }
    }
    
}
    
    class cell{
    	int cellSize = 12;
    	public boolean [] c;
    	
    	cell(){
    		c = new boolean [cellSize];
    	}
    	
    	public void set(boolean [] code, boolean[] s, boolean [] d){
    		int j=0;
    		for (int i = 0; i<code.length; i++)
    			c[j++]= code[i];
    		for (int i = 0; i<s.length; i++)
    			c[j++]= s [i];
    		for (int i = 0; i<d.length; i++)
    			c[j++] = d[i];
    	}
    	
    	public void set(){
    		for (int i = 0; i<c.length; i++)
    			c[i]= true;
    	}
    	public void clr(){
    		for (int i =0; i<c.length;i++)
    			c[i] = false;
    	}
    	
    	public boolean[] getC(){
    		boolean [] code = new boolean[4];
    		for (int i= 0; i<code.length; i++)
    			code[i] = c[i];
    		return code;
    	}
    	public boolean[] getS(){
    		boolean [] s = new boolean[4];
    		for (int i= 0; i<s.length; i++)
    			s[i] = c[i+4];
    		return s;
    	}
    	public boolean[] getD(){
    		boolean [] d = new boolean[4];
    		for (int i= 0; i<d.length; i++)
    			d[i] = c[i+8];
    		return d;
    	}
    	
    
    
    public void print(){
    	for(int i =0; i<c.length; i++)
    		System.out.println(c[i]+ " ");
    }
 }  



