package com.optimizenow.presentation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import com.optimizenow.model.Endereco;
import com.optimizenow.model.Loja;


public class LojaPresentationModel<T> extends STDSPresentation {

	private static final long serialVersionUID = 2393483525774947147L;

	private Loja loja;

	public LojaPresentationModel(Object bean) {
		super(bean);
		this.loja = (Loja) bean;
		if (loja.getEndereco() == null) {
			loja.setEndereco(new Endereco());
		}
	}
	
	public ValueModel getLogradouro() {
		ValueHolder value = new ValueHolder(loja.getEndereco().getLogradouro());
		value.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("Mudou para" + evt.getNewValue());
			}
			
		});
		return value;
		
	}

}
