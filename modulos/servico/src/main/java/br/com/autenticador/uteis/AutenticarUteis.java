package br.com.autenticador.uteis;

public class AutenticarUteis {
	
	private static final int[] pesoCPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] pesoCNPJ = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
	
	public static boolean isValidCpf(String cpf) {
		cpf = removeCaracteresCpfCnpj(cpf);
		if ((cpf == null) || (cpf.length() != 11)) {
			return false;
		}

		Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
		Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
		return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
	}
	
	public static boolean isValidCnpj(String cnpj) {
		cnpj = removeCaracteresCpfCnpj(cnpj);
		if (cnpj != null && cnpj.contains("/")) {
			cnpj = cnpj.replace("-", "").replace(".", "").replace("/", "");
		}
		if ((cnpj == null) || (cnpj.length() != 14)) {
			return false;
		}

		Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
		Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
		return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
	}
	
	private static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}
	
	public static String removeCaracteresCpfCnpj(String cpf) {
		if (cpf != null) {
			cpf = cpf.replace(".", "").replace("-", "").replace("/", "");
			return cpf.trim();
		}
		return "";
	}
}