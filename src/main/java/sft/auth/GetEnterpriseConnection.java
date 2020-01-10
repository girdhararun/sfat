package sft.auth;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.GetUserInfoResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import sft.SOQL.SOQLCheck;

import java.util.Map;

public class GetEnterpriseConnection {
    EnterpriseConnection connection;
    String authEndPoint = "";
    static final Map<String, String> setupDetails = SftSetup.getSftSetup();
    static final String USERNAME = setupDetails.get("username");
    static final String PASSWORD = setupDetails.get("password");

    // Constructor
    public GetEnterpriseConnection(String authEndPoint) {
        this.authEndPoint = authEndPoint;
    }

    public static void main(String[] args) {
        GetEnterpriseConnection ec = new GetEnterpriseConnection(setupDetails.get("domain_url")+"/"+setupDetails.get("soap_c"));
        ec.run();
    }

    public void run() {
        // Make a login call
        if (login()) {
             SOQLCheck soql = new SOQLCheck(connection);
            try {
                 soql.querySample("SELECT FirstName, LastName FROM Contact");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logout();
        }
    }

    private boolean login() {
        boolean success = false;

        try {
            ConnectorConfig config = new ConnectorConfig();
            config.setUsername(USERNAME);
            config.setPassword(PASSWORD);

            System.out.println("AuthEndPoint: " + authEndPoint);
            config.setAuthEndpoint(authEndPoint);

            connection = new EnterpriseConnection(config);
            printUserInfo(config);

            success = true;
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }

        return success;
    }

    private void printUserInfo(ConnectorConfig config) {
        try {
            GetUserInfoResult userInfo = connection.getUserInfo();

            System.out.println("\nLogging in ...\n");
            System.out.println("UserID: " + userInfo.getUserId());
            System.out.println("User Full Name: " + userInfo.getUserFullName());
            System.out.println("User Email: " + userInfo.getUserEmail());
            System.out.println();
            System.out.println("SessionID: " + config.getSessionId());
            System.out.println("Auth End Point: " + config.getAuthEndpoint());
            System.out.println("Service End Point: " + config.getServiceEndpoint());
            System.out.println();
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }
    }

    private void logout() {
        try {
            connection.logout();
            System.out.println("Logged out.");
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }
    }
}
