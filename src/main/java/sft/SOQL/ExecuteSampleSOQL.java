package sft.SOQL;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import sft.auth.GetEnterpriseConnection;

public class ExecuteSampleSOQL {
    EnterpriseConnection connection;

    public ExecuteSampleSOQL(EnterpriseConnection connection) {
        this.connection = connection;
    }

    public void querySample(String soqlQuery) {

        try {
            QueryResult qr = connection.query(soqlQuery);
            boolean done = false;

            if (qr.getSize() > 0) {
                System.out.println("\nLogged-in user can see " + qr.getRecords().length + " contact records.");

                while (!done) {
                    System.out.println("");
                    SObject[] records = qr.getRecords();
                    for (int i = 0; i < records.length; ++i) {
                        Contact con = (Contact) records[i];
                        String fName = con.getFirstName();
                        String lName = con.getLastName();

                        if (fName == null) {
                            System.out.println("Contact " + (i + 1) + ": " + lName);
                        } else {
                            System.out.println("Contact " + (i + 1) + ": " + fName + " " + lName);
                        }
                    }

                    if (qr.isDone()) {
                        done = true;
                    } else {
                        qr = connection.queryMore(qr.getQueryLocator());
                    }
                }
            } else {
                System.out.println("No records found.");
            }
        } catch (ConnectionException ce) {
            ce.printStackTrace();
        }
    }
}
