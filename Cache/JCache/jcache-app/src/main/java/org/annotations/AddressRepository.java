/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.annotations;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Denis
 */
public class AddressRepository {

    private Map<Integer, Address> data = new HashMap();

    public void add(int id, Address address) {
        System.out.println("Put to Repository");
        data.put(id, address);
    }

    public void remove(int id) {
        System.out.println("Remove from Repository");
        data.remove(id);
    }

    public Address get(int id) {
        System.out.println("Get from Repository");
        return data.get(id);
    }

    public void clear() {
        System.out.println("Remove all from Repository");
        data.clear();
    }

    public Map<Integer, Address> getData() {
        return data;
    }

}
