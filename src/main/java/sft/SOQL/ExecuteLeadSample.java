package sft.SOQL;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Lead;

public class ExecuteLeadSample {
    public static void main(String[] args){
        QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        qr = db.ExecuteSOQL("SELECT Status FROM Lead WHERE FirstName = 'DB test FirstName' ORDER BY CreatedDate ASC NULLS FIRST");
        Lead lead = (Lead) qr.getRecords()[1];
        System.out.println("FirstName : "+lead.getFirstName());
        System.out.println("Status : "+lead.getStatus());
    }
}
