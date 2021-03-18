package com.rutu.example.graphshighchartsexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rutu.example.graphshighchartsexample.entity.Grades;
import com.rutu.example.graphshighchartsexample.repository.GradesRepository;

@Controller
public class GraphController {
	@Autowired 
	private GradesRepository gradesRepository;
	
	
	@ResponseBody
	@RequestMapping(path="/get-data")
    public String getAllGrades() {
		List<Grades> gradesList=gradesRepository.findAll();
		JsonArray jsonSem=new JsonArray();
		JsonArray jsonGpa=new JsonArray();
		JsonObject json=new JsonObject();
		gradesList.forEach(data->{
			jsonSem.add(data.getSem());
			jsonGpa.add(data.getGpa());
		});
		json.add("sem",jsonSem);
		json.add("gpa",jsonGpa);
		return json.toString();
	}
}
	
	
	
	
	
