/*
 * Copyright (c) 2005-2019 Substance Kirill Grouchnikov. All Rights Reserved.
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
 *  o Neither the name of Substance Kirill Grouchnikov nor the names of 
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
package org.pushingpixels.substance.api.painter.decoration;

import org.pushingpixels.substance.api.SubstanceColorSchemeBundle;
import org.pushingpixels.substance.api.SubstanceSkin;
import org.pushingpixels.substance.api.SubstanceSlices;
import org.pushingpixels.substance.api.colorscheme.LightGrayColorScheme;
import org.pushingpixels.substance.api.colorscheme.MetallicColorScheme;
import org.pushingpixels.substance.internal.utils.NoiseFactory;
import org.pushingpixels.substance.internal.utils.SubstanceColorSchemeUtilities;

/**
 * Implementation of {@link SubstanceDecorationPainter} that uses marble noise
 * painting on decoration areas.
 * 
 * @author Kirill Grouchnikov
 */
public class MarbleNoiseDecorationPainter extends ImageWrapperDecorationPainter {
	/**
	 * The display name for the decoration painters of this class.
	 */
	public static final String DISPLAY_NAME = "Marble Noise";

	/**
	 * Metallic skin.
	 */
	private static final SubstanceSkin METALLIC_SKIN = getMetallicSkin();

	private static SubstanceSkin getMetallicSkin() {
		SubstanceSkin res = new SubstanceSkin() {
			@Override
			public String getDisplayName() {
				return "Metallic Skin";
			}
		};
		res.registerDecorationAreaSchemeBundle(
				new SubstanceColorSchemeBundle(new MetallicColorScheme(), new MetallicColorScheme(),
						new LightGrayColorScheme()),
				SubstanceSlices.DecorationAreaType.NONE);
		return res;
	}

	/**
	 * Creates a new marble noise decoration painter.
	 */
	public MarbleNoiseDecorationPainter() {
		super();
		this.originalTile = NoiseFactory.getNoiseImage(
				METALLIC_SKIN, 400, 400, 0.8,
				0.8, false, true, true);
	}

    @Override
	public String getDisplayName() {
		return DISPLAY_NAME;
	}
}
