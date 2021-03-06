/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Bruno Medeiros - modifications, removed OverlayStore requirements
 *******************************************************************************/
package melnorme.lang.ide.ui.preferences.common;

import melnorme.lang.ide.ui.LangUIPlugin;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Abstract preference wraping a {@link IPreferencesWidgetComponent}.
 * Old API, preferred to use {@link AbstractPreferencesBlock}.
 */
public abstract class AbstractPreferencesBlockPrefPage_Old extends AbstractComponentsPrefPage {
	
	private IPreferencesWidgetComponent fConfigurationBlock;
	
	public AbstractPreferencesBlockPrefPage_Old(IPreferenceStore store) {
		super(store);
		fConfigurationBlock = createPreferencesComponent();
	}
	
	protected abstract IPreferencesWidgetComponent createPreferencesComponent();
	
	@Override
	protected Control createContents(Composite parent) {
		return fConfigurationBlock.createComponent(parent);
	}
	
	@Override
	public boolean performOk() {
		super.performOk();
		
		fConfigurationBlock.saveSettings();
		LangUIPlugin.flushInstanceScope();
		
		return true;
	}
	
	@Override
	public void performDefaults() {
		super.performDefaults();
		
		fConfigurationBlock.loadDefaults();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
	
}