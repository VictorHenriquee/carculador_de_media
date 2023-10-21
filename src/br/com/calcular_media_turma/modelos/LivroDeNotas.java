package br.com.calcular_media_turma.modelos;

public class LivroDeNotas {

    private int numeroAlunos;
    private double mediaAluno;
    private double somaMedia;
    private double mediaTurma;


    public LivroDeNotas(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    public double getMediaAluno() {
        return mediaAluno;
    }

    public double getMediaTurma() {
        return mediaTurma;
    }

    public void calcularMediaDeCadaAluno(double a1, double a2, double a3) {
        mediaAluno = (a1 + a2 + a3) / 3;
        this.somaMedia += mediaAluno;
    }

    public void calcularMediaDaTurma() {
        mediaTurma = somaMedia / numeroAlunos;
    }
}

