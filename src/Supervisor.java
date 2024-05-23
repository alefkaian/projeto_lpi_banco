public class Supervisor extends Pessoa{
    private int grauHierarquia;
    private String departamento;
    private int idS;

    public Supervisor(){
    }

    public Supervisor(String nome, int grauHierarquia, String departamento) {
        super(nome);
        this.grauHierarquia = grauHierarquia;
        this.departamento = departamento;
    }

    public int getGrauHierarquia() {
        return grauHierarquia;
    }

    public void setGrauHierarquia(int grauHierarquia) {
        this.grauHierarquia = grauHierarquia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    @Override
    public String toString() {
        return "Supervisor(" +
                "IdS: " + this.idS +
                ", Nome: " + super.getNome() +
                ", Grau de Hierarquia: " + this.grauHierarquia +
                ", Departamento: " + this.departamento + ")";
    }
}

