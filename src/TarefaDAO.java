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

    public Tarefa buscaPorIdDAO(int id) {
        String sql = "SELECT * FROM Tarefa WHERE idT=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idT"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataPrazo(rs.getString("dataPrazo"));
                tarefa.setNotificacoes(rs.getBoolean("notificacoes"));
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
        String sql = "UPDATE Tarefa SET titulo=?, descricao=?, dataPrazo=?, notificacoes=? WHERE idT=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataPrazo());
            stmt.setBoolean(4, tarefa.isNotificacoes());
            stmt.setInt(5, tarefa.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirTarefaDAO(int id) {
        String sql = "DELETE FROM Tarefa WHERE idT=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Tarefa> listarTarefasDAO() {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM Tarefa";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("idT"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataPrazo(rs.getString("dataPrazo"));
                tarefa.setNotificacoes(rs.getBoolean("notificacoes"));
                tarefas.add(tarefa);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tarefas;
    }
}