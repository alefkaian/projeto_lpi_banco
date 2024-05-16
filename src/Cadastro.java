import java.util.ArrayList;

public class Cadastro {
    private TarefaDAO tarefaDAO;



    public Cadastro() {
        this.tarefaDAO = new TarefaDAO();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefaDAO.adiciona(tarefa);
        System.out.println("\nTarefa cadastrada com sucesso!");
    }

    public Tarefa buscarTarefaPorId(int id) {
        ArrayList<Tarefa> listaTarefas = tarefaDAO.listarTarefasDAO();
        for (Tarefa tarefa : listaTarefas){
            if (id == tarefa.getId()) return tarefaDAO.buscaPorIdDAO(id);
        }
        return null;
    }

    public void atualizarTarefa(Tarefa tarefa){
        tarefaDAO.atualizarTarefaDAO(tarefa);
        System.out.println("\nDados da tarefa atualizados com sucesso!");
    }

    public void excluirTarefa(int id){
        tarefaDAO.excluirTarefaDAO(id);
        System.out.println("\nTarefa excluída com sucesso!");
    }


    public void listarTarefasDetalhado() {
        ArrayList<Tarefa> listaTarefas = tarefaDAO.listarTarefasDAO();

        for (Tarefa tarefa : listaTarefas) {
            System.out.println("\n" + tarefa.toString());
        }
    }

    public void listarTarefasSimplificado() {
        ArrayList<Tarefa> listaTarefas = tarefaDAO.listarTarefasDAO();

        for (Tarefa tarefa : listaTarefas) {
            System.out.println(tarefa.getId() + "- " + tarefa.getTitulo());
        }
    }
}

