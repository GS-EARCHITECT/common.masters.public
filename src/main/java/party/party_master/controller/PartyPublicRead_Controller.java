package party.party_master.controller;

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
import party.party_master.model.dto.PartyMaster_DTO;
import party.party_master.services.I_PartyMasterPublicRead_Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/partyPublicReadManagemente")
public class PartyPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Party_Party_Cuntroller.class);

	@Autowired
	private I_PartyMasterPublicRead_Service partyPublicReadServ;

	@GetMapping(value = "/getAllParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyMaster_DTO>> getAllParties() {
		CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> completableFuture = partyPublicReadServ
				.getAllParties();
		CopyOnWriteArrayList<PartyMaster_DTO> partyDTOs = completableFuture.join();
		// logger.info("size :"+partyDTOs.size());
		return new ResponseEntity<>(partyDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PartyMaster_DTO>> getSelectParties(
			@RequestBody CopyOnWriteArrayList<Long> partyCuSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<PartyMaster_DTO>> completableFuture = partyPublicReadServ
				.getSelectParties(partyCuSeqNos);
		CopyOnWriteArrayList<PartyMaster_DTO> partyDTOs = completableFuture.join();
		return new ResponseEntity<>(partyDTOs, HttpStatus.OK);
	}
}