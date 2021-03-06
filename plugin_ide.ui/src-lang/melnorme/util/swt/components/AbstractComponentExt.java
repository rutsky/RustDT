/*******************************************************************************
 * Copyright (c) 2015 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package melnorme.util.swt.components;

import static melnorme.utilbox.core.Assert.AssertNamespace.assertFail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * An {@link AbstractComponent} with {@link #setEnabled(boolean)} functionality.
 */
public abstract class AbstractComponentExt extends AbstractComponent {
	
	public AbstractComponentExt() {
		super();
		
		_verify_setEnabled();
	}
	
	/* -----------------  ----------------- */
	
	public abstract void setEnabled(boolean enabled);
	
	protected void _verify_setEnabled() {
		_verify_setEnabled(getClass());
	}
	
	protected void _verify_setEnabled(Class<?> klass) {
		boolean needsMethodOverride = false;
		
		Field[] declaredFields = klass.getDeclaredFields();
		for(Field field : declaredFields) {
			if(field.getName().startsWith("this$")) {
				continue;
			}
			if(Modifier.isStatic(field.getModifiers()) || field.getType().isPrimitive()) {
				continue;
			}
			needsMethodOverride = true;
			break;
		}
		if(needsMethodOverride) {
			
			// if the subclass has declared new fields, ensure it has override setEnabled too
			
			for(Method method : klass.getDeclaredMethods()) {
				if(method.getName().equals("setEnabled")) {
					return;
				}
			}
			assertFail();
			
		} else {
			
			_verify_setEnabled(klass.getSuperclass());
			return;
		}
		
	}
	
}