package E_hashing;

import E_hashing.collision.DirectChaining;
import E_hashing.collision.DoubleHashing;
import E_hashing.collision.LinearProbing;
import E_hashing.collision.QuadraticProbing;
import E_hashing.functions.FoddingFunction;
import E_hashing.functions.MidsqureFunction;
import E_hashing.functions.ModuloFunction;

public class MyHashtable {

    private String hashFunctionMethod;
    private String collisionResolutionTechnique;

    public static final String MODULO_FUNCTION = "MODULO_FUNCTION";
    public static final String MIDSQUARE_FUNCTION = "MIDSQUARE_FUNCTION";
    public static final String FODDING_FUNCTION = "FODDING_FUNCTION";

    public static final String DIRECT_CHANING = "DIRECT_CHANING";
    public static final String LINEAR_PROBING = "LINEAR_PROBING";
    public static final String QUADRATIC_PROBING = "QUADRATIC_PROBING";
    public static final String DOUBLE_HASHING = "DOUBLE_HASHING";

    // functions
    ModuloFunction moduloFunction;
    MidsqureFunction midsqureFunction;
    FoddingFunction foddingFunction;

    // collision
    LinearProbing linearProbing;
    QuadraticProbing quadraticProbing;
    DoubleHashing doubleHashing;
    DirectChaining directChaining;

    public MyHashtable(int size, String hashFunctionMethod, String collisionResolutionTechnique){
        if(hashFunctionMethod == MODULO_FUNCTION){
            this.moduloFunction = new ModuloFunction(size);
            this.hashFunctionMethod = hashFunctionMethod;
        }
        else if(hashFunctionMethod == MIDSQUARE_FUNCTION){
            this.midsqureFunction = new MidsqureFunction(size);
            this.hashFunctionMethod = hashFunctionMethod;
        }
        else if(hashFunctionMethod == FODDING_FUNCTION){
            this.foddingFunction = new FoddingFunction(size);
            this.hashFunctionMethod = hashFunctionMethod;
        }
        else {
            throw new RuntimeException("Invalid hash function");
        }

        if(collisionResolutionTechnique == LINEAR_PROBING){
            this.linearProbing = new LinearProbing(size);
            this.collisionResolutionTechnique = collisionResolutionTechnique;
        }
        else if(collisionResolutionTechnique == QUADRATIC_PROBING){
            this.quadraticProbing = new QuadraticProbing(size);
            this.collisionResolutionTechnique = collisionResolutionTechnique;
        }
        else if(collisionResolutionTechnique == DOUBLE_HASHING){
            this.doubleHashing = new DoubleHashing(size);
            this.collisionResolutionTechnique = collisionResolutionTechnique;
        }
        else if(collisionResolutionTechnique == DIRECT_CHANING){
            this.directChaining = new DirectChaining(size);
            this.collisionResolutionTechnique = collisionResolutionTechnique;
        }
        else{
            throw new RuntimeException("Invalid collision resolution technique");
        }
    }

    public int getHash(int key){
        if(this.hashFunctionMethod == MODULO_FUNCTION){
            return this.moduloFunction.getHash(key);
        }
        else if(this.hashFunctionMethod == MIDSQUARE_FUNCTION){
            return this.midsqureFunction.getHash(key);
        }
        else if(this.hashFunctionMethod == FODDING_FUNCTION){
            return this.foddingFunction.getHash(key);
        }
        else {
            throw new RuntimeException("invalid hash function");
        }
    }

    public void add(Employee employee){
        if(this.collisionResolutionTechnique == LINEAR_PROBING){
            this.linearProbing.add(this.getHash(employee.getId()), employee);
        }
        else if(this.collisionResolutionTechnique == QUADRATIC_PROBING){
            this.quadraticProbing.add(this.getHash(employee.getId()), employee);
        }
        else if(this.collisionResolutionTechnique == DOUBLE_HASHING){
            int hash = this.getHash(employee.getId());
            this.doubleHashing.add(hash, employee);
        }
        else if(this.collisionResolutionTechnique == DIRECT_CHANING){
            this.directChaining.add(this.getHash(employee.getId()), employee);
        }
        else {
            throw new RuntimeException("invalid collision resolution technique");
        }
    }

