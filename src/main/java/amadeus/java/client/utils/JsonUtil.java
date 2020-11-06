package amadeus.java.client.utils;

import java.io.File;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtil {
	@Autowired
	private ObjectMapper mapper;
	public  String toString(Object object) throws Exception {
		String json = mapper.writeValueAsString(object);
		return json;
	}
	public  File toFile(Object object, File file) throws Exception {
		String json = toString(object);
		try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath())) {
		    fileWriter.write(json);
		}
		return file;
	}
}
