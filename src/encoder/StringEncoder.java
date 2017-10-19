package encoder;
import java.nio.charset.Charset;

public class StringEncoder {
	public String getStringFromByteArray(byte [] bytes, Charset charset) {
		return new String(bytes, charset);
	}
}
