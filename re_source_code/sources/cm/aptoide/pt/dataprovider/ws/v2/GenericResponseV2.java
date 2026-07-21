package cm.aptoide.pt.dataprovider.ws.v2;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GenericResponseV2 {
    List<ErrorResponse> errors;
    String status;

    public List<ErrorResponse> getErrors() {
        return this.errors;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean hasErrors() {
        List<ErrorResponse> list = this.errors;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isOk() {
        String str = this.status;
        return str != null && str.equalsIgnoreCase("ok");
    }
}
