package compilador;

public class Token {
	private String token;
	private String lexema;
	private boolean palabraReservada;
	
	public Token(String token, String lexema, boolean palabraReservada) {
		this.token = token;
		this.lexema = lexema;
		this.palabraReservada = palabraReservada;
	}

	public String getToken() {
		return token;
	}

	public String getLexema() {
		return lexema;
	}

	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	public boolean isPalabraReservada() {
		return palabraReservada;
	}

}