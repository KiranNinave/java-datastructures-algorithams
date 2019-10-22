package E_hashing.functions;

import java.util.Random;

// in midsquare function we take square of key then pickup any part of square that has width same as table width
public class MidsqureFunction {
    private int tableSize;
    public MidsqureFunction(int tableSize){
        this.tableSize = tableSize;
    }

    private int getWidth(){
        Random r = new Random();
        return r.nextInt(String.valueOf(this.tableSize).length()-2)+2;
    }

    public int getHash(int key){
        int square = (int)Math.pow(key, 2);
        int maxWidth = 2;
        String hashString = String.valueOf(square);
        int hash = square;
        if(hashString.length() > maxWidth){
            hash = Integer.valueOf(hashString.substring(0, maxWidth));
        }
        return hash;
    }
}
