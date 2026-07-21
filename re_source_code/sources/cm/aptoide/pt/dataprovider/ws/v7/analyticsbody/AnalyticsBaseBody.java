package cm.aptoide.pt.dataprovider.ws.v7.analyticsbody;

import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsBaseBody extends BaseBody {
    private final String aptoidePackage;

    public AnalyticsBaseBody(String str) {
        this.aptoidePackage = str;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v7.BaseBody
    public String getAptoidePackage() {
        return this.aptoidePackage;
    }
}
