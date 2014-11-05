package Control;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;
import java.sql.Statement;
  
public class Conexao { 
    public static void main(String[] args) {  
    
    
    }
    
    public Connection getConexao(){
        Connection con = null;  
        // TODO code application logic here  
        try {  
            String url = "jdbc:postgresql://localhost:5432/pdiDb";  
            String usuario = "postgres";  
            String senha = "amarildo";  
  
            Class.forName("org.postgresql.Driver");  
  
            
            con = DriverManager.getConnection(url, usuario, senha);  
  
            System.out.println("Conexão realizada com sucesso."); 
  
        } catch (Exception e) {  
             e.printStackTrace();  
        }
        
        return con;
    }
    
    
}  