    public Employee get(int key){
        if(this.collisionResolutionTechnique == LINEAR_PROBING){
            return this.linearProbing.get(this.getHash(key), key);
        }
        else if(this.collisionResolutionTechnique == QUADRATIC_PROBING){
            return this.quadraticProbing.get(this.getHash(key), key);
        }
        else if(this.collisionResolutionTechnique == DOUBLE_HASHING){
            return this.doubleHashing.get(this.getHash(key), key);
        }
        else if(this.collisionResolutionTechnique == DIRECT_CHANING){
            return this.directChaining.get(this.getHash(key), key);
        }
        else{
            throw new RuntimeException("invalid collission resolution technique");
        }
    }

    public Employee delete(int key){
        if(this.collisionResolutionTechnique == LINEAR_PROBING){
            return this.linearProbing.deleteLinearProbing(this.getHash(key), key);
        }
        else if(this.collisionResolutionTechnique == QUADRATIC_PROBING){
            return this.quadraticProbing.delete(this.getHash(key), key);
        }
        else if(this.collisionResolutionTechnique == DOUBLE_HASHING){
            return this.doubleHashing.delete(this.getHash(key), key);
        }
        else {
            throw new RuntimeException("invalid collission resolution technique");
        }
    }






    public static void main(String[] args) {
        // this hashtable uses modulo function and linear probing
//        System.out.println("----------------modulo and linear probing ---------------");
//        MyHashtable myHashtable1 = new MyHashtable(100, MyHashtable.MODULO_FUNCTION, MyHashtable.LINEAR_PROBING);
//        myHashtable1.add(new Employee(1000, "abc"));
//        myHashtable1.add(new Employee(1970, "pqr"));
//        System.out.println(myHashtable1.get(1000));
//        System.out.println(myHashtable1.get(1970));
//        System.out.println(myHashtable1.delete(1000));
//        System.out.println(myHashtable1.get(1000));
//        System.out.println(myHashtable1.get(1970));
//        System.out.println("----------------modulo and linear probing ---------------");
//
//        System.out.println();
//        System.out.println();

//        System.out.println("----------------midsquare and quadratic probing ---------------");
//        MyHashtable myHashtable2 = new MyHashtable(100, MyHashtable.MIDSQUARE_FUNCTION, MyHashtable.QUADRATIC_PROBING);
//        myHashtable2.add(new Employee(10, "abc"));
//        myHashtable2.add(new Employee(100, "pqr"));
//        System.out.println(myHashtable2.get(10));
//        System.out.println(myHashtable2.get(100));
//        System.out.println(myHashtable2.delete(100));
//        System.out.println(myHashtable2.get(100));
//
//        System.out.println("----------------midsquare and quadratic probing ---------------");

//        System.out.println("----------------fodding and double hashing ---------------");
//        MyHashtable myHashtable = new MyHashtable(100, MyHashtable.FODDING_FUNCTION, MyHashtable.DOUBLE_HASHING);
//        myHashtable.add(new Employee(1020, "abc"));
//        myHashtable.add(new Employee(9999, "pqr"));
//        System.out.println(myHashtable.get(1020));
//        System.out.println(myHashtable.get(9999));
//        System.out.println(myHashtable.delete(1020));
//        System.out.println(myHashtable.get(1020));
//
//        System.out.println("----------------fodding and double hashing ---------------");

        System.out.println("----------------modulo function and direct chaining ---------------");
        MyHashtable myHashtable = new MyHashtable(100, MyHashtable.MODULO_FUNCTION, MyHashtable.DIRECT_CHANING);
        myHashtable.add(new Employee(1000, "abc"));
        System.out.println(myHashtable.get(1000));
        System.out.println("----------------modulo function and direct chaining ---------------");
    }

}
