import java.time.LocalDate;

public class Tarefa {
    private int id;
    private String nome;
    private LocalDate dataPrazo;
    private String descricao;
    private boolean notificacoes;

    // Construtor
    public Tarefa(int id, String nome, LocalDate dataPrazo, String descricao, boolean notificacoes) {
        this.id = id;
        this.nome = nome;
        this.dataPrazo = dataPrazo;
        this.descricao = descricao;
        this.notificacoes = notificacoes;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(boolean notificacoes) {
        this.notificacoes = notificacoes;
    }

    // Método para imprimir detalhes da tarefa
    @Override
    public String toString() {
        return "Tarefa[id= " + id + ", nome= " + nome + ", data Prazo= " + dataPrazo + ", descricao= " + descricao + ", notificacoes=" + (notificacoes ? "Sim" : "Não") + ']';

    }

}

