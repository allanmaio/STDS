package com.optimizenow.gui;

import com.jgoodies.binding.value.AbstractConverter;
import com.jgoodies.binding.value.ValueModel;

public class DoubleDecimalConverter extends AbstractConverter {

	private static final long serialVersionUID = -5712832256864552713L;

	public DoubleDecimalConverter(ValueModel subject) {
		super(subject);
	}

	public Object convertFromSubject(Object object) {
		Double value = (Double) object;
		if (value == null) {
			return "";
		}
		return value.toString();
	}

	public void setValue(Object object) {
		if (object != null) {
			Double tmp = new Double((String) object);
			subject.setValue(tmp);
		} else {
			subject.setValue(new Double("0.00"));
		}
	}
}
