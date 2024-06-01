public class ContaPoupanca extends Cliente {
    private static final double taxaRendimento = 1.1; // Taxa de rendimento fixa

    public ContaPoupanca(String cpf, String cnpj, String nome, String senha, String email, int tipoDeConta, double saldo) {
        super(cpf, cnpj, nome, senha, email, tipoDeConta, saldo);
    }

    // Calcular e aplicar o rendimento
    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento; // Atualiza o saldo aplicando o rendimento
        System.out.println("Rendimento aplicado: " + rendimento);
    }
}
