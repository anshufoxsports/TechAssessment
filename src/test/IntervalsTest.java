/**
 * 
 */
package test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import main.Intervals;
/**
 * @author Anshu.Shireen
 *
 */
public class IntervalsTest {

	@Test
	public void testIntervalEx1() {
		
//		Includes: 10-100
//		Excludes: 20-30
//		Output should be: 10-19, 31-100
		
		Intervals inc= new Intervals();
		ArrayList<Integer> inl =new ArrayList<Integer>();
		Intervals.start = 10;
		Intervals.end   = 100;
		
		inc.setIntervals(inl);
		inl=inc.getIntervals();
		
		
		Intervals exc = new Intervals();
		ArrayList<Integer> exl =new ArrayList<Integer>();
		Intervals.start = 20;
		Intervals.end   = 30;	
		
		exc.setIntervals(exl);
		exl = exc.getIntervals();

		//Removing the exclusions 
		Set<Integer> result = new LinkedHashSet<Integer>();
		for(Integer i : exc.removeDuplicates(exl)){
					result = Intervals.removeItem(inc.removeDuplicates(inl),i);
				}
				
				System.out.println(" \"Resultant\" list ");
				System.out.println(result);
				//assert
		
	}
	
	
	@Test
	public void testIntervalEx2() {
		Intervals in = new Intervals();
	}

	
	@Test
	public void testIntervalEx3() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntervalEx4() {
		fail("Not yet implemented");
	}


}
