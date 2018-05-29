import box.Int;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        int[] i = {7,1,2,3,4,5,6,7,8};
       // howManySum(i,9);


        Function<Integer,Integer> square = (a)->a*a;
        Function<Integer,Integer> twice = (a)->2*a;
        Consumer<Integer> consumer= (a)->{a = a*2;};
        Supplier<Integer> supplier = ()->5;
        consumer.andThen(System.out::print).accept(supplier.get());




        ;
        //System.out.print(twice.andThen(square).compose(twice).apply(5));

    }

    static int howManySum(int[] numbers, int target) {
        int howManySum = 0;
        List<Integer> nums = new ArrayList();
        for(int k : numbers){
            nums.add(k);
        }
        Collections.sort(nums);



        for(int i =0; i<nums.size(); i++){
            int sum = nums.get(i);
            if(target == sum){
                howManySum ++;
                continue;
            }
            for(int j = i+1 ; j<nums.size(); j++){
                sum += nums.get(j);
                if(target == sum){
                    howManySum ++;
                }else if (target < sum){
                    break;
                }
            }
        }
        return howManySum;
    }

}
