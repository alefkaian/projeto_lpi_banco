
public class Tarefa {
    private int id;
    private String titulo;
    private String dataPrazo;
    private String descricao;
    private boolean notificacoes;

    // Construtor

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String dataPrazo, boolean notificacoes) {
        this.titulo = titulo;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(String dataPrazo) {
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

    @Override
    public String toString() {
        return "Tarefa(" +
                "Id: " + this.id +
                ", Título: " + this.titulo +
                ", Descrição: " + this.descricao +
                ", Prazo: " + this.dataPrazo +
                ", Notificações: " + isNotificacoes() + ")";

    }
}