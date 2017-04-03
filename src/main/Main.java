package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import rdfbones.form.FormConfiguration;
import rdfbones.formProcessing.DependencyCalculator;
import rdfbones.graphData.Graph;
import rdfbones.graphData.GraphPath;
import rdfbones.graphData.VariableDependency;
import rdfbones.lib.ArrayLib;
import rdfbones.lib.DebugLib;
import rdfbones.lib.GraphLib;
import rdfbones.lib.JSON;
import rdfbones.lib.Log;
import rdfbones.lib.TripleLib;
import rdfbones.rdfdataset.RDFNode;
import rdfbones.test.PathTest;

public class Main {

	public static void main(String[] args) {

		/*
		 * getData(String formType) delete(String formType, String graphVar)
		 * input(String formType) debug(String formType) dependencyDebug(String
		 * formType) dependencyDescriptor(String formType) ajax(String formType,
		 * String jsonFile) addFormData(String formType, String varName)
		 */
		Test.debug("sde");
		
	}

	public static void log(String msg) {

		System.out.println(msg);
	}

	public static void pathTest() {

		List<String> inputVariables = new ArrayList<String>();
		GraphPath path = DependencyCalculator.getGraphPath(TripleLib
				.sdeInstanceRestrictionTriples(), inputVariables, new String(
				"skeletalInventory"));
		log(path.debug());
	}

}