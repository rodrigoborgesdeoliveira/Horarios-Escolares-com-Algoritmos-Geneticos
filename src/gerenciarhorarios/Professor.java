/*
 * Classe professor de cada disciplina. Cada professor possui suas restrições e
 * leciona uma ou mais disciplinas.
 */
package gerenciarhorarios;

/**
 *
 * @author Rodrigo
 */
public class Professor {
    private String nome; //nome do professor.
    private int id; //id do professor.
    private char[] restricoes = new char[96]; // Indiponibilidades de horário do professor.
    /* Quantidade de horários: matutino = 36, vespertino = 36, noturno = 24.
       Total de horários em uma semana = 96 horários.
    */
    public Professor(String nome) {
        this.nome = nome;
        //Define-se que inicialmente o professor não possui restrições. restricoes = 0.
        for (int i = 0; i < restricoes.length; i++) {
            restricoes[i] = '0';            
        }
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
        
    public String getNome() {
        return nome;
    }

    public void setID(int id){
        this.id = id;
    }
    
    public int getID() {
        return id;
    }
    
    public void setRestricoes(char[] r){
        restricoes = r;
    }
    
    public char[] getRestricoes(){
        return restricoes;
    }
}
