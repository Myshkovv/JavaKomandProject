package service;

import user.Client;
import user.Driver;
import user.User;

public interface DeleteObjectService {
    void deleteUser(int deleteId);
    void deleteDriverFromArray(Driver driver);
    void deleteClientFromArray(Client client);
    void deleteUserStory(User user);
    void clearUserRides(int userId);
}
