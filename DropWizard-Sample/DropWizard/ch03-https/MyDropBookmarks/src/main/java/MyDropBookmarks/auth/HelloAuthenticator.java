package MyDropBookmarks.auth;

import MyDropBookmarks.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

public class HelloAuthenticator implements Authenticator<BasicCredentials, User> {
    private String configPassword;

    public HelloAuthenticator(String configPassword) {
        this.configPassword = configPassword;
    }

    @Override
    public com.google.common.base.Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        System.out.println("@@@@@@@@@@@@HelloAuthenticator.checker!!!!");
        String username = basicCredentials.getUsername();
        String password = basicCredentials.getPassword();
        System.out.println("username="+username);
        System.out.println("username="+password);

        if(configPassword.equals(basicCredentials.getPassword())){
            System.out.println("Success");
            return com.google.common.base.Optional.of(new User(username));
        }
        return com.google.common.base.Optional.absent();
    }
}
