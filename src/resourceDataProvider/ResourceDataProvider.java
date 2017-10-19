package resourceDataProvider;

public abstract class ResourceDataProvider {
	
	public abstract byte [] getData(String uri);
	
	public abstract byte [] getData();
}
