package enterprise.company_class.services;

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
import enterprise.company_class.model.dto.CompanyClassMaster_DTO;
import enterprise.company_class.model.master.CompanyClassMaster;
import enterprise.company_class.model.repo.CompanyClassMasterPublicRead_Repo;

@Service("companyClassPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class CompanyClassMasterPublicRead_Service implements I_CompanyClassMasterPublicRead_Service 
{
	// private static final Logger logger =
	// LoggerFactory.getLogger(CompanyClassMasterService.class);

	@Autowired
	private CompanyClassMasterPublicRead_Repo companyClassPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> getAllCompanyClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyClassMaster> companyList = companyClassPublicReadRepo.getAllMasters();
		CopyOnWriteArrayList<CompanyClassMaster_DTO> cDTOs = companyList != null ? this.getCompanyClassMasterDtos(companyList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
		
	}

	public CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>>  getSelectCompanyClasses(CopyOnWriteArrayList<Long> companySeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<CompanyClassMaster> companyList = companyClassPublicReadRepo.getSelectCompanyClassMasters(companySeqNos);
		CopyOnWriteArrayList<CompanyClassMaster_DTO> cDTOs = companyList != null ? this.getCompanyClassMasterDtos(companyList) : null;
		return cDTOs;
   		},asyncExecutor);
		return future;
	}
	
	private synchronized CopyOnWriteArrayList<CompanyClassMaster_DTO> getCompanyClassMasterDtos(CopyOnWriteArrayList<CompanyClassMaster> cClasss) 
	{
		CompanyClassMaster_DTO cDTO = null;
		CopyOnWriteArrayList<CompanyClassMaster_DTO> cDTOs = new CopyOnWriteArrayList<CompanyClassMaster_DTO>();

		for (int i = 0; i < cClasss.size(); i++) 
		{
			cDTO = this.getCompanyClassMaster_DTO(cClasss.get(i));
			cDTOs.add(cDTO);
		}
		return cDTOs;
	}

	private synchronized CompanyClassMaster_DTO getCompanyClassMaster_DTO(CompanyClassMaster cClass) 
	{
		CompanyClassMaster_DTO cDTO = null;
		cDTO = new CompanyClassMaster_DTO();
		cDTO.setCompanyClass(cClass.getCompanyClass());
		cDTO.setCompanyClassSeqNo(cClass.getCompanyClassSeqNo());
		cDTO.setDescription(cClass.getDescription());
		cDTO.setSpecificationSeqNo(cClass.getSpecificationSeqNo());		
		return cDTO;
	}

}