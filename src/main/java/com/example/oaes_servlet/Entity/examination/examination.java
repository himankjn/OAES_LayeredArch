package com.example.oaes_servlet.Entity.examination;

abstract public class examination {
    int test_id=0;
    String exam_id="";
    eval_data edata=null;

    abstract boolean get_list_tests();
    abstract boolean get_questions();
    abstract void submit_for_eval();

    //template method
    public boolean conduct(){
        if(!get_list_tests()) return false;
        if(!get_questions()) return false;
        submit_for_eval();
        return  true;
    }
}
