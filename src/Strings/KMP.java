public class KMP {
    static int[] lps;
    public static void LPS(String s){
        int len=0;
        int i=1;
        lps[0]=0;
        while(i<lps.length){
            if(s.charAt(i)==s.charAt(len))
                lps[i++]=++len;
            else{
                if(len!=0)
                    len=lps[len-1];
                else
                    lps[i++]=0;
            }
        }
    }
    public static void kmpSearch(String text,String pattern){
        int n=text.length();
        int m=pattern.length();
        lps=new int[m];
        LPS(pattern);

        int i=0,j=0;

        while(i<n){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }

            if(j==m){
                System.out.println("String found !! at index :: "+ (i-j));
                j=lps[j-1];
            }else if(i<n && text.charAt(i)!=pattern.charAt(j)){
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
    }
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        kmpSearch(text, pattern);
    }
}
