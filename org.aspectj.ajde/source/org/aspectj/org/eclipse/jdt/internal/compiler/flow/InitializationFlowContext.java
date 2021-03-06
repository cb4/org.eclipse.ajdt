/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
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
package org.aspectj.org.eclipse.jdt.internal.compiler.flow;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.aspectj.org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

/**
 * Reflects the context of code analysis, keeping track of enclosing
 *	try statements, exception handlers, etc...
 */
public class InitializationFlowContext extends ExceptionHandlingFlowContext {
	public int exceptionCount;
	public TypeBinding[] thrownExceptions = new TypeBinding[5];
	public ASTNode[] exceptionThrowers = new ASTNode[5];
	public FlowInfo[] exceptionThrowerFlowInfos = new FlowInfo[5];
	public FlowInfo	initsBeforeContext;

	public InitializationFlowContext(FlowContext parent, ASTNode associatedNode, FlowInfo initsBeforeContext, FlowContext initializationParent, BlockScope scope) {
		super(
			parent,
			associatedNode,
			Binding.NO_EXCEPTIONS, // no exception allowed by default
			initializationParent,
			scope,
			FlowInfo.DEAD_END);
		this.initsBeforeContext = initsBeforeContext;
	}

	public void checkInitializerExceptions(
		BlockScope currentScope,
		FlowContext initializerContext,
		FlowInfo flowInfo) {
		for (int i = 0; i < this.exceptionCount; i++) {
			initializerContext.checkExceptionHandlers(
				this.thrownExceptions[i],
				this.exceptionThrowers[i],
				this.exceptionThrowerFlowInfos[i],
				currentScope);
		}
	}

	@Override
	public FlowContext getInitializationContext() {
		return this;
	}

	@Override
	public String individualToString() {

		StringBuffer buffer = new StringBuffer("Initialization flow context"); //$NON-NLS-1$
		for (int i = 0; i < this.exceptionCount; i++) {
			buffer.append('[').append(this.thrownExceptions[i].readableName());
			buffer.append('-').append(this.exceptionThrowerFlowInfos[i].toString()).append(']');
		}
		return buffer.toString();
	}

	@Override
	public void recordHandlingException(
		ReferenceBinding exceptionType,
		UnconditionalFlowInfo flowInfo,
		TypeBinding raisedException,
		TypeBinding caughtException,
		ASTNode invocationSite,
		boolean wasMasked) {

		// even if unreachable code, need to perform unhandled exception diagnosis
		int size = this.thrownExceptions.length;
		if (this.exceptionCount == size) {
			System.arraycopy(
				this.thrownExceptions,
				0,
				(this.thrownExceptions = new TypeBinding[size * 2]),
				0,
				size);
			System.arraycopy(
				this.exceptionThrowers,
				0,
				(this.exceptionThrowers = new ASTNode[size * 2]),
				0,
				size);
			System.arraycopy(
				this.exceptionThrowerFlowInfos,
				0,
				(this.exceptionThrowerFlowInfos = new FlowInfo[size * 2]),
				0,
				size);
		}
		this.thrownExceptions[this.exceptionCount] = raisedException;
		this.exceptionThrowers[this.exceptionCount] = invocationSite;
		this.exceptionThrowerFlowInfos[this.exceptionCount++] = flowInfo.copy();
	}
}
