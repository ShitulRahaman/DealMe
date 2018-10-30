package exibition.utility;

public class DB {
    public static final String DBA_URL = "jdbc:mysql://localhost:3306/test";
    public static final String DBA_USERNAME = "root";
    //    public static final String DBA_PASSWORD = "D71bd@123$%^";
    public static final String DBA_PASSWORD = "";
    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    public static final String USER_BY_USER_NAME_QUERY = "select user_name, password, active from user where user_name=?";
    public static final String AUTHORITIES_BY_USER_NAME_QUERY = "select user_name, role from user where user_name=?";
}
