package enterprise.company_unit_class.controller;

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

import enterprise.company_unit_class.model.dto.CompanyUnitClassMaster_DTO;
import enterprise.company_unit_class.services.I_CompanyUnitClassMasterPublicRead_Service;

@RestController
@RequestMapping("/companyUnitClassPublicReadManagement")
public class CompanyUnitClassMasterPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(Unit_Unit_Classntroller.class);

	@Autowired
	private I_CompanyUnitClassMasterPublicRead_Service companyUnitClassPublicReadServ;

	@GetMapping(value = "/getAllCompanyUnitClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> getAllCompanyUnitClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> completableFuture = companyUnitClassPublicReadServ.getAllCompanyUnitClasses();
		CopyOnWriteArrayList<CompanyUnitClassMaster_DTO> companyUnitClassDTOs = completableFuture.join();
		return new ResponseEntity<>(companyUnitClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectCompanyUnitClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> getSelectCompanyUnitClasses(@RequestBody CopyOnWriteArrayList<Long> companyUnitClassSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> completableFuture = companyUnitClassPublicReadServ.getSelectCompanyUnitClasses(companyUnitClassSeqNos);
		CopyOnWriteArrayList<CompanyUnitClassMaster_DTO> companyUnitClassDTOs = completableFuture.join();
		return new ResponseEntity<>(companyUnitClassDTOs, HttpStatus.OK);	}
	
}