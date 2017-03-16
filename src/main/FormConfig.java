package main;

import rdfbones.form.FormConfiguration;
import rdfbones.lib.GraphLib;
import rdfbones.lib.TripleLib;

public class FormConfig {

	public static FormConfiguration sde() {

		FormConfiguration formConfig = GraphLib.getFormConfig(
				TripleLib.sdeDataTiples(), TripleLib.sdeSchemeTriples(),
				TripleLib.sdeForm(), TripleLib.sdeFormGraph());
		formConfig.dataGraph.globalLabelKey = "objectUriLabel";
		return formConfig;
	}
	
	public static FormConfiguration si() {

		return GraphLib.getFormConfig(TripleLib.skeletalInvDataTriples(), 
				TripleLib.skeletalInvRestrictionTriples(), TripleLib.skeletalInvForm());
	}
	
	public static FormConfiguration csr() {

		return GraphLib.getFormConfig(
				TripleLib.csrDataTriples(), TripleLib.csrSchemeTriples(),
				TripleLib.csrForm());
	}
	
}
