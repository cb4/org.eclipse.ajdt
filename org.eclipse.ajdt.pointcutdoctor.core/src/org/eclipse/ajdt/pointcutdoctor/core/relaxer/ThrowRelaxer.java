/*******************************************************************************
 * Copyright (c) 2007 Linton Ye.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Linton Ye - initial API and implementation
 ******************************************************************************/
package org.eclipse.ajdt.pointcutdoctor.core.relaxer;

import java.util.List;

import org.aspectj.weaver.World;
import org.aspectj.weaver.patterns.KindedPointcut;
import org.aspectj.weaver.patterns.SignaturePattern;
import org.aspectj.weaver.patterns.ThrowsPattern;


public class ThrowRelaxer extends SignatureRelaxer {

	@Override
	protected void doRelax(World world, List<RelaxData> results) {
		// to *
		if (affectingPointcut instanceof KindedPointcut) {
			SignaturePattern sig = ((KindedPointcut)affectingPointcut).getSignature();
			if (sig.getThrowsPattern()!=ThrowsPattern.ANY) {
				results.add(new RelaxData(RelaxOp.Replace, ThrowsPattern.ANY, this, affectingPointcut));
			}
		}
	}
}
