package com.qa.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

public class JSONUtil {

	private ObjectMapper mapper;

	public JSONUtil() {
		this.mapper = new ObjectMapper();
	}

	public String getJSONForObject(Object obj) {
		try {
			return mapper.writeValueAsString(obj);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}