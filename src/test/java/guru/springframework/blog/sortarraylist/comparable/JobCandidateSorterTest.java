package guru.springframework.blog.sortarraylist.comparable;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class JobCandidateSorterTest {

    @Test
    public void testGetSortedJobCandidateByAge() throws Exception {
        JobCandidate jobCandidate1 = new JobCandidate("Mark Smith", "Male", 26);
        JobCandidate jobCandidate2 = new JobCandidate("Sandy Hunt", "Female", 23);
        JobCandidate jobCandidate3 = new JobCandidate("Betty Clark", "Female", 20);
        JobCandidate jobCandidate4 = new JobCandidate("Andrew Styne", "Male", 24);
        ArrayList<JobCandidate> jobCandidateList = new ArrayList<>();
        jobCandidateList.add(jobCandidate1);
        jobCandidateList.add(jobCandidate2);
        jobCandidateList.add(jobCandidate3);
        jobCandidateList.add(jobCandidate4);
        JobCandidateSorter jobCandidateSorter = new JobCandidateSorter(jobCandidateList);
        ArrayList<JobCandidate> sortedJobCandidate = jobCandidateSorter.getSortedJobCandidateByAge();
        System.out.println("-----Sorted JobCandidate by age: Ascending-----");
        for (JobCandidate jobCandidate : sortedJobCandidate) {
            System.out.println(jobCandidate);
        }

    }
}