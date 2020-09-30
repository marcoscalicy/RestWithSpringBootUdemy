package br.com.marcoscalicy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix ="file")
public class FileStorageConfig {

    private String upLoadDir;

    public String getUpLoadDir() {
        return upLoadDir;
    }

    public void setUpLoadDir(String upLoadDir) {
        this.upLoadDir = upLoadDir;
    }
}
