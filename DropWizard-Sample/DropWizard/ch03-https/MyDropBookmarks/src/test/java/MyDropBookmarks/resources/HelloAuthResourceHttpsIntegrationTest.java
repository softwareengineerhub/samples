package MyDropBookmarks.resources;

import MyDropBookmarks.MyDropBookmarksApplication;
import MyDropBookmarks.MyDropBookmarksConfiguration;
import ch.qos.logback.core.net.ssl.SSLConfiguration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.grizzly.ssl.SSLContextConfigurator;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.TestCase.assertTrue;

public class HelloAuthResourceHttpsIntegrationTest {

    private static final String CONFIG_PATH = "config.yml";

    @ClassRule
    public static final DropwizardAppRule<MyDropBookmarksConfiguration> RULE = new DropwizardAppRule<>(MyDropBookmarksApplication.class, CONFIG_PATH);

    private static final String TARGET = "https://localhost:8443";

    private static final String PATH = "/helloauth/a";

    private static final String TRUST_STORE_FILE_NAME = "dropbookmarks.keystore";

    private static final String TRUST_STORE_PASSWORD = "11111111";

    private Client client;

    private static final HttpAuthenticationFeature FEATURE = HttpAuthenticationFeature.basic("denis", "11");

    @Before
    public void setUp(){
        SslConfigurator sslConfigurator = SslConfigurator.newInstance();
        sslConfigurator.trustStoreFile(TRUST_STORE_FILE_NAME);
        sslConfigurator.trustStorePassword(TRUST_STORE_PASSWORD);
        SSLContext context = sslConfigurator.createSSLContext();
        client = ClientBuilder.newBuilder().sslContext(context).build();
    }

    @Test
    public void testSadPath() {
        Response response = client.target(TARGET).path(PATH).request().get();
        assertTrue(response.getStatus()==Response.Status.UNAUTHORIZED.getStatusCode());
    }

    @Test
    public void testHappyPath() {
        client.register(FEATURE);
        Response response = client.target(TARGET).path(PATH).request(MediaType.TEXT_PLAIN).get();
        assertTrue(response.getStatus()==Response.Status.OK.getStatusCode());
    }

    @After
    public void tearDown(){
        client.close();
    }
}
