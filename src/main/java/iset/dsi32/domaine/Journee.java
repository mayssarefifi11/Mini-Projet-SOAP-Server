package iset.dsi32.domaine;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement(name = "journee")
public class Journee {

    private int id ;

    private Date date;

    public Journee() {
        this.id = 0;
        this.date = new Date();
    }

    public Journee(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Journee{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
