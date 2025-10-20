import java.io.*;

public class FiltroSubproceso {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: FiltroSubproceso <campo> <valor>");
            return;
        }

        String campo = args[0];
        String valor = args[1];

        File inputFile = new File("./src/net/salesianos/inputs/personas_500.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(campo + ": " + valor)) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}