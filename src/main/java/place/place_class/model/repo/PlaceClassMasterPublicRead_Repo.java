package place.place_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import place.place_class.model.master.PlaceClassMaster;

@Repository("placeClassMasterPublicReadRepo")
public interface PlaceClassMasterPublicRead_Repo extends JpaRepository<PlaceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM Place_Class_Master a order by a.place_class_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PlaceClassMaster> getAllPlaceClasses();

	@Query(value = "SELECT * FROM Place_Class_Master a where place_class_seq_no in :ids order by a.place_class_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PlaceClassMaster> getSelectPlaceClasses(@Param("ids") CopyOnWriteArrayList<Long> ids);;
	
}
