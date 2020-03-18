package model.servico;

public interface ServicoPagamentoOnLine { 
	
	double taxaPagamento(double valor);
	double juros(double valor, int meses);
	

}


