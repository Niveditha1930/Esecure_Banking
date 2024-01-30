package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
      /**
       * This method is used to read the data from PropertyFile
       * @param key
       * @return
       * @throws IOException
       */
      
	public String getPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	

	}

