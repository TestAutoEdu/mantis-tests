package marina.edu.test.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity//Аннотация для Hybernate (работа с OQL)
@Table(name = "group_list") //Аннотация для Hybernate (работа с OQL)
public class GroupData {

    @Id//Аннотация для Hybernate (работа с OQL)
    @Column(name = "group_id") //Аннотация для Hybernate (работа с OQL)
    @Type(type = "int")
    public static int id = Integer.MAX_VALUE;
    @Column(name = "group_name") //Аннотация для Hybernate (работа с OQL)
    public static String name;
    @Column(name = "group_header") //Аннотация для Hybernate (работа с OQL)
    public static String header;
    @Column(name = "group_footer") //Аннотация для Hybernate (работа с OQL)
    public static String footer;

    public GroupData(int id, String groupNameModificated, String groupHeaderModificated, String groupFooterModificated) {
    }

    public GroupData(int id, String Name) {
    }

    public GroupData(String test2, Object o, Object o1) {
    }

    public void setId(int id) {
        GroupData.id = id;
    }


    public int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getHeader() {
        return header;
    }

    public static String getFooter() {
        return footer;
    }

    public static void setFooter(String footer) {
        GroupData.footer = footer;
    }

    public static void setName(String name) {
        GroupData.name = name;
    }

    public static void setHeader(String header) {
        GroupData.header = header;
    }

    @Override
    public String toString() {

        return "GroupData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @Override

    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }


    public static class getId {
        public getId(int group_id) {
        }
    }
}
