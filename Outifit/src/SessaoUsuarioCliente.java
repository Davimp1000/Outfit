


public class SessaoUsuarioCliente 
{
    private static SessaoUsuarioCliente instancia;
    private Usuario usuario;

    private SessaoUsuarioCliente() { }

    public static SessaoUsuarioCliente getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuarioCliente();
        }
        return instancia;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void limparSessao() {
        usuario = null;
    }
}
