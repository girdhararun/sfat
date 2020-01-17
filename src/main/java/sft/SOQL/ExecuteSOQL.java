package sft.SOQL;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.ws.ConnectionException;

public class ExecuteSOQL extends GetDatabaseConnection {
    QueryResult qr;
    GetDatabaseConnection eDBConnection = new GetDatabaseConnection();
    EnterpriseConnection connection;

    public QueryResult ExecuteSOQL(String soqlQuery) {
        connection = eDBConnection.login();
        try {
            qr = connection.query(soqlQuery);
        } catch (ConnectionException e) {
            e.printStackTrace();
        }finally {
            eDBConnection.logout();
        }
        return qr;
    }
}
