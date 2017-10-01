package analizador;

public class Automatas {

	public static boolean isIdentificador(String lexema) {//IDENTIFICADOR
		String letra = "[A-Za-z]";
		String simb = "[$|_]";
		String digitoLetra = "[0-9A-Za-z]";
		String caracter = "";
		int estado = 1;
		
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			//System.out.println(caracter);
			switch (estado) {
			case 1:
				if (caracter.matches(letra) || caracter.matches(simb))
					estado = 2;
				else
					estado = 3;
				break;
			case 2:
				if (caracter.matches(digitoLetra) || caracter.matches(simb))
					estado = 2;
				else
					estado = 3;
				break;
			}
		}
		if (estado != 3)
			return true;
		return false;
	}

	public static boolean isNumero(String lexema) {//CONSTANTE NUMERICA
		String digito = "[0-9]";
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches(digito))
					estado = 1;
				else
					estado = 2;
				break;
			}
		}
		if (estado != 2)
			return true;
		return false;
	}
	
	public static boolean isFloat(String lexema) {//NUMERO DECIMAL
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (Automatas.isNumero(caracter))
					estado = 1;
				else {
					estado = 2;
					i--;
				}
				break;
			case 2:
				if (caracter.equalsIgnoreCase("."))
					if (i + 1 != lexema.length())
						//System.out.println(caracter);
						estado = 3;
					else
						estado = 4;
				else
					estado = 4;
				break;
			case 3:
				if (Automatas.isNumero(caracter)) {
					estado = 3;
				} else
					estado = 4;
				break;
			}
		}
		if (estado != 4)
			return true;
		return false;
	}
	
	public static boolean isDelimiter(String lexema) {//DELIMITADOR
		String caracter = "";
		String simb = "[{|}|[|]|(|)|?|¿]";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches(simb)) 
					estado = 2;
				break;
			}
		}
		if (estado != 2)
			return true;
		return false;
	}
	
	
	public static boolean isOperator(String lexema) {//OPERADORES
		String caracter = "";
		int estado = 1;
		for (int i = 0; i < lexema.length(); i++) {
			caracter = lexema.charAt(i) + "";
			switch (estado) {
			case 1:
				if (caracter.matches("+") || caracter.matches("-") || caracter.matches("*") || caracter.matches("/")
						|| caracter.matches("%")) 
					estado = 2;
				else if(caracter.matches(">")|| caracter.matches("<") || caracter.matches("=") || caracter.matches("!"))
					estado = 3;
				else
					estado = 5;
				break;
			case 3:
				if(caracter.matches("="))
					estado = 4;
				else
					estado = 5;
			
			}
		}
		if (estado != 5)
			return true;
		return false;
	}
	


	
}

