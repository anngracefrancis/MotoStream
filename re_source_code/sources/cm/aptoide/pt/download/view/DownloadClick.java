package cm.aptoide.pt.download.view;

import cm.aptoide.pt.download.DownloadAnalytics;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadClick.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcm/aptoide/pt/download/view/DownloadClick;", HttpUrl.FRAGMENT_ENCODE_SET, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, "Lcm/aptoide/pt/download/view/Download;", "action", "Lcm/aptoide/pt/download/view/DownloadEvent;", "(Lcm/aptoide/pt/download/view/Download;Lcm/aptoide/pt/download/view/DownloadEvent;)V", "getAction", "()Lcm/aptoide/pt/download/view/DownloadEvent;", "getDownload", "()Lcm/aptoide/pt/download/view/Download;", "component1", "component2", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class DownloadClick {
    private final DownloadEvent action;
    private final Download download;

    public DownloadClick(Download download, DownloadEvent downloadEvent) {
        kotlin.jvm.internal.m.f(download, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT);
        kotlin.jvm.internal.m.f(downloadEvent, "action");
        this.download = download;
        this.action = downloadEvent;
    }

    public static /* synthetic */ DownloadClick copy$default(DownloadClick downloadClick, Download download, DownloadEvent downloadEvent, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            download = downloadClick.download;
        }
        if ((i2 & 2) != 0) {
            downloadEvent = downloadClick.action;
        }
        return downloadClick.copy(download, downloadEvent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Download getDownload() {
        return this.download;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DownloadEvent getAction() {
        return this.action;
    }

    public final DownloadClick copy(Download download, DownloadEvent action) {
        kotlin.jvm.internal.m.f(download, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT);
        kotlin.jvm.internal.m.f(action, "action");
        return new DownloadClick(download, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadClick)) {
            return false;
        }
        DownloadClick downloadClick = (DownloadClick) other;
        return kotlin.jvm.internal.m.a(this.download, downloadClick.download) && this.action == downloadClick.action;
    }

    public final DownloadEvent getAction() {
        return this.action;
    }

    public final Download getDownload() {
        return this.download;
    }

    public int hashCode() {
        return (this.download.hashCode() * 31) + this.action.hashCode();
    }

    public String toString() {
        return "DownloadClick(download=" + this.download + ", action=" + this.action + ')';
    }
}
