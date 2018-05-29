package box;
//== only works for numbers between -128 and 127
public class Lon {
    public static void main(String[] args) {
        Long i1 = 128L;
        Long i2 = 128L;
        System.out.println(i1==i2);

        Long i3 = 127L;
        Long i4 = 127L;
        System.out.println(i3==i4);
    }
}
