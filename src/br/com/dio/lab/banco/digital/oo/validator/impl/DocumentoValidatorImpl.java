package br.com.dio.lab.banco.digital.oo.validator.impl;

import br.com.dio.lab.banco.digital.oo.validator.Validator;

public final class DocumentoValidatorImpl implements Validator<String> {

    @Override
    public boolean isValid(String documento) {
        // Remover pontos e traços do CPF
        documento = documento.replaceAll("\\D", "");

        // Verifica se tem 11 dígitos
        if (documento.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (casos como 111.111.111-11)
        if (documento.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (documento.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        firstDigit = (firstDigit == 10 || firstDigit == 11) ? 0 : firstDigit;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (documento.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        secondDigit = (secondDigit == 10 || secondDigit == 11) ? 0 : secondDigit;

        // Verifica se os dígitos calculados conferem com os dígitos do CPF
        return documento.charAt(9) - '0' == firstDigit && documento.charAt(10) - '0' == secondDigit;
    }

}
