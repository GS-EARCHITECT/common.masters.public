package party.party_contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import party.party_contacts.model.dto.PartyContact_DTO;
import party.party_contacts.services.I_PartyContactPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyContactPublicReadManagement")
public class PartyContactPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(PartyContact_Controller.class);

	@Autowired
	private I_PartyContactPublicRead_Service partyContactPublicReadServ;

	@GetMapping(value = "/getSelectPartyContacts", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartyContacts(@RequestBody CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> completableFuture = partyContactPublicReadServ.getSelectPartyContacts(ids);
		CopyOnWriteArrayList<PartyContact_DTO> partyContact_DTOs = completableFuture.join();
		return new ResponseEntity<>(partyContact_DTOs, HttpStatus.OK);
	}
	

	@GetMapping(value = "/getSelectPartiesByMobiles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByMobiles(@RequestBody CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> completableFuture = partyContactPublicReadServ.getSelectPartiesByMobiles(ids);
		CopyOnWriteArrayList<PartyContact_DTO> partyContact_DTOs = completableFuture.join();
		return new ResponseEntity<>(partyContact_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartiesByEmail/{emailid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByEmail(@PathVariable String emailid)
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> completableFuture = partyContactPublicReadServ.getSelectPartiesByEmail(emailid);
		CopyOnWriteArrayList<PartyContact_DTO> partyContact_DTOs = completableFuture.join();
		return new ResponseEntity<>(partyContact_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectPartiesByLandlines", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartiesByLandlines(@RequestBody CopyOnWriteArrayList<Long> ids)
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> completableFuture = partyContactPublicReadServ.getSelectPartiesByLandlines(ids);
		CopyOnWriteArrayList<PartyContact_DTO> partyContact_DTOs = completableFuture.join();
		return new ResponseEntity<>(partyContact_DTOs, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAllPartyContact", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyContact_DTO>> getAllPartyContact() 
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> completableFuture = partyContactPublicReadServ.getAllPartyContacts();
		CopyOnWriteArrayList<PartyContact_DTO> partyContact_DTOs = completableFuture.join();
		return new ResponseEntity<>(partyContact_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPartyContactsBetweenTimes/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyContact_DTO>> getSelectPartyContactsBetweenTimes(@RequestBody CopyOnWriteArrayList<Long> ids, @PathVariable String fr, @PathVariable String to)
	{
		CompletableFuture<CopyOnWriteArrayList<PartyContact_DTO>> completableFuture = partyContactPublicReadServ.getSelectPartyContactsBetweenTimes(ids, fr, to);
		CopyOnWriteArrayList<PartyContact_DTO> partyContact_DTOs = completableFuture.join();
		return new ResponseEntity<>(partyContact_DTOs, HttpStatus.OK);
	}
	
	}