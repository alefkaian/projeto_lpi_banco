import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarefaDAO {
    private Connection connection;

    public TarefaDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    public void adiciona(Tarefa tarefa) {
        String sql = "INSERT INTO Tarefa(titulo, descricao, dataPrazo, notificacoes) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataPrazo());
            stmt.setBoolean(4, tarefa.isNotificacoes());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tarefa buscaPorIdDAO(int idT) {
        String sql = "SELECT * FROM Tarefa WHERE idT=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idT);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setIdT(rs.getInt("idT"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataPrazo(rs.getString("dataPrazo"));
                tarefa.setNotificacoes(rs.getBoolean("notificacoes"));
                tarefa.setIdS(rs.getInt("idS"));
                return tarefa;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void atualizarTarefaDAO(Tarefa tarefa) {
        String sql = "UPDATE Tarefa SET titulo=?, descricao=?, dataPrazo=?, notificacoes=?, prioridade=?, idS=? WHERE idT=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataPrazo());
            stmt.setBoolean(4, tarefa.isNotificacoes());
            stmt.setString(5, tarefa.getPrioridade());

            if (tarefa.getIdS() == 0) {
                stmt.setNull(6, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(6, tarefa.getIdS());
            }

            stmt.setInt(7, tarefa.getIdT());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirTarefaDAO(int idT) {
        String sql_membro = "UPDATE Membro SET idT = NULL WHERE idt= ?";
        String sql_tarefa = "DELETE FROM Tarefa WHERE idT=?";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql_membro)) {

                stmt.setInt(1, idT);
                stmt.execute();
            }

            try (PreparedStatement stmt = connection.prepareStatement(sql_tarefa)) {

                stmt.setInt(1, idT);
                stmt.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Tarefa> listarTarefasDAO() {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT idT, titulo, descricao, dataPrazo, notificacoes, prioridade, idS FROM Tarefa";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setIdT(rs.getInt("idT"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataPrazo(rs.getString("dataPrazo"));
                tarefa.setNotificacoes(rs.getBoolean("notificacoes"));
                tarefa.setPrioridade(rs.getString("prioridade"));
                tarefa.setIdS(rs.getInt("idS")); // Adiciona o idS à Tarefa
                tarefas.add(tarefa);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tarefas;
    }

    public void atribuirSupervisorTarefaDAO(int idT, int idS) {
        String sql = "UPDATE Tarefa SET idS=? WHERE idT=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idS);
            stmt.setInt(2, idT);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}