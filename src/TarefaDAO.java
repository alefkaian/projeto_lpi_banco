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
        String sql = "INSERT INTO Tarefa(nome, descricao, dataprazo, notificacoes) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa.getNome());
            stmt.setString(2, tarefa.getDataPrazo());
            stmt.setString(3, tarefa.getDescricao());
            stmt.setBoolean(4, tarefa.isNotificacoes());
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
                tarefa.setId(rs.getInt("id"));
                tarefa.setNome(rs.getString("nome"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataPrazo(rs.getString("dataprazo"));
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
