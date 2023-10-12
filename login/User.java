package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Esta classe representa um usuário e fornece métodos para conectar-se a um banco de dados,
 * verificar a existência de um usuário e armazenar informações relacionadas ao usuário.
 */
public class User {

    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     * @return Uma instância de Connection que representa a conexão com o banco de dados.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do MySQL e instancia uma conexão com o banco de dados
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Tratamento de exceções, o que acontece em caso de erro
        }
        return conn;
    }

    /** Nome do usuário */
    public String nome = "";

    /** Resultado da verificação de usuário (verdadeiro ou falso) */
    public boolean result = false;

    /**
     * Verifica se um usuário com um login e senha fornecidos existe no banco de dados.
     * @param login O login do usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return Verdadeiro se o usuário for encontrado, falso caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Estabelece uma conexão com o banco de dados

        // Monta a instrução SQL para a consulta no banco de dados
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement(); // Cria uma instrução SQL
            ResultSet rs = st.executeQuery(sql); // Executa a consulta SQL

            if (rs.next()) {
                // Se houver resultados na consulta, define "result" como verdadeiro e armazena o nome encontrado
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Tratamento de exceções, o que acontece em caso de erro durante a consulta
        }
        return result;
    }
}
