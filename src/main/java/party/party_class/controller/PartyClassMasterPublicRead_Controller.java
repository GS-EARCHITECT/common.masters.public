package party.party_class.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import party.party_class.model.dto.PartyClassMaster_DTO;
import party.party_class.services.I_PartyClassMasterPublicRead_Service;

@RestController
@RequestMapping("/partyClassPublicReadManagement")
public class PartyClassMasterPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Classntroller.class);

	@Autowired
	private I_PartyClassMasterPublicRead_Service partyClassPublicReadServ;

	@GetMapping(value = "/getAllPartyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyClassMaster_DTO>> getAllPartyClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> completableFuture = partyClassPublicReadServ.getAllPartyClasses();
		CopyOnWriteArrayList<PartyClassMaster_DTO> partyClassDTOs = completableFuture.join();
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyClassMaster_DTO>> getSelectPartyClasses(@RequestBody CopyOnWriteArrayList<Long> partyClassSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyClassMaster_DTO>> completableFuture = partyClassPublicReadServ.getSelectPartyClasses(partyClassSeqNos);
		CopyOnWriteArrayList<PartyClassMaster_DTO> partyClassDTOs = completableFuture.join();
		return new ResponseEntity<>(partyClassDTOs, HttpStatus.OK);

	}

}