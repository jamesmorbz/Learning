package DumpEnv;
public class Scratch {
    
}



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

List<Integer> list = new ArrayList<Integer>( ((Hashtable<String, Integer>) Dictionary).values() );
Collections.sort(list, Collections.reverseOrder());
System.out.println("Sorted values: " + list);


//for (Enumeration keys = Dictionary.keys(); keys.hasMoreElements();)
//{
//    System.out.println("Sports Availible: " + keys.nextElement());
//}