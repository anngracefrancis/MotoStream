package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.pt.download.DownloadAnalytics;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EarnAppcListAnalytics.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListAnalytics;", HttpUrl.FRAGMENT_ENCODE_SET, "downloadAnalytics", "Lcm/aptoide/pt/download/DownloadAnalytics;", "(Lcm/aptoide/pt/download/DownloadAnalytics;)V", "sendNotEnoughSpaceErrorEvent", HttpUrl.FRAGMENT_ENCODE_SET, "md5", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EarnAppcListAnalytics {
    private final DownloadAnalytics downloadAnalytics;

    public EarnAppcListAnalytics(DownloadAnalytics downloadAnalytics) {
        kotlin.jvm.internal.m.f(downloadAnalytics, "downloadAnalytics");
        this.downloadAnalytics = downloadAnalytics;
    }

    public final void sendNotEnoughSpaceErrorEvent(String md5) {
        this.downloadAnalytics.sendNotEnoughSpaceError(md5);
    }
}
