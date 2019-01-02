/*
 * Copyright (c) 2005-2019 Flamingo Kirill Grouchnikov. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer. 
 *     
 *  o Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *     
 *  o Neither the name of Flamingo Kirill Grouchnikov nor the names of 
 *    its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.pushingpixels.flamingo.api.common;

import org.pushingpixels.flamingo.api.common.model.*;
import org.pushingpixels.flamingo.api.common.projection.Projection;
import org.pushingpixels.flamingo.internal.substance.common.ui.SubstanceCommandToggleButtonUI;

import javax.swing.*;

/**
 * Command button.
 * 
 * @author Kirill Grouchnikov
 */
public class JCommandToggleButton extends AbstractCommandButton {
	/**
	 * The UI class ID string.
	 */
	public static final String uiClassID = "CommandToggleButtonUI";

	public JCommandToggleButton(Projection<AbstractCommandButton, ? extends Command,
			CommandButtonPresentationModel> projection) {
		super(projection);
		this.setActionModel(new ActionToggleButtonModel(this, false));

		if (command.isToggleSelected()) {
			this.getActionModel().setSelected(true);
		}

		this.updateUI();
	}

	/**
	 * Resets the UI property to a value from the current look and feel.
	 * 
	 * @see JComponent#updateUI
	 */
	@Override
	public void updateUI() {
		setUI(SubstanceCommandToggleButtonUI.createUI(this));
	}

	@Override
	public String getUIClassID() {
		return uiClassID;
	}

	@Override
	public String toString() {
		return "Command toggle button[" + this.getText() + "]";
	}
}
