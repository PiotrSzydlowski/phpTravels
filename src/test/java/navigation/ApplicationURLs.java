package navigation;

import configuration.AppProperties;

public class ApplicationURLs {
    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String REGISTRATION_URL = APPLICATION_URL + "register";
    public static final String LOGIN_URL = APPLICATION_URL + "login";
    public static final String ACCOUNT_URL = APPLICATION_URL + "account/";
}
