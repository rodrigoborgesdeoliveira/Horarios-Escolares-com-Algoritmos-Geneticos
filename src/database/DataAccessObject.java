/*
 * Classe com métodos para fazer o CRUD (CREATE, READ, UPDATE, DELETE) com o banco de dados.
 */
package database;

import gerenciarhorarios.Aula;
import gerenciarhorarios.Disciplina;
import gerenciarhorarios.Professor;
import gerenciarhorarios.Turma;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class DataAccessObject {

    public static Connection con = null;
    public static PreparedStatement stmt = null;
    public static ResultSet rs = null;

    //Criar as tabelas caso não existam.
    public static void createTables() {
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        String SQLProfessor = "CREATE TABLE IF NOT EXISTS professor ("
                + "id INT NOT NULL AUTO_INCREMENT, "
                + "nome VARCHAR(50) NOT NULL, "
                + "restricoes VARCHAR(96),"
                + "PRIMARY KEY(id));";
        String SQLDisciplina = "CREATE TABLE IF NOT EXISTS disciplina ("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "PRIMARY KEY(id),"
                + "nome VARCHAR(45) NOT NULL,"
                + "qtd_aulas_semanais INT NOT NULL,"
                + "professor_id INT NOT NULL,"
                //                + "INDEX fk_professor_id(professor_id ASC),"
                //                + "CONSTRAINT fk_professor_id"
                + "FOREIGN KEY(professor_id) REFERENCES professor(id));";
        String SQLTurma = "CREATE TABLE IF NOT EXISTS turma("
                + "id INT NOT NULL AUTO_INCREMENT,"
                + "PRIMARY KEY(id),"
                + "curso VARCHAR(45),"
                + "nivel_ensino VARCHAR(45) NOT NULL,"
                + "nome VARCHAR(45) NOT NULL,"
                + "ano INT NOT NULL,"
                + "turno VARCHAR(45) NOT NULL,"
                + "janelamento_disciplinas BOOLEAN,"
                + "dias_semana VARCHAR(6),"
                + "aulas_geminadas BOOLEAN,"
                + "sem_aulas_geminadas BOOLEAN);";
        String SQLAula = "CREATE TABLE IF NOT EXISTS aula("
                + "disciplina_id INT NOT NULL,"
                + "turma_id INT NOT NULL,"
                + "PRIMARY KEY(disciplina_id,turma_id),"
                //                + "INDEX fk_disciplina_id(disciplina_id ASC),"
                //                + "CONSTRAINT fk_disciplina_id"
                + "FOREIGN KEY(disciplina_id) REFERENCES disciplina(id),"
                //                + "INDEX fk_turma_id(turma_id ASC),"
                //                + "CONSTRAINT fk_turma_id"
                + "FOREIGN KEY(turma_id) REFERENCES turma(id),"
                + "turma_conjunta_id INT,"
                //                + "INDEX fk_turma_conjunta_id(turma_conjunta_id ASC),"
                //                + "CONSTRAINT fk_turma_conjunta_id"
                + "FOREIGN KEY(turma_conjunta_id) REFERENCES turma(id));";
        String SQLHorario = "CREATE TABLE IF NOT EXISTS horario("
                + "posicao INT NOT NULL,"
                + "turma_id INT NOT NULL,"
                + "disciplina_id INT,"
                //                + "INDEX fk_horario_turma_id(turma_id ASC),"
                //                + "CONSTRAINT fk_horario_turma_id"
                + "FOREIGN KEY(turma_id) REFERENCES turma(id),"
                //                + "INDEX fk_horario_disciplina_id(disciplina_id ASC),"
                //                + "CONSTRAINT fk_horario_disciplina_id"
                + "FOREIGN KEY(disciplina_id) REFERENCES disciplina(id));";

        try {
            stmt = con.prepareStatement(SQLProfessor);
            stmt.executeUpdate();
            stmt = con.prepareStatement(SQLDisciplina);
            stmt.executeUpdate();
            stmt = con.prepareStatement(SQLTurma);
            stmt.executeUpdate();
            stmt = con.prepareStatement(SQLAula);
            stmt.executeUpdate();
            stmt = con.prepareStatement(SQLHorario);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método createTables", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Inserir o professor no banco.
    public static void insert(Professor p) {
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO professor (nome, restricoes) VALUES (?,?);");
            stmt.setString(1, p.getNome());
            String restricoes = new String(p.getRestricoes());
            stmt.setString(2, restricoes);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método insertProfessor", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Inserir a disciplina no banco.
    public static void insert(Disciplina d) {
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO disciplina (nome, qtd_aulas_semanais, professor_id) VALUES (?,?,?);");
            stmt.setString(1, d.getNome());
            stmt.setInt(2, d.getQtdAulasSemanais());
            stmt.setInt(3, d.getIdProfessor());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método insertDisciplina", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Inserir a turma no banco.
    public static void insert(Turma t) {
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO turma (curso, nivel_ensino, nome, ano, turno, janelamento_disciplinas,"
                    + " dias_semana, aulas_geminadas, sem_aulas_geminadas) VALUES (?,?,?,?,?,?,?,?,?);");
            stmt.setString(1, t.getCurso());
            stmt.setString(2, t.getNivelEnsino());
            stmt.setString(3, t.getNome());
            stmt.setInt(4, t.getAno());
            stmt.setString(5, t.getTurno());
            stmt.setBoolean(6, t.getJanelamentoDisciplinas());
            String diasSemana = new String(t.getDiasSemana());
            stmt.setString(7, diasSemana);
            stmt.setBoolean(8, t.getAulasGeminadas());
            stmt.setBoolean(9, t.getSemAulasGeminadas());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método insertTurma", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Inserir a aula no banco.
    public static void insert(Aula a) {
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO aula (disciplina_id, turma_id, turma_conjunta_id) VALUES (?,?,null);");
            stmt.setInt(1, a.getIDDisciplina());
            stmt.setInt(2, a.getIDTurma());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método insertAula", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Inserir horários de uma turma no banco.
    public static void insertHorario(Turma t) {
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;

        int[] horario = t.getHorarioTurma();
        try {
            for (int i = 0; i < horario.length; i++) {
                if (horario[i] != 0) { //Se for uma aula vazia, deixar disciplina como valor nulo no banco de dados.
                    stmt = con.prepareStatement("INSERT INTO horario (posicao, turma_id, disciplina_id) VALUES"
                            + " (?,?,?);");
                    stmt.setInt(1, i);
                    stmt.setInt(2, t.getID());
                    stmt.setInt(3, horario[i]);
                } else {
                    stmt = con.prepareStatement("INSERT INTO horario (posicao, turma_id) VALUES"
                            + " (?,?);");
                    stmt.setInt(1, i);
                    stmt.setInt(2, t.getID());
                }
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método insertHorario", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Retorna o professor pelo id fornecido.
    public static Professor getProfessorByID(int id) {
        Professor professor = null;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM professor WHERE id LIKE ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            rs.next();
            professor = new Professor(rs.getString(2));
            professor.setID(rs.getInt(1));
            professor.setRestricoes(rs.getString(3).toCharArray());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getProfessorByID", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return professor;
    }

    //Retorna a disciplina pelo id fornecido.
    public static Disciplina getDisciplinaByID(int id) {
        Disciplina disciplina = null;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM disciplina WHERE id LIKE ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            rs.next();
            disciplina = new Disciplina(rs.getString(2), rs.getInt(3), rs.getInt(4));
            disciplina.setID(rs.getInt(1));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getDisciplinaByID", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return disciplina;
    }

    //Retorna a turma pelo id fornecido.
    public static Turma getTurmaByID(int id) {
        Turma turma = null;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM turma WHERE id LIKE ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            rs.next();
            turma = new Turma(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            turma.setID(rs.getInt(1));
            turma.setJanelamentoDisciplinas(rs.getBoolean(7));
            turma.setDiasSemana(rs.getString(8).toCharArray());
            turma.setAulasGeminadas(rs.getBoolean(9));
            turma.setSemAulasGeminadas(rs.getBoolean(10));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getTurmaByID", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return turma;
    }

    //Retorna as aulas de uma turma especificada pelo id.
    public static ArrayList<Aula> getAulasByIDTurma(int id) {
        Aula aula = null;
        ArrayList<Aula> aulas = new ArrayList<>();
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM aula WHERE turma_id LIKE ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                aula = new Aula();
                aula.setIDDisciplina(rs.getInt(1));
                aula.setIDTurma(rs.getInt(2));
                if (rs.getString(3) == null) {
                    aula.setIDTurmaConjunta(0); //Não possui turma conjunta.
                } else {
                    aula.setIDTurmaConjunta(rs.getInt(3));
                }
                aulas.add(aula);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getAulasByIDTurma", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aulas;
    }

    //Retorna as aulas que possuem um dado id de disciplina.
    public static ArrayList<Aula> getAulasByIDDisciplina(int id) {
        Aula aula = null;
        ArrayList<Aula> aulas = new ArrayList<>();
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM aula WHERE disciplina_id LIKE ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                aula = new Aula();
                aula.setIDDisciplina(rs.getInt(1));
                aula.setIDTurma(rs.getInt(2));
                if (rs.getString(3) == null) {
                    aula.setIDTurmaConjunta(0); //Não possui turma conjunta.
                } else {
                    aula.setIDTurmaConjunta(rs.getInt(3));
                }
                aulas.add(aula);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getAulasByIDDisciplina", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aulas;
    }

    public static Turma getHorarioTurma(int idTurma) {
        Turma turma = DataAccessObject.getTurmaByID(idTurma);
        int[] horario;
        stmt = null;
        rs = null;
        String turno = turma.getTurno();

        if (turno.equals("Matutino") || turno.equals("Vespertino")) {
            //Matutino ou vespertino.
            horario = new int[36];
        } else {
            //Noturno
            horario = new int[24];
        }

        try {
            stmt = con.prepareStatement("SELECT * FROM horario WHERE turma_id = (?);");
            stmt.setInt(1, idTurma);
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getString(3) == null) {
                    //Se for nulo, não há disciplinas nessa posição do horário.
                    //ID disciplina = 0.
                    horario[rs.getInt(1)] = 0; //rs.getInt(1) = coluna posicao.                    
                } else {
                    horario[rs.getInt(1)] = rs.getInt(3); //rs.getInt(3) = coluna disciplina_id.
                }
            }

            turma.setHorarioTurma(horario);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getHorarioTurma", JOptionPane.ERROR_MESSAGE);
        }

        return turma;
    }

    public static ArrayList<Disciplina> getDisciplinasByIDProfessor(int idProfessor) {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disciplina = null;
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM disciplina WHERE professor_id = (?);");
            stmt.setInt(1, idProfessor);
            rs = stmt.executeQuery();

            while (rs.next()) {
                disciplina = new Disciplina(rs.getString(2), rs.getInt(3), rs.getInt(4));
                disciplina.setID(rs.getInt(1));
                disciplinas.add(disciplina);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getDisciplinasByIDProfessor", JOptionPane.ERROR_MESSAGE);
        }

        return disciplinas;
    }

    public static boolean turmaTemHorario(int id) {
        boolean turmaTemHorario = false;
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM horario WHERE turma_id = (?);");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                turmaTemHorario = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método turmaTemHorario", JOptionPane.ERROR_MESSAGE);
        }

        return turmaTemHorario;
    }

    public static boolean turmaExiste(String curso, String nivelEnsino, String nome,
            int ano, String turno) {
        boolean turmaExiste = false;
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM turma WHERE (curso, "
                    + "nivel_ensino, nome, ano, turno) = (?,?,?,?,?);");
            stmt.setString(1, curso);
            stmt.setString(2, nivelEnsino);
            stmt.setString(3, nome);
            stmt.setInt(4, ano);
            stmt.setString(5, turno);
            rs = stmt.executeQuery();

            if (rs.next()) {
                turmaExiste = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método turmaExiste", JOptionPane.ERROR_MESSAGE);
        }

        return turmaExiste;
    }

    public static void removeHorarioByIDTurma(int id) {
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("DELETE FROM horario "
                    + "WHERE turma_id = (?);");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método removeHorarioByIDTurma", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Retorna os professores armazenados na tabela professor em ordem crescente.
    public static ArrayList<Professor> getProfessores() {
        ArrayList<Professor> professores = new ArrayList<>();
        Professor professor;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM professor ORDER BY nome ASC;"); //Pega todos os elementos da tabela professor
            //com o nome em ordem crescente.
            rs = stmt.executeQuery();
            while (rs.next()) { //Pegar os elementos do ResultSet e colocar no ArrayList.
                professor = new Professor(rs.getString(2));
                professor.setID(rs.getInt(1));
                professor.setRestricoes(rs.getString(3).toCharArray());
                professores.add(professor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getProfessores", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return professores;
    }

    //Retorna as disciplinas armazenadas na tabela disciplina em ordem crescente.
    public static ArrayList<Disciplina> getDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disciplina = null;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM disciplina ORDER BY nome ASC;"); //Pega todos os elementos da tabela disciplina
            //com o nome em ordem crescente.
            rs = stmt.executeQuery();
            while (rs.next()) { //Pegar os elementos do ResultSet e colocar no ArrayList.
                disciplina = new Disciplina(rs.getString(2), rs.getInt(3), rs.getInt(4));
                disciplina.setID(rs.getInt(1));
                disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getDisciplinas", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return disciplinas;
    }

    //Retorna as turmas armazenadas na tabela turma em ordem crescente.
    public static ArrayList<Turma> getTurmas() {
        ArrayList<Turma> turmas = new ArrayList<>();
        Turma turma = null;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            //Pega todos os elementos da tabela turma com o nome do curso, 
            //nível de ensino, ano e nome da turma em ordem crescente.
            stmt = con.prepareStatement("SELECT * FROM turma ORDER BY curso, nivel_ensino, ano, nome, turno ASC;");

            rs = stmt.executeQuery();
            while (rs.next()) { //Pegar os elementos do ResultSet e colocar no ArrayList.
                turma = new Turma(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                turma.setID(rs.getInt(1));
                turma.setJanelamentoDisciplinas(rs.getBoolean(7));
                turma.setDiasSemana(rs.getString(8).toCharArray());
                turma.setAulasGeminadas(rs.getBoolean(9));
                turma.setSemAulasGeminadas(rs.getBoolean(10));
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getTurmas", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return turmas;
    }

    //Retorna as turmas de um dado curso.
    public static ArrayList<Turma> getTurmasByCurso(String curso) {
        ArrayList<Turma> turmas = new ArrayList<>();
        Turma turma = null;
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM turma WHERE curso = (?) ORDER BY curso, ano, nome, turno ASC;");
            stmt.setString(1, curso);
            rs = stmt.executeQuery();

            while (rs.next()) {
                turma = new Turma(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                turma.setID(rs.getInt(1));
                turma.setJanelamentoDisciplinas(rs.getBoolean(7));
                turma.setDiasSemana(rs.getString(8).toCharArray());
                turma.setAulasGeminadas(rs.getBoolean(9));
                turma.setSemAulasGeminadas(rs.getBoolean(10));
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getTurmasByCurso", JOptionPane.ERROR_MESSAGE);
        }

        return turmas;
    }

    //Retorna as turmas de um dado nível de ensino.
    public static ArrayList<Turma> getTurmasByNivelEnsino(String nivelEnsino) {
        ArrayList<Turma> turmas = new ArrayList<>();
        Turma turma = null;

        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM turma WHERE nivel_ensino = (?) ORDER BY curso, nivel_ensino,"
                    + " ano, nome, turno ASC;");
            stmt.setString(1, nivelEnsino);
            rs = stmt.executeQuery();

            while (rs.next()) {
                turma = new Turma(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                turma.setID(rs.getInt(1));
                turma.setJanelamentoDisciplinas(rs.getBoolean(7));
                turma.setDiasSemana(rs.getString(8).toCharArray());
                turma.setAulasGeminadas(rs.getBoolean(9));
                turma.setSemAulasGeminadas(rs.getBoolean(10));
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getTurmasByNivelEnsino", JOptionPane.ERROR_MESSAGE);
        }

        return turmas;
    }

    //Retorna as aulas armazenadas na tabela aula.
    public static ArrayList<Aula> getAulas() {
        ArrayList<Aula> aulas = new ArrayList<>();
        Aula aula = null;
        //Connection con = ConnectionFactory.getConnection();
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM aula;"); //Pega todos os elementos da tabela turma
            //com o nome do curso em ordem crescente.
            rs = stmt.executeQuery();
            while (rs.next()) { //Pegar os elementos do ResultSet e colocar no ArrayList.
                aula = new Aula();
                aula.setIDDisciplina(rs.getInt(1));
                aula.setIDTurma(rs.getInt(2));
                if (rs.getString(3) != null) {
                    aula.setIDTurmaConjunta(rs.getInt(3));
                } else {
                    aula.setIDTurmaConjunta(0); //Não possui turma conjunta.
                }
                aulas.add(aula);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getAulas", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aulas;
    }

    public static void update(Professor professor) {
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("UPDATE professor "
                    + "SET nome = (?), restricoes = (?) "
                    + "WHERE id = (?);");
            stmt.setString(1, professor.getNome());
            String restricoes = new String(professor.getRestricoes());
            stmt.setString(2, restricoes);
            stmt.setInt(3, professor.getID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método updateProfessor", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Turma turma) {
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("UPDATE turma SET curso = (?),"
                    + "nivel_ensino = (?), nome = (?), ano = (?),"
                    + "turno = (?), janelamento_disciplinas = (?), "
                    + "dias_semana = (?), aulas_geminadas = (?),"
                    + "sem_aulas_geminadas = (?) WHERE id = (?);");
            stmt.setString(1, turma.getCurso());
            stmt.setString(2, turma.getNivelEnsino());
            stmt.setString(3, turma.getNome());
            stmt.setInt(4, turma.getAno());
            stmt.setString(5, turma.getTurno());
            stmt.setBoolean(6, turma.getJanelamentoDisciplinas());
            stmt.setString(7, new String(turma.getDiasSemana()));
            stmt.setBoolean(8, turma.getAulasGeminadas());
            stmt.setBoolean(9, turma.getSemAulasGeminadas());
            stmt.setInt(10, turma.getID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método updateTurma", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void update(Aula aula) {
        stmt = null;
        rs = null;

        try {
            stmt = con.prepareStatement("UPDATE aula SET disciplina_id = (?), "
                    + "turma_id = (?), turma_conjunta_id = (?) WHERE (disciplina_id, turma_id) "
                    + "= (?,?);");
            stmt.setInt(1, aula.getIDDisciplina());
            stmt.setInt(2, aula.getIDTurma());
            if (aula.getIDTurmaConjunta() != 0) {
                //Possui turma conjunta.
                stmt.setInt(3, aula.getIDTurmaConjunta());
            } else{
                //Não possui.
                stmt.setString(3, null);
            }
            stmt.setInt(4, aula.getIDDisciplina());
            stmt.setInt(5, aula.getIDTurma());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método updateAula", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Retorna as posições de uma disciplina nos horários de todas as turmas.
    public static ArrayList<Integer> getPosicoesHorarioByIDDisciplina(int idDisciplina) {
        PreparedStatement stmtHorario = null;
        ResultSet rsHorario = null;
        ArrayList<Integer> posicoes = new ArrayList<>();

        try {
            stmtHorario = con.prepareStatement("SELECT * FROM horario WHERE disciplina_id = (?);");
            stmtHorario.setInt(1, idDisciplina);
            rsHorario = stmtHorario.executeQuery();

            while (rsHorario.next()) {
                //Fazer correção de acordo com o turno.
                Turma turma = DataAccessObject.getTurmaByID(rsHorario.getInt(2)); //rs.getInt(2) = coluna turma_id.

                int turmaAcrescimo; //Acréscimo para definir as restrições de acordo com o turno.
                switch (turma.getTurno()) {
                    case "Matutino":
                        turmaAcrescimo = 0;
                        break;
                    case "Vespertino":
                        turmaAcrescimo = 36;
                        break;
                    default:
                        //Noturno.
                        turmaAcrescimo = 72;
                        break;
                }

                posicoes.add(rsHorario.getInt(1) + turmaAcrescimo); //rs.getInt(1) = coluna posicao.
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getPosicoesHorarioByIDDisciplina", JOptionPane.ERROR_MESSAGE);
        } finally {
            //Fechar o ResultSet e o PreparedStatement.
            try {
                if (rsHorario != null) {
                    rsHorario.close();
                }
                if (stmtHorario != null) {
                    stmtHorario.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return posicoes;
    }

    //Retorna a turma conjunta de uma dada aula.
    public static int getIDTurmaConjunta(int idDisciplina, int idTurma) {
        stmt = null;
        rs = null;

        int idTurmaConjunta = 0;

        try {
            stmt = con.prepareStatement("SELECT turma_conjunta_id FROM aula WHERE (disciplina_id, "
                    + "turma_id) = (?,?);");
            stmt.setInt(1, idDisciplina);
            stmt.setInt(2, idTurma);

            rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getString(1) != null) {
                    idTurmaConjunta = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getIDTurmaConjunta", JOptionPane.ERROR_MESSAGE);
        }

        return idTurmaConjunta;
    }

    //Retorna ids de turmas que possuem uma dada turma como conjunta para uma determinada disciplina.
    public static ArrayList<Integer> getIDsTurmasByIDTurmaConjuntaIDDisciplina(int idTurmaConjunta, int idDisciplina) {
        stmt = null;
        rs = null;
        ArrayList<Integer> idsTurmas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT turma_id FROM aula WHERE "
                    + "(turma_conjunta_id, disciplina_id) = (?,?);");
            stmt.setInt(1, idTurmaConjunta);
            stmt.setInt(2, idDisciplina);

            rs = stmt.executeQuery();
            while (rs.next()) {
                idsTurmas.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.\n"
                    + ex.getMessage(), "Erro no método getIDsTurmasByIDTurmaConjunta", JOptionPane.ERROR_MESSAGE);
        }

        return idsTurmas;
    }

    public static void abrirConexao() {
        con = ConnectionFactory.getConnection();
    }

    public static void fecharConexao() {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }
}
