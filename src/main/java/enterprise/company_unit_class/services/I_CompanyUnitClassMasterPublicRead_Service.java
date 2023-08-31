package enterprise.company_unit_class.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import enterprise.company_unit_class.model.dto.CompanyUnitClassMaster_DTO;

public interface I_CompanyUnitClassMasterPublicRead_Service 
{
public CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> getAllCompanyUnitClasses();
public CompletableFuture<CopyOnWriteArrayList<CompanyUnitClassMaster_DTO>> getSelectCompanyUnitClasses(CopyOnWriteArrayList<Long> companyClassSeqNos);
}