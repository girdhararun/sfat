package sft.soql;

import com.sforce.soap.enterprise.Error;
import com.sforce.soap.enterprise.*;
import com.sforce.soap.enterprise.sobject.Lead;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class ExecuteSOQL {
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

    public boolean UpdateLeadObject(Lead lead) {
        boolean flag = true;
        try {
            connection = eDBConnection.login();
            System.out.println(lead.getId() + " : Being Updated");
            SaveResult[] results = connection.update(new SObject[]{lead});
            for (SaveResult saveResult : results) {
                if (saveResult.isSuccess()) {
                    System.out.println("Successfully updated Lead ID: " + saveResult.getId());
                } else {
                    flag = false;
                    // Handle the errors.
                    // We just print the first error out for sample purposes.
                    Error[] errors = saveResult.getErrors();
                    if (errors.length > 0) {
                        System.out.println("Error: could not update " + "Lead ID "
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

    public boolean convertLead(Lead[] leads) {
        String[] result = new String[4];
        LeadConvert[] leadsToConvert = new LeadConvert[leads.length];
        try {
            for (int i = 0; i < leads.length; ++i) {
                System.out
                    .println(" Lead: " + leads[i].getId());
                leadsToConvert[i] = new LeadConvert();
                leadsToConvert[i].setConvertedStatus("Closed - Converted");
                leadsToConvert[i].setLeadId(leads[i].getId());
                result[0] = leads[i].getId();
            }
            LeadConvertResult[] lcResults = connection.convertLead(leadsToConvert);
            for (int j = 0; j < lcResults.length; ++j) {
                if (lcResults[j].isSuccess()) {
                    System.out.println("Lead converted successfully!");
                    System.out.println("Account ID: " + lcResults[j].getAccountId());
                    System.out.println("Contact ID: " + lcResults[j].getContactId());
                    System.out.println("Opportunity ID: "
                        + lcResults[j].getOpportunityId());
                } else {
                    System.out.println("\nError converting new Lead: "
                        + lcResults[j].getErrors()[0].getMessage());
                }
            }

        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }

    boolean flag = false;
        return flag;

}
}
