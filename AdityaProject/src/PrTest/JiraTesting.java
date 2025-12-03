package PrTest;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://localhost:8080/";
		
		
		SessionFilter session= new SessionFilter();
		
		given().relaxedHTTPSValidation().header("content-type", "application/json")
		.body("{\r\n"
				+ "    \"username\": \"rvrm30\",\r\n"
				+ "    \"password\": \"ambition1\"\r\n"
				+ "}").filter(session)
		.when().post("rest/auth/1/session")
		.then().extract().asString();
		
		//Create Issue
		String response= given().header("content-type", "application/json")
		.filter(session).body("{\r\n"
				+ "   \"fields\":{\r\n"
				+ "       \"project\":{\r\n"
				+ "           \"key\":\"PRAC\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Unable to launch epic\",\r\n"
				+ "       \"description\":\"Unable to launch epic on test env\",\r\n"
				+ "       \"issuetype\":{\r\n"
				+ "           \"name\":\"Bug\"\r\n"
				+ "       }\r\n"
				+ "     }\r\n"
				+ "\r\n"
				+ "   }\r\n"
				+ "            ")
		.log().all()
		.when().post("rest/api/2/issue")
		.then().extract().asString();
		
		JsonPath js= new JsonPath(response);
		int Bugid=js.getInt("id");
		System.out.println(Bugid);
		
		
		//Add Comment
		given().pathParam("defectid", Bugid).header("content-type", "application/json")
		.body("{\r\n"
				+ "    \"body\": \"Issue still exist attachments\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).log().all()
		.when().post("rest/api/2/issue/{defectid}/comment");
		
		//Update Comment
		
		//Add Attachments
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("defectid", Bugid)
		.header("Content-Type", "multipart/form-data")
		.multiPart("file",new File("C:\\Users\\supub\\Notworking.txt"))
		.when().post("rest/api/2/issue/{defectid}/attachments")
		.then().assertThat().statusCode(200);
		
		
		//Get Issue
		String butdetailsresponse=given().filter(session).pathParam("defectid", Bugid)
		.queryParam("fields", "comment")
		.when().get("/rest/api/2/issue/{defectid}")
		.then().log().all().extract().response().asString();
		
		System.out.println(butdetailsresponse);
		
		
	}

}
