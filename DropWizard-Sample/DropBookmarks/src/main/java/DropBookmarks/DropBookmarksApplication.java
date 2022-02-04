package DropBookmarks;

import DropBookmarks.resources.HelloAuthResource;
import DropBookmarks.resources.HelloResource;
import DropBookmarks.resources.MyRootResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropBookmarksApplication extends Application<DropBookmarksConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropBookmarksApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropBookmarks";
    }

    @Override
    public void initialize(final Bootstrap<DropBookmarksConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropBookmarksConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(HelloResource.class);
        environment.jersey().register(MyRootResource.class);
        //environment.jersey().register(HelloAuthResource.class);

       // BasicAuthFactory<String> basicAuthFactory = new BasicAuthFactory(new HelloAuthenticator(), "SUPER SECRET STUFF", String.class);
       // environment.jersey().register(AuthFactory.binder(basicAuthFactory));

    }

}
