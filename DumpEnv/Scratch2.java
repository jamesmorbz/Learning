package DumpEnv;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class Scratch2 {

Hashtable<String, Integer> htRandomNumbers = new Hashtable<String, Integer>();
 
htRandomNumbers.put("Five", 5);
htRandomNumbers.put("Three", 3);
htRandomNumbers.put("Nine", 9);
htRandomNumbers.put("Seven", 7);
htRandomNumbers.put("Two", 2);
 
System.out.println( "Hashtable contains: " + htRandomNumbers );
 
//get all the entries from the hashtable and put it in a List
List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(htRandomNumbers.entrySet());
 
//sort the entries based on the value by custom Comparator
Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
 
  public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
      return entry1.getValue().compareTo( entry2.getValue() );
  }
  
});
 
Map<String, Integer> mapSortedByValues = new LinkedHashMap<String, Integer>();
 
//put all sorted entries in LinkedHashMap
for( Map.Entry<String, Integer> entry : list  ){
    mapSortedByValues.put(entry.getKey(), entry.getValue());
}
 
System.out.println("Map sorted by values: " + mapSortedByValues);

}
//for (Enumeration keys = Dictionary.keys(); keys.hasMoreElements();)
//{
//    System.out.println("Sports Availible: " + keys.nextElement());
//}