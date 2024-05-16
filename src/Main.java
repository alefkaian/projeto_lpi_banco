import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha_menu_principal = -1;
        Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
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
                        nova_tarefa.setDataPrazo(input.nextLine());
                        System.out.println("Deseja ativar as notificações? (s/n)");
                        String notif = input.nextLine();
                        nova_tarefa.setNotificacoes(notif.equals("s"));
                        cadastro.adicionarTarefa(nova_tarefa);
                        escolha_menu_principal = -1;
                        break;

                    case 2:
                        int escolha_tarefa = -1;
                        while (escolha_tarefa != 0) {
                            System.out.println("\nQual tarefa deseja editar/excluir?");
                            cadastro.listarTarefasSimplificado();
                            System.out.println("0- Voltar");
                            escolha_tarefa = input.nextInt();
                            System.out.println(escolha_tarefa);
                            input.nextLine();

                            Tarefa tarefa_escolhida = cadastro.buscarTarefaPorId(escolha_tarefa);
                            int escolha_menu_edicao = -1;
                            if (cadastro.buscarTarefaPorId(escolha_tarefa) != null) {
                                while (escolha_menu_edicao != 0) {
                                    System.out.println("\nTarefa selecionada: \n" + tarefa_escolhida.toString());
                                    System.out.println("\nAlterar \n1- Título" +
                                            "\n2- Descrição" +
                                            "\n3- Data" +
                                            "\n4- Notificações" +
                                            "\n\n5- Confirmar alterações\n6- Excluir tarefa\n0- Voltar");
                                    escolha_menu_edicao = input.nextInt();
                                    input.nextLine();

                                    switch (escolha_menu_edicao) {
                                        case 0:
                                            break;

                                        case 1:
                                            System.out.println("Título atual: " + tarefa_escolhida.getTitulo());
                                            System.out.println("Novo título: ");
                                            tarefa_escolhida.setTitulo(input.nextLine());
                                            break;

                                        case 2:
                                            System.out.println("Descrição atual: " + tarefa_escolhida.getDescricao());
                                            System.out.println("Nova descrição: ");
                                            tarefa_escolhida.setDescricao(input.nextLine());
                                            break;

                                        case 3:
                                            System.out.println("Prazo atual: " + tarefa_escolhida.getDataPrazo());
                                            System.out.println("Novo prazo: ");
                                            tarefa_escolhida.setDataPrazo(input.nextLine());
                                            break;

                                        case 4:
                                            System.out.println("Notificações atualmente: " + tarefa_escolhida.isNotificacoes());
                                            System.out.println("Deseja ativar as notificações? (s/n): ");
                                            tarefa_escolhida.setNotificacoes(input.nextLine().equals("s"));
                                            break;

                                        case 5:
                                            cadastro.atualizarTarefa(tarefa_escolhida);
                                            escolha_menu_edicao = 0;
                                            break;

                                        case 6:
                                            System.out.println("Deseja realmente excluir a tarefa? (s/n)");
                                            if (input.nextLine().equals("s")) {
                                                cadastro.excluirTarefa(tarefa_escolhida.getId());
                                                escolha_menu_edicao = 0;
                                            }
                                            break;


                                        default:
                                            System.out.println("\nEscolha inválida!");
                                            break;
                                    }
                                }


                            }
                        }
                        escolha_menu_principal = -1;
                        break;

                    case 3:
                        System.out.println("\nLista de tarefas cadastradas: ");
                        cadastro.listarTarefasDetalhado();
                        escolha_menu_principal = -1;
                        break;

                    default:
                        System.out.println("\nEscolha inválida!");
                        escolha_menu_principal = -1;
                        break;
                }
            } catch (Exception t) {
                System.out.println("\nEntrada inválida!");
                input.nextLine();
            }
        }
        input.close(); // Fechar o scanner ao finalizar
    }
}