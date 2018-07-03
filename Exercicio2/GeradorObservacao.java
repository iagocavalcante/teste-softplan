
import java.util.Iterator;
import java.util.List;

public class GeradorObservacao {

	// Texto da observacao
	private String observacao;

	public GeradorObservacao() {
		this.observacao = "";
	}

	// Gera observa��es, com texto pre-definido, incluindo os n�meros, das notas
	// fiscais, recebidos no par�metro
	public String geraObservacao(List lista) {
		if (!lista.isEmpty()) {
			return retornaObservaoComCodigo(lista);
		}
		return this.observacao;
	}

	// Separa os codigos da nota fiscal
	private String separaCodigos(List lista) {
		// verifica tamanho da lista e atribui texto padrao
		verificaTamanhoLista(lista);
		StringBuilder codigosConcatenados = new StringBuilder();
		// Acha separador
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer codigo = iterator.next();
			String separador = "";
			if( codigosConcatenados.toString() == null || codigosConcatenados.toString().length() <= 0 )
				separador =  "";
			else if( iterator.hasNext() )
				separador =  ", ";
			else
				separador =  " e ";

			codigosConcatenados.append(separador + codigo);
		}

		return codigosConcatenados.toString();
	}

	//Retorna observacao montada com texto
	private String retornaObservaoComCodigo(List lista) {
		String codigos = separaCodigos(lista);
		return this.observacao + codigos + ".";
	}

	private void verificaTamanhoLista(List lista) {
		if (lista.size() > 1) {
			this.observacao = "Fatura das notas fiscais de simples remessa: ";
		} else {
			this.observacao = "Fatura da nota fiscal de simples remessa: ";
		}
	}
}