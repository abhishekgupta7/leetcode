import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/***
 *  Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:

    Return an empty list if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes. 
 * @author abhigupta
 *
 */
public class WordLadder2 {
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {      
   List<List<String>> res = new ArrayList<List<String>>();         
   HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
   HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
   ArrayList<String> solution = new ArrayList<String>();

   dict.add(end);          
   bfs(start, end, dict, nodeNeighbors, distance);                 
   dfs(start, end, dict, nodeNeighbors, distance, solution, res);   
   return res;
}

// BFS: Trace every node's distance from the start node (level by level).
private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
  for (String str : dict)
      nodeNeighbors.put(str, new ArrayList<String>());

  Queue<String> queue = new java.util.LinkedList<>();
  queue.offer(start);
  distance.put(start, 0);

  while (!queue.isEmpty()) {
      int count = queue.size();
      boolean foundEnd = false;
      for (int i = 0; i < count; i++) {
          String cur = queue.poll();
          int curDistance = distance.get(cur);                
          ArrayList<String> neighbors = getNeighbors(cur, dict);

          for (String neighbor : neighbors) {
              nodeNeighbors.get(cur).add(neighbor);
              if (!distance.containsKey(neighbor)) {// Check if visited
                  distance.put(neighbor, curDistance + 1);
                  if (end.equals(neighbor))// Found the shortest path
                      foundEnd = true;
                  else
                      queue.offer(neighbor);
                  }
              }
          }

          if (foundEnd)
              break;
      }
  }

// Find all next level nodes.    
private ArrayList<String> getNeighbors(String node, Set<String> dict) {
  ArrayList<String> res = new ArrayList<String>();
  char chs[] = node.toCharArray();

  for (char ch ='a'; ch <= 'z'; ch++) {
      for (int i = 0; i < chs.length; i++) {
          if (chs[i] == ch) continue;
          char old_ch = chs[i];
          chs[i] = ch;
          if (dict.contains(String.valueOf(chs))) {
              res.add(String.valueOf(chs));
          }
          chs[i] = old_ch;
      }

  }
  return res;
}

// DFS: output all paths with the shortest distance.
private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
           solution.add(cur);
   if (end.equals(cur)) {
           res.add(new ArrayList<String>(solution));
       }
       else {
           for (String next : nodeNeighbors.get(cur)) {            
               if (distance.get(next) == distance.get(cur) + 1) {
                   dfs(next, end, dict, nodeNeighbors, distance, solution, res);
               }
            }
       }           
       solution.remove(solution.size() - 1);
   }
}
