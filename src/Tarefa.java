
public class Tarefa {
    private int id;
    private String nome;
    private String dataPrazo;
    private String descricao;
    private boolean notificacoes;

    public Tarefa(){

    }

    // Construtor
    public Tarefa(String nome, String dataPrazo, String descricao, boolean notificacoes) {
        this.nome = nome;
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
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataPrazo='" + dataPrazo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", notificacoes=" + notificacoes +
                '}';
    }
}
