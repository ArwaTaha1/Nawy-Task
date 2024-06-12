
import java.util.*;
public class test {
	
	public static ArrayList<String> transformDateFormat(String [] dates) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i =0;i<dates.length;i++) {
			String date = dates[i];
			if (dates[i].length()<10) 
				continue;
			if (date.charAt(4)=='/' || date.charAt(4)=='-') {
				if (Integer.parseInt(date.substring(5,7))>12) {
					String s = date.substring(0,4) + date.substring(8) + date.substring(5,7);
					result.add(s);	
				}
				else {
					String s = date.substring(0,4)  + date.substring(5,7) + date.substring(8);
					result.add(s);
				}
			}
			else {
				if (Integer.parseInt(date.substring(0,2))>12) {
					String s = date.substring(6) + date.substring(3,5) + date.substring(0,2);
					result.add(s);	
				}
				else {
					String s = date.substring(6) + date.substring(0,2) + date.substring(3,5);
					result.add(s);
				}
				
			}
			
		}
		return result;
	}
	
	
	public static boolean isValid(String s) {
		if (s.length()%2==1)
			return false;
		Hashtable <Character,Character> h = new Hashtable<Character,Character> ();
		h.put('(', ')');
		h.put('[', ']');
		h.put('{', '}');
		Stack <Character> stack = new Stack<Character>();
		for (int i =0;i<s.length();i++) {
			char tmp = s.charAt(i);
			if (!h.containsKey(tmp)&&!h.containsValue(tmp))
				return false;
			if (h.containsKey(tmp)) { //{{{()[]}}}
				stack.push(tmp);
			}
			if (h.containsValue(tmp)&& h.get(stack.peek())==tmp) {
				stack.pop();
			}
				
		}
		return stack.isEmpty();
	}
	
}
