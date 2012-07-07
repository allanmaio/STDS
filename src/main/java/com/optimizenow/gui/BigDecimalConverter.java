package com.optimizenow.gui;

import java.math.BigDecimal;

import com.jgoodies.binding.value.AbstractConverter;
import com.jgoodies.binding.value.ValueModel;

public class BigDecimalConverter extends AbstractConverter {

	private static final long serialVersionUID = -2912110429268014788L;

	public BigDecimalConverter(ValueModel subject) {
		super(subject);
	}

	public Object convertFromSubject(final Object object) {
		final BigDecimal value = (BigDecimal) object;
		if (value == null) {
			return "";
		}
		return value.toString();
	}

	public void setValue(final Object object) {
		if (object != null) {
			BigDecimal tmp = new BigDecimal((String) object);
			subject.setValue(tmp);
		} else {
			subject.setValue(new BigDecimal("0.00"));
		}
	}

}
