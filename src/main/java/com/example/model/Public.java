/**
 * This class is generated by jOOQ
 */
package com.example.model;


import com.example.model.tables.Each;
import com.example.model.tables.Note;
import com.example.model.tables.Notetype;
import com.example.model.tables.SchemaVersion;
import com.example.model.tables.Skeys;
import com.example.model.tables.Svals;
import com.example.model.tables.Tenant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

	private static final long serialVersionUID = -1468484226;

	/**
	 * The reference instance of <code>public</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("public");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Each.EACH,
			Note.NOTE,
			Notetype.NOTETYPE,
			SchemaVersion.SCHEMA_VERSION,
			Skeys.SKEYS,
			Svals.SVALS,
			Tenant.TENANT);
	}
}
