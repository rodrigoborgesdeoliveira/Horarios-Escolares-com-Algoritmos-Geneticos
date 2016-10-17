/*
 * Algoritmo para modificação da população.
 */
package gerenciarhorarios;

import database.DataAccessObject;
import java.util.Random;

/**
 *
 * @author Rodrigo
 */
public class Algoritmo {

    private static double taxaCrossover;
    private static double taxaMutacao;

    public static void setTaxaCrossover(double taxaCrossover) {
        Algoritmo.taxaCrossover = taxaCrossover;
    }

    public static double getTaxaCrossover() {
        return taxaCrossover;
    }

    public static void setTaxaMutacao(double taxaMutacao) {
        Algoritmo.taxaMutacao = taxaMutacao;
    }

    public static double getTaxaMutacao() {
        return taxaMutacao;
    }

    public static Populacao gerarNovaGeracao(Populacao populacao, boolean elitismo) {
        Random r = new Random();
        int idTurma = populacao.getMelhorIndividuo().getIDTurma();

        //Nova população de indivíduos vazios com o mesmo tamanho da antiga.
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao());

        //Se elitismo = true, manter o melhor indivíduo da geração anterior.
        if (elitismo) {
            novaPopulacao.setIndividuo(populacao.getMelhorIndividuo());
        }

        //Inserir novos indivíduos na nova população, até atingir o tamanho máximo.
        while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {
            //Seleciona o pais por seleção torneio.
            Individuo[] pais = new Individuo[2];
            pais = retornaIndividuos(selecaoTorneio(populacao));
            
            Individuo[] filhos = new Individuo[2];

            //Faz ou não o cruzamento (crossover) segundo a taxa de crossover.
            //Se não fizer o crossover, os pais serão parte da nova geração.
            if (r.nextDouble() <= taxaCrossover) {
                filhos = retornaIndividuos(crossover(pais[1], pais[0], novaPopulacao));
            } else {
                filhos[0] = new Individuo(pais[0].getGenes(), idTurma, pais[0].getQtdAlelosVazios(), novaPopulacao);
                filhos[1] = new Individuo(pais[1].getGenes(), idTurma, pais[1].getQtdAlelosVazios(), novaPopulacao);
            }

            //Adiciona os filhos na nova geração.
            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);
        }
        
        novaPopulacao.ordenarPopulacao();
        return novaPopulacao;
    }

    public static Individuo[] crossover(Individuo individuo1, Individuo individuo2, Populacao novaPopulacao) {
        Random r = new Random();

        //Sorteia o ponto de corte.
        int pontoCorte1 = r.nextInt((individuo1.getGenes().length / 2) - 2) + 1;
        int pontoCorte2 = r.nextInt((individuo1.getGenes().length / 2) - 2) + (individuo1.getGenes().length / 2);

        Individuo[] filhos = new Individuo[2];

        //pega os genes dos pais
        int[] genesPai1 = individuo1.getGenes();
        int[] genesPai2 = individuo2.getGenes();

        //Possuirão os mesmos genes que o pai entre 0 e o pontoCorte1, e entre pontoCorte2 e o final.
        int[] genesFilho1 = genesPai1;
        int[] genesFilho2 = genesPai2;

        //Realiza o corte e distribui os genes dos pais. 
        //Genes entre pontoCorte1 e pontoCorte2.
        for (int i = pontoCorte1; i < pontoCorte2; i++) {
            genesFilho1[i] = genesPai2[i];
            genesFilho2[i] = genesPai1[i];
        }

        //Cria os novos indivíduos com os genes dos pais.
        filhos[0] = new Individuo(genesFilho1, individuo1.getIDTurma(), individuo1.getQtdAlelosVazios(), novaPopulacao);
        filhos[1] = new Individuo(genesFilho2, individuo2.getIDTurma(), individuo2.getQtdAlelosVazios(), novaPopulacao);

        return filhos;
    }

    public static Individuo[] selecaoTorneio(Populacao populacao) {
        Random r = new Random();

        Populacao populacaoIntermediaria = new Populacao(3);

        //Seleciona três indivíduos aleatórios da população e insere na populacao intermediária.
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(populacao.getTamPopulacao())));
        populacaoIntermediaria.setIndividuo(populacao.getIndividuo(r.nextInt(populacao.getTamPopulacao())));

        //Ordena a população por ordem de melhor aptidao.
        populacaoIntermediaria.ordenarPopulacao();

        Individuo[] pais = new Individuo[2];

        //Os pais serão os dois melhores indivíduos da população intermediária.
        pais[0] = new Individuo(populacaoIntermediaria.getIndividuo(0));
        pais[1] = new Individuo(populacaoIntermediaria.getIndividuo(1));

        return pais;
    }

    //Cria indivíduos a partir de outros indivíduos.
    public static Individuo[] retornaIndividuos(Individuo[] individuosBase) {
        Individuo[] individuos = new Individuo[individuosBase.length];
        for (int i = 0; i < individuosBase.length; i++) {
            individuos[i] = new Individuo(individuosBase[i]);
        }

        return individuos;
    }
}
