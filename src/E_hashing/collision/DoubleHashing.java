package E_hashing.collision;

import E_hashing.Employee;
import E_hashing.functions.FoddingFunction;

public class DoubleHashing {
    private Employee[] table;
    private FoddingFunction  foddingFunction;
    public DoubleHashing(int tableSize){
        this.table = new Employee[tableSize];
        foddingFunction = new FoddingFunction(tableSize);
    }

    public void add(int hash, Employee employee){
        int couter = 0;
        while (couter<this.table.length && this.table[hash]!=null){
            hash = foddingFunction.getHash(hash);
            couter++;
        }
        if(couter >= this.table.length) throw new RuntimeException("hash Overflow");
        this.table[hash] = employee;
    }

    public Employee get(int hash, int key){
        int couter = 0;
        while (couter < this.table.length && this.table[hash] != null && this.table[hash].getId() != key){
            hash = foddingFunction.getHash(hash);
            couter++;
        }
        if(couter>=this.table.length) return null;
        return this.table[hash];
    }

    public Employee delete(int hash, int key){
        Employee employee = this.get(hash, key);
        if(employee == null) throw new RuntimeException("data not found");
        Employee deletedEmployee = new Employee(employee.getId(), employee.getName());
        employee.setId(-1);
        return  deletedEmployee;
    }
}
