package cm.aptoide.pt.dataprovider.ws.v7.analyticsbody;

/* JADX INFO: loaded from: classes.dex */
public class DownloadInstallAnalyticsBaseBody extends AnalyticsBaseBody {
    private final Data data;

    public DownloadInstallAnalyticsBaseBody(String str, Data data) {
        super(str);
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }
}
