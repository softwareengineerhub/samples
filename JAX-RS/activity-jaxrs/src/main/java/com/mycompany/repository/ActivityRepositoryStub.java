/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repository;

import com.mycompany.model.Activity;
import com.mycompany.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class ActivityRepositoryStub implements ActivityRepository {

    private List<Activity> list = new ArrayList<>();
    private static final ActivityRepositoryStub instance = new ActivityRepositoryStub();

    public ActivityRepositoryStub() {
        Activity activity = new Activity();
        activity.setDescription("Swimming");
        activity.setDuration(40);
        User user = new User();
        user.setName("User");
        activity.setUser(user);
        list.add(activity);
        Activity activity1 = new Activity();
        activity1.setDescription("Cycling");
        activity1.setDuration(120);
        User user1 = new User();
        user1.setName("User2");
        activity1.setUser(user1);
        list.add(activity1);
    }

    @Override
    public List<Activity> findAllActivities() {
        return list;
    }

    @Override
    public void add(Activity activity) {
        list.add(activity);
    }

    @Override
    public Activity delete(int id) {
        return list.remove(id);
    }

    public static ActivityRepositoryStub getInstance() {
        return instance;
    }

    @Override
    public List<Activity> search(List<String> ids) {
        List<Activity> result = new ArrayList();
        for(String id: ids){
            int index = Integer.parseInt(id);
            if(index<list.size()){
                result.add(list.get(index));
            }
        }
        return result;
    }

}
