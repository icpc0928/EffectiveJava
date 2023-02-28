package cp6;

public enum Operation_0 {
    //當添加新的枚舉時，可能會忘了做switch的方法, 且依照正確邏輯 switch中不應該走到throw Error這行 這是比較不好的方法
    PLUS ,
    MINUS ,
    TIMES ,
    DIVIDE ;

    public double apply(double x, double y){
        switch (this){
            case PLUS:return x+y;
            case MINUS:return x-y;
            case TIMES:return x*y;
            case DIVIDE:return x/y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}
