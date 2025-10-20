import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {

  private static final String SUBPROCESS_ROUTE = "src/FiltroSubproceso.java";
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("/**** FILTRO DE PERSONAS ***/");
    System.out.println("Campos disponibles para filtrar:");
    System.out.println("1 - Sexo");
    System.out.println("2 - Altura");
    System.out.println("3 - Belleza");
    System.out.println("4 - Estado");
    System.out.println("5 - Vivo");
    System.out.println("6 - Salud");
    System.out.println("7 - Vista");
    System.out.print("Selecciona el número del campo: ");
    int userOption = scanner.nextInt();

    String atribute = null;
    String firstValue = null;
    String secondValue = null;

    switch (userOption) {
      case 1:
        atribute = "Sexo";
        firstValue = "Hombre";
        secondValue = "Mujer";
        break;
      case 2:
        atribute = "Altura";
        firstValue = "Alto";
        secondValue = "Bajo";
        break;
      case 3:
        atribute = "Belleza";
        firstValue = "Guapo";
        secondValue = "Feo";
        break;
      case 4:
        atribute = "Estado";
        firstValue = "Soltero";
        secondValue = "Casado";
        break;
      case 5:
        atribute = "Vivo";
        firstValue = "Vivo";
        secondValue = "Muerto";
        break;
      case 6:
        atribute = "Salud";
        firstValue = "Bien";
        secondValue = "Malito";
        break;
      case 7:
        atribute = "Vista";
        firstValue = "Gafas";
        secondValue = "Normal";
        break;
      default:
        System.out.println("Opción inválida");
        return;
    }

    Process p1 = throwSubProcess(atribute, firstValue);
    Process p2 = throwSubProcess(atribute, secondValue);

    waitSubprocess(p1);
    waitSubprocess(p2);

    showResults(atribute, firstValue);
    showResults(atribute, secondValue);

    System.out.println("Filtrado completado.");

    scanner.close();
  }


  /* ************ LANZAR EL SUBPROCESO ************ */
  private static Process throwSubProcess(String atribute, String value) {

    try {

      File outputFile = new File("./src/net/salesianos/outputs/filtro_" + atribute + "_" + value + ".txt");
      outputFile.getParentFile().mkdirs();

      ProcessBuilder pb = new ProcessBuilder("java", SUBPROCESS_ROUTE, atribute, value);
      pb.redirectOutput(outputFile);
      pb.redirectError(ProcessBuilder.Redirect.INHERIT);

      return pb.start();

    } catch (IOException e) {

      e.printStackTrace();
      return null;
    }
  }


  /* ************ ESPERAR AL SUBPRESECO ************ */
  private static void waitSubprocess(Process p) {

    if (p == null) return;

    try {

      p.waitFor();

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /* ************ MOSTRAR EL RESULTADO ************ */
  private static void showResults(String atribute, String value) {

    File f = new File("./src/net/salesianos/outputs/filtro_" + atribute + "_" + value + ".txt");

    if (!f.exists()) {

      System.out.println("No se generó el archivo para " + value);
      return;
    }

    int contador = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(f))) {

      while (br.readLine() != null) contador++;

    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(atribute + " = " + value + ": " + contador + " coincidencias");
  }

}
