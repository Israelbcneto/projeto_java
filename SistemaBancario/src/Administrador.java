import java.util.ArrayList;
public class Administrador extends Usuario {
    //A classse administrador é uma das que usaremos bastante banco de dados para armazenar os dados transacionais do sistema bancário para poder usá-los
    //de acordo com o usuário
    // Atributos para armazenar dados
    private ArrayList<Double> saques;
    private ArrayList<Double> transferencias;
    private ArrayList<Double> depositos;
    private ArrayList<Double> emprestimos;
    public Administrador(String cfp, String cnpj, String nome, String senha, String email, int tipoDeConta, int nivelAcesso) {
        super(cfp, cnpj, nome, senha, email, tipoDeConta);
        // Inicializar lista
        this.saques = new ArrayList<>();
        this.transferencias = new ArrayList<>();
        this.depositos = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }
    //Métodos para adicionar dados vamos precisar de API (Banco de Dados)
    public void adicionarSaque(double valor) {
        saques.add(valor);
    }
    public void adicionarTransferencia(double valor) {
        transferencias.add(valor);
    }
    public void adicionarDeposito(double valor) {
        depositos.add(valor);
    }
    public void adicionarEmprestimo(double valor) {
        emprestimos.add(valor);
    }
    //GETTS
    public ArrayList<Double> getSaques() {
        return saques;
    }
    public ArrayList<Double> getTransferencias() {
        return transferencias;
    }
    public ArrayList<Double> getDepositos() {
        return depositos;
    }
    public ArrayList<Double> getEmprestimos() {
        return emprestimos;
    }
}

