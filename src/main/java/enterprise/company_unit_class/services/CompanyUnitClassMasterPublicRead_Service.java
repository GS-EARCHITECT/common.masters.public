package enterprise.company_unit_class.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import enterprise.company_unit_class.model.dto.CompanyUnitClassMaster_DTO;
import enterprise.company_unit_class.model.master.CompanyUnitClassMaster;
import enterprise.company_unit_class.model.repo.CompanyUnitClassMasterPublicRead_Repo;

@Service("compUnitClassPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyUnitClassMasterPublicRead_Service implements I_CompanyUnitClassMasterPublicRead_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyUnitClassMasterService.class);

	@Autowired
	private CompanyUnitClassMasterPublicRead_Repo compUnitClassPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	
	public CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> getAllCompanyUnitClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyUnitClassMaster> companyUnitList = compUnitClassPublicReadRepo.getAllMasters();
		CopyOnWriteArrayList<CompanyUnitClassMaster_DTO> cDTOs = companyUnitList != null ? this.getCompanyUnitClassMasterDtos(companyUnitList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> getSelectCompanyUnitClasses(CopyOnWriteArrayList<Long> companyUnitSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyUnitClassMaster> companyUnitList = compUnitClassPublicReadRepo.getSelectCompanyUnitClassMasters(companyUnitSeqNos);
		CopyOnWriteArrayList<CompanyUnitClassMaster_DTO> cDTOs = companyUnitList != null ? this.getCompanyUnitClassMasterDtos(companyUnitList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<CompanyUnitClassMaster_DTO> getCompanyUnitClassMasterDtos(CopyOnWriteArrayList<CompanyUnitClassMaster> cClasss) 
	{
		CompanyUnitClassMaster_DTO cDTO = null;
		CopyOnWriteArrayList<CompanyUnitClassMaster_DTO> cDTOs = new CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getCompanyUnitClassMaster_DTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private CompanyUnitClassMaster_DTO getCompanyUnitClassMaster_DTO(CompanyUnitClassMaster cClass) {
		CompanyUnitClassMaster_DTO cDTO = null;
		cDTO = new CompanyUnitClassMaster_DTO();
		cDTO.setUnitClassSeqNo(cClass.getUnitClassSeqNo());
		cDTO.setUnitclass(cClass.getUnitclass());
		cDTO.setDescription(cClass.getDescription());
		cDTO.setSpecificationSeqNo(cClass.getSpecificationSeqNo());		
		return cDTO;
	}
	
}