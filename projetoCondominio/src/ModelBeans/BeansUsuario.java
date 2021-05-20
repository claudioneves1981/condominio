package ModelBeans;

public class BeansUsuario {
	private int usu_cod;
	private String pesquisa;
	private String usu_nome;
	private String login_usuario;
	private String tipo_usuario;
	private String senha_usuario;
	private String observacao;
	
	public BeansUsuario() {
	}

	public int getUsu_cod() {
		return usu_cod;
	}

	public void setUsu_cod(int usu_cod) {
		this.usu_cod = usu_cod;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}

	public String getLogin_usuario() {
		return login_usuario;
	}

	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;		
	}
	
	public String getObservacao() {
		return observacao;		
	}
}