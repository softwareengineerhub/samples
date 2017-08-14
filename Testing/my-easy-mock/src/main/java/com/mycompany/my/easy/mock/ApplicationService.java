/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.easy.mock;

/**
 *
 * @author prokopiukd
 */
public class ApplicationService {

    private Collaborator collaborator;

    public void setListener(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public void addDocument(String title, String document) {
        collaborator.documentAdded(title);
    }
    
    public Collaborator getListener(){
        return collaborator;
    }
}
