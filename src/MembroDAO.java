import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembroDAO {
    private Connection connection;

    public MembroDAO() {
        this.connection = new Conexao().GeraConexao();
    }

    public void adiciona(Membro membro) {
        String sql = "INSERT INTO Membro(idM, nome, cargo) VALUES(?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, membro.getIdM());
            stmt.setString(2, membro.getNome());
            stmt.setString(3, membro.getCargo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Membro buscaPorIdDAO(int idM) {
        String sql = "SELECT * FROM Membro WHERE idM=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idM);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Membro membro = new Membro();
                membro.setIdM(rs.getInt("idM"));
                membro.setNome(rs.getString("nome"));
                membro.setCargo(rs.getString("cargo"));
                membro.setIdT(rs.getInt("idT"));
                return membro;
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void atualizarMembroDAO(Membro membro) {
        String sql = "UPDATE Membro SET nome=?, cargo=?, idT=? WHERE idM=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, membro.getNome());
            stmt.setString(2, membro.getCargo());

            if (membro.getIdT() == 0) {
                stmt.setNull(3, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(3, membro.getIdT());
            }

            stmt.setInt(4, membro.getIdM());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirMembroDAO(int idM) {
        String sql = "DELETE FROM Membro WHERE idM=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idM);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Membro> listarMembrosDAO() {
        ArrayList<Membro> membros = new ArrayList<>();
        String sql = "SELECT * FROM Membro";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Membro membro = new Membro();
                membro.setIdM(rs.getInt("idM"));
                membro.setNome(rs.getString("nome"));
                membro.setCargo(rs.getString("cargo"));
                membro.setIdT(rs.getInt("idT"));
                membros.add(membro);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return membros;
    }

    public void atribuirTarefaMembroDAO(int idM, int idT) {
        String sql = "UPDATE Membro SET idT=? WHERE idM=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idT);
            stmt.setInt(2, idM);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
