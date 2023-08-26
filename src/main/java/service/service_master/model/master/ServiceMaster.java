package service.service_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_MASTER database table.
 * 
 */
@Entity
@Table(name = "SERVICE_MASTER")
public class ServiceMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MASTER_SERVICE_SEQUENCE")
	@SequenceGenerator(name = "MASTER_SERVICE_SEQUENCE", sequenceName = "MASTER_SERVICE_SEQUENCE", allocationSize = 1)
	@Column(name = "MASTER_SERVICE_SEQ_NO")
	private Long masterServiceSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SERVICE")
	private String service;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	public ServiceMaster() {
	}

	public Long getMasterServiceSeqNo() {
		return this.masterServiceSeqNo;
	}

	public void setMasterServiceSeqNo(Long masterServiceSeqNo) {
		this.masterServiceSeqNo = masterServiceSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterServiceSeqNo == null) ? 0 : masterServiceSeqNo.hashCode());
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
		ServiceMaster other = (ServiceMaster) obj;
		if (masterServiceSeqNo == null) {
			if (other.masterServiceSeqNo != null)
				return false;
		} else if (!masterServiceSeqNo.equals(other.masterServiceSeqNo))
			return false;
		return true;
	}

	public ServiceMaster(java.lang.Long masterServiceSeqNo, String description, String service,
			java.lang.Long specificationSeqNo) {
		super();
		this.masterServiceSeqNo = masterServiceSeqNo;
		this.description = description;
		this.service = service;
		this.specificationSeqNo = specificationSeqNo;
	}

}