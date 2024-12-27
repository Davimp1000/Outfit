


import java.util.List;
import java.util.Scanner;


public class Usuario 

{
 
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private int numeroAcesso;
    
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private Scanner scanner;
    
    
    
     
    
    
    public Usuario( String nome, String email,String cpf) 
    {
      
        this.nome = nome;
        this.email = email;
        
        this.cpf = cpf;
    }

    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
      
    }

    
    
    
    
    
    
    
    
    
    
  
    
    
    Usuario() 
    {
         
    }

    
    
    public Usuario(String nome, String email, String senha, int numeroAcesso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numeroAcesso = numeroAcesso;
    }

    
    
    
    
    
    
    
        
       


 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getNumeroAcesso() {
        return numeroAcesso;
    }

    public void setNumeroAcesso(int numeroAcesso) {
        this.numeroAcesso = numeroAcesso;
    }

    
    
    
    
    
    
    
}