package io.jasonlu.scalajdk8patterns.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by louz on 2016/10/9.
 */
public class JavaFunction {
    public static void main(String[] args) {
        User user1 = new User(1, "user1");
        User user2 = new User(2, "user2");
        User user3 = new User(3, "user3");

        List<User> users = Arrays.asList(user3, user2, user1);

        /*  JDK 7 mode
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        });
        */

        // JDK 8 mode
        users.sort((o1, o2) -> o1.getId() - o2.getId());

//        System.out.println(users);
        users.forEach(a -> System.out.println(a));
    }
}
