package com.rgomes.mobiauto_backend_interview.utils;

public class CNPJValidator {
    
    public static boolean isCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // Verifica se tem 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso1[i];
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        // Cálculo do segundo dígito verificador
        int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 13; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso2[i];
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        // Verifica se os dígitos calculados conferem com os dígitos fornecidos
        return cnpj.charAt(12) == Character.forDigit(digito1, 10) &&
               cnpj.charAt(13) == Character.forDigit(digito2, 10);
    }
}
