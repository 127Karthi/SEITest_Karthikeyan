import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class DeDup {
	
    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

    public static void main(String args[]){
    	DeDup deDupObj = new DeDup();
    	int[] withoutDup = null;
    	
    	//deDupObj.randomIntegers = deDupObj.getIntArrayWitnRandomValues(10000);
    	deDupObj.printArrayElements("Initial Array Elements :",deDupObj.randomIntegers);
    	withoutDup = deDupObj.removeDuplicates(deDupObj.randomIntegers);
    	deDupObj.printArrayElements("Removed Duplicates (With Order) :",withoutDup);
    	
    	withoutDup = deDupObj.removeDuplicatesWithSorting(deDupObj.randomIntegers);
    	deDupObj.printArrayElements("Removed Duplicates By Sorting :",withoutDup);
    	
    	withoutDup = deDupObj.removeDuplicatesWithHashMap(deDupObj.randomIntegers);
    	deDupObj.printArrayElements("Removed Duplicates By HashMap :",withoutDup);
    	

    }
    /*
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
		
	*/
    public int[] removeDuplicates(int[] arrayWithDup){
    	int arraySize = 0;
    	int i=0;
    	int current = 0;
    	int next = -1;
    	boolean dupFound = false;
    	int[] arrayWithoutDup = null;
    	int[] resultArray = null;
    	
    	if(arrayWithDup == null){
    		return null;
    	}
    	arraySize = arrayWithDup.length;
    	arrayWithoutDup = new int[arraySize];
    	for(;i<arraySize;i++){
    		current =  arrayWithDup[i];
    		for(int k=0;k<=next+1;k++){
    			if(next<0){
    				arrayWithoutDup[next+1]=current;
    				next++;
    				break;
    				
    			}else if(current==arrayWithoutDup[k]){
    				dupFound = true;
    				break;
    			}
    		}
    		if(!dupFound && next>=0){
    			arrayWithoutDup[next]=current;
    			dupFound = false;
    			next++;
    		}else{
    			dupFound = false;
    		}
    		
    	}
    	
    	resultArray = new int[next];
    	/*
    	 * Copying array to another new array object to get rid of 
    	 * the default values in the tail of the array. This also can be achieved 
    	 * with System.arraycopy as shown below.
    	 * 
    	 * System.arraycopy(arrayWithoutDup, 0, resultArray, 0,next);
    	 * */
    	for(int in=0;in<next;in++){
    		resultArray[in]=arrayWithoutDup[in];    		
    	}
    	
    	return resultArray;
    }
    
    /*
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
	*/
    public int[] removeDuplicatesWithSorting(int[] arrayWithDup){    	
    	int currentElement = 0;
    	boolean found = false;
    	int next = 0;
    	int[] arrayWithoutDup = null;
    	int[] resultArray = null;
    	
    	arrayWithDup = sortArrayElements(arrayWithDup);    	
    	currentElement = arrayWithDup[0];    	
    	arrayWithoutDup = new int[arrayWithDup.length];

    	for (int i = 0; i < arrayWithDup.length; i++) {
    	    if (currentElement == arrayWithDup[i] && !found) {
    	        found = true;
    	    } else if (currentElement != arrayWithDup[i]) {
    	        arrayWithoutDup[next]=currentElement;
    	        currentElement = arrayWithDup[i];
    	        next++;
    	        found = false;
    	    }
    	}
    	arrayWithoutDup[next]=currentElement;
    	next++;
    	    	
    	resultArray = new int[next];
    	/*
    	 * Copying array to another new array object to get rid of 
    	 * the default values in the tail of the array. This also can be achieved 
    	 * with System.arraycopy as shown below.
    	 * 
    	 * System.arraycopy(arrayWithoutDup, 0, resultArray, 0,next);
    	 * */
    	for(int in=0;in<next;in++){
    		resultArray[in]=arrayWithoutDup[in];    		
    	}
    	return resultArray;
    }
    
    
      
	/*
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
		
	*/
    public int[] removeDuplicatesWithHashMap(int[] arrayWithDup){
    	Map<Integer,Boolean> intMap = new HashMap<Integer,Boolean>();
    	int[] arrayWithoutDup = null;
    	if(arrayWithDup == null){
    		return null;
    	}
    	for(int i=0;i<arrayWithDup.length;i++){
    		intMap.put(arrayWithDup[i], true);
    	}
    	arrayWithoutDup = convertSetToArray(intMap.keySet());
    	return arrayWithoutDup;
    }
    
    private int[] convertSetToArray(Set<Integer> intSet){
    	int[] arrayWithoutDup = null;
    	int i=0;
    	if(intSet == null){
    		return arrayWithoutDup;
    	}
    	arrayWithoutDup = new int[intSet.size()];
    	for(Integer element:intSet){
    		arrayWithoutDup[i]=element;
    		i++;
    	}
    	return arrayWithoutDup;
    }
    
    private int[] sortArrayElements(int[] unSortedArray){
    	int temp =0;
    	
    	for(int i=0;i<unSortedArray.length;i++)
        {
            for(int j=i;j<unSortedArray.length;j++)
            {
                if(unSortedArray[i]>unSortedArray[j])
                {
                temp=unSortedArray[i];
                unSortedArray[i]=unSortedArray[j];
                unSortedArray[j]=temp;
                }

            }
        }
    	
    	return unSortedArray;
    }
    
    private void printArrayElements(String str,int[] intArray){
    	if(intArray != null){
    		System.out.println(str);
    		for(int i=0;i<intArray.length;i++){
	    		System.out.print(intArray[i]+" ");
	    	}
	    	System.out.println();
    	}
    }
    
    //Method to generate integer array with given length.
    private int[] getIntArrayWitnRandomValues(int maxLength){
    	int[] intArray = new int[maxLength];
    	Random randomGenerator = new Random();
    	for(int i=0;i<maxLength;i++){
    		intArray[i]=randomGenerator.nextInt(maxLength);
    	}
    	return intArray;
    }

}
