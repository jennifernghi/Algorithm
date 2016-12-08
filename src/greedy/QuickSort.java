package greedy;
import java.util.List;

/**
 * 
 * @author Nghi Nguyen
 * Modified QuickSort used for interval scheduling
 */
public class QuickSort {
	
	
	/**
	 *  quicksort for list of Job
	 * @param list - generic list
	 */
	public void quickSort(List<Job> list){
		quickSort(list, 0, list.size()-1);
	}
	
	/**
	 * Recusive sorting algorithm
	 * @param list - Job list
	 * @param start - first index of the list
	 * @param end - last index of the list
	 */
	public void quickSort(List<Job> list, int start, int end){
		if(start < end){//base case
			int pivotIndex = partition(list,start,end); //get the index of the pivot
			quickSort(list, start, pivotIndex-1);//sort the left part
			quickSort(list,pivotIndex+1,end);//sort the right part
		}
	}
	/**
	 * partition
	 * @param list - Job list
	 * @param start - first index of the list
	 * @param end - last index of the list
	 * @return new pivotIndex
	 */
	public int partition(List<Job> list, int start, int end){
		Job pivot = list.get(end); // the pivot is the last element
		int i = start-1;
		for(int j = start; j<end; j++){
			//compare by ending time
			if(Integer.valueOf(list.get(j).getEnd()).compareTo(pivot.getEnd())<=0){
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i+1, end);//swap the pivot, now elements on the left smaller than the pivot, and elements on the right larger than the pivot
		
		return i+1;// return new index of the pivot
	}
	
	
	
	/**
	 * swap list[i] with list[j] 
	 * @param list - Job list
	 * @param i - index 
	 * @param j - index
	 */
	public void swap(List<Job> list, int i, int j){
		Job temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
