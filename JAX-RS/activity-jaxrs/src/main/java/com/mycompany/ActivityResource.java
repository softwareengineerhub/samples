/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.model.Activity;
import com.mycompany.model.User;
import com.mycompany.repository.ActivityRepository;
import com.mycompany.repository.ActivityRepositoryStub;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author Denis
 */
@Path(value = "activities")
public class ActivityResource {

    private ActivityRepository activityRepository = ActivityRepositoryStub.getInstance();

    @PUT
    @Path("activity-json/{activityId}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity updateActivity(@PathParam("activityId") String id, Activity activity) {
        User u = new User();
        u.setName("Default");
        activity.setUser(u);
        Activity old = activityRepository.findAllActivities().set(Integer.parseInt(id), activity);
        return old;
    }

    @POST
    @Path("activity-json")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        User u = new User();
        u.setName("Default");
        activity.setUser(u);
        activityRepository.add(activity);
        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
        String duration = formParams.get("duration").get(0);
        String description = formParams.get("description").get(0);
        Activity activity = new Activity();
        activity.setDescription(description);
        activity.setDuration(Integer.parseInt(duration));
        User u = new User();
        u.setName("Default");
        activity.setUser(u);
        activityRepository.add(activity);
        return activity;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}")
    public Activity getActivity(@PathParam("activityId") String id) {
        return activityRepository.findAllActivities().get(Integer.parseInt(id));
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}")
    public Activity deleteActivity(@PathParam("activityId") int id) {
        System.out.println("DELETE.id=" + id);
        return activityRepository.delete(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/response/{activityId}")
    public Response getActivityAsResponse(@PathParam("activityId") String id) {
        System.out.println("---------getActivityAsResponse-------id=" + id);
        if (id.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        List<Activity> list = activityRepository.findAllActivities();
        int idValue = Integer.parseInt(id);
        if (idValue > list.size() - 1) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Activity activity = list.get(idValue);
        System.out.println("@Before response");
        return Response.ok(activity, MediaType.APPLICATION_XML).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{activityId}/user")
    public User getUser(@PathParam("activityId") String id) {
        return activityRepository.findAllActivities().get(Integer.parseInt(id)).getUser();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/search")
    public List<Activity> searchByQueryParams(@QueryParam("ids") List<String> ids) {
        return activityRepository.search(ids);
    }
}
