package io.jasonlu.json;

/**
 * Created by jiehenglu on 17/01/12.
 */
public class User {
    private final String name;
    private final int value;

    public User(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (value != user.value) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }
}
