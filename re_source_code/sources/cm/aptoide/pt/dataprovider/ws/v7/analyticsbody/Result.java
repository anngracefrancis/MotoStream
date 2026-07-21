package cm.aptoide.pt.dataprovider.ws.v7.analyticsbody;

/* JADX INFO: loaded from: classes.dex */
public class Result {
    private ResultError error;
    private ResultStatus status;

    public enum ResultStatus {
        SUCC,
        FAIL
    }

    public ResultError getError() {
        return this.error;
    }

    public ResultStatus getStatus() {
        return this.status;
    }

    public void setError(ResultError resultError) {
        this.error = resultError;
    }

    public void setStatus(ResultStatus resultStatus) {
        this.status = resultStatus;
    }
}
