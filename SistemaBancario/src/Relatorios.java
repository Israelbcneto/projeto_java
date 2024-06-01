public class Relatorios {
    public void gerarRelatorios(Administrador admin) {
        System.out.println("Relatório de Operações:");
        System.out.println("Total de Saques: " + admin.getTotalSaques());
        System.out.println("Total de Depósitos: " + admin.getTotalDepositos());
    }
}
