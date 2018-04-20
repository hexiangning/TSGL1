package datebase.jdbc;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class Database {  
    private static final String URL="jdbc:mysql://localhost:3306/books";  
    private static final String NAME="root";  
    private static final String PASSWORD="leadfar";  
    private static Connection conn=null;//静态代码块（将加载驱动、连接数据库放入静态块中）  
    static{  
        try {  
                //1.加载驱动程序  
                Class.forName("com.mysql.jdbc.Driver");  
                //2.获得数据库的连接  
                conn = DriverManager.getConnection(URL, NAME, PASSWORD);  
                System.out.println("数据库连接成功！");  
                } catch (ClassNotFoundException e) {  
                    e.printStackTrace();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
      
    //对外提供一个方法来获取数据库连接  
    public static Connection getConnection(){  
        return conn;  
    }  
      
  //相当于c++中的析构函数  
    protected void finalize() throws java.lang.Throwable  
    {  
        conn.close();  
    }  
}  