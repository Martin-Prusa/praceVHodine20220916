package cz.martin.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class UsersService {
    private UsersRepository service = new UsersRepository();
    private List<User> users = service.load();

    public Map<String, List<User>> getUsersByShell() {
         return users.stream().collect(groupingBy(User::getLoginShell));
    }

    public List<User> getSystemUsers() {
        return users.stream().filter(i -> i.getUserId() < 1000).toList();
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
