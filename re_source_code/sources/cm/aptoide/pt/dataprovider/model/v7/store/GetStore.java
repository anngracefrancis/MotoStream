package cm.aptoide.pt.dataprovider.model.v7.store;

/* JADX INFO: loaded from: classes.dex */
public class GetStore extends StoreUserAbstraction<GetStoreMeta> {
    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    protected boolean canEqual(Object obj) {
        return obj instanceof GetStore;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof GetStore) && ((GetStore) obj).canEqual(this) && super.equals(obj);
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public int hashCode() {
        return 59 + super.hashCode();
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public String toString() {
        return "GetStore()";
    }
}
