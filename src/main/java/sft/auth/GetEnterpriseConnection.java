package sft.auth;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class GetEnterpriseConnection {


    final String USERNAME = SftSetup.getSftSetup().get("username");
    final String PASSWORD = SftSetup.getSftSetup().get("password");
    EnterpriseConnection connection;

    public static void main(String[] args) {
        GetEnterpriseConnection econn = new GetEnterpriseConnection();
        econn.getEnterpriseConnection();
    }

    public EnterpriseConnection getEnterpriseConnection() {
        ConnectorConfig config = new ConnectorConfig();
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);

        try {

            connection = Connector.newConnection(config);

            // display some current settings
            System.out.println("Auth EndPoint: " + config.getAuthEndpoint());
            System.out.println("Service EndPoint: " + config.getServiceEndpoint());
            System.out.println("Username: " + config.getUsername());
            System.out.println("SessionId: " + config.getSessionId());

        } catch (ConnectionException e1) {
            e1.printStackTrace();
        }
        return connection;
    }
}

