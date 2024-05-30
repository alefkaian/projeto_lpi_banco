import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.ENGLISH);
        Cadastro cadastro = new Cadastro();
        Calendario calendario = new Calendario();

        int escolha_menu_principal = -1;
        while (escolha_menu_principal != 0) {
            try {
                System.out.println("\nEscolha uma das operações:");
                System.out.println("1- Cadastro de Pessoas\n2- Cadastro de Tarefas\n3- Atribuição de pessoas às tarefas\n4- Calendário\n0- Sair");
                escolha_menu_principal = input.nextInt();
                input.nextLine();

                switch (escolha_menu_principal) {
                    case 0:
                        System.out.println("\nEncerrando programa.");
                        break;

                    case 1:
                        int escolha_pessoa = -1;
                        while (escolha_pessoa != 0) {
                            System.out.println("\nEscolha o tipo de cadastro:");
                            System.out.println("1- Cadastro de Supervisor\n2- Cadastro de Membro\n0- Voltar");
                            escolha_pessoa = input.nextInt();
                            input.nextLine();

                            switch (escolha_pessoa) {
                                case 0:
                                    break;

                                case 1:
                                    int escolha_supervisor = -1;
                                    while (escolha_supervisor != 0) {
                                        System.out.println("\nEscolha uma das operações de Cadastro de Supervisores:");
                                        System.out.println("1- Cadastrar novo supervisor\n2- Modificar/Excluir supervisores\n3- Ver lista de supervisores\n0- Voltar");
                                        escolha_supervisor = input.nextInt();
                                        input.nextLine();

                                        switch (escolha_supervisor) {
                                            case 0:
                                                break;

                                            case 1:
                                                Pessoa novo_supervisor = new Supervisor();
                                                System.out.println("\nDigite o nome do supervisor: ");
                                                novo_supervisor.setNome(input.nextLine());
                                                System.out.println("Digite o grau de hierarquia: ");
                                                ((Supervisor) novo_supervisor).setGrauHierarquia(input.nextInt());
                                                input.nextLine();
                                                System.out.println("Digite o departamento: ");
                                                ((Supervisor) novo_supervisor).setDepartamento(input.nextLine());
                                                cadastro.adicionarSupervisor((Supervisor) novo_supervisor);
                                                escolha_supervisor = -1;
                                                break;

                                            case 2:
                                                int escolha_supervisor_edicao = -1;
                                                while (escolha_supervisor_edicao != 0) {
                                                    System.out.println("\nQual supervisor deseja editar/excluir?");
                                                    cadastro.listarSupervisoresSimplificado();
                                                    System.out.println("0- Voltar");
                                                    escolha_supervisor_edicao = input.nextInt();
                                                    input.nextLine();

                                                    Pessoa supervisor_escolhido = cadastro.buscarSupervisorPorId(escolha_supervisor_edicao);
                                                    int escolha_menu_edicao = -1;
                                                    if (supervisor_escolhido != null) {
                                                        while (escolha_menu_edicao != 0) {
                                                            System.out.println("\nSupervisor selecionado: \n" + ((Supervisor) supervisor_escolhido).toString());
                                                            System.out.println("\nAlterar \n1- Nome" +
                                                                    "\n2- Grau de Hierarquia" +
                                                                    "\n3- Departamento" +
                                                                    "\n\n4- Confirmar alterações\n5- Excluir supervisor\n0- Voltar");
                                                            escolha_menu_edicao = input.nextInt();
                                                            input.nextLine();

                                                            switch (escolha_menu_edicao) {
                                                                case 0:
                                                                    break;

                                                                case 1:
                                                                    System.out.println("Nome atual: " + supervisor_escolhido.getNome());
                                                                    System.out.println("Novo nome: ");
                                                                    supervisor_escolhido.setNome(input.nextLine());
                                                                    break;

                                                                case 2:
                                                                    System.out.println("Grau de hierarquia atual: " + ((Supervisor) supervisor_escolhido).getGrauHierarquia());
                                                                    System.out.println("Novo grau de hierarquia: ");
                                                                    ((Supervisor) supervisor_escolhido).setGrauHierarquia(input.nextInt());
                                                                    input.nextLine();
                                                                    break;

                                                                case 3:
                                                                    System.out.println("Departamento atual: " + ((Supervisor) supervisor_escolhido).getDepartamento());
                                                                    System.out.println("Novo departamento: ");
                                                                    ((Supervisor) supervisor_escolhido).setDepartamento(input.nextLine());
                                                                    break;

                                                                case 4:
                                                                    cadastro.atualizarSupervisor((Supervisor) supervisor_escolhido);
                                                                    escolha_menu_edicao = 0;
                                                                    break;

                                                                case 5:
                                                                    System.out.println("Deseja realmente excluir o supervisor? (s/n)");
                                                                    if (input.nextLine().equals("s")) {
                                                                        cadastro.excluirSupervisor(((Supervisor) supervisor_escolhido).getIdS());
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
                                                escolha_supervisor = -1;
                                                break;

                                            case 3:
                                                System.out.println("\nLista de supervisores cadastrados: ");
                                                cadastro.listarSupervisoresDetalhado();
                                                escolha_supervisor = -1;
                                                break;

                                            default:
                                                System.out.println("\nEscolha inválida!");
                                                escolha_supervisor = -1;
                                                break;
                                        }
                                    }
                                    escolha_pessoa = -1;
                                    break;

                                case 2:
                                    int escolha_membro = -1;
                                    while (escolha_membro != 0) {
                                        System.out.println("\nEscolha uma das operações de Cadastro de Membros:");
                                        System.out.println("1- Cadastrar novo membro\n2- Modificar/Excluir membros\n3- Ver lista de membros\n0- Voltar");
                                        escolha_membro = input.nextInt();
                                        input.nextLine();

                                        switch (escolha_membro) {
                                            case 0:
                                                break;

                                            case 1:
                                                Pessoa novo_membro = new Membro();
                                                System.out.println("\nDigite o nome do membro: ");
                                                novo_membro.setNome(input.nextLine());
                                                System.out.println("Digite o cargo: ");
                                                ((Membro) novo_membro).setCargo(input.nextLine());
                                                cadastro.adicionarMembro((Membro) novo_membro);
                                                escolha_membro = -1;
                                                break;

                                            case 2:
                                                int escolha_membro_edicao = -1;
                                                while (escolha_membro_edicao != 0) {
                                                    System.out.println("\nQual membro deseja editar/excluir?");
                                                    cadastro.listarMembrosSimplificado();
                                                    System.out.println("0- Voltar");
                                                    escolha_membro_edicao = input.nextInt();
                                                    input.nextLine();

                                                    Pessoa membro_escolhido = cadastro.buscarMembroPorId(escolha_membro_edicao);
                                                    int escolha_menu_edicao = -1;
                                                    if (membro_escolhido != null) {
                                                        while (escolha_menu_edicao != 0) {
                                                            System.out.println("\nMembro selecionado: \n" + ((Membro) membro_escolhido).toString());
                                                            System.out.println("\nAlterar \n1- Nome" +
                                                                    "\n2- Cargo" +
                                                                    "\n\n3- Confirmar alterações\n4- Excluir membro\n0- Voltar");
                                                            escolha_menu_edicao = input.nextInt();
                                                            input.nextLine();

                                                            switch (escolha_menu_edicao) {
                                                                case 0:
                                                                    break;

                                                                case 1:
                                                                    System.out.println("Nome atual: " + membro_escolhido.getNome());
                                                                    System.out.println("Novo nome: ");
                                                                    membro_escolhido.setNome(input.nextLine());
                                                                    break;

                                                                case 2:
                                                                    System.out.println("Cargo atual: " + ((Membro) membro_escolhido).getCargo());
                                                                    System.out.println("Novo cargo: ");
                                                                    ((Membro) membro_escolhido).setCargo(input.nextLine());
                                                                    break;

                                                                case 3:
                                                                    cadastro.atualizarMembro((Membro) membro_escolhido);
                                                                    escolha_menu_edicao = 0;
                                                                    break;

                                                                case 4:
                                                                    System.out.println("Deseja realmente excluir o membro? (s/n)");
                                                                    if (input.nextLine().equals("s")) {
                                                                        cadastro.excluirMembro(((Membro) membro_escolhido).getIdM());
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
                                                escolha_membro = -1;
                                                break;

                                            case 3:
                                                System.out.println("\nLista de membros cadastrados: ");
                                                cadastro.listarMembrosDetalhado();
                                                escolha_membro = -1;
                                                break;

                                            default:
                                                System.out.println("\nEscolha inválida!");
                                                escolha_membro = -1;
                                                break;
                                        }
                                    }
                                    escolha_pessoa = -1;
                                    break;

                                default:
                                    System.out.println("\nEscolha inválida!");
                                    escolha_pessoa = -1;
                                    break;
                            }
                        }
                        escolha_menu_principal = -1;
                        break;

                    case 2:
                        int escolha_tarefa = -1;
                        while (escolha_tarefa != 0) {
                            System.out.println("\nEscolha uma das operações de Cadastro de Tarefas:");
                            System.out.println("1- Cadastrar nova tarefa\n2- Modificar/Excluir tarefas\n3- Ver lista de tarefas\n0- Voltar");
                            escolha_tarefa = input.nextInt();
                            input.nextLine();

                            switch (escolha_tarefa) {
                                case 0:
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
                                    escolha_tarefa = -1;
                                    break;

                                case 2:
                                    int escolha_tarefa_edicao = -1;
                                    while (escolha_tarefa_edicao != 0) {
                                        System.out.println("\nQual tarefa deseja editar/excluir?");
                                        cadastro.listarTarefasSimplificado();
                                        System.out.println("0- Voltar");
                                        escolha_tarefa_edicao = input.nextInt();
                                        input.nextLine();

                                        Tarefa tarefa_escolhida = cadastro.buscarTarefaPorId(escolha_tarefa_edicao);
                                        int escolha_menu_edicao = -1;
                                        if (tarefa_escolhida != null) {
                                            while (escolha_menu_edicao != 0) {
                                                System.out.println("\nTarefa selecionada: \n" + tarefa_escolhida);
                                                System.out.println("\nAlterar \n1- Título" +
                                                        "\n2- Descrição" +
                                                        "\n3- Data" +
                                                        "\n4- Notificações" +
                                                        "\n5- Definir Prioridade" +
                                                        "\n\n6- Confirmar alterações\n7- Excluir tarefa\n0- Voltar");
                                                escolha_menu_edicao = input.nextInt();
                                                input.nextLine();

                                                switch (escolha_menu_edicao) {
                                                    case 0:
                                                        break;

                                                    case 1:
                                                        System.out.println("Título atual: " + tarefa_escolhida.getTitulo());
                                                        System.out.println("Novo título: ");
                                                        tarefa_escolhida.setTitulo(input.nextLine());
                                                        escolha_menu_edicao = -1;
                                                        break;

                                                    case 2:
                                                        System.out.println("Descrição atual: " + tarefa_escolhida.getDescricao());
                                                        System.out.println("Nova descrição: ");
                                                        tarefa_escolhida.setDescricao(input.nextLine());
                                                        escolha_menu_edicao = -1;
                                                        break;

                                                    case 3:
                                                        System.out.println("Prazo atual: " + tarefa_escolhida.getDataPrazo());
                                                        System.out.println("Novo prazo: ");
                                                        tarefa_escolhida.setDataPrazo(input.nextLine());
                                                        escolha_menu_edicao = -1;
                                                        break;

                                                    case 4:
                                                        System.out.println("Notificações atualmente: " + tarefa_escolhida.isNotificacoes());
                                                        System.out.println("Deseja ativar as notificações? (s/n): ");
                                                        tarefa_escolhida.setNotificacoes(input.nextLine().equals("s"));
                                                        escolha_menu_edicao = -1;
                                                        break;

                                                    case 5:
                                                        System.out.println("Qual prioridade deseja definir para a tarefa?\n1- Baixa\n2- Média\n3- Alta");
                                                        int escolha_prioridade = input.nextInt();
                                                        input.nextLine();
                                                        switch (escolha_prioridade) {
                                                            case 1:
                                                                tarefa_escolhida.alterarPrioridade(Prioridade.BAIXA);
                                                                break;
                                                            case 2:
                                                                tarefa_escolhida.alterarPrioridade(Prioridade.MEDIA);
                                                                break;
                                                            case 3:
                                                                tarefa_escolhida.alterarPrioridade(Prioridade.ALTA);
                                                                break;
                                                            default:
                                                                System.out.println("\nEscolha inválida!");
                                                                break;
                                                        }

                                                        escolha_menu_edicao = -1;
                                                        break;

                                                    case 6:
                                                        cadastro.atualizarTarefa(tarefa_escolhida);
                                                        escolha_menu_edicao = 0;
                                                        break;

                                                    case 7:
                                                        System.out.println("Deseja realmente excluir a tarefa? (s/n)");
                                                        if (input.nextLine().equals("s")) {
                                                            cadastro.excluirTarefa(tarefa_escolhida.getIdT());
                                                            escolha_menu_edicao = 0;
                                                        }
                                                        break;

                                                    default:
                                                        System.out.println("\nEscolha inválida!");
                                                        escolha_menu_edicao = -1;
                                                        break;
                                                }
                                            }
                                        }
                                    }
                                    escolha_tarefa = -1;
                                    break;

                                case 3:
                                    System.out.println("\nLista de tarefas cadastradas: ");
                                    cadastro.listarTarefasDetalhado();
                                    escolha_tarefa = -1;
                                    break;

                                default:
                                    System.out.println("\nEscolha inválida!");
                                    escolha_tarefa = -1;
                                    break;
                            }
                        }
                        escolha_menu_principal = -1;
                        break;

                    case 3:
                        // Atribuir Pessoas

                        int escolha_tarefa_atribuir = -1;
                        while (escolha_tarefa_atribuir != 0) {
                            System.out.println("\nEscolha a tarefa:");
                            cadastro.listarTarefasSimplificado();
                            System.out.println("0- Voltar");
                            escolha_tarefa_atribuir = input.nextInt();
                            input.nextLine();

                            Tarefa tarefa_escolhida = cadastro.buscarTarefaPorId(escolha_tarefa_atribuir);
                            if (tarefa_escolhida != null) {
                                int escolha_atribuir = -1;
                                while (escolha_atribuir != 0) {
                                    System.out.println("\nTarefa selecionada: " + tarefa_escolhida.getTitulo());
                                    System.out.println("Supervisor: " + cadastro.mostrarNomeSupervisorTarefa(escolha_tarefa_atribuir));
                                    System.out.println("Membros: " + cadastro.mostrarNomeMembrosTarefa(escolha_tarefa_atribuir));

                                    System.out.println("\n1- Atribuir supervisor\n2- Atribuir Membros\n3- Remover Supervisor\n4- Remover Membros\n0- Voltar");
                                    escolha_atribuir = input.nextInt();
                                    input.nextLine();

                                    switch (escolha_atribuir) {
                                        case 0:
                                            break;

                                        case 1:
                                            int escolha_supervisor;
                                            System.out.println("\nQual supervisor deseja atribuir à tarefa?");
                                            cadastro.listarSupervisoresSimplificado();
                                            System.out.println("0- Voltar");
                                            escolha_supervisor = input.nextInt();
                                            input.nextLine();

                                            if (escolha_supervisor != 0) {
                                                Pessoa supervisor_escolhido = cadastro.buscarSupervisorPorId(escolha_supervisor);
                                                if ((Supervisor) supervisor_escolhido != null) {
                                                    tarefa_escolhida.setIdS(escolha_supervisor);
                                                    cadastro.atribuirSupervisorTarefa(escolha_tarefa_atribuir, escolha_supervisor);
                                                } else {
                                                    System.out.println("\nSupervisor inválido!");
                                                }
                                            }

                                            escolha_atribuir = -1;
                                            break;

                                        case 2:
                                            int escolha_membro = -1;
                                            while (escolha_membro != 0) {
                                                System.out.println("\nMembros: " + cadastro.mostrarNomeMembrosTarefa(escolha_tarefa_atribuir));
                                                System.out.println("\nQual membro deseja atribuir à tarefa?");
                                                cadastro.listarMembrosSemTarefa();
                                                System.out.println("0- Voltar");
                                                escolha_membro = input.nextInt();
                                                input.nextLine();

                                                if (escolha_membro != 0) {
                                                    Pessoa membro_escolhido = cadastro.buscarMembroPorId(escolha_membro);
                                                    if (membro_escolhido != null && ((Membro) membro_escolhido).getIdT() == 0) {
                                                        ((Membro) membro_escolhido).setIdT(escolha_tarefa_atribuir);
                                                        cadastro.atribuirTarefaMembro(escolha_membro, escolha_tarefa_atribuir);
                                                    } else {
                                                        System.out.println("\nMembro inválido!");
                                                    }
                                                }
                                            }
                                            escolha_atribuir = -1;
                                            break;

                                        case 3:
                                            tarefa_escolhida.setIdS(0);
                                            cadastro.atualizarTarefa(tarefa_escolhida);
                                            System.out.println("\nSupervisor removido com sucesso!");

                                            escolha_atribuir = -1;
                                            break;

                                        case 4:
                                            int membro_para_remover = -1;
                                            while (membro_para_remover != 0) {
                                                System.out.println("\nMembros: " + cadastro.mostrarNomeMembrosTarefa(escolha_tarefa_atribuir));
                                                System.out.println("\nQual membro deseja remover da tarefa?");
                                                cadastro.listarIdMembrosTarefa(escolha_tarefa_atribuir);
                                                System.out.println("0- Voltar");
                                                membro_para_remover = input.nextInt();
                                                input.nextLine();

                                                if (membro_para_remover != 0) {
                                                    Pessoa obj_membro_para_remover = cadastro.buscarMembroPorId(membro_para_remover);
                                                    if (obj_membro_para_remover != null && ((Membro) obj_membro_para_remover).getIdT() == escolha_tarefa_atribuir) {
                                                        ((Membro) obj_membro_para_remover).setIdT(0);
                                                        cadastro.atualizarMembro((Membro) obj_membro_para_remover);
                                                        System.out.println("\nMembro removido com sucesso!");
                                                    } else {
                                                        System.out.println("\nMembro inválido!");
                                                    }
                                                }
                                            }
                                            escolha_atribuir = -1;
                                            break;

                                        default:
                                            escolha_atribuir = -1;
                                            System.out.println("Escolha inválida!");
                                            break;
                                    }
                                }
                            }

                        }
                        escolha_menu_principal = -1;
                        break;


                    case 4:
                        calendario.exibirCalendario(cadastro.getListaTarefas());
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
        input.close();
    }
}