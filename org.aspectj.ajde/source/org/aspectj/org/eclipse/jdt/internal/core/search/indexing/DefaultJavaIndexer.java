/*******************************************************************************
 * Copyright (c) 2011, 2013 IBM Corporation and others.
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
package org.aspectj.org.eclipse.jdt.internal.core.search.indexing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.Path;
import org.aspectj.org.eclipse.jdt.core.search.IJavaSearchScope;
import org.aspectj.org.eclipse.jdt.core.search.SearchEngine;
import org.aspectj.org.eclipse.jdt.core.search.SearchParticipant;
import org.aspectj.org.eclipse.jdt.internal.compiler.util.Util;
import org.aspectj.org.eclipse.jdt.internal.core.index.FileIndexLocation;
import org.aspectj.org.eclipse.jdt.internal.core.index.Index;
import org.aspectj.org.eclipse.jdt.internal.core.index.IndexLocation;
import org.aspectj.org.eclipse.jdt.internal.core.search.JavaSearchDocument;

@SuppressWarnings("rawtypes")
public class DefaultJavaIndexer {
	private static final char JAR_SEPARATOR = IJavaSearchScope.JAR_FILE_ENTRY_SEPARATOR.charAt(0);

	public void generateIndexForJar(String pathToJar, String pathToIndexFile) throws IOException {
		File f = new File(pathToJar);
		if (!f.exists()) {
			throw new FileNotFoundException(pathToJar + " not found"); //$NON-NLS-1$
		}
		IndexLocation indexLocation = new FileIndexLocation(new File(pathToIndexFile));
		Index index = new Index(indexLocation, pathToJar, false /*reuse index file*/);
		SearchParticipant participant = SearchEngine.getDefaultSearchParticipant();
		index.separator = JAR_SEPARATOR;
		ZipFile zip = new ZipFile(pathToJar);
		try {
			for (Enumeration e = zip.entries(); e.hasMoreElements();) {
				// iterate each entry to index it
				ZipEntry ze = (ZipEntry) e.nextElement();
				String zipEntryName = ze.getName();
				if (Util.isClassFileName(zipEntryName)) {
					final byte[] classFileBytes = org.aspectj.org.eclipse.jdt.internal.compiler.util.Util.getZipEntryByteContent(ze, zip);
					JavaSearchDocument entryDocument = new JavaSearchDocument(ze, new Path(pathToJar), classFileBytes, participant);
					entryDocument.setIndex(index);
					new BinaryIndexer(entryDocument).indexDocument();
				}
			}
			index.save();
		} finally {
			zip.close();
		}
		return;
	}
}
