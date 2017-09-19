/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structural.adaptor;

/**
 *
 * @author prokopiukd
 */
public class EmployeeAdaptor {

    private String name;
    private int age;

    public EmployeeAdaptor(LegacyEmployee legacyEmployee) {
        name = legacyEmployee.getName();
        age = Integer.parseInt(legacyEmployee.getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
