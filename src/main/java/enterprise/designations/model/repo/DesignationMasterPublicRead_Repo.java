package enterprise.designations.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.designations.model.master.DesignationMaster;

@Repository("designationMasterPublicReadRepo")
public interface DesignationMasterPublicRead_Repo extends JpaRepository<DesignationMaster, Long> 
{
	@Query(value = "select * from DESIGNATION_MASTER ORDER BY MASTER_DESIGNATION_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<DesignationMaster> getAllMasters();

	@Query(value = "select * from DESIGNATION_MASTER where MASTER_DESIGNATION_SEQ_NO in :ids ORDER BY MASTER_DESIGNATION_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<DesignationMaster> getSelectDesignationMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

}
