package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Contrato;
import model.entidades.Prestacao;
import model.servico.ServicoContrato;
import model.servico.ServicoPaypal;


public class ProgramInterface { 
	
	public static void main(String[] args) throws ParseException {

			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			
			
			System.out.println("Automatizar o processamento de contratos. Gerar parcelas a serem pagas para o contrato,"); 
			System.out.println("com base no número de meses desejado.");
			System.out.println("A empresa utiliza um serviço de pagamento online que cobra um juro mensal, bem como uma taxa"); 
			System.out.println("por pagamento. Juros simples de 1% a cada parcela mais taxa de pagamento de 2%.");
			System.out.println("Programa deve ler dados do contrato(número do contrato,data do contrato e valor total do contrato)"); 
			System.out.println("Em seguida ler o número de meses para parcelamento, e gerar parcelas a serem pagas (data e valor)");
			System.out.println();

			
			System.out.println("Entre com os dados do Contrato");
			System.out.print("Numero: ");
			int number = sc.nextInt();
			System.out.print("Data (dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Valor do Contrato: ");
			double totalValue = sc.nextDouble();
			
			Contrato contrato = new Contrato(number, date, totalValue);
			
			System.out.print("Entre com número de parcelas: ");
			int n = sc.nextInt();
			
			ServicoContrato servicoContrato = new ServicoContrato(new ServicoPaypal());
			
			servicoContrato.processaContrato(contrato, n); 
			
			System.out.println("Parcelas:");
			for (Prestacao x : contrato.getPrestacoes()) {
				System.out.println(x);
			}
			
			sc.close();
		}

}
