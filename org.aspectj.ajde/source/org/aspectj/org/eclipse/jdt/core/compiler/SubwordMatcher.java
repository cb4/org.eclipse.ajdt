/*******************************************************************************
 * Copyright (c) 2020 Julian Honnen.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Julian Honnen - initial API and implementation
 *******************************************************************************/
package org.aspectj.org.eclipse.jdt.core.compiler;

import java.util.Arrays;
import java.util.BitSet;

import org.aspectj.org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

class SubwordMatcher {

	private static final int[] EMPTY_REGIONS = new int[0];

	private final char[] name;
	private final BitSet wordBoundaries;

	public SubwordMatcher(String name) {
		this.name = name.toCharArray();
		this.wordBoundaries = new BitSet(name.length());

		BoundaryState state = BoundaryState.SEPARATOR;
		for (int i = 0; i < this.name.length; i++) {
			char c = this.name[i];
			if (state.isWordBoundary(c)) {
				this.wordBoundaries.set(i);
			}
			state = state.next(c);
		}
	}

	public int[] getMatchingRegions(String pattern) {
		int segmentStart = 0;
		int[] segments = EMPTY_REGIONS;

		// Main loop is on pattern characters
		int iName = -1;
		int iPatternWordStart = 0;
		for (int iPattern = 0; iPattern < pattern.length(); iPattern++) {
			iName++;
			if (iName == this.name.length) {
				// We have exhausted the name (and not the pattern), so it's not a match
				return null;
			}

			char patternChar = pattern.charAt(iPattern);
			char nameChar = this.name[iName];

			// For as long as we're exactly matching, bring it on
			if (patternChar == nameChar) {
				continue;
			}
			if (!isWordBoundary(iName) && equalsIgnoreCase(patternChar, nameChar)) {
				// we're not at a word boundary, case-insensitive match is fine
				continue;
			}

			// not matching, record previous segment and find next word match in name
			if (iName > segmentStart) {
				segments = Arrays.copyOf(segments, segments.length + 2);
				segments[segments.length - 2] = segmentStart;
				segments[segments.length - 1] = iName - segmentStart;
			}

			int wordStart = indexOfWordStart(iName, patternChar);
			if (wordStart < 0) {
				// no matching word found, backtrack and try to find next occurrence of current word
				int next = indexOfWordStart(iName, pattern.charAt(iPatternWordStart));
				if (next > 0) {
					wordStart = next;
					iPattern = iPatternWordStart;
					// last recorded segment was invalid -> drop it
					segments = Arrays.copyOfRange(segments, 0, segments.length - 2);
				}
			}

			if (wordStart < 0) {
				// We have exhausted name (and not pattern), so it's not a match
				return null;
			}

			segmentStart = wordStart;
			iName = wordStart;
			iPatternWordStart = iPattern;
		}

		// we have exhausted pattern, record final segment
		segments = Arrays.copyOf(segments, segments.length + 2);
		segments[segments.length - 2] = segmentStart;
		segments[segments.length - 1] = iName - segmentStart + 1;

		return segments;
	}

	/**
	 * Returns the index of the first word after nameStart, beginning with patternChar. Returns -1 if no matching word
	 * is found.
	 */
	private int indexOfWordStart(int nameStart, char patternChar) {

		for (int iName = nameStart; iName < this.name.length; iName++) {
			char nameChar = this.name[iName];
			if (isWordBoundary(iName) && equalsIgnoreCase(nameChar, patternChar)) {
				return iName;
			}

			// don't match across identifiers (e.g. "index" should not match "substring(int beginIndex)")
			if (!ScannerHelper.isJavaIdentifierPart(nameChar)) {
				return -1;
			}
		}

		// We have exhausted name
		return -1;
	}

	private boolean equalsIgnoreCase(char a, char b) {
		return ScannerHelper.toLowerCase(a) == ScannerHelper.toLowerCase(b);
	}

	private boolean isWordBoundary(int iName) {
		return this.wordBoundaries.get(iName);
	}

	private enum BoundaryState {
		SEPARATOR() {
			@Override
			public BoundaryState next(char c) {
				if (c == '_')
					return SEPARATOR;

				return ScannerHelper.isUpperCase(c) ? CAPS_WORD : WORD;
			}
			@Override
			public boolean isWordBoundary(char c) {
				return true;
			}
		},
		WORD() {
			@Override
			public BoundaryState next(char c) {
				if (c == '_')
					return SEPARATOR;

				return WORD;
			}

			@Override
			public boolean isWordBoundary(char c) {
				return ScannerHelper.isUpperCase(c);
			}
		},
		CAPS_WORD() {
			@Override
			public BoundaryState next(char c) {
				if (c == '_')
					return SEPARATOR;

				return ScannerHelper.isUpperCase(c) ? CAPS_WORD : WORD;
			}

			@Override
			public boolean isWordBoundary(char c) {
				return next(c) == SEPARATOR;
			}
		};

		public abstract boolean isWordBoundary(char c);

		public abstract BoundaryState next(char c);
	}
}