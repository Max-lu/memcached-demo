package custom;

import java.io.Serializable;

/**
 * Created by max.lu on 2016/3/21.
 */
public final class Account implements Serializable {

    private static final long serialVersionUID = -9026498648840274608L;

    public Account() {

    }

    @Override
    public String toString() {
        return "[name=" + this.name + ",password=" + this.password + "]";
    }

    public Account(String name) {
        this.name = name;
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
