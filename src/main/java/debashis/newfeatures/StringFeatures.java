package debashis.newfeatures;

import java.util.HashMap;

public class StringFeatures {
    public static void main(String[] args) {
        String test = "    valuesToTest   ";
        System.out.println(test.isBlank());
        System.out.println(test.strip());
        System.out.println(test.stripTrailing());
        System.out.println(test.stripLeading());
        System.out.println((String) "UPPER".transform(s->s.substring(2)));
        var map = new HashMap<String,String>();
        map.put("test","1234");
        for(var mv : map.entrySet()){
            System.out.println(mv.getKey());
        }
    }
}
