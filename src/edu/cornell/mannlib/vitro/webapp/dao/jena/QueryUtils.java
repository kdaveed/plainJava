package edu.cornell.mannlib.vitro.webapp.dao.jena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rdfbones.lib.JSON;

public class QueryUtils {

  public static List<Map<String, String>> getResult(String queryStr, List<String> uris, List<String> literals){
    
    //Generating dummy data
    List<Map<String, String>> result = new ArrayList<Map<String, String>>();
    Map<String, String> singleResult = new HashMap<String, String>();
    for(String uri : uris){
      String rand = new String(uri + Double.toString(Math.random()*100000).substring(0, 4));
      singleResult.put(uri, rand);
    }
    if(literals != null){
      for(String literal : literals){
        singleResult.put(literal, literal);
      }
    }
    result.add(singleResult);
    return result;
  }
  
  public static String subUrisForQueryVars(String queryString, Map<String, String> varsToUris) {
  
    for (String var : varsToUris.keySet()) {
       queryString = subUriForQueryVar(queryString, var, varsToUris.get(var));
    }
    return queryString;
  }

  public static String subUrisForQueryLiterals(String queryString, Map<String, String> varsToUris) {
    
    for (String var : varsToUris.keySet()) {
       queryString = subUriForQueryLiteral(queryString, var, varsToUris.get(var));
    }
    return queryString;
  }
  
  /** Manually replace a query variable with a uri when prebinding causes the query to fail, probably
   * due to a Jena bug.
   */
  public static String subUriForQueryLiteral(String queryString, String varName, String literal) {
    return queryString.replaceAll("\\?" + varName + "\\b", "\"" + literal + "\"");
  }
  
  public static String subUriForQueryVar(String queryString, String varName, String uri) {
      return queryString.replaceAll("\\?" + varName + "\\b", "<" + uri + ">");
  }
  
  public static JSONArray getJSON(List<Map<String, String>> results){
    
    JSONArray resultArray = new JSONArray();
    for(Map<String, String> result : results){
      JSONObject jsonObject = new JSONObject();
      for(String key : result.keySet()){
        try {
          jsonObject.put(key, result.get(key));
        } catch (JSONException e) {
          // TODO Autogenerated catch block
          e.printStackTrace();
        }
      }
      resultArray.put(jsonObject);
    }   
    return resultArray;
  }
  
  public static JSONObject getJSONObject(List<Map<String, String>> results){
	    
	  return (JSONObject) JSON.get(getJSON(results), 0);
  }
  
}