package moten.david.xuml.model.util;

import model.FreeType;
import model.Primitive;
import model.PrimitiveType;
import model.Type;
import moten.david.xuml.model.compiler.util.Util;

public class ModelUtil {

	public static String getCanonicalName(model.Class cls) {
		return Util.getFullPath(cls.getPackage(), ".") + "." + cls.getName();
	}

	public static String getJavaType(PrimitiveType t) {
		return getJavaType(t.getPrimitive());
	}

	public static String getJavaType(Primitive t) {
		if (Primitive.ARBITRARY_ID.equals(t)) {
			return "int";
		} else if (Primitive.BOOLEAN.equals(t)) {
			return "Boolean";
		} else if (Primitive.DATE.equals(t)) {
			return "java.util.Date";
		} else if (Primitive.DECIMAL.equals(t)) {
			return "Double";
		} else if (Primitive.INTEGER.equals(t)) {
			return "Integer";
		} else if (Primitive.LONG.equals(t)) {
			return "Long";
		} else if (Primitive.STRING.equals(t)) {
			return "String";
		} else if (Primitive.TIMESTAMP.equals(t)) {
			return "java.util.Date";
		} else if (Primitive.TIME.equals(t)) {
			return "java.util.Date";
		}
		throw new Error("unrecognized type " + t.toString());
	}

	public static String getTypeName(Type type) {
		if (type instanceof FreeType) {
			return ((FreeType) type).getType();
		} else if (type instanceof PrimitiveType) {
			return ModelUtil.getJavaType(((PrimitiveType) type));
		} else
			throw new Error("unrecognized Type: "
					+ type.getClass().getCanonicalName());
	}

}
