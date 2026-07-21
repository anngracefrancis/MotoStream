package cm.aptoide.pt.dataprovider.model.v7.search;

import cm.aptoide.pt.dataprovider.model.v7.Obb;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;

/* JADX INFO: loaded from: classes.dex */
public class SearchApp extends App {
    private boolean hasVersions;
    private Obb obb;

    @Override // cm.aptoide.pt.dataprovider.model.v7.listapp.App
    public Obb getObb() {
        return this.obb;
    }

    public boolean hasVersions() {
        return this.hasVersions;
    }

    public void setHasVersions(boolean z) {
        this.hasVersions = z;
    }

    @Override // cm.aptoide.pt.dataprovider.model.v7.listapp.App
    public void setObb(Obb obb) {
        this.obb = obb;
    }
}
