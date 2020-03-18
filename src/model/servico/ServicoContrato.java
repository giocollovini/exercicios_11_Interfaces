package model.servico;

import java.util.Calendar;
import java.util.Date;

import model.entidades.Contrato;
import model.entidades.Prestacao;



public class ServicoContrato { 
	
	private ServicoPagamentoOnLine servicoPagamentoOnLine;
	
	public ServicoContrato(ServicoPagamentoOnLine servicoPagamentoOnLine) {
		this.servicoPagamentoOnLine = servicoPagamentoOnLine;
	}
	
	public void processaContrato(Contrato contrato, int meses) {
		double quotaBasica = contrato.getValorTotal() / meses;  
		for (int i = 1; i <= meses; i++) { 
            Date data = adicionaMeses(contrato.getDataContrato(), i);
            double atualizaQuota = quotaBasica + servicoPagamentoOnLine.juros(quotaBasica, i);
            double quotaTotal =  atualizaQuota + servicoPagamentoOnLine.taxaPagamento(atualizaQuota);
            contrato.addPrestacoes(new Prestacao(data, quotaTotal));
        }
	}
	
	private Date adicionaMeses(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}	

}
