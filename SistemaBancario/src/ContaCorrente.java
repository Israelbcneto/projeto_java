
public class ContaCorrente extends Cliente {
    public ContaCorrente(String cpf, String nome, String email, String cnpj, double saldo) {
        super(cpf, nome, email, cnpj, saldo);
    }
    //tarifa bancária
    public void cobrarTarifaBancaria(double valorTarifa) {
        if (saldo >= valorTarifa) {
            saldo -= valorTarifa;
            System.out.println("Tarifa bancária cobrada com sucesso: " + valorTarifa);
        } else {
            System.out.println("Saldo insuficiente para cobrar tarifa bancária.");
        }
    }
}


