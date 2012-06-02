package xuml.tools.jaxb.compiler;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import xuml.tools.jaxb.compiler.A.AId;

@javax.persistence.Entity
@Table(name = "TableB")
public class B implements Serializable {

	@EmbeddedId
	private BId id;

	@MapsId(value = "aId")
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "a_one", referencedColumnName = "a_one"),
			@JoinColumn(name = "a_two", referencedColumnName = "a_two") })
	private A a;

	@Embeddable
	public static class BId implements Serializable {

		@Embedded
		private AId aId;

		@Column(name = "b_one")
		private String b1;

	}

}
