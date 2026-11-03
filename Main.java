import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tarefa> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== 📝 GERENCIADOR DE TAREFAS ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Concluir Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    tarefas.add(new Tarefa(desc));
                    System.out.println("✅ Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TAREFAS ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa registada.");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- CONCLUIR TAREFA ---");
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas para concluir.");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                        System.out.print("Digite o número da tarefa a concluir: ");
                        int num = scanner.nextInt();
                        if (num > 0 && num <= tarefas.size()) {
                            tarefas.get(num - 1).marcarComoConcluida();
                            System.out.println("🎉 Tarefa marcada como concluída!");
                        } else {
                            System.out.println("❌ Número inválido!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("A sair do sistema... Até logo!");
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}