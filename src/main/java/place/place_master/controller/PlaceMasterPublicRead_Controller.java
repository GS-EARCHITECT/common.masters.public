package place.place_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import place.place_master.model.dto.PlaceMaster_DTO;
import place.place_master.service.I_PlaceMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/placePublicReadManagement")
public class PlaceMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(PlaceMaster_Controller.class);

	@Autowired
	private I_PlaceMasterPublicRead_Service placeMasterPublicReadServ;

	@GetMapping(value = "/getAllPlaces", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PlaceMaster_DTO>> getAllPlaces() {
		CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> completableFuture = placeMasterPublicReadServ
				.getAllPlaces();
		CopyOnWriteArrayList<PlaceMaster_DTO> placeDTOs = completableFuture.join();
		return new ResponseEntity<>(placeDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPlaces", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PlaceMaster_DTO>> getSelectPlaces(
			@RequestBody CopyOnWriteArrayList<Long> placeSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<PlaceMaster_DTO>> completableFuture = placeMasterPublicReadServ
				.getSelectPlaces(placeSeqNos);
		CopyOnWriteArrayList<PlaceMaster_DTO> placeDTOs = completableFuture.join();
		return new ResponseEntity<>(placeDTOs, HttpStatus.OK);
	}

}