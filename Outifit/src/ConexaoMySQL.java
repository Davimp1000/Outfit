


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoMySQL
{
    Connection con = null;
    
    private static final String URL = "jdbc:mysql://localhost:3306/industria_de_roupas_db"; 
    private static final String USUARIO = "root"; 
    private static final String SENHA = "2960412032."; 

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
     public void fecharConexao()
    {
           
       
try{
   con.close();
    System.out.println( "Conexão com o banco de dados fechada" );
} catch (SQLException sqle) {
    System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage() );
}
    }
    
    
    
    
}

