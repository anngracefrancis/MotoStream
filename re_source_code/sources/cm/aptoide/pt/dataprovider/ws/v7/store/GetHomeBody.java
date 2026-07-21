package cm.aptoide.pt.dataprovider.ws.v7.store;

import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;

/* JADX INFO: loaded from: classes.dex */
public class GetHomeBody extends GetStoreBody {
    private Long userId;

    public GetHomeBody(BaseRequestWithStore.StoreCredentials storeCredentials, WidgetsArgs widgetsArgs, Long l) {
        super(storeCredentials, widgetsArgs);
        this.userId = l;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }
}
