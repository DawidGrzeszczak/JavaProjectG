package com.kainos.ea;

import com.kainos.ea.controller.FinanceMember;
import com.kainos.ea.controller.HR;
import com.kainos.ea.controller.Manager;
import com.kainos.ea.controller.TalentManager;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class trueApplication extends Application<trueConfiguration> {

    public static void main(final String[] args) throws Exception {
        new trueApplication().run(args);
    }

    @Override
    public String getName() {
        return "true";
    }

    @Override
    public void initialize(final Bootstrap<trueConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<trueConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(trueConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final trueConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HR());
        environment.jersey().register(new FinanceMember());
        environment.jersey().register(new Manager());
        environment.jersey().register(new TalentManager());
    }
}
