package guru.springframework.blog.sortarraylist.ascendingdescending;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class SortArrayListAscendingDescendingTest {

    @Test
    public void testSortAscendingDescending() throws Exception {
        ArrayList<String> countryList = new ArrayList<>();
        countryList.add("France");
        countryList.add("USA");
        countryList.add("India");
        countryList.add("Spain");
        countryList.add("England");
        SortArrayListAscendingDescending sortArrayList = new SortArrayListAscendingDescending(countryList);
        ArrayList<String> unsortedArrayList = sortArrayList.getArrayList();
        System.out.println("Unsorted ArrayList: " + unsortedArrayList);
        ArrayList<String> sortedArrayListAscending = sortArrayList.sortAscending();
        System.out.println("Sorted ArrayList in Ascending Order : " + sortedArrayListAscending);
        ArrayList<String> sortedArrayListDescending = sortArrayList.sortDescending();
        System.out.println("Sorted ArrayList in Descending Order: " + sortedArrayListDescending);
    }
}