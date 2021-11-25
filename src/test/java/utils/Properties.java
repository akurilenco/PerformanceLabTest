package utils;

public class Properties {
    private java.util.Properties getProperties() {
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getProperty(String propertyKey) {
        java.util.Properties properties = getProperties();
        return properties.getProperty(propertyKey);
    }
}
