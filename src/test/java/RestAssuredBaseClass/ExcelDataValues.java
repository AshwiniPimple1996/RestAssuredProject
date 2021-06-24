package RestAssuredBaseClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import dataprovider.DataProviderJsonBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import pojo.Category;
import pojo.RootBody;
import pojo.Tags;

public class ExcelDataValues {

	@Test(enabled=true,dataProvider="DataProviderJsonBody")
	public void jsonpojobody(String id,String name,String status,String catId,String catName,String tagId,String tagName,String photourlarray) throws Exception{
		
		RestAssured.baseURI="http://localhost:3000";
		
		RootBody object=new RootBody();
		Category catobject=new Category();
		Tags tagobject=new Tags();
		
		List<String> photoUrlsobject=new ArrayList<String>();
		
		photoUrlsobject.add(photourlarray);
		//photoUrlsobject.add(photourlarray1);
		
		object.setId(id);
		object.setName(name);
		object.setStatus(status);
		
		catobject.setId(catId);
		catobject.setName(catName);
		
		tagobject.setId(tagId);
		tagobject.setName(tagName);
		
		object.setPhotoUrls(photoUrlsobject);
		object.setCategory(catobject);
		object.setTags(tagobject);
		
		ObjectMapper mapper=new ObjectMapper();
		
		String jsonbody=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonbody).
		when()
			.post("/employee").then().statusCode(201).log().all();
	
		System.out.println(jsonbody);
		
		given()
			.get("/employee").
		then()
			//.body(name, equalTo(object)).log().all();
			.body(status, hasItem("pending")).log().all();
	
		
		
	}
	
	@DataProvider(name = "DataProviderJsonBody")
	public Object[][] exceldata() throws Exception {
		Object[][] data = DataProviderJsonBody.getexceldata();

		return data;

	}
	
	@Test(enabled=false)
	public void assertBody(){
		JSONObject jsonrootobject=new JSONObject();
		
		RestAssured.baseURI=("http://localhost:3000");
		
		
		given()
			.get("/employee").
		then()
			.body("name", equalTo("neha")).log().all();
		//.body("title", hasItem("design")).log().all();
			
	}

	
	

	
	
}
