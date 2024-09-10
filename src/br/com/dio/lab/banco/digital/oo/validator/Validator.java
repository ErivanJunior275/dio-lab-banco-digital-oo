package br.com.dio.lab.banco.digital.oo.validator;

public interface Validator<T> {

    boolean isValid(T value);

}
