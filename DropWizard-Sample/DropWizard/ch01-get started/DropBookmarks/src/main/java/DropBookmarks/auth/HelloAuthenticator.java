package DropBookmarks.auth;

import DropBookmarks.core.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

public class HelloAuthenticator implements Authenticator<BasicCredentials, User> {

    //@Override
    public Optional<User> authenticate2(BasicCredentials basicCredentials) throws AuthenticationException {
        if("1".equals(basicCredentials.getPassword())){
            return Optional.of(new User());
        }
        return Optional.empty();
    }

    @Override
    public com.google.common.base.Optional<User> authenticate(BasicCredentials basicCredentials) throws AuthenticationException {
        if("1".equals(basicCredentials.getPassword())){
            return com.google.common.base.Optional.of(new User());
        }
        return com.google.common.base.Optional.absent();
    }
}
