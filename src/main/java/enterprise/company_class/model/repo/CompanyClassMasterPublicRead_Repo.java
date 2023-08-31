package enterprise.company_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.company_class.model.master.CompanyClassMaster;

@Repository("compClassPublicReadRepo")
public interface CompanyClassMasterPublicRead_Repo extends JpaRepository<CompanyClassMaster, Long> 
{
	@Query(value = "select * from COMPANY_CLASS_MASTER ORDER BY COMPANY_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyClassMaster> getAllMasters();

	@Query(value = "select * from COMPANY_CLASS_MASTER where COMPANY_CLASS_SEQ_NO in :ids ORDER BY MASTER_COMPANY_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<CompanyClassMaster> getSelectCompanyClassMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
}
