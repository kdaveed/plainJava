package rdfbones.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import rdfbones.graphData.Graph;
import rdfbones.lib.ArrayLib;
import rdfbones.rdfdataset.RDFNode;
import rdfbones.rdfdataset.Triple;

import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;

public class GraphTest {

	Graph graph;

	public GraphTest(Graph graph) {
		this.graph = graph;
	}

	public void newInstances(String... strings) {
		assertEquals(graph.newInstances, ArrayLib.getList(strings));
	}

	public void triplesToStore(String subject, String predicate, String object) {

		this.testTriples("graph.triplesToStore", graph.triplesToStore, subject, predicate, object);
	}

	public void dataQueryTriples(String subject, String predicate, String object) {

		this.testTriples("graph.dataRetreivalQuery", graph.dataRetreivalQuery, subject, predicate, object);
	}

	public void typeQueryTriples(String subject, String predicate, String object) {

		this.testTriples("graph.typeQueryTriples", graph.typeQueryTriples, subject, predicate, object);
	}

	public List<String> getList(List<RDFNode> nodes) {

		List<String> list = new ArrayList<String>();
		for (RDFNode node : nodes) {
			list.add(node.varName);
		}
		return list;
	}

	public void testTriples(String msg, List<Triple> triples, String subject,
			String predicate, String object) {

		boolean found = false;
		for (Triple triple : triples) {

			if (triple.subject.varName.equals(subject)
					&& triple.predicate.equals(predicate)
					&& triple.object.varName.equals(object)) {
				found = true;
			}
		}
		if (!found) {
			fail("Triple : " + subject + " " + predicate + " " + object + "\n"
					+ "is not found in " + msg);
		}
	}

}
