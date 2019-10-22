package E_hashing.functions;

// in modulo function we mod key by largest prime number i.e less than table size
// why prime no? :- because prime number have less factors
public class ModuloFunction {
    private int modulo;

    public ModuloFunction(int tableSize){
        this.modulo = this.generateModulo(tableSize);
    }

    public int getHash(int key){
        return key % this.modulo;
    }

    private int generateModulo(int size){
        int modulo = -1;
        for(int i=size; i>=2; i--){
            boolean isPrime = true;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i % j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                modulo = i;
                break;
            }
        }
        if(modulo == -1) throw new RuntimeException("invalid table size");
        return modulo;
    }
}
