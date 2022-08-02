package debashis.array;

public class MetaString {

    public static void main(String[] args){
        String str1 = "geeks";
        String str2 = "geegs";
        MetaString metaString = new MetaString();
        System.out.println(metaString.checkMetaString(str1,str2));
    }

    private boolean checkMetaString(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        char str1Char=' ',str2Char= ' ';
        boolean foundChar = false;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) == str2.charAt(i)){
                continue;
            }else{
                if(foundChar == false){
                    str1Char = str1.charAt(i);
                    str2Char = str2.charAt(i);
                    foundChar = true;
                }else{
                    if(str1Char == str2.charAt(i) && str2Char == str1.charAt(i)){
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
