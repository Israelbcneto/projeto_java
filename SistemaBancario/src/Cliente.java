public class Cliente extends Usuario {
    // Atributo específico de Cliente
    protected double saldo;

    public Cliente(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta);
        this.saldo = saldo;
    }

    // Consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Extrato da conta
    public void extrato() {
        // Lógica para exibir extrato da conta
    }

    public void excluirConta() {
        // Lógica para excluir a conta do cliente
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado: " + valor);
    }

    public void transferir(double valor, String contaDestino) {
        if (saldo >= valor) {
            saldo -= valor;
            // Lógica para transferir dinheiro para outra conta
            System.out.println("Transferência realizada para a conta " + contaDestino + " no valor de " + valor);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado: " + valor);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void emprestimo(double valor) {
        // Lógica para solicitar empréstimo
    }
}

