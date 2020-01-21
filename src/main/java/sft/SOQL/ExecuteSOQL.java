package sft.SOQL;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.Error;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Lead;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class ExecuteSOQL extends GetDatabaseConnection {
    QueryResult qr;
    GetDatabaseConnection eDBConnection = new GetDatabaseConnection();
    EnterpriseConnection connection;

    public QueryResult ExecuteQuery(String soqlQuery) {
        connection = eDBConnection.login();
        try {
            qr = connection.query(soqlQuery);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } finally {
//            eDBConnection.logout();
        }
        return qr;
    }

    public boolean UpdateObject(Lead lead) {
        boolean flag = true;
        try {
            Lead[] updates = new Lead[2];
            connection = eDBConnection.login();
            System.out.println(lead.getFirstName() + " : Being Updated");
            SaveResult[] results = connection.update(new SObject[]{lead});
            for (SaveResult saveResult : results) {
                if (saveResult.isSuccess()) {
                    System.out.println("Successfully updated Account ID: " + saveResult.getId());
                } else {
                    flag = false;
                    // Handle the errors.
                    // We just print the first error out for sample purposes.
                    Error[] errors = saveResult.getErrors();
                    if (errors.length > 0) {
                        System.out.println("Error: could not update " + "Account ID "
                            + saveResult.getId() + ".");
                        System.out.println("\tThe error reported was: ("
                            + errors[0].getStatusCode() + ") "
                            + errors[0].getMessage() + ".");
                    }
                }
            }

        } catch (ConnectionException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
