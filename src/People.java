import java.util.ArrayList;

/**
 * Created by macbookair on 10/19/15.
 */
public class People implements Comparable{
    int pos;
    String firstname;
    String lastname;
    String email;
    String country;
    String ip;

    public People(int pos, String firstname, String lastname, String email, String country, String ip) {
        this.pos = pos;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.ip = ip;

    }

    @Override
    public int compareTo (Object o) {
        People c = (People) o;
        return lastname.compareTo(c.lastname);
    }
    @Override
    public String toString() {
                return String.format("%s %s from %s \n", firstname,lastname,country );
            }
        }
