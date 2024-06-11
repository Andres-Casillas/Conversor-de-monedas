import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush(); 
            System.out.println("========================");
            System.out.println("  CONVERSOR DE MONEDAS  ");
            System.out.println("========================");
            System.out.println("");
            System.out.println("Que desea convertir:");
            System.out.println("1.- USD --> EUR");
            System.out.println("2.- EUR --> USD");
            System.out.println("3.- USD --> MXN");
            System.out.println("4.- MXN --> USD");
            System.out.println("5.- USD --> ARS");
            System.out.println("6.- ARS --> USD");
            System.out.println("7.- USD --> BRL");
            System.out.println("8.- BRL --> USD");
            System.out.println("\n0.- Salir.");
            
            opcion = entrada.nextInt();
            if (opcion == 0) break;
            
            System.out.println("Cantidad que desea convertir:");
            Double monto = entrada.nextDouble();
            Consulta consulta = new Consulta();
            Conversor conversor = null;

            switch (opcion) {
                case 1: // USD --> EUR
                    conversor = consulta.consultaConversor("USD", "EUR", monto);
                    break;
                case 2: // EUR --> USD
                    conversor = consulta.consultaConversor("EUR", "USD", monto);
                    break;
                case 3: // USD --> MXN
                    conversor = consulta.consultaConversor("USD", "MXN", monto);
                    break;
                case 4: // MXN --> USD
                    conversor = consulta.consultaConversor("MXN", "USD", monto);
                    break;
                case 5: // USD --> ARS
                    conversor = consulta.consultaConversor("USD", "ARS", monto);
                    break;
                case 6: // ARS --> USD
                    conversor = consulta.consultaConversor("ARS", "USD", monto);
                    break;
                case 7: // USD --> BRL
                    conversor = consulta.consultaConversor("USD", "BRL", monto);
                    break;
                case 8: // BRL --> USD
                    conversor = consulta.consultaConversor("BRL", "USD", monto);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
            
            if (conversor != null) {
                System.out.println("\n\n\nResultado: " + monto + " " + conversor.base_code() + " = " + conversor.conversion_result() + " " + conversor.target_code());
            }

            System.out.println("\n\nHacer otra conversion? 1.- Si.\n                       0.- Salir.");
            opcion = entrada.nextInt();

        } while (opcion != 0);
        
        entrada.close();
    }
}
