
import java.util.Arrays;
import java.text.Normalizer;
class Main { 

    public static void main(String[] args) { 

        Main programa = new Main(); 

        boolean resultado = programa.esPalindromo("ot é,¿?,eto!");
        System.out.println(resultado);
    } 
    // // Version basico. Solo mayúsculas o minúsculas.
    // public boolean esPalindromo(String texto) {
    //     char[] v = texto.toCharArray();
    //     char[] copia = new char[texto.length()];
    //     for (int j = 0; j < copia.length; j++) {
    //         copia[copia.length - j - 1] = v[j];
    //     }
    //     boolean iguales = true;
    //     for (int k = 0; k < copia.length && iguales; k++) {
    //         if (copia[k] != v[k]) {
    //             iguales = false;
    //         }
    //     }
    //     return iguales;
    // } 

        // Version 2. Con espacio, signos de puntuación, caracteres especiales que no son letras ni dígitos, mayúsculas, minúsculas. 
    public static boolean esPalindromo(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD)
                       .replaceAll("[^\\p{ASCII}]", "") // Elimina todos los caracteres que no sean ASCII, incluyendo los acentos y diacríticos en los caracteres de otros idiomas.
                        .replaceAll("\\s+", "") // Eliminar espacios para este frase nota laka la ton - ¿acaso hubo buhos aca? - A man, a plan, a canal, Panama. "¡A Toyota's a !, asá, Toyota". Elimina todos los espacios en blanco, incluyendo espacios, tabulaciones y saltos de línea.
                        .replaceAll("\\p{Punct}", "") // Eliminar puntuación para este frase nota laka la ton. Elimina todos los signos de puntuación, como comas, puntos, signos de interrogación, entre otros.
                       .toLowerCase(); //convierte todos los caracteres de la cadena a minúsculas para asegurarse de que se estén comparando correctamente en la parte del código que verifica si el texto es un palíndromo.
        int length = texto.length();
        for (int i = 0; i < length/2; i++) {
            if (texto.charAt(i) != texto.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
} 

    // //Version 0. Sin carateres, con espacio
    // public static boolean esPalindromo(String texto) {
    //     texto = texto.toLowerCase().replaceAll("[^a-z0-9]", "");
    //     int length = texto.length();
    //     for (int i = 0; i < length/2; i++) {
    //         if (texto.charAt(i) != texto.charAt(length - i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;}