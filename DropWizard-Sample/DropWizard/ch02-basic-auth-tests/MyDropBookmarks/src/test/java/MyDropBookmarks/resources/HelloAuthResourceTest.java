package MyDropBookmarks.resources;

import MyDropBookmarks.auth.HelloAuthenticator;
import MyDropBookmarks.core.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

import static junit.framework.TestCase.assertTrue;

public class HelloAuthResourceTest {

    private static final String USERNAME = "denis";
    private static final HttpAuthenticationFeature FEATURE = HttpAuthenticationFeature.basic(USERNAME,"1");

    @ClassRule
    public static final ResourceTestRule RULE = ResourceTestRule.builder()
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .addResource(new HelloAuthResource())
            .addResource(
                    AuthFactory.binder(
                            new BasicAuthFactory<>(
                                    new HelloAuthenticator(),
                                    "SUPER SECRET STUFF",
                                    User.class)
                    )
            )
            .build();

    @BeforeClass
    public static void setUp(){
        RULE.getJerseyTest().client().register(FEATURE);
    }

    @Test
    public void integrationTest() {
        String res = RULE.getJerseyTest().target("/helloauth/a").request(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("res=" + res);
        assertTrue(("Hello-Auth!!!; user="+USERNAME).equals(res));
    }

}
