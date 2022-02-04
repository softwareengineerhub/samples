package com.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyWizardApplication extends Application<MyWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MyWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "MyWizard-app01";
    }

    @Override
    public void initialize(final Bootstrap<MyWizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MyWizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        System.out.println("Hello!!!");
    }

}
