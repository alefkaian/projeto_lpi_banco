import java.util.ArrayList;

public class Cadastro {
    private TarefaDAO tarefaDAO;

    public Cadastro() {
        this.tarefaDAO = new TarefaDAO();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefaDAO.adiciona(tarefa);
        System.out.println("\nPessoa cadastrada com sucesso!");
    }

    /*public void excluirTarefa(int indice) {
        if (indice >= 0 && indice < listaTarefa.size()) {
            listaTarefa.remove(indice);
        } else {
            System.out.println("Índice inválido");
        }
    }
    */

    public void listarTarefas() {

        ArrayList<Tarefa> listaTarefas = tarefaDAO.listarTarefasDAO();

        for (Tarefa tarefa : listaTarefas) {
            System.out.println("\n" + tarefa.toString());
        }
    }
}


