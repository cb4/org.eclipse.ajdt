/*******************************************************************************
 * Copyright (c) 2000, 2014 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.aspectj.org.eclipse.jdt.internal.core;

import org.aspectj.org.eclipse.jdt.core.ISourceRange;
import org.aspectj.org.eclipse.jdt.core.SourceRange;

public class CompilationUnitElementInfo extends OpenableElementInfo {

	/**
	 * Count that will be used by SourceTypeConverter to decide whether or not to diet parse.
	 */
	public static int ANNOTATION_THRESHOLD_FOR_DIET_PARSE = 10;

	/**
	 * The length of this compilation unit's source code <code>String</code>
	 */
	protected int sourceLength;

	/**
	 * Timestamp of original resource at the time this element
	 * was opened or last updated.
	 */
	protected long timestamp;

	/*
	 * Number of annotations in this compilation unit
	 */
	public int annotationNumber = 0;

	public boolean hasFunctionalTypes = false;

/**
 * Returns the length of the source string.
 */
public int getSourceLength() {
	return this.sourceLength;
}
protected ISourceRange getSourceRange() {
	return new SourceRange(0, this.sourceLength);
}
/**
 * Sets the length of the source string.
 */
public void setSourceLength(int newSourceLength) {
	this.sourceLength = newSourceLength;
}
}
