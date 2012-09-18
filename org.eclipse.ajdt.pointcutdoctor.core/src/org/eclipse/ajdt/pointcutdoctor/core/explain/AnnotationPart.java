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
package org.eclipse.ajdt.pointcutdoctor.core.explain;

import org.aspectj.util.FuzzyBoolean;
import org.aspectj.weaver.JoinPointSignature;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.World;
import org.aspectj.weaver.patterns.AnnotationTypePattern;
import org.aspectj.weaver.patterns.Pointcut;

public class AnnotationPart extends SigPart {

//	private AnnotationTypePattern annotation;

	public AnnotationPart(Pointcut pointcut, AnnotationTypePattern annotation) {
		super(pointcut, annotation);
	}

	@Override
	protected FuzzyBoolean matchesExactly(JoinPointSignature sig, World world) {
		AnnotationTypePattern annotation = (AnnotationTypePattern) node;
		return annotation.matches(sig); //TODO any problems?
	}

	@Override
	protected String getJoinPointPartName() {
		return "annotation";
	}

	@Override
	protected String getJoinPointPartValue(Shadow shadow) {
		return "TODO";
	}

}
