package io.jasonlu.json;

import java.time.LocalDate;

/**
 * Created by jiehenglu on 17/01/12.
 */
public class User {
    private String name;
    private int value;
    private LocalDate birth;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", birth=" + birth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (value != user.value) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birth != null ? birth.equals(user.birth) : user.birth == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + value;
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
