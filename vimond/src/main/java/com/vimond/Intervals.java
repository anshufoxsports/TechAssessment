package com.vimond;

import java.util.*;
import java.util.logging.Logger;


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
	private final static Logger LOGGER = Logger.getLogger(Intervals.class.getName());


	public Intervals(){
		mergedIntervals= new ArrayList<Integer>();		
	}

	public void setIntervals() {		
		ArrayList<Integer> l = createList(start,end);
		ArrayList<Integer> finalset = mergeIntervals(this.mergedIntervals,l);
		this.mergedIntervals=finalset;
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
//		LOGGER.info("Merging the intervals...");
		mlist.addAll(mlist.size(),nlist);
		return mlist;
	}

	public Set<Integer> removeDuplicates(ArrayList<Integer> l){	
		Collections.sort(l);
		Set<Integer> s = new LinkedHashSet<Integer>(l);
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
		start =0;end =0;

		System.out.print("Enter start of interval- ");  
		start= sc.nextInt();  

		System.out.print("Enter end of interval- ");  
		end= sc.nextInt();  
	}

	/**
	 * @param inclusions
	 * @param exclusions
	 * @return
	 */
	public static Set<Integer> getFinalIntervals(Intervals inc,  Intervals ... args) {
		Set<Integer> result = new LinkedHashSet<Integer>();
		LOGGER.info("#######  Sorting and Removing duplicates from the interval lists #####");
		
		//System.out.println("#######  User Input List  "+inc.getIntervals());
		Set<Integer> ins = inc.removeDuplicates(inc.getIntervals());
		//System.out.println("#######  Final List       "+ins);

		Intervals exc = new Intervals();
		if (args.length>0){
			exc = args[0];
			System.out.println("#######  Input Exclusion       "+exc.getIntervals());
			Set<Integer> exs = exc.removeDuplicates(exc.getIntervals());
			System.out.println("#######  Final Exclusions List "+exs);

			//Removing the exclusions 
			for(Integer i : exs){
				result = removeItem(ins,i);
			}

		} else result = ins;
		
		return result;
	}




	public static void main(String[] args) {
		/*Includes: 10-100, 200-300, 400-500
		Excludes: 95-205, 410-420
		Output should be: 10-19, 31-100*/


		Intervals inclusions = new Intervals();
		LOGGER.info(" ######### Enter the \"Includes\" interval ranges ###########");
		String response;
		ArrayList<Integer> inl =new ArrayList<Integer>();


		do {
			readInput();
			inclusions.setIntervals();

			System.out.print("do you wish to add more intervals? y/n ");
			response = sc.next();
		}
		while (response.contains("y"));
		inl=inclusions.getIntervals();

		Intervals exclusions = new Intervals();
		LOGGER.info(" ######### Enter the \"Excludes\" interval ranges ############");

		ArrayList<Integer> exl =new ArrayList<Integer>();
		response =null;

		do{
			readInput();
			exclusions.setIntervals();
			System.out.print("do you wish to add more intervals? y/n ");
			response = sc.next();
		}
		while (response.contains("y"));	
		exl = exclusions.getIntervals();
		


		Set<Integer> result = new LinkedHashSet<Integer>();
		result = getFinalIntervals(inclusions, exclusions);

		LOGGER.info(" \"Resultant\" list ");
		LOGGER.info(result.toString());
	}

}
