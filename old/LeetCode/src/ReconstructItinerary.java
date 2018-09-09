import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * 332. Reconstruct Itinerary
 * 
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

    If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.

Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order. 
 * @author abhigupta
 *
 */
public class ReconstructItinerary {

    
    List<String> list = new ArrayList();

public List<String> findItinerary(String[][] tickets) {


if(tickets == null || tickets.length ==0) {
    return list;
}

Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

for(int i = 0; i< tickets.length;i++) {
    
      PriorityQueue<String> val =  map.get(tickets[i][0]);
    
    if(val != null) {
        


       val.add(tickets[i][1]);
        
    }else {
        val = new PriorityQueue<String>();
        val.add(tickets[i][1]);
        map.put(tickets[i][0],val);
    }

}

visit("JFK", map);
return list;

}

void visit(String airport, Map<String, PriorityQueue<String>> targets) {
while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
    visit(targets.get(airport).poll(), targets);
list.add(0, airport);
}


}
