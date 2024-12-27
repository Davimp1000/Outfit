
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ProdutoDao

{
 
  Statement stmt = null;
  Connection con = null;
  
  Produto produto = new Produto();
  
  private DefaultTableModel model;
     
    
    
    
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
    
    
    
    
    
    
    
    public void cadastrar(Produto produto)
    {
        
        
        PreparedStatement ps = null;
       
       
        
        String sql = "insert into produtos(nome,valor,estoque) values (?,?,?)";
        
        try
        {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getEstoque());
           
            
            ps.executeUpdate();
              
            JOptionPane.showMessageDialog(null,"Cadastro concluído!!");
        }
         catch(SQLException sqle)
        {
              JOptionPane.showMessageDialog(null, "Não conseguimos efetuar o cadastro, volte mais tarde");
        }
        
        
        
        
        
        
        
        
    }
    
    
    
    
      public void listar(DefaultTableModel model)
      {
             
      
       
       
        
        String sql = "select*from produtos";
        
        try
        {
            
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
          
              while(rs.next())
              {
             int id =     rs.getInt("id");
             String nome =    rs.getString("nome");
             Double valor =    rs.getDouble("valor");
             int estoque =    rs.getInt("estoque");
                        
                  model.addRow(new Object[] {id,nome,valor,estoque});
              }
              
             
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"erroo");
        }
        
        
        
        
      }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     //=============================================FECHAR CONEXÃO COM O MYSQL WORKBENCH==============================
    public void fecharConexao()
    {
           
       
try {
    con.close();
    System.out.println( "Conexão com o banco de dados fechada" );
} catch (SQLException sqle) {
    System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage() );
}
    }
    
    
    
    
    
    
    //ATUALIZAR ESTOQUE
    
    public void atualizar(int novoEstoque,String nomeP)
    {
        PreparedStatement ps = null;
        
        String sql = "update produtos set estoque = ? where nome = ?";
        
        try
        {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, novoEstoque);
            ps.setString(2, nomeP);
            
             ps.executeUpdate();
           
        }
        catch(SQLException sqle)
        {
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    public void buscarEstoque(String nomeP,int quant)
    {
        
        
        String sql = "select estoque from produtos where nome = " + "'" + nomeP+  "'";
        
        try
        {
            
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
          
              while(rs.next())
              {
         
            
             int estoque =    rs.getInt("estoque");
                        
              int novo = estoque - quant;
              
              atualizar(novo,nomeP);
              }
              
             
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"erroo");
        }
        
    }
    
   
    
    
    
    
    
    
    
}
