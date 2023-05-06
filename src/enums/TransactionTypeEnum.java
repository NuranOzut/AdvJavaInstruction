package enums;

public enum TransactionTypeEnum {

    DEPOSIT(10),//0
    WITHDRAW(20),//1
    TRANSFER(30),//2

    PAYMENT(40),//3
    OTHER(50);//4

    private final int code;

    public int getCode() {
        return code;
    }

    TransactionTypeEnum(int code){
        this.code=code;
    }

}