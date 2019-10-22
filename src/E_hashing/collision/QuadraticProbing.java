package E_hashing.collision;

import E_hashing.Employee;

public class QuadraticProbing {
    Employee[] table;

    public QuadraticProbing(int tableSize){
        this.table = new Employee[tableSize];
    }

    public Employee get(int hash, int key){
        int couter = 0;
        int square = 1;
        while (couter < this.table.length && this.table[hash] != null && this.table[hash].getId() != key){
            if(hash >= this.table.length) hash=0;
            hash = hash + (int) Math.pow(square, 2);
            square++;
            couter++;
        }
        if(couter>=this.table.length) return null;
        return this.table[hash];
    }

    public void add(int hash, Employee employee){
        int couter = 0;
        int square = 1;
        while (couter<this.table.length && this.table[hash]!=null){
            if(hash >= this.table.length) hash=0;
            hash = hash + (int) Math.pow(square, 2);
            square++;
            couter++;
        }
        if(couter >= this.table.length) throw new RuntimeException("hash Overflow");
        this.table[hash] = employee;
    }

    public Employee delete(int hash, int key){
        Employee employee = this.get(hash, key);
        if(employee == null) throw new RuntimeException("employee not found");
        Employee deletedEmployee = new Employee(employee.getId(), employee.getName());
        employee.setId(-1);
        return deletedEmployee;
    }
}
