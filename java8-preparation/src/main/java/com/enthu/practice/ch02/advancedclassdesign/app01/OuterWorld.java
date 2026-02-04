package com.enthu.practice.ch02.advancedclassdesign.app01;

public class OuterWorld {


    private class InnerPeace {
        private String reason = "none";
    }

    private void m(){
        InnerPeace innerPeace = new InnerPeace();
        innerPeace.reason="ttt";
    }

}
