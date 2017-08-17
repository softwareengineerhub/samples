/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.my.app;

import java.util.Set;

/**
 *
 * @author prokopiukd
 */
public class Movie {

    private String name;
    private Set<String> genres;

    public Movie() {
    }
    
    

    public Movie(String name, Set<String> genres) {
        this.name = name;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }
    
    

    @Override
    public String toString() {
        return "Movie{" + "name=" + name + ", genres=" + genres + '}';
    }

}
