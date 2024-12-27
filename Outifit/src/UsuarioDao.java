


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class UsuarioDao
{
    
    Connection con = null;
    
    
    
    
    
    
    public void conectar()
    {
        
        
        
        
        
          
              //CONEXÃO COM O BANCO DE DADOS//
        try
        {
          Class.forName("com.mysql.cj.jdbc.Driver" );
          System.out.println( "Driver JDBC carregado" );
          
        }
        catch(ClassNotFoundException cnfe)
                {
                     System.out.println( "Driver JDBC nao encontrado : " +
                               cnfe.getMessage() );
                }
            
        
        
        try
        {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industria_de_roupas_db","root","2960412032.");
            System.out.println( "Conexao com o banco de dados estabelecida." );
        }
        catch(SQLException sqle)
                {
                     System.out.println( "Erro na conexao ao Bando de Dados : " +
                                        sqle.getMessage() );
                }
        
       //======================================================================================================== 
        
        
       
                                        //STATEMENT
       
          Statement stmt = null;
       try
       {
          stmt = con.createStatement();
           System.out.println( "Pronto para execucao de comandos sql." );
       }
       catch(SQLException sqle)
               {
                    System.out.println( "Erro no acesso ao Bando de Dados : " +
                                        sqle.getMessage() );
               }
       
        }
    
    
    
    
    
    
    
     public void fecharConexao()
    {
           
       
try {
    con.close();
    System.out.println( "Conexão com o banco de dados fechada" );
} catch (SQLException sqle) {
    System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage() );
}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
                          //MÉTODO DE LOGIN CLIENTE
     public static Usuario autenticarCliente(String email, String senha) {
        String sql = "SELECT nome, email, cpf FROM clientes WHERE email = ? AND senha = ?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                return new Usuario(nome, email, cpf); // Retorna um objeto Usuario
            }
        } catch (Exception e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
        }
        return null; // Retorna null se o login falhar
    }
    
    
    
    //MÉTODO DE CADASTRO CLIENTE
    
    public void cadastroCliente(String nome,String email,String cpf,String senha)
    {
        PreparedStatement ps = null;
        
         String sql = "insert into clientes(nome,email,cpf,senha) values (?,?,?,?)";
        
        try
        {
              ps = con.prepareStatement(sql);
              
                ps.setString(1, nome);
                  ps.setString(2, email);
                    ps.setString(3, cpf);
                      ps.setString(4, senha);
                      
                       ps.executeUpdate();
                       
                          JOptionPane.showMessageDialog(null,"Cadastro concluído!!");
        }
        catch(SQLException sqle)
        {
              JOptionPane.showMessageDialog(null, "Não conseguimos efetuar o cadastro, volte mais tarde");
        }
    }
    
    
    
    
    
    
    
    
    //MÉTODO LOGIN ADM
    
      public static Usuario autenticarAdm(String email, String senha,int numeroAcesso) {
        String sql = "SELECT nome, email FROM funcionario WHERE email = ? AND senha = ? AND numeroAcesso = ?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);
            stmt.setInt(3, numeroAcesso);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
            
                return new Usuario(nome, email); // Retorna um objeto Usuario
            }
        } catch (Exception e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
        }
        return null; // Retorna null se o login falhar
    }
    
    
    
    
    
     //MÉTODO CADASTRO DE ADMIN
      
        public void cadastroAdmin(String nome,String email,String senha,int numeroAcesso)
    {
        PreparedStatement ps = null;
        
         String sql = "insert into funcionario(nome,email,senha,numeroAcesso) values (?,?,?,?)";
        
        try
        {
              ps = con.prepareStatement(sql);
              
                ps.setString(1, nome);
                  ps.setString(2, email);
                    ps.setString(3, senha);
                      ps.setInt(4, numeroAcesso);
                      
                       ps.executeUpdate();
                       
                          JOptionPane.showMessageDialog(null,"Cadastro concluído!!");
        }
        catch(SQLException sqle)
        {
              JOptionPane.showMessageDialog(null, "Não conseguimos efetuar o cadastro, volte mais tarde");
        }
    }
    
    
    
    
    
    
  
    
    
    
    
    
    
   
    
    
    
    
}
