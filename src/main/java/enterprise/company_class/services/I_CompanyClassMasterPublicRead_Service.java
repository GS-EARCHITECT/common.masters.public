package enterprise.company_class.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.company_class.model.dto.CompanyClassMaster_DTO;

public interface I_CompanyClassMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> getAllCompanyClasses();
	public CompletableFuture<CopyOnWriteArrayList<CompanyClassMaster_DTO>> getSelectCompanyClasses(CopyOnWriteArrayList<Long> companyClassSeqNos);	
}