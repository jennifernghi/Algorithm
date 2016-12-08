package greedy;


public class Job {
	private String id;
	private int start;
	private int end;
	
	public Job(String id, int start, int end){
		this.id=id;
		this.start=start;
		this.end=end;
	}

	public int getEnd() {
		return this.end;
	}
	
	public int getStart() {
		return this.start;
	}

	

	@Override
	public String toString() {
		return id + " " + start + " "+end;
	}
	
	
	
}
