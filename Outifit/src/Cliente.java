


import java.util.List;





public class Cliente extends Usuario 
{
    private double saldoDesconto;
    private List<Cliente> clientes;
    
    Usuario user = new Usuario();
    
    
    
    
    
    
    
    
      
    public Cliente( String nome, String email, String senha,String cpf) 
    {
        super( nome, email, senha,cpf);
       
    }

    public Cliente()
    {
    }
    
    
    
   
    
    public void cadastrarCliente()
    {
            Cliente cliente = new Cliente( user.getNome(),user.getEmail() , user.getSenha(),user.getCpf());
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
}