



import java.util.List;

public class Venda 

{
    
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;
    private String data;
    private int quantidade;
    

         // Construtor
    public Venda( Cliente cliente, List<Produto> produtos, double total, String data,int quantidade) {
        
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = total;
        this.data = data;
        this.quantidade = quantidade;
    }
    
    

// Métodos para registrar vendas e calcular total
    public void registrarVenda() {
        for (Produto produto : produtos) 
        {
            
            produto.AtualizarEstoque(1); // Reduz estoque
        }
    }
    
    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
  
    
    
}