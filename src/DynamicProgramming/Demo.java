package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	static List<String> lcsResults = new ArrayList<>();
	
	FileHandler f = new FileHandler();
	
	/**
	 * problem 2
	 * @param filename
	 */
	public void findLCS(String filename) {
		//read from afile
		f.readFileLCS(filename.trim());
		//find LCS and write to a file
		for(LCS lcs: f.getlcsInputData()){
			lcs.findLCS(lcs.getX(), lcs.getY());
			lcsResults.add(lcs.getLCSString());
		}
		
		f.writeToAFile(lcsResults, "OutputLCS.txt");
		System.out.println("Succesfull! results are in OutputLCS.txt");
	}
	
	
	public static void main(String[] args) {
		 
		if(args.length == 2){
			Demo demo = new Demo();
			if(Integer.parseInt(args[0].trim())==2){
				demo.findLCS(args[1].trim());
			}
			
			
		}else{
			
			System.out.println("to test for problem : java Demo 2 filename");
			System.out.println("filename: lcs");
		}
		
	}
	
	
}
