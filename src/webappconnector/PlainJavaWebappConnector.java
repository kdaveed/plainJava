package webappconnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONArray;

import rdfbones.formProcessing.WebappConnector;
import rdfbones.lib.ArrayLib;
import rdfbones.lib.JSON;
import edu.cornell.mannlib.vitro.webapp.dao.jena.QueryUtils;

public class PlainJavaWebappConnector implements WebappConnector{

  public Map<String, Object> requestMap = new HashMap<String, Object>();
  boolean logEnabled = true;
  JSONArray queries = JSON.arr();
  
  public PlainJavaWebappConnector(){
    
  	this.queries = JSON.arr();
  }
  
  public PlainJavaWebappConnector(boolean log){
    this.logEnabled = log;
  }

  public String getInputParameter(String parameterName){
    
    if(this.requestMap.containsKey(parameterName)){
      return this.requestMap.get(parameterName).toString();
    } else {
      return parameterName + "URI";  
    }
  }
  
  public List<Map<String, String>> sparqlResult(String queryStr, List<String> uris, List<String> literals){

  	this.queries.put(queryStr);	
  	return QueryUtils.getResult(queryStr, uris, literals);
  }
  
  public void log(String msg){
    
    if(this.logEnabled){
      System.out.println(msg);
    }
  }

  public String getUnusedURI() {
    return new String(UUID.randomUUID().toString().substring(0, 2));
  }

  public boolean addTriples(String triples, String editKey){
    return true;    
  }
 
  public boolean removeTriples(String triples, String editKey){
    return true;
  }
  
  public void addToQueries(String query){
  	log(query);
  }
  
  public JSONArray getQueries(){
  	return this.queries;
  }
  
}
