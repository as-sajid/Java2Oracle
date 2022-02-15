import java.sql.*;
public class Java2oracle {
    public static void main(String[] args) throws Exception {

        try{  
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
              
            //step3 create the statement object
                       try (//step2 create  the connection object
                               Connection con = DriverManager.getConnection(  
                                       "jdbc:oracle:thin:@localhost:1521/XEPDB1","hr","hr")) {
                           //step3 create the statement object
                           Statement stmt=con.createStatement();
                           //step4 execute query
                           ResultSet rs=stmt.executeQuery("select employee_id, salary,department_id from employees where employee_id < 200");
                           while (rs.next()) {
                               System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                           }
            //step5 close the connection object
                       }  
              
            }catch(ClassNotFoundException | SQLException e){ System.out.println(e);}  
               

        System.out.println("Hello, World!");
    }
}
