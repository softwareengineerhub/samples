/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author prokopiukd
 */
public class CityCache {

    private static Map<String, City> cityMap = new HashMap();

    public static void loadCache() {
        CityA a = new CityA();
        a.setCountry("A");
        a.setName("AA");

        CityB b = new CityB();
        b.setCountry("B");
        b.setName("BB");

        CityC c = new CityC();
        c.setCountry("C");
        c.setName("CC");

        cityMap.put("a", a);
        cityMap.put("b", b);
        cityMap.put("c", c);
    }

    public static City getCity(String cityId) {
        City cachedCity = cityMap.get(cityId);
        return (City) cachedCity.clone();
    }

}
