import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupervisorDAO {
    private Connection connection;

    public SupervisorDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    public void adiciona(Supervisor supervisor) {
        String sql = "INSERT INTO Supervisor(idS, nome, grauHierarquia, departamento) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, supervisor.getIdS());
            stmt.setString(2, supervisor.getNome());
            stmt.setInt(3, supervisor.getGrauHierarquia());
            stmt.setString(4, supervisor.getDepartamento());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Supervisor buscaPorIdDAO(int idS) {
        String sql = "SELECT * FROM Supervisor WHERE idS=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idS);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Supervisor supervisor = new Supervisor();
                supervisor.setIdS(rs.getInt("idS"));
                supervisor.setNome(rs.getString("nome"));
                supervisor.setGrauHierarquia(rs.getInt("grauHierarquia"));
                supervisor.setDepartamento(rs.getString("departamento"));
                return supervisor;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void atualizarSupervisorDAO(Supervisor supervisor) {
        String sql = "UPDATE Supervisor SET nome=?, grauHierarquia=?, departamento=? WHERE idS=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, supervisor.getNome());
            stmt.setInt(2, supervisor.getGrauHierarquia());
            stmt.setString(3, supervisor.getDepartamento());
            stmt.setInt(4, supervisor.getIdS());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirSupervisorDAO(int idS) {
        String sql_tarefa = "UPDATE Tarefa SET idS = NULL WHERE idS = ?";
        String sql_supervisor = "DELETE FROM Supervisor WHERE idS = ?";

        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql_tarefa)) {
                stmt.setInt(1, idS);
                stmt.execute();
            }

            try (PreparedStatement stmt = connection.prepareStatement(sql_supervisor)) {
                stmt.setInt(1, idS);
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Supervisor> listarSupervisoresDAO() {
        ArrayList<Supervisor> supervisores = new ArrayList<>();
        String sql = "SELECT * FROM Supervisor";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Supervisor supervisor = new Supervisor();
                supervisor.setIdS(rs.getInt("idS"));
                supervisor.setNome(rs.getString("nome"));
                supervisor.setGrauHierarquia(rs.getInt("grauHierarquia"));
                supervisor.setDepartamento(rs.getString("departamento"));
                supervisores.add(supervisor);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supervisores;
    }
}
