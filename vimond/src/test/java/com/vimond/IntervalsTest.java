package com.vimond; 
//import static org.junit.Assert.fail;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

//import org.junit.Test;


/**
 * @author Anshu.Shireen
 *
 */

public class IntervalsTest {
	
	Intervals inclusions = new Intervals();
	Intervals exclusions = new Intervals();
	Intervals expected  =  new Intervals();
	
	Intervals inc = new Intervals();
	Intervals exc = new Intervals();
	Intervals el = new Intervals();

	
	
	public void setRange(int s, int e ){
		Intervals.start = s;
		Intervals.end   = e;
	}
	
	public Intervals inclusions(int s, int e ){
		setRange(s,e);
		inclusions.setIntervals();
		return inclusions;
	}
	
	public Intervals exclusions(int s, int e ){
		setRange(s,e);
		exclusions.setIntervals();
		return exclusions;
		
	}
	
	public Intervals expected(int s, int e ){
		setRange(s,e);
		expected.setIntervals();
		return expected;
		
	}

	
	
	
	@Test
	public void testIntervalEx1() {
		
//		Includes: 10-100
//		Excludes: 20-30
//		Output should be: 10-19, 31-100

		inc = inclusions(10,100);
		exc = exclusions(20,30);
		
		Set<Integer> result,expected = new LinkedHashSet<Integer>();
		result = Intervals.getFinalIntervals(inc,exc)	;
		
		el =expected(10,19);
		el= expected(31,100);	
		
		//System.out.println("#######  Expected List   ###### ");
		expected=Intervals.getFinalIntervals(el);
		
		assertTrue(result.equals(expected));
		
		System.out.println("#######  Resultant list "+result);
	}
	
	
	@Test
	public void testIntervalEx2() {
		/*Includes: 50-5000, 10-100
		Excludes: (none)
		Output: 10-5000*/
		
		inc = inclusions(50,5000);
		inc = inclusions(10,100);		
		
		Set<Integer> result,expected = new LinkedHashSet<Integer>();
		result = Intervals.getFinalIntervals(inc)	;	
		
		el= expected(10,5000);		
		expected=Intervals.getFinalIntervals(el);
		assertTrue(result.equals(expected));
	
		System.out.println(" \"Resultant\" list ");
		System.out.println(result);
	}

	
	@Test
	public void testIntervalEx3() {
//		Includes: 10-100, 200-300
//		Excludes: 95-205
//		Output: 10-94,206-300		
		
		inc = inclusions(10,100);
		inc = inclusions(200,300);		
		
		exc = exclusions(95,205);
		
		Set<Integer> result,expected = new LinkedHashSet<Integer>();
		result = Intervals.getFinalIntervals(inc,exc);	
		
		el= expected(10,94);	
		el= expected(206,300);	
		expected=Intervals.getFinalIntervals(el);
		assertTrue(result.equals(expected));

		
		System.out.println(" \"Resultant\" list ");
		System.out.println(result);
		
	}

	@Test
	public void testIntervalEx4() {
//		Includes: 10-100, 200-300, 400-500
//		Excludes: 95-205, 410-420
//		Output: 10-94, 206-300, 400-409, 421-500
		
		inc = inclusions(10,100);
		inc = inclusions(200,300);		
		inc = inclusions(400,500);
		
		exc = exclusions(95,205);
		exc = exclusions(410,420);
		
		Set<Integer> result,expected = new LinkedHashSet<Integer>();
		result = Intervals.getFinalIntervals(inc,exc);	
		
		el= expected(10,94);	
		el= expected(206,300);
		el= expected(400,409);	
		el= expected(421,500);
		
		expected=Intervals.getFinalIntervals(el);
		assertTrue(result.equals(expected));

		
		System.out.println(" \"Resultant\" list ");
		System.out.println(result);
	}


}

