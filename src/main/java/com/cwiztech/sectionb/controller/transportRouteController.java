package com.cwiztech.sectionb.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cwiztech.sectionb.model.TransportRoute;
import com.cwiztech.sectionb.repository.transportRouteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/transportroute")
public class transportRouteController {

	@Autowired 
	private transportRouteRepository transportrouterepository;
	
	@RequestMapping(method = RequestMethod.GET)
	private List<TransportRoute> get() {
		List<TransportRoute> transportroutes = transportrouterepository.findActive();
		return transportroutes;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	private List<TransportRoute> getAll() {
		List<TransportRoute> transportroutes = transportrouterepository.findAll();
		return transportroutes;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private TransportRoute getOne(@PathVariable long id) {
		TransportRoute transportroute = transportrouterepository.findOne(id);
		return transportroute;
	}

	@RequestMapping(value = "/old", method = RequestMethod.POST)
	private TransportRoute insert(@RequestBody TransportRoute data) {
		TransportRoute transportroute = transportrouterepository.saveAndFlush(data);
		return transportroute;
	}

	@RequestMapping(method = RequestMethod.POST)
	private String insert(@RequestBody String data) throws JsonProcessingException {
		return insertupdateAll(data);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private String update(@RequestBody String data) throws JsonProcessingException {
		return insertupdateAll(data);
	}

	@RequestMapping(method = RequestMethod.PUT)
	private String insertupdate(@RequestBody String data) throws JsonProcessingException {
		JSONArray jsonTransportRoutes = new JSONArray(data);
		JSONArray jsonAPIResponse = new JSONArray();
				
		for (int i=0; i<jsonTransportRoutes.length(); i++) {
			jsonAPIResponse.put(insertupdateAll(jsonTransportRoutes.get(i).toString()));
		}
		return jsonAPIResponse.toString();
	}
	
	private String insertupdateAll(String data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String rtnAPIResponse = "Invalid Response";
		JSONObject jsonTransportRoute = new JSONObject(data);
		
		TransportRoute transportroute = new TransportRoute();

		if (!jsonTransportRoute.has("transportroute_CODE") || jsonTransportRoute.isNull("transportroute_CODE"))
		{
			return "transportroute_CODE is missing!";
		}

		if (!jsonTransportRoute.has("transportroute_DESC") || jsonTransportRoute.isNull("transportroute_DESC"))
		{
			return "transportroute_DESC is missing!";
		}

		if (!jsonTransportRoute.has("routetype_ID") || jsonTransportRoute.isNull("routetype_ID"))
		{
			return "routetype_ID is missing!";
		}

		transportroute.setTRANSPORTROUTE_CODE(jsonTransportRoute.getString("transportroute_CODE"));
		transportroute.setTRANSPORTROUTE_DESC(jsonTransportRoute.getString("transportroute_DESC"));
		transportroute.setROUTETYPE_ID(jsonTransportRoute.getLong("routetype_ID"));
		
		if (jsonTransportRoute.has("colour_ID") && !jsonTransportRoute.isNull("colour_ID"))
			transportroute.setCOLOUR_ID(jsonTransportRoute.getLong("colour_ID"));
		
		transportroute.setISACTIVE(jsonTransportRoute.getString("isactive"));
		
		transportroute = transportrouterepository.saveAndFlush(transportroute);
		rtnAPIResponse = mapper.writeValueAsString(transportroute);
		return rtnAPIResponse;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private TransportRoute delete(@PathVariable long id) {
		TransportRoute transportroute = transportrouterepository.findOne(id);
		transportrouterepository.delete(transportroute);
		return transportroute;
	}

}
