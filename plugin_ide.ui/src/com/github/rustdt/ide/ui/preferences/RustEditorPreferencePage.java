/*******************************************************************************
 * Copyright (c) 2014 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package com.github.rustdt.ide.ui.preferences;



import melnorme.lang.ide.ui.LangUIPlugin;
import melnorme.lang.ide.ui.preferences.common.AbstractPreferencesBlockPrefPage;


public class RustEditorPreferencePage extends AbstractPreferencesBlockPrefPage {
	
	public RustEditorPreferencePage() {
		super(LangUIPlugin.getInstance().getPreferenceStore());
	}
	
	@Override
	protected String getHelpId() {
		return null;
	}
	
	@Override
	protected EditorConfigurationBlock createPreferencesComponent() {
		return new EditorConfigurationBlock(this);
	}
	
}