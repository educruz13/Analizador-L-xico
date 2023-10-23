package analizador.lexico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorLexico {

    public enum TipoToken {
        PALABRA_RESERVADA,
        IDENTIFICADOR,
        NUMERO_ENTERO,
        NUMERO_DECIMAL,
        CADENA,
        CARACTER,
        COMENTARIO,
        FIN_DE_LINEA,
        PARENTESIS_IZQUIERDO,
        PARENTESIS_DERECHO,
        LLAVE_IZQUIERDA,
        LLAVE_DERECHA,
        CORCHETE_IZQUIERDO,
        CORCHETE_DERECHO,
        COMA,
        PUNTO_Y_COMA,
        SIGNO_NUMERAL,
        SIGNO_MENOR_QUE,
        SIGNO_MAYOR_QUE,
        OPERADOR_RELACIONAL,
        OPERADOR_LOGICO,
        OPERADOR_ARITMETICO,
        OPERADOR_ASIGNACION,
        OTRO
    }

    public static class Token {
        public final TipoToken tipo;
        public final String lexema;

        public Token(TipoToken tipo, String lexema) {
            this.tipo = tipo;
            this.lexema = lexema;
        }
    }

    public static Token[] analizarCodigo(String codigo) {
        List<Token> tokens = new ArrayList<>();

        Pattern pattern = Pattern.compile(
            "(int|double|float|char|void|if|else|while|for|do|switch|case|break|continue|return|include)|" +  // Palabras reservadas
            "[a-zA-Z_][a-zA-Z0-9_]*|" +  // Identificadores
            "\\d+\\.\\d*|\\d+|" +  // Números enteros y decimales
            "\"[^\"]*\"|'.'|" +  // Cadenas y caracteres
            "//.*|/\\*.*?\\*/|" +  // Comentarios
            "[(){}\\[\\],;]|" +  // Operadores y delimitadores
            "#|<|>|::|==|!=|<=|>=|&&|\\|\\||[+\\-*/%]|=|\\s");

        Matcher matcher = pattern.matcher(codigo);
        while (matcher.find()) {
            String token = matcher.group();
            TipoToken tipo = TipoToken.OTRO;

            if (token.matches("int|double|float|char|void|if|else|while|for|do|switch|case|break|continue|return|include")) {
                tipo = TipoToken.PALABRA_RESERVADA;
            } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                tipo = TipoToken.IDENTIFICADOR;
            } else if (token.matches("\\d+")) {
                tipo = TipoToken.NUMERO_ENTERO;
            } else if (token.matches("\\d+\\.\\d*")) {
                tipo = TipoToken.NUMERO_DECIMAL;
            } else if (token.matches("\"[^\"]*\"")) {
                tipo = TipoToken.CADENA;
            } else if (token.matches("'.'")) {
                tipo = TipoToken.CARACTER;
            } else if (token.matches("//.*|/\\*.*?\\*/")) {
                tipo = TipoToken.COMENTARIO;
            } else if (token.equals("\n")) {
                tipo = TipoToken.FIN_DE_LINEA;
            } else if (token.equals("(")) {
                tipo = TipoToken.PARENTESIS_IZQUIERDO;
            } else if (token.equals(")")) {
                tipo = TipoToken.PARENTESIS_DERECHO;
            } else if (token.equals("{")) {
                tipo = TipoToken.LLAVE_IZQUIERDA;
            } else if (token.equals("}")) {
                tipo = TipoToken.LLAVE_DERECHA;
            } else if (token.equals("[")) {
                tipo = TipoToken.CORCHETE_IZQUIERDO;
            } else if (token.equals("]")) {
                tipo = TipoToken.CORCHETE_DERECHO;
            } else if (token.equals(",")) {
                tipo = TipoToken.COMA;
            } else if (token.equals(";")) {
                tipo = TipoToken.PUNTO_Y_COMA;
            } else if (token.equals("#")) {
                tipo = TipoToken.SIGNO_NUMERAL;
            } else if (token.equals("<")) {
                tipo = TipoToken.SIGNO_MENOR_QUE;
            } else if (token.equals(">")) {
                tipo = TipoToken.SIGNO_MAYOR_QUE;
            } else if (token.equals("::")) {
                tipo = TipoToken.OPERADOR_ASIGNACION;
            } else if (token.matches("==|!=|<=|>=|&&|\\|\\||[+\\-*/%]|=")) {
                tipo = TipoToken.OPERADOR_RELACIONAL;
            } else if (token.matches("[+\\-*/%]")) {
                tipo = TipoToken.OPERADOR_ARITMETICO;
            } else if (token.matches("=|\\+|\\-|\\*|/|%")) {
                tipo = TipoToken.OPERADOR_ASIGNACION;
            }

            if (tipo != TipoToken.OTRO && !token.matches("\\s")) {
                tokens.add(new Token(tipo, token));
            }
        }

        return tokens.toArray(new Token[0]);
    }



    public static Token[] analizarArchivo(String nombreArchivo) throws IOException {
        StringBuilder codigo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                codigo.append(linea).append("\n");
            }
        }
        return analizarCodigo(codigo.toString());
    }

    public static void main(String[] args) {
        // Especifica el nombre del archivo directamente aquí
        String nombreArchivo = "C:\\Users\\Daniel\\Desktop\\Analizador Lexico\\src\\analizador\\lexico\\prueba.cpp";

        try {
            Token[] tokens = analizarArchivo(nombreArchivo);

            for (Token token : tokens) {
                System.out.println("lexema: " + token.lexema + "\ttipo: " + token.tipo);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreArchivo + ": " + e.getMessage());
}
}
}

