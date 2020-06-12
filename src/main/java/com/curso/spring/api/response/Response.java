package com.curso.spring.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private T resultado;
    private List<String> errores;

    public Response() {

    }

    public T getResultado() {
        return this.resultado;
    }

    public void setResultado(T resultado) {
        this.resultado = resultado;
    }

    public List<String> getErrores() {
        if (this.errores == null) {
            this.errores = new ArrayList<>();
        }
        return this.errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }
}