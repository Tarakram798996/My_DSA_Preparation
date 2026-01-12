package Hashing;
import java.util.*;

public class FindWordsThatCanBeFormedByCharacters {
    public static Map<Character,Integer> map;
    public static int countCharacters(String[] words, String chars) {
        map = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            char ch = chars.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int res=0;
        for(String s : words){
            if(s.length()<=chars.length() && check(s)){
                res+=s.length();
            }
        }
        return res;
    }
    public static boolean check(String s){
        Map<Character,Integer> minMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int val=minMap.getOrDefault(ch,0)+1;
            if(!map.containsKey(ch) || val>map.get(ch)) return false;
            minMap.put(ch,val);
        }
        return true;
    }

    public static void main(String[] args) {
        int res = countCharacters(new String[]{"tarak","ram","bob"},"btarkmbra");
        System.out.println(res);
    }
}
