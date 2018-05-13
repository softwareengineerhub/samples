/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.model.Activity;
import java.util.List;

/**
 *
 * @author Denis
 */
public interface ActivityRepository {

    public List<Activity> findAllActivities();
    
    public void add(Activity activity);
    
    public Activity delete(int id);
    
    public List<Activity> search(List<String> ids); 
}
