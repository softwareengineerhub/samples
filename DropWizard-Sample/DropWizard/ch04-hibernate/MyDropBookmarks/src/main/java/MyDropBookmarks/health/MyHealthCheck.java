package MyDropBookmarks.health;

import com.codahale.metrics.health.HealthCheck;

public class MyHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
