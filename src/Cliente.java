/*
Vitor Takahashi Miranda
RA 231740
Laboratorio 2
Definicao da classe Cliente
*/

public class Cliente {
	private String nome;
	private String CPF;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Construtor
	public Cliente (String nome, String CPF, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	// Getters and Setters
	public String getNome () {
		return nome;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getCPF () {
		return CPF;
	}
	
	public void setCPF (String CPF) {
		this.CPF = CPF;
	}
	
	public String getDataNascimento () {
		return dataNascimento;
	}
	
	public void setDataNascimento (String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade () {
		return idade;
	}
	
	public void setIdade (int idade) {
		this.idade = idade;
	}
	
	public String getEndereco () {
		return endereco;
	}
	
	public void setEndereco (String endereco) {
		this.endereco = endereco;
	}
	
	public boolean validaCPF () {
		String CPF_sem_pontos = CPF.replaceAll(".", "");
		// Caso o CPF nao tenha 11 digitos
		if (CPF_sem_pontos.length() != 11) {
			return false;
		}
		
		// Caso todos os digitos sejam iguais
		int i;
		for (i = 1; i < 11; i++) {
			if(CPF_sem_pontos.charAt(i) != CPF_sem_pontos.charAt(0)) {
				break;
			}
		}
		if (i == 11) {
			return false;
		}
		
		// Calculo dos digitos verificadores
		// Primeiro digito verificador
		int soma = 0;
		int numero;
		String atual;
		for (i = 10; i >= 2; i--) {
			atual = String.valueOf(CPF_sem_pontos.charAt(10 - i)) ;
			numero = Integer.parseInt(atual);
			soma += i*numero;
		}
		atual = String.valueOf(CPF_sem_pontos.charAt(9));
		int verificacao = Integer.parseInt(atual);
		if (verificacao != (soma * 10) % 11) {
			return false;
		}
		
		// Segundo digito verificador
		atual = String.valueOf(CPF_sem_pontos.charAt(10));
		verificacao = Integer.parseInt(atual);
		soma = 0;
		for (i = 11; i >= 2; i--) {
			atual = String.valueOf(CPF_sem_pontos.charAt(11 - i)) ;
			numero = Integer.parseInt(atual);
			soma += i*numero;
		}
		if (verificacao != (soma * 10) % 11) {
			return false;
		}
		
		// Caso tenha chegado ate aqui, eh um cpf valido
		return true;
		
	}
}