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

import xuml.tools.jaxb.compiler.B.BId;

@javax.persistence.Entity
@Table(name = "TableC")
public class C implements Serializable {

	@EmbeddedId
	private CId id;

	@MapsId(value = "bId")
	@ManyToOne
	@JoinColumns(value = {
			@JoinColumn(name = "a_one", referencedColumnName = "a_one"),
			@JoinColumn(name = "a_two", referencedColumnName = "a_two"),
			@JoinColumn(name = "b_one", referencedColumnName = "b_one") })
	private B b;

	@Embeddable
	public static class CId implements Serializable {

		@Embedded
		private BId bId;

		@Column(name = "c_one")
		private String c1;
	}

}
