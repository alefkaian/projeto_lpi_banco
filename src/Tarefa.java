import java.util.SortedMap;

public class Tarefa {
    private int idT;
    private String titulo;
    private String dataPrazo;
    private String descricao;
    private boolean notificacoes;
    private String prioridade;
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public void alterarPrioridade(Calendario c, Prioridade p){
        switch (p){
            case BAIXA:
                this.dataPrazo = c.calcularNovaData(+14);
                this.prioridade = "baixa";
                System.out.println("\nPrioridade escolhida: BAIXA. Novo prazo: " + this.dataPrazo);
                break;
            case MEDIA:
                this.dataPrazo = c.calcularNovaData(+7);
                this.prioridade = "media";
                System.out.println("\nPrioridade escolhida: MEDIA. Novo prazo: " + this.dataPrazo);
                break;
            case ALTA:
                this.dataPrazo = c.calcularNovaData(+3);
                this.prioridade = "alta";
                System.out.println("\nPrioridade escolhida: ALTA. Novo prazo: " + this.dataPrazo);
                break;
            default:
                System.out.println("Não era pra estar aqui!");
                break;
        }
        if (this.notificacoes){
            System.out.println("E-mail enviado para SELECT * FROM Membro WHERE idT = (this.idT) e para (idS)");
        }
    }

    @Override
    public String toString() {
        return "Tarefa(" +
                "Id: " + this.idT +
                ", Título: " + this.titulo +
                ", Descrição: " + this.descricao +
                ", Prazo: " + this.dataPrazo +
                ", Notificações: " + this.notificacoes +
                ", Prioridade: " + this.prioridade +
                ", IdS: " + this.idS + ")";
    }
}