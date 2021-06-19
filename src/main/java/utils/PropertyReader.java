package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {


        String path = this.getFilePath();

        public String getFilePath() {
            String filepath;
            File file = new File("");
            String absolutePathOfFirstFile = file.getAbsolutePath();
            filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
            return filepath;
        }



        public String readPropertyConfig(String key) throws IOException {
            String value = "";
            try {
                Properties prop = new Properties();
                File f = new File(this.path + "/src/test/resources/config/Configuration.properties");

                if (f.exists()) {
                    prop.load(new FileInputStream(f));
                    value = prop.getProperty(key);
                }
            } catch (Exception e) {
                throw e;
            }
            return value;
        }




}
