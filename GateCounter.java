
public class GateCounter {
	private static int totalCount;
	
	public void tallyCount(){
		System.out.println(totalCount);
		
	}
	
	public void tallyIn(){
		totalCount += 1;
	}

}
