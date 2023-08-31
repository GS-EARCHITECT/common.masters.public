package enterprise.company_unit_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_unit_class.model.master.CompanyUnitClassMaster;

@Repository("compUnitClassPublicReadRepo")
public interface CompanyUnitClassMasterPublicRead_Repo extends JpaRepository<CompanyUnitClassMaster, Long> 
{
	@Query(value = "select * from COMPANY_UNIT_CLASS_MASTER ORDER BY COMPANY_UNIT_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyUnitClassMaster> getAllMasters();

	@Query(value = "select * from COMPANY_UNIT_CLASS_MASTER where COMPANY_UNIT_CLASS_SEQ_NO in :ids ORDER BY MASTER_COMPANY_UNIT_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyUnitClassMaster> getSelectCompanyUnitClassMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
}
