

public class Cartoes 
{

    private String nomeCompleto;
    private String numero;
    private String cvv;
    private String parcelas;

  
    
    public Cartoes(String nomeCompleto, String numero, String cvv, String parcelas) {
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
        this.cvv = cvv;
        this.parcelas = parcelas;
    }

    public Cartoes(String nomeCompleto, String numero, String cvv) {
        this.nomeCompleto = nomeCompleto;
        this.numero = numero;
        this.cvv = cvv;
    }

    public Cartoes() {
    }

    
    
    
    
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }


    
    
    
}
