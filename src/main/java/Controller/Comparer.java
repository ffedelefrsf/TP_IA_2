package Controller;
import java.util.TreeMap;
import javafx.util.Pair;

public class Comparer {
    private static TreeMap<String,TreeMap<String,Integer>> dp;
    
    public static int match(String a,String b)
    {
        dp=new TreeMap();
        a=a.toUpperCase();
        b=b.toUpperCase();
        return recursiveMatch(a,b);
    }
    
    private static int recursiveMatch(String a,String b)
    {
        if(dp.containsKey(a) && dp.get(a).containsKey(b)) return dp.get(a).get(b);
        int posa=0,posb=0,dif=0,aux1,aux2,aux3;
        while(posa<a.length() && posb<b.length())
        {
            
            if(a.charAt(posa)!=b.charAt(posb))
            {
                aux1=recursiveMatch(a.substring(posa),b.substring(posb+1));
                aux2=recursiveMatch(a.substring(posa+1),b.substring(posb));
                aux3=recursiveMatch(a.substring(posa+1),b.substring(posb+1));
                posa=a.length()-1;
                posb=b.length()-1;
                dif=1+Math.min(aux1, Math.min(aux2,aux3));
            }
            posa++;
            posb++;
        }
        dif+=(a.length()-posa) + (b.length() - posb);
        if(!dp.containsKey(a)) dp.put(a,new TreeMap());
        dp.get(a).put(b, dif);
        return dif;
    }
    
}
