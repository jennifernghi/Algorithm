package greedy;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	static List<Job> jobResult = new ArrayList<>();
	FileHandler f = new FileHandler();
	/**
	 * problem 1
	 * @param filename
	 */
	public void intervalscheduling(String filename) {
		//read file
		List<Job> jobs = f.readFileJob(filename.trim());
		//scheldule
		interval i = new interval(jobs);
		i.scheduler();
		//print out results and write to a file
		for(Job finalschedule: i.getFinalSchedule()){
			System.out.println(finalschedule);
			jobResult.add(finalschedule);
		}
		
		
		
		f.writeToAFile(jobResult, "OutputIS.txt");
		System.out.println("Succesfull! results are in OutputIS.txt");
	}
	
	
	
	public static void main(String[] args) {
		 
		if(args.length == 2){
			Demo demo = new Demo();
			
			
			if(Integer.parseInt(args[0].trim())==1){
				demo.intervalscheduling(args[1].trim());
			}
		}else{
			System.out.println("to test for problem 1: java Demo 1 filename");
			System.out.println("filename: interval");
			System.out.println("to test for problem 2: java Demo 2 filename");
			System.out.println("filename: lcs");
		}
		
	}
	
	
}
