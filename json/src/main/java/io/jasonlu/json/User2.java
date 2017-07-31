package io.jasonlu.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jiehenglu on 17/01/12.
 */
public class User2 {
    private final String name;

    // json中的字段名和java字段名不一致时需要用该注解进行转换
    @SerializedName(value="v", alternate = {"v1"})
    private final int value;

    public User2(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User2 user2 = (User2) o;

        if (value != user2.value) return false;
        return name != null ? name.equals(user2.name) : user2.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }
}
