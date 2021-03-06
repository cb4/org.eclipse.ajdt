/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation.
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

package org.aspectj.org.eclipse.jdt.internal.compiler.apt.model;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.RecordComponentElement;

import org.aspectj.org.eclipse.jdt.internal.compiler.apt.dispatch.BaseProcessingEnvImpl;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

public class RecordComponentElementImpl extends VariableElementImpl implements RecordComponentElement {

	protected RecordComponentElementImpl(BaseProcessingEnvImpl env, FieldBinding binding) {
		super(env, binding);
	}

	@Override
	public ElementKind getKind() {
		return ElementKind.RECORD_COMPONENT;
	}

	@Override
	public ExecutableElement getAccessor() {
		FieldBinding field = (FieldBinding) this._binding;
		ReferenceBinding binding = field.declaringClass;
		if (binding instanceof SourceTypeBinding) {
			MethodBinding accessor = ((SourceTypeBinding) binding).getRecordComponentAccessor(field.name);
			return new ExecutableElementImpl(_env, accessor);
		}
		return null;
	}
}
