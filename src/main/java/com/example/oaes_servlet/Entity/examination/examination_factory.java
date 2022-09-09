package com.example.oaes_servlet.Entity.examination;

public class examination_factory {
    public examination create_exam(String type, String e_id){
        examination exam = null;
        if(type=="iiitb"){
            exam = new examination_iiitb(e_id);
        }
        return exam;
    }
}
