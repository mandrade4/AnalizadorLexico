package analizador;

import java.util.ArrayList;
import compilador.*;

public class Lexico {

		private ArrayList<Token> simbolos = new ArrayList<Token>();

		public void analizarLinea(String linea) {
			simbolos.clear();
			char[] caracteres = linea.toCharArray();
			String lexema = "";
			boolean flag = false;
			for (int i = 0; i < caracteres.length; i++) {
				String caracter = caracteres[i] + "";//Letra por letra
				System.out.println(caracter);
				if (flag) {
					if (caracter.equalsIgnoreCase(" ")) {
						flag = false;
						Token simbolo = new Token("string", lexema, false);
						System.out.println("\tToken: " + simbolo.getToken() + " Lexema: " + simbolo.getLexema() + "\n");
						System.out.println(simbolo.getToken()+simbolo.getLexema());
						this.simbolos.add(simbolo);
						analizarLexema(caracter);
						lexema = "";
						continue;
					}
					lexema += caracter;
					continue;
				}
				if (TablaToken.getInstance().isLexemaToken(caracter)) {
					if (caracter.equalsIgnoreCase(" ")) {
						flag = true;
					}	
					if (!lexema.isEmpty()) {
						analizarLexema(lexema);
					}
					analizarLexema(caracter);
					lexema = "";
				} else if (caracter.equalsIgnoreCase(" ")) {
					//System.out.println(lexema);
					if (!lexema.isEmpty()) {
						analizarLexema(lexema);
					}
					lexema = "";
				} else {
					lexema += caracter;
				}
			}
			if (!lexema.isEmpty()) {
				analizarLexema(lexema);
			}
		}

		private void analizarLexema(String lexema) {
			Token simbolo = TablaToken.getInstance().getTokenByLexema(lexema);
			if (simbolo == null) {
				if (Automatas.isIdentificador(lexema))
					simbolo = new Token("IDENTIFICADOR", lexema, false);
				else if (Automatas.isNumero(lexema))
					simbolo = new Token("CONSTANTE NUMERICA", lexema, false);
				else if (Automatas.isFloat(lexema))
					simbolo = new Token("CONSTANTE NUMERICA", lexema, false);
				else if (Automatas.isDelimiter(lexema))
					simbolo = new Token("DELIMITADOR", lexema, false);
				else if (Automatas.isOperator(lexema))
					simbolo = new Token("OPERADOR", lexema, false);
				
				if (!TablaToken.getInstance().existeLexema(lexema)) {
					TablaToken.getInstance().getTokenInicial().add(simbolo);
				}			
			}
			if (simbolo != null) {
				System.out.println(simbolo.getLexema() + "	" + simbolo.getToken() + "\n");
				this.simbolos.add(simbolo);
			}
		}
		
		public ArrayList<Token> getSimbolos() {
			return simbolos;
		}

		public void setSimbolos(ArrayList<Token> simbolos) {
			this.simbolos = simbolos;
		}
		
	}
