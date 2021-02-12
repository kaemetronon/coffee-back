package ru.coffee.nostresso.model.response;

public class FailResponce implements Response{

    public String getErrorMsg() {
        return errorMsg;
    }

    private String errorMsg;
    public FailResponce(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean getSuccess() {
        return false;
    }
}
