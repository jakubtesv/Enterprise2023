package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.User;

public interface UserService {

    User getUser(String username);
    public void saveUser(User user);
}