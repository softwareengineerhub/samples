package DropBookmarks.health;

import com.codahale.metrics.health.HealthCheck;

public class MyHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        System.out.println("!!!!!Healthcheck");
        return Result.healthy();
    }
}
