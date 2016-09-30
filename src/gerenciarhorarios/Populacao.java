/*
 * Criação e definição da população do algoritmo genético.
 */
package gerenciarhorarios;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class Populacao {
    private Individuo[] individuos;
    private int tamPopulacao;
    
    //Cria uma população a partir de outra população.
    public Populacao(Populacao populacaoBase){
        this.tamPopulacao = populacaoBase.tamPopulacao;
        this.individuos = new Individuo[tamPopulacao];
        for (int i = 0; i < this.tamPopulacao; i++) {
            this.individuos[i] = new Individuo(populacaoBase.individuos[i]);
        }
    }
    
    //Cria uma população com indivíduos aleatórios.
    public Populacao(int tamPopulacao, ArrayList<Disciplina> disciplinas, int idTurma){
        this.tamPopulacao = tamPopulacao;
        individuos = new Individuo[tamPopulacao];
        //Criação dos indivíduos.
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = new Individuo(disciplinas, idTurma);
        }
        ordenarPopulacao();
    }
    
    //Cria uma população com indivíduos vazios, que serão preenchidos depois.
    public Populacao(int tamPopulacao){
        this.tamPopulacao = tamPopulacao;        
        individuos = new Individuo[this.tamPopulacao];
        
        //Criação dos indivíduos vazios.
        for (int i = 0; i < individuos.length; i++) {
            individuos[i] = null;
        }
    }
    
    //Insere um indivíduo em dada posição da população.
    public void setIndividuo(Individuo individuo, int posicao){
        individuos[posicao] = new Individuo(individuo);
    }
    
    //Insere um indivíduo na primeira posição que estiver disponível na população (onde Indivíduo = null).
    public void setIndividuo(Individuo individuo){
        for (int i = 0; i < individuos.length; i++) {
            if(individuos[i] == null){
                individuos[i] = individuo;
                return;
            }            
        }
    }
    
    //Retorna o individuo de uma dada posição da população.
    public Individuo getIndividuo(int posicao){
        return individuos[posicao];
    }
    
    //Ordenar a população em ordem de aptidão. Menor aptidão primeiro, maior por último.
    public void ordenarPopulacao(){
        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < individuos.length; i++) {
                if (individuos[i].getAptidao() < individuos[i - 1].getAptidao()) {
                    Individuo temp = individuos[i];
                    individuos[i] = individuos[i - 1];
                    individuos[i - 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);        
    }
    
    //Retorna a quantidade de indivíduos não nulos.
    public int getNumIndividuos(){
        int n = 0;
        for (int i = 0; i < individuos.length; i++) {
            if(individuos[i] != null){
                n++;
            }            
        }
        return n;
    }
    
    //Retorna o indivíduo com melhor aptidão (Quanto menor, melhor).
    public Individuo getMelhorIndividuo(){
        ordenarPopulacao();
        return individuos[0];
    }
    
    //Retorna o tamanho da população.
    public int getTamPopulacao(){
        return tamPopulacao;
    }
}
