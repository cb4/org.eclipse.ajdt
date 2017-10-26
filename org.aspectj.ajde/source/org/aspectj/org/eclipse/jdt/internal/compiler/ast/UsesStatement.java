/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This is an implementation of an early-draft specification developed under the Java
 * Community Process (JCP) and is made available for testing and evaluation purposes
 * only. The code is not compatible with any specification of the JCP.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.aspectj.org.eclipse.jdt.internal.compiler.ast;

public class UsesStatement extends ModuleStatement {

	public TypeReference serviceInterface;

	public UsesStatement(TypeReference serviceInterface) {
		this.serviceInterface = serviceInterface;
	}
	@Override
	public StringBuffer print(int indent, StringBuffer output) {
		printIndent(indent, output);
		output.append("uses "); //$NON-NLS-1$
		this.serviceInterface.print(0, output);
		output.append(";"); //$NON-NLS-1$
		return output;
	}

}
