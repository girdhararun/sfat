package sft.soql;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Lead;

import java.util.Date;

public class ExecuteLeadSample {
    public static void main(String[] args) {
        QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        qr = db.ExecuteQuery("SELECT Id, FirstName, Status FROM Lead WHERE FirstName like 'auto1579854362680%' ORDER BY CreatedDate ASC NULLS FIRST");
        Lead lead = (Lead) qr.getRecords()[0];
        System.out.println("FirstName : "+lead.getFirstName());
        System.out.println("Status : "+lead.getStatus());
        Date date = new Date();
        lead.setFirstName("TestNameUpdated"+date.getTime());
        db.UpdateLeadObject(lead);
        Lead lto[] = new Lead[1];
        lto[0] = lead;
        db.convertLead(lto);
    }
}
