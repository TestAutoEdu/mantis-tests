package marina.edu.test.tests;

import marina.edu.test.model.GroupData;
import org.testng.annotations.Test;

import java.sql.*;
import marina.edu.test.model.GroupData;

public class DbConnectionTest {
   /** @Test (enabled = false)
    public void testDbConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from group_list");
            while (rs.next()){
                new GroupData.getId(rs.getInt("group_id")).getName(rs.getString("group_name"))
                        .getHeader(rs.getString("group_header")).getFooter(rs.getString("group_footer"));
            }

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }**/
}
