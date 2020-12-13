package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */

/**
 * @author Anshu.Shireen
 *
 */
public class Intervals {
	public static int start;
	public static int end;
	static Scanner sc= new Scanner(System.in);
	public ArrayList<Integer> mergedIntervals ;

	public Intervals(){
		  mergedIntervals= new ArrayList<Integer>();
	}
	
	public void setIntervals(ArrayList<Integer> intervals) {
		String response;		
		
		do{
			ArrayList<Integer> l = createList(start,end);
			ArrayList<Integer> finalset = mergeIntervals(this.mergedIntervals,l);
			this.mergedIntervals=finalset;

			System.out.print("do you wish to add more intervals? y/n ");
			response = sc.next();
			}
		while (response.contains("y"));		
	}

	
	public ArrayList<Integer> getIntervals(){
		return mergedIntervals;	
	}


	
	public static ArrayList<Integer> createList(int begin , int end){
		ArrayList<Integer> l = new ArrayList(end - begin+1);
  	    for(int i = begin; i <= end; l.add(i),i++);
		return l;
	}
	
	
	
	public static ArrayList<Integer> mergeIntervals(ArrayList<Integer> mlist, ArrayList<Integer> nlist){
		System.out.println("Merging the intervals...");
		mlist.addAll(mlist.size(),nlist);
		return mlist;
	}
	
	public Set<Integer> removeDuplicates(ArrayList<Integer> l){	
		System.out.println("Removing duplicates from the inclusions interval lists");
		Set<Integer> s = new LinkedHashSet<Integer>(l);
		System.out.println(s);
		return s;

	}
	
	
	
	public static Set<Integer> removeItem(Set<Integer> ins, int element) {
	    for (Iterator<Integer> i = ins.iterator(); i.hasNext();) {
	        Integer number = i.next();
	        if (Objects.equals(number, element)) {
	            i.remove();
	        }
	    }
		return ins;
	}
	
	public static void readInput(){				
		System.out.print("Enter start of interval- ");  
		start= sc.nextInt();  
		
		System.out.print("Enter end of interval- ");  
		end= sc.nextInt();  	
	}
	
	
	
	public static void main(String[] args) {
		/*Includes: 10-100, 200-300, 400-500
		Excludes: 95-205, 410-420
		Output should be: 10-19, 31-100*/
		

		Intervals inclusions = new Intervals();		
		System.out.println(" ######### Enter the \"Includes\" interval ranges ###########");
		readInput();
		ArrayList<Integer> inl =new ArrayList<Integer>();
		inclusions.setIntervals(inl);
		inl=inclusions.getIntervals();
		
		Intervals exclusions = new Intervals();	
		readInput();
		System.out.println(" ######### Enter the \"Excludes\" interval ranges ############");
		ArrayList<Integer> exl =new ArrayList<Integer>();
		exclusions.setIntervals(exl);
		exl = exclusions.getIntervals();

		
		
		//Removing the exclusions 
		Set<Integer> result = new LinkedHashSet<Integer>();
		for(Integer i : exclusions.removeDuplicates(exl)){
			result = removeItem(inclusions.removeDuplicates(inl),i);
		}
		
		System.out.println(" \"Resultant\" list ");
		System.out.println(result);
	}
}
