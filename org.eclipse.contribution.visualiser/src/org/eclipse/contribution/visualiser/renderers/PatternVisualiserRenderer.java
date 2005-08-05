/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     Ben Dalziel - initial version
 *******************************************************************************/
package org.eclipse.contribution.visualiser.renderers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.contribution.visualiser.palettes.PatternVisualiserPalette;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;

public class PatternVisualiserRenderer extends ClassicVisualiserRenderer {

	PatternVisualiserPalette palette = new PatternVisualiserPalette();
		
	private static int nextAvailablePattern = 0;
	
	private Map patternMemory = new HashMap();
	
	/**
	 * Get the next assignable pattern data and return it. If all the predefined patterns
	 * have been assigned, a new one is generated
	 * @return byte[][] - pattern data
	 */
	protected byte[][] getNextPattern() {
		byte[][][] pats = palette.getPaletteContence();
		if (nextAvailablePattern < pats.length) {
			byte[][] patternData = pats[nextAvailablePattern++];
			return patternData;
		} else {
			byte[][] patternData = palette.getRandomPattern();
				return patternData;
		}		
	}
	
	/**
	 * Converts the patternData into a Pattern
	 * @param patternData - byte[][] used to create the image
	 * @return The Pattern to be used
	 */
	private Pattern createPattern(byte[][] patternData) {
		Image patternImg = new Image(Display.getCurrent(), 8, 8);
		GC gc = new GC(patternImg);

		for (int i = 0; i < patternData.length; i++) {
			byte[] b = patternData[i];
			gc.setForeground(ColorConstants.black);
			if (b[1]==b[3] && b[2]==b[4]) {
				gc.drawPoint(b[1], b[2]);
			} else {
				gc.drawLine(b[1], b[2], b[3], b[4]);
			}
		}
		Pattern pattern = new Pattern(Display.getCurrent(), patternImg);		
		gc.dispose();
		patternImg.dispose();
		return pattern;
	}

	/**
	 * Returns pattern data from the patternMemory if the colour is recognised
	 * or a new pattern if the colour is new to the renderer
	 * @param colour
	 * @return byte[][] - pattern data
	 */
	private byte[][] getPatternForColour(Color colour) {
		
		byte[][] stripePatternData = null;
		if (patternMemory.containsKey(colour)) {
			stripePatternData = (byte[][]) patternMemory.get(colour);
		} else {
			stripePatternData = getNextPattern();
			patternMemory.put(colour, stripePatternData);
		}
		return stripePatternData;
	}
	
	/**
	 * Uses a colour, associates a pattern with it and tiles it over the gc 
	 * @param gc
	 * @param colour - The colour assigned to the gc
	 */
	public void setDitherPattern(GC gc, Color colour) {
		gc.setBackgroundPattern(createPattern(getPatternForColour(colour)));
	}
}
