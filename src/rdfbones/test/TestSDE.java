package rdfbones.test;

import static org.junit.Assert.*;
import main.FormConfig;

import org.junit.Before;
import org.junit.Test;

import rdfbones.form.FormConfiguration;

public class TestSDE {

	GraphTest graphTest;
	
	@Before
	public void setUp() {

		FormConfiguration formConfig = FormConfig.sde();
		this.graphTest = new GraphTest(formConfig.dataGraph);
	}
	
	@Test 
	public void test(){
		
		//New instances
		graphTest.newInstances("objectUri");
		//Triples to store
		graphTest.triplesToStore("subjectUri", "obo:BFO_0000051", "objectUri");
		graphTest.triplesToStore("objectUri", "rdf:type", "objectUriType");
		//Data query triples
		graphTest.dataQueryTriples("subjectUri", "obo:BFO_0000051", "objectUri");
		graphTest.dataQueryTriples("objectUri", "vitro:mostSpecificType", "objectUriType");
		graphTest.dataQueryTriples("objectUriType", "rdfs:subClassOf", "obo:OBI_0000471");
		//Type query triples
		graphTest.typeQueryTriples("subjectUri", "rdf:type", "subjectType");
		graphTest.typeQueryTriples("subjectType", "obo:BFO_0000051", "objectUriType");
		graphTest.typeQueryTriples("objectUriType", "rdfs:subClassOf", "obo:OBI_0000471");
	}
}
