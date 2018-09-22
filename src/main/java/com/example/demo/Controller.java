package com.example.demo;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.Body;
import com.example.form.Nest;
import com.example.form.Response;
import com.example.form.ScheduleList;

@RestController
@Validated
public class Controller {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/login",
			// Jsonをリクエストにする設定
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public Response loginUser(@Validated @RequestBody Body body) {
		Nest nest = new Nest();
		Response response = new Response();

		System.out.println("sql実行");
		List<Map<String, Object>> list2 = jdbcTemplate.queryForList("SELECT * FROM users WHERE password=? AND name=?",
				body.getPassword(), body.getName());
		String strName = list2.get(0).get("name").toString();
		String strPassword = list2.get(0).get("password").toString();
		String strId = list2.get(0).get("id").toString();

		String msg = messageSource.getMessage("search.goodcondition", null, Locale.JAPANESE);

		System.out.println("response");
		System.out.println(list2);
		System.out.println("response");

		nest.setName(strName);
		nest.setPassword(strPassword);
		nest.setId(strId);
		response.setResponse(nest);
		response.setMassage(msg);
		response.setResult("true");

		System.out.println(response);

		return response;
	}

	@RequestMapping(value = "/adduser",
			// Jsonをリクエストにする設定
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public Response adduser(@Validated @RequestBody Body body) {
		Nest nest = new Nest();

		Response response = new Response();
		System.out.println("sql実行_追加");
		System.out.println(body);

		jdbcTemplate.update("INSERT INTO users (name,password) VALUES (?,?)", body.getName(), body.getPassword());
		response.setResult("true");
		return response;
	}

	@RequestMapping(value = "/memberList",
			// Jsonをリクエストにする設定
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public List<Map<String, Object>> menberList(@Validated @RequestBody Body body) {
		Nest nest = new Nest();

		Response response = new Response();
		System.out.println("sql実行_メンバー一覧");

		List<Map<String, Object>> list2 = jdbcTemplate.queryForList("SELECT * FROM users");
		// String strName = list2.get(0).get("name").toString();
		// String strPassword = list2.get(0).get("password").toString();
		// String strId = list2.get(0).get("id").toString();
		// String position = list2.get(0).get("position").toString();
		// String user_comment = list2.get(0).get("user_comment").toString();
		// String number = list2.get(0).get("number").toString();

		// String msg = messageSource.getMessage("search.goodcondition", null,
		// Locale.JAPANESE);

		System.out.println("response");
		System.out.println(list2);
		System.out.println("response");

		// nest.setName(strName);
		// nest.setPassword(strPassword);
		// nest.setId(strId);
		// nest.setPosition(position);
		// nest.setUser_comment(user_comment);
		// nest.setNumber(number);
		// response.setResponse(nest);
		// response.setMassage(msg);
		// response.setResult("true");

		System.out.println(response);

		return list2;
	}

	@RequestMapping(value = "/scheduleList",
			// Jsonをリクエストにする設定
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public List<Map<String, Object>> scheduleList(@Validated @RequestBody ScheduleList scheduleList) {
		Nest nest = new Nest();

		Response response = new Response();
		System.out.println("sql実行_スケジュール一覧");

		List<Map<String, Object>> list2 = jdbcTemplate.queryForList("SELECT * FROM schedule");
		// String strName = list2.get(0).get("name").toString();
		// String strPassword = list2.get(0).get("password").toString();
		// String strId = list2.get(0).get("id").toString();
		// String position = list2.get(0).get("position").toString();
		// String user_comment = list2.get(0).get("user_comment").toString();
		// String number = list2.get(0).get("number").toString();

		// String msg = messageSource.getMessage("search.goodcondition", null,
		// Locale.JAPANESE);

		System.out.println("response");
		System.out.println(list2);
		System.out.println("response");

		// nest.setName(strName);
		// nest.setPassword(strPassword);
		// nest.setId(strId);
		// nest.setPosition(position);
		// nest.setUser_comment(user_comment);
		// nest.setNumber(number);
		// response.setResponse(nest);
		// response.setMassage(msg);
		// response.setResult("true");

		System.out.println(response);

		return list2;
	}

}