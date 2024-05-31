
public class Cliente extends Usuario {
    //Atributo específico de Cliente
    protected double saldo;
    public Cliente(String cfp, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cfp, cnpj, nome, senha, email, tipoDeConta);
        this.saldo = saldo;
    }
    //consultar saldo
    public double saldo() {
        return saldo;
    }
    //extrato da conta
    public void extrato() {
        // Lógica para exibir extrato da conta
    }
    public void excluirConta() {
        // Lógica para excluir a conta do cliente
    }
    public void depositar(double valor) {
        // Lógica para depositar dinheiro na conta
    }
    public void transferir(double valor, String contaDestino) {
        // Lógica para transferir dinheiro para outra conta
    }
    public void sacar(double valor) {
        // Lógica para sacar dinheiro da conta
    }
    public void emprestimo(double valor) {
        // Lógica para solicitar empréstimo
    }
}


