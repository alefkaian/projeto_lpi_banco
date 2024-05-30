public class Membro extends Pessoa{
    private String cargo;
    private int idM;

    private int idT;

    public Membro(){

    }

    public Membro(String nome, String cargo) {
        super(nome);
        this.cargo = cargo;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    @Override
    public String toString() {
        return "Membro(" +
                "IdM: " + this.idM +
                ", Nome: " + super.getNome() +
                ", Cargo: " + this.cargo +
                ", idT: " + this.idT + ")";
    }
}
