public class ContaPJ extends Cliente {
    public ContaPJ(String cpf, String nome, String email, String cnpj, double saldo) {
        super(cpf, nome, email, cnpj, saldo);
    }
    //Método para validar CNPJ
    public boolean validarCNPJ(String cnpj) {
        //lógica para validar o CNPJ
        return cnpj.equals(getCnpj());
    }
}
