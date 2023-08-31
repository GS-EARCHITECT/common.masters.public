package enterprise.company_class.controller;

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
import enterprise.company_class.model.dto.CompanyClassMaster_DTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import enterprise.company_class.services.I_CompanyClassMasterPublicRead_Service;

@RestController
@RequestMapping("/companyClassPublicReadManagement")
public class CompanyClassMasterPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Classntroller.class);

	@Autowired
	private I_CompanyClassMasterPublicRead_Service companyClassPublicReadServ;

	@GetMapping(value = "/getAllCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyClassMaster_DTO>> getAllCompanyClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> completableFuture = companyClassPublicReadServ.getAllCompanyClasses();
		CopyOnWriteArrayList<CompanyClassMaster_DTO> companyClassDTOs = completableFuture.join();
		return new ResponseEntity<>(companyClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyClassMaster_DTO>> getSelectCompanyClasses(@RequestBody CopyOnWriteArrayList<Long> companyClassSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> completableFuture = companyClassPublicReadServ.getSelectCompanyClasses(companyClassSeqNos);
		CopyOnWriteArrayList<CompanyClassMaster_DTO> companyClassDTOs = completableFuture.join();
		return new ResponseEntity<>(companyClassDTOs, HttpStatus.OK);

	}

}