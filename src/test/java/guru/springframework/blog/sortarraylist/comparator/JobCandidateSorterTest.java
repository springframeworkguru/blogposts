package guru.springframework.blog.sortarraylist.comparator;


import guru.springframework.blog.sortarraylist.comparator.JobCandidate;
import guru.springframework.blog.sortarraylist.comparator.JobCandidateSorter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JobCandidateSorterTest {
    JobCandidateSorter jobCandidateSorter;

    @Before
    public void setUp() throws Exception {
        JobCandidate jobCandidate1 = new JobCandidate("Mark Smith", "Male", 26);
        JobCandidate jobCandidate2 = new JobCandidate("Sandy Hunt", "Female", 23);
        JobCandidate jobCandidate3 = new JobCandidate("Betty Clark", "Female", 20);
        JobCandidate jobCandidate4 = new JobCandidate("Andrew Styne", "Male", 24);
        ArrayList<JobCandidate> jobCandidateList = new ArrayList<>();
        jobCandidateList.add(jobCandidate1);
        jobCandidateList.add(jobCandidate2);
        jobCandidateList.add(jobCandidate3);
        jobCandidateList.add(jobCandidate4);
        jobCandidateSorter = new JobCandidateSorter(jobCandidateList);
    }

    @Test
    public void testGetSortedJobCandidateByAge() throws Exception {
        System.out.println("-----Sorted JobCandidate by age: Descending-----");
        ArrayList<JobCandidate> sortedJobCandidate = jobCandidateSorter.getSortedJobCandidateByAge();
        for (JobCandidate jobCandidate : sortedJobCandidate) {
            System.out.println(jobCandidate);
        }
    }

    @Test
    public void testGetSortedJobCandidateByName() throws Exception {
        System.out.println("-----Sorted JobCandidate by name: Ascending-----");
        ArrayList<JobCandidate> sortedJobCandidate = jobCandidateSorter.getSortedJobCandidateByName();
        for (JobCandidate jobCandidate : sortedJobCandidate) {
            System.out.println(jobCandidate);
        }

    }
}