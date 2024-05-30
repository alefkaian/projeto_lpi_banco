import java.util.ArrayList;

public class Cadastro {
    private TarefaDAO tarefaDAO;
    private SupervisorDAO supervisorDAO;
    private MembroDAO membroDAO;

    public Cadastro() {
        this.tarefaDAO = new TarefaDAO();
        this.supervisorDAO = new SupervisorDAO();
        this.membroDAO = new MembroDAO();
    }

    // Métodos para Tarefas
    public void adicionarTarefa(Tarefa tarefa) {
        tarefaDAO.adiciona(tarefa);
        System.out.println("\nTarefa cadastrada com sucesso!");
    }

    public Tarefa buscarTarefaPorId(int idT) {
        return tarefaDAO.buscaPorIdDAO(idT);
    }

    public void atualizarTarefa(Tarefa tarefa) {
        tarefaDAO.atualizarTarefaDAO(tarefa);
        System.out.println("\nDados da tarefa atualizados com sucesso!");
    }

    public void excluirTarefa(int idT) {
        tarefaDAO.excluirTarefaDAO(idT);
        System.out.println("\nTarefa excluída com sucesso!");
    }

    public ArrayList<Tarefa> getListaTarefas(){
        return tarefaDAO.listarTarefasDAO();
    }

    public void listarTarefasDetalhado() {
        ArrayList<Tarefa> listaTarefas = getListaTarefas();
        for (Tarefa tarefa : listaTarefas) {
            System.out.println("\n" + tarefa.toString());
        }
    }

    public void listarTarefasSimplificado() {
        ArrayList<Tarefa> listaTarefas = getListaTarefas();
        for (Tarefa tarefa : listaTarefas) {
            System.out.println(tarefa.getIdT() + "- " + tarefa.getTitulo());
        }
    }

    // Métodos para Supervisores
    public void adicionarSupervisor(Supervisor supervisor) {
        supervisorDAO.adiciona(supervisor);
        System.out.println("\nSupervisor cadastrado com sucesso!");
    }

    public Supervisor buscarSupervisorPorId(int idS) {
        return supervisorDAO.buscaPorIdDAO(idS);
    }

    public void atualizarSupervisor(Supervisor supervisor) {
        supervisorDAO.atualizarSupervisorDAO(supervisor);
        System.out.println("\nDados do supervisor atualizados com sucesso!");
    }

    public void excluirSupervisor(int idS) {
        supervisorDAO.excluirSupervisorDAO(idS);
        System.out.println("\nSupervisor excluído com sucesso!");
    }

    public void listarSupervisoresDetalhado() {
        ArrayList<Supervisor> listaSupervisores = supervisorDAO.listarSupervisoresDAO();
        for (Supervisor supervisor : listaSupervisores) {
            System.out.println("\n" + supervisor.toString());
        }
    }

    public void listarSupervisoresSimplificado() {
        ArrayList<Supervisor> listaSupervisores = supervisorDAO.listarSupervisoresDAO();
        for (Supervisor supervisor : listaSupervisores) {
            System.out.println(supervisor.getIdS() + "- " + supervisor.getNome());
        }
    }

    // Métodos para Membros
    public void adicionarMembro(Membro membro) {
        membroDAO.adiciona(membro);
        System.out.println("\nMembro cadastrado com sucesso!");
    }

    public Membro buscarMembroPorId(int idM) {
        return membroDAO.buscaPorIdDAO(idM);
    }

    public void atualizarMembro(Membro membro) {
        membroDAO.atualizarMembroDAO(membro);
        System.out.println("\nDados do membro atualizados com sucesso!");
    }

    public void excluirMembro(int idM) {
        membroDAO.excluirMembroDAO(idM);
        System.out.println("\nMembro excluído com sucesso!");
    }

    public void listarMembrosDetalhado() {
        ArrayList<Membro> listaMembros = membroDAO.listarMembrosDAO();
        for (Membro membro : listaMembros) {
            System.out.println("\n" + membro.toString());
        }
    }

    public void listarMembrosSimplificado() {
        ArrayList<Membro> listaMembros = membroDAO.listarMembrosDAO();
        for (Membro membro : listaMembros) {
            System.out.println(membro.getIdM() + "- " + membro.getNome());
        }
    }

    public void listarMembrosSemTarefa() {
        ArrayList<Membro> listaMembros = membroDAO.listarMembrosDAO();
        for (Membro membro : listaMembros) {
            if (membro.getIdT() == 0){
                System.out.println(membro.getIdM() + "- " + membro.getNome());
            }
        }
    }

    public String mostrarNomeSupervisorTarefa(int idT){
        Tarefa tarefa = buscarTarefaPorId(idT);
        if (tarefa != null){
            if (tarefa.getIdS() == 0) {
                return "";
            }
            else{
                return buscarSupervisorPorId(tarefa.getIdS()).getNome();
            }
        }
        else {
            return "";
        }
    }

    public String mostrarNomeMembrosTarefa(int idT){
        ArrayList<Membro> listaMembros = membroDAO.listarMembrosDAO();
        String nomeMembros = new String();
        for (Membro membro : listaMembros) {
            if (membro.getIdT() == idT) nomeMembros = nomeMembros.concat(membro.getNome() + ", ");
        }
        if (nomeMembros.equals("")){
            return nomeMembros;
        }
        else{
            return nomeMembros.substring(0, nomeMembros.length() - 2);
        }
    }

    public void listarIdMembrosTarefa(int idT) {
        ArrayList<Membro> listaMembros = membroDAO.listarMembrosDAO();
        for (Membro membro : listaMembros) {
            if (membro.getIdT() == idT) {
                System.out.println(membro.getIdM() + "- " + membro.getNome());
            }
        }
    }

    public void atribuirSupervisorTarefa(int idT, int idS) {
        tarefaDAO.atribuirSupervisorTarefaDAO(idT, idS);
        System.out.println("\nSupervisor <" + supervisorDAO.buscaPorIdDAO(idS).getNome() + "> adicionado a tarefa <" + tarefaDAO.buscaPorIdDAO(idT).getTitulo() + "> com sucesso!");
    }

    public void atribuirTarefaMembro(int idM, int idT) {
        membroDAO.atribuirTarefaMembroDAO(idM, idT);
        System.out.println("\nMembro <" + membroDAO.buscaPorIdDAO(idM).getNome() + "> adicionado à tarefa <" + tarefaDAO.buscaPorIdDAO(idT).getTitulo() + "> com sucesso!");
    }

}
