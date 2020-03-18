package model.servico;

public class ServicoPaypal implements ServicoPagamentoOnLine {

	private static final double TAXA_PERCENTUAL = 0.02;
	private static final double PRESTACAO_MENSAL = 0.01;

	@Override
	public double taxaPagamento(double valor) {
		return valor * TAXA_PERCENTUAL;
	}

	@Override
	public double juros(double valor, int meses) {
		return valor * PRESTACAO_MENSAL * meses;
	}
}
