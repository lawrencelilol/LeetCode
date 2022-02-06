import java.util.*;

public class Flights {
    public static void main(String[] args) {
        Flights f = new Flights();
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        List<String> c = new ArrayList<>();
        List<String> d = new ArrayList<>();
        a.add(0,"MUC");
        a.add(1,"LHR");
        b.add(0,"JFK");
        b.add(1,"MUC");
        c.add(0,"SFO");
        c.add(1,"SJC");
        d.add(0,"LHR");
        d.add(1,"SFO");

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(0,a);
        tickets.add(1,b);
        tickets.add(2,c);
        tickets.add(3,d);
        System.out.println(tickets);
        System.out.println(f.findItinerary(tickets));
    }

    Map<String, Map<String,Integer>> targets;
    Deque<String> res;

    boolean helper(int ticketNum) {
        if(res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast();
        if(targets.containsKey(last)) {
            for(Map.Entry<String,Integer> target: targets.get(last).entrySet()) {
                int count = target.getValue();
                if(count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(helper(ticketNum)) {
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        targets = new HashMap<String, Map<String,Integer>>();
        res = new LinkedList<>();
        for(List<String> t: tickets) {
            Map<String, Integer> temp;
            if(targets.containsKey(t.get(0))) {
                temp = targets.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1),0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
            }
            targets.put(t.get(0),temp);
        }
        res.add("JFK");
        helper(tickets.size());
        return new ArrayList<>(res);
    }

}
