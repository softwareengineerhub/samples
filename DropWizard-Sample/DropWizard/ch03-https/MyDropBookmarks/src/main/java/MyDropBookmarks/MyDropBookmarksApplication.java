package MyDropBookmarks;

import MyDropBookmarks.auth.HelloAuthenticator;
import MyDropBookmarks.core.User;
import MyDropBookmarks.resources.HelloAuthResource;
import MyDropBookmarks.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyDropBookmarksApplication extends Application<MyDropBookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MyDropBookmarksApplication().run(args);
    }

    @Override
    public String getName() {
        return "MyDropBookmarks";
    }

    @Override
    public void initialize(final Bootstrap<MyDropBookmarksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MyDropBookmarksConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application



        environment.jersey().register(HelloResource.class);
        environment.jersey().register(HelloAuthResource.class);

        String configPassword = configuration.getPassword();
        environment.jersey().register(
                AuthFactory.binder(
                        new BasicAuthFactory<>(
                                new HelloAuthenticator(configPassword),
                                "SUPER SECRET STUFF",
                                User.class)
                )
        );


    }

}
