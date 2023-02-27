package cp3;

import java.util.Comparator;
import java.util.Objects;

public final class PhoneNumber implements Cloneable {
    private final int areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private static int rangeCheck(int val, int max, String arg) throws IllegalAccessException {
        if(val < 0 || val > max){
            throw new IllegalAccessException(arg + " : " + val);
        }
        return val;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PhoneNumber that = (PhoneNumber) o;
//        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(areaCode, prefix, lineNum);
//    }


    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof PhoneNumber)) return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

    //延遲初始化hashCode
    private int hashCode;

    @Override
    public int hashCode(){
        int result = hashCode;
        if(result == 0){
            result = Integer.hashCode(areaCode);
            result = 31 * result + Integer.hashCode(prefix);
            result = 31 * result + Integer.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }


    /**
     * 回傳國碼-區碼-電話號碼
     * 格式: "XXX-YY-ZZZZZZZZ"
     * XXX:國碼 YY:區碼 ZZZZZZZZ:電話號碼
     * 如果號碼小於格式設置的位數,則前面補0
     */
    @Override
    public String toString() {
        return String.format("%03d-%02d-%08d", areaCode, prefix, lineNum);
    }

    @Override
    public PhoneNumber clone(){
        try{
            return (PhoneNumber) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }


    public int compareTo1(PhoneNumber pn){
        int result = Integer.compare(areaCode, pn.areaCode);
        if(result == 0){
            result = Integer.compare(prefix, pn.prefix);
            if(result == 0){
                result = Integer.compare(lineNum, pn.lineNum);
            }
        }
        return result;
    }

    //Comparable with comparator construction method
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public int compareTo(PhoneNumber pn){
        return COMPARATOR.compare(this, pn);
    }

}
