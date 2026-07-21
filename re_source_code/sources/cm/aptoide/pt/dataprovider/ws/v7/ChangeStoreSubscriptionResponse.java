package cm.aptoide.pt.dataprovider.ws.v7;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;

/* JADX INFO: loaded from: classes.dex */
public class ChangeStoreSubscriptionResponse extends BaseV7Response {
    private StoreSubscriptionState status;
    private Store store;

    public enum StoreSubscriptionState {
        UNSUBSCRIBED,
        SUBSCRIBED
    }

    public StoreSubscriptionState getStatus() {
        return this.status;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStatus(StoreSubscriptionState storeSubscriptionState) {
        this.status = storeSubscriptionState;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
