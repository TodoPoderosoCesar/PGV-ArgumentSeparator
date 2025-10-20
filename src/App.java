import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Introduzca por que parámetro desea buscar las personas: ");
    String userOption = scanner.nextLine();

    scanner.close();
  }
}
