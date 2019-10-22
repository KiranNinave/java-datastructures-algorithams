package E_hashing.functions;

import java.util.Random;

public class FoddingFunction {
    private int tableSize;

    public FoddingFunction(int tableSize){
        this.tableSize = tableSize;
    }

    private int getWidth(){
        Random r = new Random();
        return r.nextInt(String.valueOf(this.tableSize).length()-2)+2;
    }

    public int getHash(int key){
        int width = 2;
        int sum = 0;
        int couter = 0;
        int temp[] = new int[10];
        while (key!=0){
            int rem = key%10;
            sum = sum*10 + rem;
            if(String.valueOf(sum).length() == width || key / 10 == 0){
                temp[couter++] = sum;
                sum = 0;
            }
            key = key/10;
        }
        sum = 0;
        while (couter>=0) sum += temp[couter--];
        if(sum >= tableSize) {
            return getHash(sum);
        }
        return sum;
    }
}
