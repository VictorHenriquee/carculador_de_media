package br.com.calcular_media_turma.principal;

import br.com.calcular_media_turma.modelos.LivroDeNotas;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        int numeroAlunos = 0;
        double a1 = 0;
        double a2 = 0;
        double a3 = 0;
        boolean verificacaoAlunos = false;
        boolean verificacaoNumeroNegativoAlunos = false;


        while (!verificacaoAlunos) {
            try {
                while (!verificacaoNumeroNegativoAlunos) {
                    numeroAlunos = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de alunos totais: "));
                    if (numeroAlunos > 0) {
                        verificacaoNumeroNegativoAlunos = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "O número de alunos deve ser um número maior do que 0");
                    }
                }
                verificacaoAlunos = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "O número de alunos deve ser um número inteiro");
            }
        }


        LivroDeNotas livroDeNotas = new LivroDeNotas(numeroAlunos);
        DecimalFormat oneDF = new DecimalFormat("#.#");

        for (int i = 1; i <= numeroAlunos; i++) {
            boolean verificacaoNotas = false;
            boolean verificacaoNotasNegativasELimite = false;
            while (!verificacaoNotas) {
                try {
                    while (!verificacaoNotasNegativasELimite) {
                        a1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da A1 do " + i + "º aluno: "));
                        a2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da A2 do " + i + "º aluno: "));
                        a3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da A3 do " + i + "º aluno: "));
                        if ((a1 >= 0 && a1 <= 30) && (a2 >= 0 && a2 <= 30) && (a3 >= 0 && a3 <= 40)) {
                            verificacaoNotasNegativasELimite = true;
                            livroDeNotas.calcularMediaDeCadaAluno(a1, a2, a3);
                            JOptionPane.showMessageDialog(null, "A média final desse aluno ficou em: " + oneDF.format(livroDeNotas.getMediaAluno()));
                        } else {
                            JOptionPane.showMessageDialog(null, """
                                    Os seguintes critérios precisam ser seguidos:
                                                        
                                    - Os valores não podem ser negativos.
                                    - A nota da A1 e A2 não podem ser maior do que 30.
                                    - A nota da a3 não pode ser maior do que 40.
                                                        
                                    Um desses critérios não foi seguido, por favor, verifique a sua resposta.
                                    """);

                        }
                    }
                    verificacaoNotas = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Somente números são aceitos neste campo");
                }
            }
        }

        livroDeNotas.calcularMediaDaTurma();

        JOptionPane.showMessageDialog(null, "A média da turma é: " + oneDF.format(livroDeNotas.getMediaTurma()));
    }
}
