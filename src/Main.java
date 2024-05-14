import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha_menu_principal = -1;
        Scanner input = new java.util.Scanner(System.in).useLocale(Locale.ENGLISH);
        Cadastro cadastro = new Cadastro();


        while (escolha_menu_principal != 0) {
            try {
                System.out.println("\nEscolha uma das operações:");
                System.out.println("1- Cadastrar nova tarefa\n2- Modificar/Excluir tarefas\n3- Ver lista de tarefas\n0- Sair");
                escolha_menu_principal = input.nextInt();
                input.nextLine();

                switch (escolha_menu_principal) {
                    case 0:
                        System.out.println("\nEncerrando programa.");
                        break;

                    case 1:
                        Tarefa nova_tarefa = new Tarefa();
                        System.out.println("\nDigite o título da tarefa: ");
                        nova_tarefa.setTitulo(input.nextLine());
                        System.out.println("Digite a descrição da tarefa: ");
                        nova_tarefa.setDescricao(input.nextLine());
                        System.out.println("Digite a data de prazo da tarefa (dd/mm/aa): ");
                        nova_tarefa.setData(input.nextline());
                        System.out.println("Deseja ativar as notificações (s/n)?");
                        String notif = input.nextLine();
                        if (notif.equals("s")) nova_tarefa.setNotificacoes(true);
                        else nova_tarefa.setNotificacoes(false);
                        cadastro.adicionarTarefa(nova_tarefa);
                        break;

                    case 2:

                        // Implementar ainda
                        int escolha_tarefa = -1, escolha_menu_editar = -1;
                        while (escolha_tarefa != 0) {
                            try{
                                System.out.println("\nQual tarefa deseja editar/excluir?\n0- Voltar");
                                cadastro.listarTarefas();
                                escolha_tarefa = input.nextInt();
                                input.nextLine();

                            }
                            catch (Exception e2){
                                System.out.println("\nEntrada invalida!");
                                input.nextLine();
                            }



                        }
                    case 3:
                        System.out.println("\nLista de tarefas cadastradas: ");
                        cadastro.listarTarefas();

                    default:
                        System.out.println("\nEscolha inválida!");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada invalida!");
                input.nextLine();
            }
        }
    }
}