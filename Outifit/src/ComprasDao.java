
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class ComprasDao 
{
    
    
    
    Connection con = null;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void inserirCompra(String nome,String produto,int quantidade,double valor)
    {
        String sql = "insert into compras (nomeComprador,produto,quantidade,valor) values (?,?,?,?)";
        
        try(Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql))
        {
            stmt.setString(1,nome);
            stmt.setString(2, produto);
            stmt.setInt(3, quantidade);
            stmt.setDouble(4, valor);
            
            stmt.executeUpdate();
            
        }
        catch(Exception e)
        {
            System.out.println("ERRO");
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
    
    
    
    
    
    public void listar(DefaultTableModel model)
    {
         Usuario usuario = SessaoUsuarioCliente.getInstancia().getUsuario();
        
        String sql = "select produto,quantidade,valor from compras where nomeComprador = " + "'" + usuario.getNome() + "'";
        
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                String produto = rs.getString("produto");
                int quant = rs.getInt("quantidade");
                double valor = rs.getDouble("valor");
                
                model.addRow(new Object[] {produto,quant,valor});
            }
        }
        catch(SQLException ex)
        {
               JOptionPane.showMessageDialog(null,"erroo");
        }
    }
    
    
    
    
    
    
    
    public void listar2(DefaultTableModel model)
    {
        
        
        String sql = "select nomeComprador,produto,quantidade,valor from compras ";
        
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                String nomeC = rs.getString("nomeComprador");
                String produto = rs.getString("produto");
                int quant = rs.getInt("quantidade");
                double valor = rs.getDouble("valor");
                
                model.addRow(new Object[] {nomeC,produto,quant,valor});
            }
        }
        catch(SQLException ex)
        {
               JOptionPane.showMessageDialog(null,"erroo");
        }
    }
    
    
    
    
    
    
    
    
    
}
