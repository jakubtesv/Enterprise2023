package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.User;


public interface UserDAO {
    User getUser(String username);

    public void saveUser(User user);
}
