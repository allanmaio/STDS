package com.optimizenow.model;

import java.io.Serializable;
/**
 * Interface que generaliza todas as classes POJO que representam o modelo
 * de dados. Possibilita polimorfismo e testes usando Mock Objects.
 */
public interface EntidadeModelo<T> extends Serializable {

}
