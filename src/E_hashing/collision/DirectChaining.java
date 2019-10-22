package E_hashing.collision;

import E_hashing.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class DirectChaining {
    LinkedList<Employee>[] table;
    public DirectChaining(int size){
        this.table = new LinkedList[size];
    }

    public void add(int hash, Employee employee){
        if(this.table[hash] == null) this.table[hash] = new LinkedList<>();
        this.table[hash].add(employee);
    }

    public Employee get(int hash, int key){
        ListIterator<Employee> listIterator = this.table[hash].listIterator(0);
        while (listIterator.hasNext()){
            Employee employee = listIterator.next();
            if(employee.getId() == key) return employee;
        }
        return null;
    }
}
