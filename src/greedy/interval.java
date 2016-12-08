package greedy;
import java.util.ArrayList;

import java.util.List;

public class interval {
	private List<Job> jobs;// job list
	private List<Job> finalSchedule;// final scheduled job
	private QuickSort sort = new QuickSort();

	/**
	 * constructor
	 * 
	 * @param jobs
	 */
	public interval(List<Job> jobs) {
		this.jobs = jobs;

	}

	/**
	 * get job list
	 * 
	 * @return jobs
	 */
	public List<Job> getJobs() {
		return this.jobs;
	}

	/**
	 * get final scheduled jobs
	 * 
	 * @return finalSchedule
	 */
	public List<Job> getFinalSchedule() {
		return this.finalSchedule;
	}

	/**
	 * greedy algorithm for interval schedule
	 */
	public void scheduler() {

		// sort job list using modified quicksort
		sort.quickSort(jobs);

		// scheduling jobs
		finalSchedule = new ArrayList<>();
		finalSchedule.add(jobs.get(0));
		int k = 0;
		for (int i = 1; i < jobs.size(); i++) {
			if (jobs.get(i).getStart() >= jobs.get(k).getEnd()) {
				finalSchedule.add(jobs.get(i));
				k = i;
			}
		}
	}
}
