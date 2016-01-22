# SEITest_Karthikeyan
Karthikeyan Arthanari - SEI Test

Approach 1: This method takes the basic approach that take each element from the source array and compare with each element
		in destination array. Add the element in the destination array only if the element is not already exist in the 
		destination array.
		
		Positives in this approach :
		1) It maintains the same order as the elements appearing in the source array.
		2) It is fast comparatively when the array has large number of duplicates.
		3) The source array iterated only once. 
		
		Negatives in this approach:
		1) The destination array is iterated as much as the number of elements in the source array. In worst case, if there
		is no duplicates in the source array, the destination array will be iterated till the end. 
		2) As the source array grows in size, this approach takes time to remove the duplicates. But, when compare to 
		Approach 2, it will take less time.
		
		Alternate Approaches : 
		1) Sort the elements in source array and tale each element to compare with next element to find the duplicates.
		The method removeDuplicatesWithSorting() implements this approach.
		2) Use Java HashMap (or Set) implementation to remove duplicates. It eliminates the nagatives of this approach.
		The method removeDuplicatesWithHashMap() implements this approach.
		
		Use Cases:
		Use Case 1:
			Description: Pass the integer array with duplicates to this method, it returns the integer array with unique integer values
			Pre-Condition : The Integer Array can be sorted or un-sorted
			Post-Condition : The duplicate values are removed, the array contains unique values.
			Assumptions : The source integer array has duplicate values.
			
		Use Case 2:
			Description: Pass the sorted integer array with duplicates to this method, it returns the integer array with unique integer values
			Pre-Condition : The source integer array is sorted and have duplicates. Sorted array will not impact the program's performance.
			Post-Condition : The duplicate values are removed, the array contains unique values.
			Assumptions : The source integer array has duplicate values and sorted.
		
		Use Case 3:
			Description: Pass the null object to this method, it returns the null object.
			Pre-Condition : The source integer array is null
			Post-Condition : It returns null object.
			Assumptions : No assumptions.
		
	
	Approach 2: This method takes the basic approach that sort the array elements and compare the each element with next
		element in the sorted array. Add element to destination array only if the next element is different than the current one.
		
		Positives in this approach :
		1) It scan the sorted source array only once to remove the duplicates.
		 
		
		Negatives in this approach:
		1) The source array is scanned multiple times to sort the array which slow down the process.In worst case, if the source 
		array is already sorted, then sorting is time consuming.
		2) The original order in the source array can not be retained.
		2) As the source array grows in size, this approach takes time to remove the duplicates. This approach takes more time
		 when compare to other two approaches.
		
		Alternate Approaches : 
		1) To retain the original order, take each element from the source array and compare with each element
		in destination array. Add the element in the destination array only if the element is not already exist in the 
		destination array. The method removeDuplicates() implements this approach.
		2) Use Java HashMap (or Set) implementation to remove duplicates. It eliminates the nagatives of this approach.
		The method removeDuplicatesWithHashMap() implements this approach.
		
		Use Cases:
		Use Case 1:
			Description: Pass the integer array(not sorted) with duplicates to this method, it returns the integer array with unique integer values
			Pre-Condition : The Integer Array can be un-sorted
			Post-Condition : The duplicate values are removed, the array contains unique values.
			Assumptions : The source integer array has duplicate values and not sorted.
		
		Use Case 2:
			Description: Pass the sorted integer array with duplicates to this method, it returns the integer array with unique integer values
			Pre-Condition : The integer array is sorted, it is not going to change the result. 
			But, sorting the sorted array is overkill the program.
			Post-Condition : The duplicate values are removed, the array contains unique values.
			Assumptions : The source integer array has duplicate values and sorted.
		
		Use Case 3:
			Description: Pass the null object to this method, it returns the null object.
			Pre-Condition : The source integer array is null
			Post-Condition : It returns null object.
			Assumptions : No assumptions.
			
			
			
			Approach 3: This approach uses the Java implementation of HashMap. HashMap keys are unique, so add the each array element
		as key and dummy boolean value as value (HashSet using this approach).
		
		Positives in this approach :
		1) This approach is very fast as HashMap is using hashcode() and equals() method internally.
		2) It eliminates the need of sorting.
		3) The source array is iterated only once.	
		4) This approach is fast and efficient even for 1000000 integer elements in the array.	 
		
		Negatives in this approach:
		1) This solution is tightly coupled with Java language as it is using java HashMap implementation.
		2) The original order in the source array can not be retained. 
		
		Alternate Approaches : 
		1) To retain the original order, take each element from the source array and compare with each element
		in destination array. Add the element in the destination array only if the element is not already exist in the 
		destination array. The method removeDuplicates() implements this approach.
		
		Use Cases:
		Use Case 1:
			Description: Pass the integer array with duplicates to this method, it returns the integer array with unique integer values
			Pre-Condition : The Integer Array can be sorted or un-sorted
			Post-Condition : The duplicate values are removed, the array contains unique values.
			Assumptions : The source integer array has duplicate values.
		
		Use Case 2:
			Description: Pass the null object to this method, it returns the null object.
			Pre-Condition : The source integer array is null
			Post-Condition : It returns null object.
			Assumptions : No assumptions.
