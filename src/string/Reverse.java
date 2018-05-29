package string;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse("annasarp".toCharArray()));
    }
    public static String reverse(char[] word){
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            char t = word[i1];
            word[i1] = word[i2];
            word[i2]=t;
            ++i1;
            --i2;
        }
        return new String(word);
    }
}
