package sft.SOQL;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.ws.ConnectionException;

public class ExecuteSOQL extends GetDatabaseConnection {
    QueryResult qResult = null;
    GetDatabaseConnection eDBConnection = new GetDatabaseConnection();
    EnterpriseConnection connection;

    public QueryResult ExecuteQuery(String soqlQuery) {
        connection = eDBConnection.login();
        try {
            boolean done = false;
            qResult = connection.query(soqlQuery);
            //If the query results exceed 500 row
            while (!done) {
                if (qResult.isDone()) {
                    done = true;
                } else {
                    qResult = connection.queryMore(qResult.getQueryLocator());
                }
            }
        } catch (ConnectionException e) {
            e.printStackTrace();
        } finally {
            eDBConnection.logout();
        }
        return qResult;
    }

//    public boolean UpdateLeadObject(Lead[] updates) {
////        Lead newlead = (Lead) dataObject;
//        boolean flag = true;
////        Lead[] updates = new Lead[2];
//        connection = eDBConnection.login();
////        System.out.println(newlead.getFirstName() + " : Being Updated");
//        try {
//            SaveResult[] results = connection.update(new SObject[]{updates});
//            SaveResult[] saveResults = connection.update(updates);
//            for (SaveResult saveResult : saveResults) {
//                if (saveResult.isSuccess()) {
//                    System.out.println("Successfully updated Lead ID: " + saveResult.getId());
//                } else {
//                    flag = false;
//                    // Handle the errors.
//                    // We just print the first error out for sample purposes.
//                    Error[] errors = saveResult.getErrors();
//                    if (errors.length > 0) {
//                        System.out.println("Error: could not update " + "Lead ID "
//                            + saveResult.getId() + ".");
//                        System.out.println("\tThe error reported was: ("
//                            + errors[0].getStatusCode() + ") "
//                            + errors[0].getMessage() + ".");
//                    }
//                }
//            }
//
//        } catch (ConnectionException e) {
//            e.printStackTrace();
//        }
//        return flag;
//    }
}
