package br.com.dio.lab.banco.digital.oo.domain.model;

import br.com.dio.lab.banco.digital.oo.validator.impl.DocumentoValidatorImpl;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Cliente {

    private static final DocumentoValidatorImpl documentoValidator = new DocumentoValidatorImpl();

    private final String nome;

    private final String documento;

    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.validarDocumento(documento);
        this.documento = documento;
    }

    private void validarDocumento(String documento) {
        if (documentoValidator.isValid(documento)) {
            return;
        }

        throw new IllegalArgumentException("Documento inválido");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(documento, cliente.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, documento);
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }

}
