package resourceDataProvider;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

public class RemoteResourceDataProvider extends ResourceDataProvider {	
	private String uri;
	
	public RemoteResourceDataProvider(String url) {
		this.uri = url;
	}

	public byte [] getData(String uri) {
		byte [] bytes;
		Optional<InputStream> inputStream = Optional.empty();
		try {
			inputStream = Optional.ofNullable(getInputStreamFromUrl(uri));
			try {
				bytes = readAllBytesFromInputStream(inputStream);
			} catch(Exception e) { 
				bytes = null;
			}
		} finally {
			inputStream.ifPresent(is-> {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		
		return bytes;
	}
	
	@Override
	public byte [] getData() {
		return getData(uri);
	}
	
	private InputStream getInputStreamFromUrl(String urlString) {
		try {
			URL url = new URL(urlString);
			return url.openStream();
		} catch (Exception e) {
			return null;
		}
	}
	
	private byte [] readAllBytesFromInputStream(Optional<InputStream> inputStream) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		inputStream.ifPresent(is -> {
			int nByte;
			try {
				while((nByte = is.read()) != -1) {
					byteArrayOutputStream.write(nByte);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		return byteArrayOutputStream.toByteArray();
	}
}
