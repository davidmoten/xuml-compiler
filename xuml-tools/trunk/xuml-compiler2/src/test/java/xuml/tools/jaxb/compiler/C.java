package xuml.tools.jaxb.compiler;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "TableC")
public class C implements Serializable {

	@EmbeddedId
	private CId id;

	// @MapsId
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "a_one", referencedColumnName = "a_one", insertable = false, updatable = false),
			@JoinColumn(name = "a_two", referencedColumnName = "a_two", insertable = false, updatable = false),
			@JoinColumn(name = "b_one", referencedColumnName = "b_one", insertable = false, updatable = false) })
	private B b;

	@Embeddable
	public static class CId implements Serializable {

		@Column(name = "a_one", insertable = false, updatable = false)
		private String a1;

		@Column(name = "a_two", insertable = false, updatable = false)
		private String a2;

		@Column(name = "b_one", insertable = false, updatable = false)
		private String b1;

		@Column(name = "c_one")
		private String c1;
	}

}
