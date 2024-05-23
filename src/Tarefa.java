
public class Tarefa {
    private int idT;
    private String titulo;
    private String dataPrazo;
    private String descricao;
    private boolean notificacoes;
    private int idS;

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
    public int getIdT() {
        return idT;
    }

    public void setIdT(int id) {
        this.idT = id;
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

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    @Override
    public String toString() {
        return "Tarefa(" +
                "Id: " + this.idT +
                ", Título: " + this.titulo +
                ", Descrição: " + this.descricao +
                ", Prazo: " + this.dataPrazo +
                ", Notificações: " + isNotificacoes() +
                ", IdS: " + this.idS + ")";

    }
}