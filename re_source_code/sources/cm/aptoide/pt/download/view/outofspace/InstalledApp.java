package cm.aptoide.pt.download.view.outofspace;

import cm.aptoide.pt.database.room.RoomInstalled;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: InstalledApp.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcm/aptoide/pt/download/view/outofspace/InstalledApp;", HttpUrl.FRAGMENT_ENCODE_SET, "appName", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", RoomInstalled.ICON, "size", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAppName", "()Ljava/lang/String;", "getIcon", "getPackageName", "getSize", "()J", "component1", "component2", "component3", "component4", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "getIdentifier", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class InstalledApp {
    private final String appName;
    private final String icon;
    private final String packageName;
    private final long size;

    public InstalledApp(String str, String str2, String str3, long j2) {
        kotlin.jvm.internal.m.f(str, "appName");
        kotlin.jvm.internal.m.f(str2, "packageName");
        kotlin.jvm.internal.m.f(str3, RoomInstalled.ICON);
        this.appName = str;
        this.packageName = str2;
        this.icon = str3;
        this.size = j2;
    }

    public static /* synthetic */ InstalledApp copy$default(InstalledApp installedApp, String str, String str2, String str3, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = installedApp.appName;
        }
        if ((i2 & 2) != 0) {
            str2 = installedApp.packageName;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = installedApp.icon;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            j2 = installedApp.size;
        }
        return installedApp.copy(str, str4, str5, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final InstalledApp copy(String appName, String packageName, String icon, long size) {
        kotlin.jvm.internal.m.f(appName, "appName");
        kotlin.jvm.internal.m.f(packageName, "packageName");
        kotlin.jvm.internal.m.f(icon, RoomInstalled.ICON);
        return new InstalledApp(appName, packageName, icon, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledApp)) {
            return false;
        }
        InstalledApp installedApp = (InstalledApp) other;
        return kotlin.jvm.internal.m.a(this.appName, installedApp.appName) && kotlin.jvm.internal.m.a(this.packageName, installedApp.packageName) && kotlin.jvm.internal.m.a(this.icon, installedApp.icon) && this.size == installedApp.size;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIdentifier() {
        return this.packageName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((this.appName.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.icon.hashCode()) * 31) + cm.aptoide.pt.aab.a.a(this.size);
    }

    public String toString() {
        return "InstalledApp(appName=" + this.appName + ", packageName=" + this.packageName + ", icon=" + this.icon + ", size=" + this.size + ')';
    }
}
