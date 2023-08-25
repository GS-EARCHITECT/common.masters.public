package place.place_class.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import place.place_class.model.dto.PlaceClassMaster_DTO;
import place.place_class.service.I_PlaceClassMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/placeClassPublicReadManagement")
public class PlaceClassMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(PlaceClassMaster_Controller.class);

	@Autowired
	private I_PlaceClassMasterPublicRead_Service placeClassMasterPublicReadServ;

	@GetMapping(value = "/getAllPlaceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PlaceClassMaster_DTO>> getAllPlaceClasses() {
		CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> completableFuture = placeClassMasterPublicReadServ
				.getAllPlaceClasses();
		CopyOnWriteArrayList<PlaceClassMaster_DTO> placeClassDTOs = completableFuture.join();
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectPlaceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<PlaceClassMaster_DTO>> getSelectPlaceClasses(
			@RequestBody CopyOnWriteArrayList<Long> placeClassSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<PlaceClassMaster_DTO>> completableFuture = placeClassMasterPublicReadServ
				.getSelectPlaceClasses(placeClassSeqNos);
		CopyOnWriteArrayList<PlaceClassMaster_DTO> placeClassDTOs = completableFuture.join();
		return new ResponseEntity<>(placeClassDTOs, HttpStatus.OK);
	}

}