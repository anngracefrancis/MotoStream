package cm.aptoide.pt.dataprovider.model.v7.listapp;

import cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessListResponse;

/* JADX INFO: loaded from: classes.dex */
public class ListAppVersions extends BaseV7EndlessListResponse<App> {
    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    protected boolean canEqual(Object obj) {
        return obj instanceof ListAppVersions;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ListAppVersions) && ((ListAppVersions) obj).canEqual(this) && super.equals(obj);
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessListResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7EndlessResponse, cm.aptoide.pt.dataprovider.model.v7.BaseV7Response
    public int hashCode() {
        return 59 + super.hashCode();
    }
}
