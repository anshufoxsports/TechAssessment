# TechAssessment

This repo contains two java files with programs 
1. Intervals.java - To find non-overlapping intervals for given input and excludes lists 
  The main method can be used for interactive input , or run the test class IntervalsTest.java to run the tests for a set of inputs
  
  The algorithm used to approach this problem is summarised as : 
  
      Read boundary values for each list
      Sort and Merge the list in case of multiple inputs
      Remove duplicates or overlaps ( converting list to a set )
      Iterate through exclusion set and remove it from the inclusion set
      Store the resultant in a new set, print the results.
  
  I have not used queues or inputstreams( availabe in java 8) . I could have used the sweep algorithm , but inbuilt functions in Collections were handy.
  
  
2. FizzBuzz.java - multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz"
    Run this as java application


To run the tests use : 
        mvn clean test
        
        
