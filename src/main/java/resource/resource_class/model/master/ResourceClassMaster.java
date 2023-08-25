package resource.resource_class.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CLASS_MASTER database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CLASS_MASTER")
public class ResourceClassMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7141680501746255496L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESOURCE_CLASS_SEQUENCE")
	@SequenceGenerator(name = "RESOURCE_CLASS_SEQUENCE", sequenceName = "RESOURCE_CLASS_SEQUENCE", allocationSize = 1)
	@Column(name = "RESOURCE_CLASS_SEQ_NO")
	private Long resourceClassSeqNo;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "RESOURCE_CLASS")
	private String resourceClass;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "STATUS")
	private String status;

	public ResourceClassMaster() {
	}

	public Long getResourceClassSeqNo() {
		return this.resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResourceClass() {
		return this.resourceClass;
	}

	public void setResourceClass(String resourceClass) {
		this.resourceClass = resourceClass;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((resourceClass == null) ? 0 : resourceClass.hashCode());
		result = prime * result + ((resourceClassSeqNo == null) ? 0 : resourceClassSeqNo.hashCode());
		result = prime * result + ((specificationSeqNo == null) ? 0 : specificationSeqNo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ResourceClassMaster other = (ResourceClassMaster) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (resourceClass == null) {
			if (other.resourceClass != null)
				return false;
		} else if (!resourceClass.equals(other.resourceClass))
			return false;
		if (resourceClassSeqNo == null) {
			if (other.resourceClassSeqNo != null)
				return false;
		} else if (!resourceClassSeqNo.equals(other.resourceClassSeqNo))
			return false;
		if (specificationSeqNo == null) {
			if (other.specificationSeqNo != null)
				return false;
		} else if (!specificationSeqNo.equals(other.specificationSeqNo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public ResourceClassMaster(Long resourceClassSeqNo, String description, String remark, String resourceClass,
			Long specificationSeqNo, String status) {
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.description = description;
		this.remark = remark;
		this.resourceClass = resourceClass;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
	}

}