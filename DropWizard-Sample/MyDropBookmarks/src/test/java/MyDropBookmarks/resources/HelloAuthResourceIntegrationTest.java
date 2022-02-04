package MyDropBookmarks.resources;

import MyDropBookmarks.MyDropBookmarksApplication;
import MyDropBookmarks.MyDropBookmarksConfiguration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertTrue;

public class HelloAuthResourceIntegrationTest {

    private static final String CONFIG_PATH = "config.yml";

    @ClassRule
    public static final DropwizardAppRule<MyDropBookmarksConfiguration> RULE = new DropwizardAppRule<>(MyDropBookmarksApplication.class, CONFIG_PATH);

    private static final String TARGET = "http://localhost:8085";

    private static final String PATH = "/helloauth/a";

    private Client client;

    private static final HttpAuthenticationFeature FEATURE = HttpAuthenticationFeature.basic("denis", "11");

    @Before
    public void setUp(){
        client = ClientBuilder.newClient();
    }

    @Test
    public void testSadPath() {
        Response response = client.target(TARGET).path(PATH).request(MediaType.TEXT_PLAIN).get();
        assertTrue(response.getStatus()==Response.Status.UNAUTHORIZED.getStatusCode());
    }

    @Test
    public void testHappyPath() {
        client.register(FEATURE);
        Response response = client.target(TARGET).path(PATH).request().get();
        assertTrue(response.getStatus()==Response.Status.OK.getStatusCode());
    }

    @After
    public void tearDown(){
        client.close();
    }
}
