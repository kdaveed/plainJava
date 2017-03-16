package main;

import org.json.JSONObject;

import rdfbones.form.FormConfiguration;
import rdfbones.formProcessing.AJAXController;
import rdfbones.graphData.Graph;
import rdfbones.lib.JSON;
import webappconnector.PlainJavaWebappConnector;

public class Test {

	public static void getData(String formType) {

		Graph graph = fc(formType).dataGraph;
		System.out
				.println(JSON.debug(graph.getExistingData("subject1", "object1")));
	}

	public static String delete(String formType, String graphVar) {

		FormConfiguration fc = fc(formType);
		Graph graph = fc.dataGraph.graphCache.get(graphVar);
		return graph.deleteData(JSONTest.getObject("delete_" + formType + "_"
				+ graphVar));
	}

	public static void input(String formType) {

		FormConfiguration fc = fc(formType);
		log(fc.dataGraph.saveInitialData(JSONTest.getObject("inputData_"
				+ formType)));
	}

	public static void debug(String formType) {

		fc(formType).dataGraph.debug();
	}

	public static void dependencyDebug(String formType) {

		fc(formType).dataGraph.dependencyDebug();
	}

	public static void dependencyDescriptor(String formType) {

		System.out
				.println(JSON.debug(fc(formType).dataGraph.dependencyDescriptor()));
	}

	public static void ajax(String formType, String jsonFile) {

		AJAXController ajax = new AJAXController(fc(formType),
				JSONTest.getObject(jsonFile));
		System.out.println(JSON.debug(ajax.response));
	}
	
	public static FormConfiguration fc(String name) {

		FormConfiguration fc;
		switch (name) {
		case "sde":
			fc =  FormConfig.sde();
			break;
		case "csr":
			fc =  FormConfig.csr();
			break;
		case "si":
			fc = FormConfig.csr();
			break;
		default:
			fc =  new FormConfiguration();
			break;
		}
		//fc.setWebapp(new PlainJavaWebappConnector());
		return fc;
	}

	public static Graph graph(String formType) {

		return fc(formType).dataGraph;
	}
	
	public static void addFormData(String formType, String varName){
		
		JSONObject obj = JSONTest.getObject("addFormData_" + formType + "_" + varName);
		log(JSON.debug(new AJAXController(fc(formType), obj).response));
	}
	
	public static void log(String msg){
		
		System.out.println(msg);
	}		

}
