package MyDropBookmarks.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static junit.framework.TestCase.assertTrue;

public class HelloResource2Test {

    @ClassRule
    public static final ResourceTestRule RULE = ResourceTestRule.builder().addResource(new HelloResource2()).build();

    @Test
    public void integrationTest() {
        String res = RULE.getJerseyTest().target("/hello2/result").request(MediaType.TEXT_PLAIN).get(String.class);
        assertTrue("Hello2!!!".equals(res));
    }

}
