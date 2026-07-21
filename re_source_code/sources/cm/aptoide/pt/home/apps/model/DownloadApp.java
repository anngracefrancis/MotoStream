package cm.aptoide.pt.home.apps.model;

import cm.aptoide.pt.aab.a;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.home.apps.App;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadApp.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003Je\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\b\u0010-\u001a\u00020\u0003H\u0016J\b\u0010.\u001a\u00020/H\u0016J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\n\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u00062"}, d2 = {"Lcm/aptoide/pt/home/apps/model/DownloadApp;", "Lcm/aptoide/pt/home/apps/model/StateApp;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "md5", RoomInstalled.ICON, "packageName", "progress", HttpUrl.FRAGMENT_ENCODE_SET, "version", RoomInstalled.VERSION_CODE, "status", "Lcm/aptoide/pt/home/apps/model/StateApp$Status;", "appId", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILcm/aptoide/pt/home/apps/model/StateApp$Status;J)V", "getAppId", "()J", "getIcon", "()Ljava/lang/String;", "getMd5", "getName", "getPackageName", "getProgress", "()I", "getStatus", "()Lcm/aptoide/pt/home/apps/model/StateApp$Status;", "setStatus", "(Lcm/aptoide/pt/home/apps/model/StateApp$Status;)V", "getVersion", "getVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "getIdentifier", "getType", "Lcm/aptoide/pt/home/apps/App$Type;", "hashCode", "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class DownloadApp implements StateApp {
    private final long appId;
    private final String icon;
    private final String md5;
    private final String name;
    private final String packageName;
    private final int progress;
    private StateApp.Status status;
    private final String version;
    private final int versionCode;

    public DownloadApp(String str, String str2, String str3, String str4, int i2, String str5, int i3, StateApp.Status status, long j2) {
        m.f(str, "name");
        m.f(str2, "md5");
        m.f(str3, RoomInstalled.ICON);
        m.f(str4, "packageName");
        m.f(str5, "version");
        this.name = str;
        this.md5 = str2;
        this.icon = str3;
        this.packageName = str4;
        this.progress = i2;
        this.version = str5;
        this.versionCode = i3;
        this.status = status;
        this.appId = j2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final String component2() {
        return getMd5();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final String component4() {
        return getPackageName();
    }

    public final int component5() {
        return getProgress();
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final int component7() {
        return getVersionCode();
    }

    public final StateApp.Status component8() {
        return getStatus();
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getAppId() {
        return this.appId;
    }

    public final DownloadApp copy(String name, String md5, String icon, String packageName, int progress, String version, int versionCode, StateApp.Status status, long appId) {
        m.f(name, "name");
        m.f(md5, "md5");
        m.f(icon, RoomInstalled.ICON);
        m.f(packageName, "packageName");
        m.f(version, "version");
        return new DownloadApp(name, md5, icon, packageName, progress, version, versionCode, status, appId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadApp)) {
            return false;
        }
        DownloadApp downloadApp = (DownloadApp) other;
        return m.a(this.name, downloadApp.name) && m.a(getMd5(), downloadApp.getMd5()) && m.a(this.icon, downloadApp.icon) && m.a(getPackageName(), downloadApp.getPackageName()) && getProgress() == downloadApp.getProgress() && m.a(this.version, downloadApp.version) && getVersionCode() == downloadApp.getVersionCode() && getStatus() == downloadApp.getStatus() && this.appId == downloadApp.appId;
    }

    public final long getAppId() {
        return this.appId;
    }

    public final String getIcon() {
        return this.icon;
    }

    @Override // cm.aptoide.pt.home.apps.App
    public String getIdentifier() {
        return getMd5();
    }

    @Override // cm.aptoide.pt.home.apps.model.StateApp
    public String getMd5() {
        return this.md5;
    }

    public final String getName() {
        return this.name;
    }

    @Override // cm.aptoide.pt.home.apps.model.StateApp
    public String getPackageName() {
        return this.packageName;
    }

    @Override // cm.aptoide.pt.home.apps.model.StateApp
    public int getProgress() {
        return this.progress;
    }

    @Override // cm.aptoide.pt.home.apps.model.StateApp
    public StateApp.Status getStatus() {
        return this.status;
    }

    @Override // cm.aptoide.pt.home.apps.App
    public App.Type getType() {
        return App.Type.DOWNLOAD;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override // cm.aptoide.pt.home.apps.model.StateApp
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return (((((((((((((((this.name.hashCode() * 31) + getMd5().hashCode()) * 31) + this.icon.hashCode()) * 31) + getPackageName().hashCode()) * 31) + getProgress()) * 31) + this.version.hashCode()) * 31) + getVersionCode()) * 31) + (getStatus() == null ? 0 : getStatus().hashCode())) * 31) + a.a(this.appId);
    }

    public void setStatus(StateApp.Status status) {
        this.status = status;
    }

    public String toString() {
        return "DownloadApp(name=" + this.name + ", md5=" + getMd5() + ", icon=" + this.icon + ", packageName=" + getPackageName() + ", progress=" + getProgress() + ", version=" + this.version + ", versionCode=" + getVersionCode() + ", status=" + getStatus() + ", appId=" + this.appId + ')';
    }

    public /* synthetic */ DownloadApp(String str, String str2, String str3, String str4, int i2, String str5, int i3, StateApp.Status status, long j2, int i4, g gVar) {
        this(str, str2, str3, str4, i2, str5, i3, (i4 & 128) != 0 ? null : status, j2);
    }
}
