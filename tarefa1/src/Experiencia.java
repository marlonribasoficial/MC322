public class Experiencia {
    Astronauta alvo;

    // para subir para o nivel 1: 60 xp
        //      - ganha 10 de vida
        //      - ganha 15 de oxigenio
        //      - ganha 15 de traje espacial

        // para subir para o nivel 2: 120 xp
        //      - ganha 20 de vida
        //      - ganha 15 de oxigenio
        //      - ganha 15 de traje espacial

        // para subir para o nivel 3: 180 xp
        //      - ganha 30 de vida
        //      - ganha 15 de oxigenio
        //      - ganha 15 de traje espacial

    // Construtor
    public Experiencia(Astronauta alvo) {
        this.alvo = alvo;
    }

    public void alterarNivel(Astronauta alvo) {
        if (alvo.exp >= 60 && alvo.exp < 120) {
            alvo.nivel = 1;

            alvo.pontosDeVida += 10;
            if (alvo.pontosDeVida > 120) alvo.pontosDeVida = 120;

            alvo.oxigenio += 15;
            if (alvo.oxigenio > 100) alvo.oxigenio = 100;

            alvo.trajeEspacial += 15;
            if (alvo.trajeEspacial > 100) alvo.trajeEspacial = 100;

            System.out.println("****************");
            System.out.println("A " + alvo.nome + " acaba de chegar ao nível " + alvo.nivel + " com " + alvo.exp + " de experiência");
            System.out.println("****************");

        } else if (alvo.exp >= 120 && alvo.exp < 180) {
            alvo.nivel = 2;

            alvo.pontosDeVida += 20;
            if (alvo.pontosDeVida > 120) alvo.pontosDeVida = 120;

            alvo.oxigenio += 15;
            if (alvo.oxigenio > 100) alvo.oxigenio = 100;

            alvo.trajeEspacial += 15;
            if (alvo.trajeEspacial > 100) alvo.trajeEspacial = 100;

            System.out.println("****************");
            System.out.println("A " + alvo.nome + " acaba de chegar ao nível " + alvo.nivel + " com " + alvo.exp + " de experiência");
            System.out.println("****************");
        } else if (alvo.exp >= 180) {
            alvo.nivel = 3;

            alvo.pontosDeVida += 30;
            if (alvo.pontosDeVida > 120) alvo.pontosDeVida = 120;

            alvo.oxigenio += 15;
            if (alvo.oxigenio > 100) alvo.oxigenio = 100;

            alvo.trajeEspacial += 15;
            if (alvo.trajeEspacial > 100) alvo.trajeEspacial = 100;

            System.out.println("****************");
            System.out.println("A " + alvo.nome + " acaba de chegar ao nível " + alvo.nivel + " com " + alvo.exp + " de experiência");
            System.out.println("****************");
        }
    }
}
