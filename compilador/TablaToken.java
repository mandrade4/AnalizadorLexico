package compilador;

import java.util.ArrayList;
import java.util.Arrays;

public class TablaToken {
	
	private static TablaToken INSTANCE;
	
	public static TablaToken getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new TablaToken();
		}
		return INSTANCE;
	}
	
	private ArrayList<Token> simbolosInicial;
	
	public TablaToken() {
		simbolosInicial = new ArrayList<Token>(
				Arrays.asList(new Token("PALABRA CLAVE", "Programa", true), 
							new Token("PALABRA CLAVE", "Entero", true),
							new Token("PALABRA CLAVE", "Flotante", true),
							new Token("PALABRA CLAVE", "Si", true), 
							new Token("PALABRA CLAVE", "Osino", true),
							new Token("PALABRA CLAVE", "Mientras", true),
							new Token("PALABRA CLAVE", "leerTeclado", true),
							new Token("PALABRA CLAVE", "imprimirPantalla", true), 
							new Token("OPERADOR", "+", true), 
							new Token("OPERADOR", "-", true), 
							new Token("OPERADOR", "*", true), 
							new Token("OPERADOR", "/", true), 
							new Token("OPERADOR", "=", true),
							new Token("OPERADOR", "%", true),
							new Token("OPERADOR", "<", true),
							new Token("OPERADOR", ">", true),
							new Token("DELIMITADOR", "[", true),
							new Token("DELIMITADOR", "]", true),
							new Token("DELIMITADOR", "{", true),
							new Token("DELIMITADOR", "}", true),
							new Token("DELIMITADOR", "¿", true),
							new Token("DELIMITADOR", "?", true),
							new Token("DELIMITADOR", "(", true),
							new Token("DELIMITADOR", ")", true)
							));
	}

	public ArrayList<Token> getTokenInicial() {
		return simbolosInicial;
	}

	public Token getTokenByLexema(String lexema){
		for(Token simbolo : this.simbolosInicial)
			if(simbolo.getLexema().equalsIgnoreCase(lexema))
				return simbolo;
		return null;
	}
	
	public boolean isLexemaToken(String lexema){
		for(Token simbolo : this.simbolosInicial)
			if(simbolo.getLexema().equalsIgnoreCase(lexema) && simbolo.isPalabraReservada())
				return true;
		return false;
	}
	
	public boolean existeLexema(String lexema) {
		for (Token simbolo : this.simbolosInicial) {
			if ((lexema.equalsIgnoreCase(simbolo.getLexema())) && (!simbolo.isPalabraReservada())) {
				return true;
			}
		}
		return false;
	}
}
