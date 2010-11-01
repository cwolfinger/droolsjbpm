package org.drools.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.io.DataIOException;
import prefuse.data.io.TreeMLWriter;

public class DRLTreeMLFormatter {
		

	public static final String FIELD = "text";

	public static InputStream getAsStream(CommonTree resultTree) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Graph graph = buildGraph(resultTree);
		
		TreeMLWriter writer = new TreeMLWriter();				
		try {
			writer.writeGraph(graph, baos);
		} catch (DataIOException e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(baos.toByteArray());
	}

	private static Graph buildGraph(CommonTree resultTree) {
		Graph tree = new Graph(true);
			tree.addColumn(FIELD, String.class);
			Node root = tree.addNode();
			root.set(FIELD, resultTree.toString());
			visit(resultTree, root, tree);
		return tree;
	}

	private static void visit(Tree sourceTree, Node father, Graph tgtTree) {
		int N = sourceTree.getChildCount();
		
		for (int j = 0; j < N; j++) {
			Node n = tgtTree.addNode();			
			Tree child = sourceTree.getChild(j);
			n.setString(FIELD, child.toString());
			tgtTree.addEdge(father,n);
			visit(child,n,tgtTree);
		}
		
	}

}
