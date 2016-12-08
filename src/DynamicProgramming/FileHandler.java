package DynamicProgramming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileHandler {
	
	private ArrayList<LCS> lcsInputData;
	//private ArrayList<Job> jobInputData;
	
	
	public ArrayList<LCS> getlcsInputData() {
		return this.lcsInputData;
	}
	/**
	 * read file for LCS problem
	 * @param filename
	 */
	public void readFileLCS(String filename){
		lcsInputData = new ArrayList<>();
		String line = "";
		BufferedReader reader=null;
		
		InputStream in = getClass().getResourceAsStream(filename);
		try {
			reader = new BufferedReader(new InputStreamReader(in));

			while((line = reader.readLine()) != null){
				int i = line.trim().indexOf(' ');
				char[] x = line.trim().substring(0, i).toCharArray();
				char[] y = line.trim().substring(i).toCharArray();
				//add new LCS(x, y)
				lcsInputData.add(new LCS(x,y));
			}
			
		} catch (IOException e1) {
			System.out.println("Error reading file");
		}
		
	}
	/**
	 * read jobs from a file
	 * @param filename
	 * @return
	 */
	/*public ArrayList<Job> readFileJob(String filename){
		jobInputData = new ArrayList<>();
		String line = "";
		BufferedReader reader=null;
		
		InputStream in = getClass().getResourceAsStream(filename);
		try {
			reader = new BufferedReader(new InputStreamReader(in));

			while((line = reader.readLine()) != null){
				int firstBlank = line.trim().indexOf(' ');
				int secondBlank = line.trim().lastIndexOf(' ');
				String id = line.trim().substring(0, firstBlank);
				int start = Integer.parseInt(line.trim().substring(firstBlank+1,secondBlank));
				int end = Integer.parseInt(line.trim().substring(secondBlank+1));
				jobInputData.add(new Job(id, start, end));
			}
			
		} catch (IOException e1) {
			System.out.println("Error reading file");
		}
		
		return jobInputData;
		
	}*/
	/**
	 * write results to a file
	 * @param data
	 * @param outputFileName
	 */
	public <T> void writeToAFile(List<T> data, String outputFileName) {
		File file = new File(outputFileName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Error writting file");
			}
		}
		
		FileWriter fileWriter;
		
		try {
			fileWriter = new FileWriter(file.getAbsolutePath());
			BufferedWriter writer = new BufferedWriter(fileWriter);
			for(T result: data){
				writer.write(result.toString().trim());
				writer.newLine();
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writting file");
		}
	}
}
