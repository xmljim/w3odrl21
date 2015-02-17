/**
 * 
 */
/**
 * @author Jim Earley <xml.jim@gmail.com> Sep 4, 2014
 * 
 *         This package contains the interfaces and default implementation for parsing ODRL documents. Parsing and processing uses a
 *         "load and push" approach: First the native format is parsed and loaded into memory using default implementations such a
 *         {@linkplain org.w3c.dom.Document} or {@linkplain com.ghotibown.json.JSONObject}.
 * 
 *         After the document is loaded, the {@link org.w3c.odrl.v21.parsers.IOdrlContentProcessor} is called to process the document into
 *         an {@link org.w3c.odrl.v21.model.IOdrlDocument}. The {@link org.w3c.odrl.v21.parsers.IOdrlContentProcessor} traversed the
 *         document structure and uses {@link org.w3c.odrl.v21.parsers.entityhandlers.IOdrlEntityHandler} instances to create
 * 
 *         There are currently two implementations
 *
 */
package org.w3c.odrl.W3COdrl2.parsers;