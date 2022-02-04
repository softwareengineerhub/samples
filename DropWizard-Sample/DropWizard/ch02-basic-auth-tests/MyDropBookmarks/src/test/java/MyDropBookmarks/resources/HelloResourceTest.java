package MyDropBookmarks.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static junit.framework.TestCase.assertTrue;

public class HelloResourceTest {

    @ClassRule
    public static final ResourceTestRule RULE = ResourceTestRule.builder().addResource(new HelloResource()).build();

    @Test
    public void integrationTest() {
        String res = RULE.getJerseyTest().target("/hello").request(MediaType.TEXT_PLAIN).get(String.class);
        assertTrue("Hello!!!".equals(res));
    }

    @Test
    public void test() {
        HelloResource helloResource = new HelloResource();
        String res = helloResource.getGreeting();
        assertTrue("Hello!!!".equals(res));
    }
}
