package main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import rdfbones.lib.JSON;

public class JSONTest {

	static String basePath = new String(
			"/Users/konkolydavid/ESE MSc/HiWi/Modules/TestJSON/");
	
	public static	JSONObject formDescripor(){
		return getObject("formDescriptor");
	}
	
	public static JSONObject sdeInput(){
		return getObject("sde_inputData");
	}
	
	public static	JSONObject existingFormGraphData(){
		return getObject("existingFormGraphData");
	}
	
	public static JSONObject getObject(String path){
		return JSON.obj(readFile(basePath + path + ".txt"));
	}

	public static JSONArray getArray(String path){
		return JSON.arr(readFile(basePath + path + ".txt"));
	}
	
	public static String readFile(String filename) {
		String content = null;
		File file = new File(filename); // for ex foo.txt
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return content;
	}
	
}
