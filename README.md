# Projeto de Login de Usuário

Este é um projeto simples para autenticar um usuário em um banco de dados MySQL. Ele consiste em uma classe Java chamada `User` que oferece métodos para conectar-se ao banco de dados, verificar a existência de um usuário e armazenar informações relacionadas ao usuário.

## Como Funciona

O projeto é implementado em Java e utiliza o driver MySQL JDBC para estabelecer uma conexão com um banco de dados MySQL. Abaixo, explicamos o que acontece em cada parte do código:

- `User.java` é a classe principal que contém todos os métodos necessários.

- `conectarBD()` é um método que estabelece uma conexão com o banco de dados. O que acontece em cada linha deste método:

    - `Connection conn = null;`: Cria uma variável `conn` para armazenar a conexão com o banco de dados.

    - `Class.forName("com.mysql.cj.jdbc.Driver").newInstance();`: Carrega o driver MySQL JDBC para permitir a conexão com o banco de dados. Essa linha lança uma exceção se o driver não estiver disponível.

    - `String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";`: Define a URL do banco de dados, o nome de usuário e a senha para a conexão.

    - `conn = DriverManager.getConnection(url);`: Estabelece a conexão com o banco de dados usando a URL fornecida.

- `verificarUsuario(String login, String senha)` é um método que verifica se um usuário com um login e senha fornecidos existe no banco de dados. O que acontece em cada linha deste método:

    - `String sql = "";`: Cria uma string vazia para armazenar a instrução SQL.

    - `Connection conn = conectarBD();`: Chama o método `conectarBD()` para obter uma conexão com o banco de dados.

    - Monta a instrução SQL para a consulta, incluindo o login e a senha fornecidos.

    - `Statement st = conn.createStatement();`: Cria um objeto `Statement` para executar a instrução SQL no banco de dados.

    - `ResultSet rs = st.executeQuery(sql);`: Executa a consulta SQL e armazena os resultados em um objeto `ResultSet`.

    - `if (rs.next()) {`: Verifica se há resultados na consulta.

        - `result = true;`: Define a variável `result` como verdadeira para indicar que o usuário foi encontrado.

        - `nome = rs.getString("nome");`: Armazena o nome do usuário encontrado na variável `nome`.

- As variáveis `nome` e `result` são usadas para armazenar informações do usuário e o resultado da verificação.

- Os comentários de documentação foram adicionados para descrever a finalidade de classes, métodos e variáveis.



