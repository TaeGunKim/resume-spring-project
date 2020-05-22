package com.mycompany.myapp.common.config;

import java.util.regex.Pattern;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class ExposablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(ExposablePropertyPlaceholderConfigurer.class);

	private String encodingPatternStr;

    private String[] encodingPatterns;

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
    	LOG.debug("converProperty start ~~");
        String value = null;
        LOG.debug("##propertyName :"+propertyName+", propertyValue:"+propertyValue);
        if (matchPattern(propertyName)) {
            value = new String(Base64.decodeBase64(propertyValue));
        } else {
            value = convertPropertyValue(propertyValue);
        }
        LOG.debug("##propertyName :"+propertyName+", propertyValue:"+value);
        return value;
    }

    private boolean matchPattern(String propertyName) {
    	LOG.debug("matchPattern start ~~");
        boolean result = false;
        for (int i=0; i<encodingPatterns.length;i++) {
            if (Pattern.compile("^"+encodingPatterns[i].trim()+"$").matcher(propertyName).find() ) {
            	LOG.debug("##encodingPatterns :"+encodingPatterns[i]+",propertyName:"+propertyName);
                result = true;
                break;
            }
        }
        return result;
    }

    public void setEncodingPatterns(String encodingPatterns) {
    	LOG.debug("setEncodingPatterns start ~~");
        this.encodingPatternStr = encodingPatterns;
        String[] patterns = encodingPatterns.split(",");
        this.encodingPatterns = new String[patterns.length];

        for ( int i=0; i<patterns.length; i++) {
            this.encodingPatterns[i] = patterns[i].replaceAll("\\.","\\\\.").replaceAll("\\*", ".*");
        }
    }

    public String getEncodingPatterns() {
        return this.encodingPatternStr;
    }

}
