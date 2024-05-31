import java.util.ArrayList;
//Classe Relatorios
public class Relatorios {
    //Método que gera relatórios
    public void gerarRelatorios(Administrador admin) {
        // Acesso aos dados armazenados no administrador
        ArrayList<Double> saques = admin.getSaques();
        ArrayList<Double> transferencias = admin.getTransferencias();
        ArrayList<Double> depositos = admin.getDepositos();
        ArrayList<Double> emprestimos = admin.getEmprestimos();

        //Aqui você pode implementar a lógica para gerar os relatórios com base nos dados
        //Por exemplo, você pode imprimir os dados ou salvar em arquivos, dependendo da necessidade
        System.out.println("Relatório de Saques: " + saques);
        System.out.println("Relatório de Transferências: " + transferencias);
        System.out.println("Relatório de Depósitos: " + depositos);
        System.out.println("Relatório de Empréstimos: " + emprestimos);
    }
}


