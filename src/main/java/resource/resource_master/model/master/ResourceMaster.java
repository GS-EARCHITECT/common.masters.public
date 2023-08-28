package resource.resource_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_MASTER database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_MASTER")
public class ResourceMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -607374000247386032L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MASTER_RESOURCE_SEQUENCE")
	@SequenceGenerator(name = "MASTER_RESOURCE_SEQUENCE", sequenceName = "MASTER_RESOURCE_SEQUENCE", allocationSize = 1)
	@Column(name = "MASTER_RESOURCE_SEQ_NO")
	private Long masterResourceSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "RESOURCENAME")
	private String resourceName;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "OEM_SEQ_NO")
	private Long oemSeqNo;

	public ResourceMaster() {
	}

	public Long getMasterResourceSeqNo() {
		return this.masterResourceSeqNo;
	}

	public void setMasterResourceSeqNo(Long masterResourceSeqNo) {
		this.masterResourceSeqNo = masterResourceSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Long getOemSeqNo() {
		return oemSeqNo;
	}

	public void setOemSeqNo(Long oemSeqNo) {
		this.oemSeqNo = oemSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterResourceSeqNo == null) ? 0 : masterResourceSeqNo.hashCode());
		result = prime * result + ((oemSeqNo == null) ? 0 : oemSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourceMaster other = (ResourceMaster) obj;
		if (masterResourceSeqNo == null) {
			if (other.masterResourceSeqNo != null)
				return false;
		} else if (!masterResourceSeqNo.equals(other.masterResourceSeqNo))
			return false;
		if (oemSeqNo == null) {
			if (other.oemSeqNo != null)
				return false;
		} else if (!oemSeqNo.equals(other.oemSeqNo))
			return false;
		return true;
	}

	public ResourceMaster(Long masterResourceSeqNo, String description, String resourceName, Long specificationSeqNo,
			Long oemSeqNo) {
		super();
		this.masterResourceSeqNo = masterResourceSeqNo;
		this.description = description;
		this.resourceName = resourceName;
		this.specificationSeqNo = specificationSeqNo;
		this.oemSeqNo = oemSeqNo;
	}

}