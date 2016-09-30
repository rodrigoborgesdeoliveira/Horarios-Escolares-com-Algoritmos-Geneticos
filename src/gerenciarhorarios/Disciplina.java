/*
 * Classe disciplina do horário. Cada disciplina é lecionada por um professor,
 * podendo um professor lecionar mais de uma disciplina.
 */
package gerenciarhorarios;

/**
 *
 * @author Rodrigo
 */
public class Disciplina {
    private int id;
    private String nome;
    private int qtdAulasSemanais;
    private int idProfessor;
        
    public Disciplina(String nome, int qtdAulasSemanais, int idProfessor){
        this.nome = nome;
        this.qtdAulasSemanais = qtdAulasSemanais;
        this.idProfessor = idProfessor;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setQtdAulasSemanais(int qtdAulasSemanais) {
        this.qtdAulasSemanais = qtdAulasSemanais;
    }

    public int getQtdAulasSemanais() {
        return qtdAulasSemanais;
    }
    
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdProfessor() {
        return idProfessor;
    }
}
