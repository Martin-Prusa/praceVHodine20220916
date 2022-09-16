package cz.martin.users;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        UsersService service = new UsersService();

        for (User user : service.getUsers()) {
            System.out.println(user.getUsername());
            System.out.println("\t userId: "+user.getUserId());
            System.out.println("\t groupId: "+user.getGroupId());
            System.out.println("\t home: "+user.getHomeDirectory());
            System.out.println("\t shell: "+user.getLoginShell());
            System.out.println("===================================");
        }

        System.out.println("-----------------------------");
        var map = service.getUsersByShell();
        for (String s : map.keySet()) {
            System.out.println(s +": "+map.get(s).stream().map(User::getUsername).collect(Collectors.joining(",")));
        }

        System.out.println("-----------------------------");
        for (User systemUser : service.getSystemUsers()) {
            System.out.println(systemUser.getUsername());
        }

        System.out.println("-----------------------------");
        System.out.println(service.getCount());
    }
}
