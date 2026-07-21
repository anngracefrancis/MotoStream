package cm.aptoide.pt.dataprovider.model.v7;

import cm.aptoide.pt.dataprovider.model.v7.listapp.App;

/* JADX INFO: loaded from: classes.dex */
public class ListApps extends BaseV7EndlessDataListResponse<App> {
    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    protected boolean canEqual(Object obj) {
        return obj instanceof ListApps;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ListApps) && ((ListApps) obj).canEqual(this) && super.equals(obj);
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public int hashCode() {
        return 59 + super.hashCode();
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessDataListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public String toString() {
        return "ListApps()";
    }
}
