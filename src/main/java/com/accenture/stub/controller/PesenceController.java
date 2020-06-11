package com.accenture.stub.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.model.PresenceInfo;
import com.accenture.model.ResponseCode;
import com.accenture.model.ScEPresenceT;
import com.google.gson.Gson;

@RestController
@RequestMapping("/v1/presence")
public class PesenceController {
	@RequestMapping(method=RequestMethod.GET,value="/accessmanager/{amId}/subscriber/{subscriberId}")
	public ScEPresenceT getPresenceData(@PathVariable("amId") String amid, @PathVariable("subscriberId") String subscriberId){
		System.out.println("Inside Stub getPresenceData Controller"+amid+"\t"+subscriberId);
		ScEPresenceT datiPresence = new ScEPresenceT();
		List<PresenceInfo> listinfo = new ArrayList<PresenceInfo>();
		PresenceInfo info = new PresenceInfo();
		info.setAmId(amid);
		info.setBrasIp("1.2.3.4");
		info.setBrasName("OpenAps");
		info.setConnectionDate("20/05/2020 12:00:00");
		info.setIp("1.2.4.2");
		info.setNetworkUsername("Openaps");
		info.setRealm("tim.it");
		info.setSessionType("ADSL_DATI_ROUTED");
		info.setSubscriberId(subscriberId);
		info.setTimestamp("123456");
		listinfo.add(info);
		datiPresence.setDatiPresence(listinfo);
		Gson gson = new Gson();
		String jsonInString = gson.toJson(datiPresence);
		ScEPresenceT presence =gson.fromJson(jsonInString, ScEPresenceT.class);
		//presenceList.add(jsonInString);
		return presence;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deletePresenceByIp")
	public ResponseCode deleteByIp(@RequestParam("ip") String ip){
		System.out.println("Inside deleteByIP()"+ip);
		ResponseCode code =new ResponseCode();
		code.setResult("1");
		code.setReturnCode("Ok");
		return code;
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/pulisciPresence")
	public ResponseCode pulsiPresence(@RequestParam("brasIp") String brasIp, 
			@RequestParam("date") Date date){
		System.out.println("Inside pulsiPresence()"+brasIp+"\t"+date);
		ResponseCode code =new ResponseCode();
		code.setResult("2");
		code.setReturnCode("Ok");
		return code;
		
	}
	

}
