package sft.SOQL;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.soap.enterprise.sobject.SObject;

public class ExecuteLeadSample {
    public static void main(String[] args) {
        QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        qr = db.ExecuteQuery("SELECT Id, FirstName, Status FROM Lead WHERE FirstName like 'TestNameUpdated%' ORDER BY CreatedDate ASC NULLS FIRST");
        boolean done = false;


        if (qr.getSize() > 0) {
            System.out.println("Logged-in user can see a total of "
                + qr.getSize() + " contact records.");
            while (!done) {
                SObject[] records = qr.getRecords();
                for (int i = 0; i < records.length; ++i) {
                    Contact con = (Contact) records[i];
                    String fName = con.getFirstName();
                    String lName = con.getLastName();
                    if (fName == null) {
                        System.out.println("Contact " + (i + 1) + ": " + lName);
                    } else {
                        System.out.println("Contact " + (i + 1) + ": " + fName
                            + " " + lName);
                    }
                }
            }
            if (qr.isDone()) {
                done = true;
            } else {
//                qr = connection.queryMore(qResult.getQueryLocator());
            }
        } else {
            System.out.println("No records found.");
        }
        System.out.println("\nQuery succesfully executed.");


//        Lead[] lead = (Lead[]) qr.getRecords();
//        System.out.println("FirstName : "+lead[0].getFirstName());
//        System.out.println("Status : "+lead[0].getStatus());
//        Date date = new Date();
//
//        lead[0].setFirstName("TestNameUpdated"+date.getTime());
//
//        db.UpdateObject(lead);
    }

//    public void update(Sobject){
//        Lead[] updates = new Lead[2];
//
//        Lead lead1 = new Lead();
//        lead1.setId(ids[0]);
//        account1.setShippingPostalCode("89044");
//        updates[0] = account1;
//
//        Account account2 = new Account();
//        account2.setId(ids[1]);
//        account2.setNumberOfEmployees(1000);
//        updates[1] = account2;
//    }
}
