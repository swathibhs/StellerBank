package steller.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class is used to handle file utilities
 * @author Lokesh
 *
 */
public class FileUtility {
	/**
	 * this method is used to get value from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertykeyValue(String key) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.propertyFilePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String value=properties.getProperty(key);
		return value;
		}
	
	

}
