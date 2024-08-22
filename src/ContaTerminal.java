import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public Integer numero;
    public String agencia;
    public String nomeCliente;
    public Double saldo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale locale = Locale.US; // Define o locale para os EUA, onde o ponto é usado como separador decimal

        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
        df.setParseBigDecimal(true);

        System.out.print("Por favor, digite o número da Agência! ");
        String agencia = sc.nextLine();

        System.out.print("Usuário: ");
        Integer numero = sc.nextInt();
        sc.nextLine(); // Consome a nova linha deixada pelo nextInt()

        System.out.print("Nome do Cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.print("Digite o saldo: ");
        String saldoString = sc.nextLine(); // Lê o saldo como String
        Double saldo = null;
        try {
            saldo = df.parse(saldoString).doubleValue(); // Converte a String para Double usando DecimalFormat
        } catch (ParseException e) {
            System.out.println("Formato de saldo inválido. Certifique-se de usar ponto como separador decimal.");
            e.printStackTrace();
        }

        if (saldo != null) {
            // Imprime a mensagem formatada corretamente
            System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque%n",
                    nomeCliente, agencia, numero, saldo);
        }

        sc.close(); // Fecha o Scanner
    }
}
