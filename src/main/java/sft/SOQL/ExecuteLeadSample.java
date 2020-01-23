package sft.SOQL;

import com.sforce.soap.enterprise.QueryResult;

public class ExecuteLeadSample {
    public static void main(String[] args) {
        QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        qr = db.ExecuteQuery("SELECT Id, FirstName, Status FROM Contact WHERE FirstName like '%' ORDER BY CreatedDate ASC NULLS FIRST");
        System.out.println(qr.getRecords().length+"---");
        boolean done = false;
//        Lead[] lead = new Lead[2];




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
