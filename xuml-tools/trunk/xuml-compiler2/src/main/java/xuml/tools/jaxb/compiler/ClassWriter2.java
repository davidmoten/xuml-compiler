package xuml.tools.jaxb.compiler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ClassWriter2 {

	private final ClassInfo info;

	public ClassWriter2(ClassInfo info) {
		this.info = info;
	}

	public String generate() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(bytes);
		writePackage(out, info);
		writeImports(out, info);
		writeClassJavadoc(out, info);
		return bytes.toString();
	}

	private void writePackage(PrintStream out, ClassInfo info) {
		out.format("package %s;\n\n", info.getPackage());
	}

	private void writeImports(PrintStream out, ClassInfo info) {
		TypeRegister types = info.getTypeRegister();
		for (String line : types.getImports()) {
			out.println(line);
		}
		out.println();
	}

	private void writeClassJavadoc(PrintStream out, ClassInfo info) {
		writeJavadoc(out, info.getClassJavadoc(), "");
	}

	// ///////////////////////////////////////
	// Utils
	// ///////////////////////////////////////

	private void writeJavadoc(PrintStream out, String comment, String indent) {
		out.format("%s/**\n", indent);
		out.format("%s * %s\n", indent, info.getClassJavadoc());
		out.format("%s */\n", indent);
	}

}
