






public class Produto 
{
 
  int estoque;
  String nome;
  Double preco;

  
  
  
    public Produto( int estoque, String nome, Double preco)
    {
       
        this.estoque = estoque;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
    }

   
  
    
    
    
    
  
  public void AtualizarEstoque( int estoque)
  {
      
  }


  
  
  
  public void EditarPreco(Double preco)
  {
      
  }

   

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }



    
}
