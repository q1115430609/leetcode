package com.ssx.leetcode.F690;

import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class Solution {

    public int getImportance(List<Employee> employees, int id) {
        for(Employee e:employees){
            if(e.id == id){
                if(e.subordinates.size() == 0){
                    return e.importance;
                }
                for(int sid:e.subordinates){
                    e.importance += getImportance(employees,sid);
                }
            }
        }
        return 0;
    }
}
