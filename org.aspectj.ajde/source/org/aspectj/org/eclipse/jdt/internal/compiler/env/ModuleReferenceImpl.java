/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation.
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
package org.aspectj.org.eclipse.jdt.internal.compiler.env;

import org.aspectj.org.eclipse.jdt.core.compiler.CharOperation;

public class ModuleReferenceImpl implements IModule.IModuleReference {
	public char[] name;
	public int modifiers;
	@Override
	public char[] name() {
		return this.name;
	}
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (!(o instanceof IModule.IModuleReference))
			return false;
		IModule.IModuleReference mod = (IModule.IModuleReference) o;
		if (this.modifiers != mod.getModifiers())
			return false;
		return CharOperation.equals(this.name, mod.name());
	}
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public int getModifiers() {
		return this.modifiers;
	}
}