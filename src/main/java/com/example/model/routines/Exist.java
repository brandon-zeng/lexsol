/**
 * This class is generated by jOOQ
 */
package com.example.model.routines;


import com.example.model.Public;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


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
public class Exist extends AbstractRoutine<Boolean> {

	private static final long serialVersionUID = -1779605741;

	/**
	 * The parameter <code>public.exist.RETURN_VALUE</code>.
	 */
	public static final Parameter<Boolean> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.BOOLEAN, false);

	/**
	 * The parameter <code>public.exist._1</code>.
	 */
	public static final Parameter<Object> _1 = createParameter("_1", org.jooq.impl.DefaultDataType.getDefaultDataType("USER-DEFINED"), false);

	/**
	 * The parameter <code>public.exist._2</code>.
	 */
	public static final Parameter<String> _2 = createParameter("_2", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * Create a new routine call instance
	 */
	public Exist() {
		super("exist", Public.PUBLIC, org.jooq.impl.SQLDataType.BOOLEAN);

		setReturnParameter(RETURN_VALUE);
		addInParameter(_1);
		addInParameter(_2);
	}

	/**
	 * Set the <code>_1</code> parameter IN value to the routine
	 */
	public void set__1(Object value) {
		setValue(_1, value);
	}

	/**
	 * Set the <code>_1</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__1(Field<Object> field) {
		setField(_1, field);
	}

	/**
	 * Set the <code>_2</code> parameter IN value to the routine
	 */
	public void set__2(String value) {
		setValue(_2, value);
	}

	/**
	 * Set the <code>_2</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void set__2(Field<String> field) {
		setField(_2, field);
	}
}
