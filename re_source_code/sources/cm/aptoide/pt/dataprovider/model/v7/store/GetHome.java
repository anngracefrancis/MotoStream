package cm.aptoide.pt.dataprovider.model.v7.store;

/* JADX INFO: loaded from: classes.dex */
public class GetHome extends StoreUserAbstraction<GetHomeMeta> {
    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    protected boolean canEqual(Object obj) {
        return obj instanceof GetHome;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof GetHome) && ((GetHome) obj).canEqual(this) && super.equals(obj);
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public int hashCode() {
        return 59 + super.hashCode();
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.store.StoreUserAbstraction, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public String toString() {
        return "GetHome()";
    }
}
