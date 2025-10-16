package Motor;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class GerenciadorDePersistencia {

    /**
     * Salva a batalha em um arquivo XML
     * @param batalha Instância da batalha a ser salva
     * @param nomeArquivo Nome do arquivo
     */
    public static void salvarBatalha(Batalha batalha, String nomeArquivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(batalha, new File(nomeArquivo));
            System.out.println("✅ Jogo salvo com sucesso!");
        } catch (JAXBException e) {
            System.out.println("❌ Erro ao salvar jogo: " + e.getMessage());
            System.out.println();
            e.printStackTrace();
        }
    }

    /**
     * Carrega uma batalha de um arquivo XML
     * @param nomeArquivo Nome do arquivo XML
     * @return Instância de Batalha carregada, ou null se falhar
     */
    public static Batalha carregarBatalha(String nomeArquivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Batalha) unmarshaller.unmarshal(new File(nomeArquivo));
        } catch (JAXBException e) {
            System.out.println("❌ Erro ao carregar jogo: " + e.getMessage());
            return null;
        }
    }
}
