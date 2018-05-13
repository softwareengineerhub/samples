/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.model.Activity;
import com.mycompany.model.User;
import java.net.URI;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.OK;
import javax.ws.rs.core.UriBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denis
 */
public class ActivityResourceTest {

    private Client client;
    private String SERVICE_PATH = "http://localhost:7001/activity-jaxrs/webresources";

    @Before
    public void init() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void workflowTest() {
        getAllActivities();
        getActivityById();
        getUserFromActivityById();
//getActivityAsResponseById();
        createActivityFromJSON();
        updateActivityById();
        deleteActivityById();
        search();
    }

    public void getActivityById() {
        Activity activity = client.target(SERVICE_PATH + "/activities/0").request().get(Activity.class);
        assertNotNull(activity);
        assertTrue(activity.getDescription().equalsIgnoreCase("Swimming"));
        assertTrue(activity.getDuration() == 40);
        String activityJSON = client.target(SERVICE_PATH + "/activities/0").request(MediaType.APPLICATION_JSON).get(String.class);
        String activityXML = client.target(SERVICE_PATH + "/activities/0").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println(activityJSON);
        System.out.println(activityXML);
    }

    public void getAllActivities() {
        List<Activity> activities = client.target(SERVICE_PATH + "/activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        assertTrue(activities.size() == 2);
    }

    public void getActivityAsResponseById() {
        Response response = client.target(SERVICE_PATH + "/activities/response/0").request().get();
        assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        response.readEntity(new GenericType<Activity>() {
        });
        //Activity  activity=(Activity) response.readEntity(Activity.class);
        /*assertNotNull(activity);
        assertTrue(activity.getDescription().equalsIgnoreCase("Swimming"));
        assertTrue(activity.getDuration() == 40);*/
    }

    public void createActivityFromJSON() {
        Activity activity = new Activity();
        activity.setDescription("D3");
        activity.setDuration(3);
        Activity createdActivity = client.target(SERVICE_PATH + "/activities/activity-json").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON), Activity.class);
        assertNotNull(createdActivity);
        assertTrue("D3".equalsIgnoreCase(createdActivity.getDescription()));
        assertTrue(createdActivity.getDuration() == 3);
        List<Activity> activities = client.target(SERVICE_PATH + "/activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        assertTrue(activities.size() == 3);
    }

    public void getUserFromActivityById() {
        Activity activity = new Activity();
        activity.setDescription("d1");
        activity.setDuration(1);
        User user = client.target(SERVICE_PATH + "/activities/0/user").request(MediaType.APPLICATION_JSON).get(User.class);
        assertTrue("User".equalsIgnoreCase(user.getName()));
    }

    public void updateActivityById() {
        Activity activity = new Activity();
        activity.setDescription("Update");
        activity.setDuration(11);
        Activity oldActivity = client.target(SERVICE_PATH + "/activities/activity-json/2").request(MediaType.APPLICATION_JSON).put(Entity.entity(activity, MediaType.APPLICATION_JSON), Activity.class);
        assertTrue("D3".equalsIgnoreCase(oldActivity.getDescription()));
        assertTrue(3 == oldActivity.getDuration());
        Activity currentActivity = client.target(SERVICE_PATH + "/activities/2").request().get(Activity.class);
        assertNotNull(currentActivity);
        assertTrue(currentActivity.getDescription().equalsIgnoreCase("Update"));
        assertTrue(currentActivity.getDuration() == 11);
    }

    private void deleteActivityById() {
        Response response = client.target(SERVICE_PATH + "/activities/2").request(MediaType.APPLICATION_JSON).delete();
        assertTrue(response.getStatus() == OK.getStatusCode());
        List<Activity> activities = client.target(SERVICE_PATH + "/activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        assertTrue(activities.size() == 2);
    }

    private void search() {
        URI uri = UriBuilder.fromUri(SERVICE_PATH+"/activities/search").queryParam("ids", "1").queryParam("ids", "0").queryParam("ids", "3").build();
        WebTarget webTarget = client.target(uri);
        List<Activity> result = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        assertTrue(result.size() == 2);
    }
}
