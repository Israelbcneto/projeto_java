public class Usuario {
    private String cfp;
    private String cnpj;
    private String nome;
    private String senha;
    private String email;
    protected int tipoDeConta; // Identificar qual o tipo de conta

    public Usuario(String cfp, String cnpj, String nome, String senha, String email, int tipoDeConta) {
        this.cfp = cfp;
        this.cnpj = cnpj;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipoDeConta = tipoDeConta;
    }

    // Getters e setters
    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(int tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public void entrar() {
        // Método para entrar (Usaremos API (Banco de dados))
    }

    // Método para cadastrar usuário (Usaremos API (Banco de dados))
    public void cadastrar() {
        // Lógica para cadastrar usuário (Usaremos API (Banco de dados))
    }
}
