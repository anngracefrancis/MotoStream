package cm.aptoide.pt.promotions;

import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.aab.Split;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.dataprovider.model.v7.Obb;
import com.google.android.gms.ads.AdRequest;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: WalletApp.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007¢\u0006\u0002\u0010\u001eJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010A\u001a\u00020\nHÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\u0017HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jß\u0001\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u0007HÆ\u0001J\u0013\u0010Q\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010S\u001a\u00020\u0005J\t\u0010T\u001a\u00020\u000eHÖ\u0001J\t\u0010U\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010)\"\u0004\b*\u0010+R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010 ¨\u0006V"}, d2 = {"Lcm/aptoide/pt/promotions/WalletApp;", HttpUrl.FRAGMENT_ENCODE_SET, "downloadModel", "Lcm/aptoide/pt/app/DownloadModel;", "isInstalled", HttpUrl.FRAGMENT_ENCODE_SET, "appName", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.ICON, DeepLinkIntentReceiver.DeepLinksKeys.ID, HttpUrl.FRAGMENT_ENCODE_SET, "packageName", "md5sum", RoomInstalled.VERSION_CODE, HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.VERSION_NAME, "path", "pathAlt", "obb", "Lcm/aptoide/pt/dataprovider/model/v7/Obb;", "size", "developer", "rating", HttpUrl.FRAGMENT_ENCODE_SET, "splits", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/aab/Split;", "requiredSplits", "storeName", "trustedBadge", "(Lcm/aptoide/pt/app/DownloadModel;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcm/aptoide/pt/dataprovider/model/v7/Obb;JLjava/lang/String;FLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getDeveloper", "getDownloadModel", "()Lcm/aptoide/pt/app/DownloadModel;", "setDownloadModel", "(Lcm/aptoide/pt/app/DownloadModel;)V", "getIcon", "getId", "()J", "()Z", "setInstalled", "(Z)V", "getMd5sum", "getObb", "()Lcm/aptoide/pt/dataprovider/model/v7/Obb;", "getPackageName", "getPath", "getPathAlt", "getRating", "()F", "getRequiredSplits", "()Ljava/util/List;", "getSize", "getSplits", "getStoreName", "getTrustedBadge", "getVersionCode", "()I", "getVersionName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "exists", "hashCode", "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class WalletApp {
    private final String appName;
    private final String developer;
    private DownloadModel downloadModel;
    private final String icon;
    private final long id;
    private boolean isInstalled;
    private final String md5sum;
    private final Obb obb;
    private final String packageName;
    private final String path;
    private final String pathAlt;
    private final float rating;
    private final List<String> requiredSplits;
    private final long size;
    private final List<Split> splits;
    private final String storeName;
    private final String trustedBadge;
    private final int versionCode;
    private final String versionName;

    public WalletApp() {
        this(null, false, null, null, 0L, null, null, 0, null, null, null, null, 0L, null, 0.0f, null, null, null, null, 524287, null);
    }

    public WalletApp(DownloadModel downloadModel, boolean z, String str, String str2, long j2, String str3, String str4, int i2, String str5, String str6, String str7, Obb obb, long j3, String str8, float f2, List<Split> list, List<String> list2, String str9, String str10) {
        kotlin.jvm.internal.m.f(str, "appName");
        kotlin.jvm.internal.m.f(str2, RoomInstalled.ICON);
        kotlin.jvm.internal.m.f(str3, "packageName");
        kotlin.jvm.internal.m.f(str8, "developer");
        kotlin.jvm.internal.m.f(list, "splits");
        kotlin.jvm.internal.m.f(list2, "requiredSplits");
        kotlin.jvm.internal.m.f(str9, "storeName");
        kotlin.jvm.internal.m.f(str10, "trustedBadge");
        this.downloadModel = downloadModel;
        this.isInstalled = z;
        this.appName = str;
        this.icon = str2;
        this.id = j2;
        this.packageName = str3;
        this.md5sum = str4;
        this.versionCode = i2;
        this.versionName = str5;
        this.path = str6;
        this.pathAlt = str7;
        this.obb = obb;
        this.size = j3;
        this.developer = str8;
        this.rating = f2;
        this.splits = list;
        this.requiredSplits = list2;
        this.storeName = str9;
        this.trustedBadge = str10;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DownloadModel getDownloadModel() {
        return this.downloadModel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPathAlt() {
        return this.pathAlt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Obb getObb() {
        return this.obb;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDeveloper() {
        return this.developer;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final float getRating() {
        return this.rating;
    }

    public final List<Split> component16() {
        return this.splits;
    }

    public final List<String> component17() {
        return this.requiredSplits;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStoreName() {
        return this.storeName;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getTrustedBadge() {
        return this.trustedBadge;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsInstalled() {
        return this.isInstalled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMd5sum() {
        return this.md5sum;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    public final WalletApp copy(DownloadModel downloadModel, boolean isInstalled, String appName, String icon, long id, String packageName, String md5sum, int versionCode, String versionName, String path, String pathAlt, Obb obb, long size, String developer, float rating, List<Split> splits, List<String> requiredSplits, String storeName, String trustedBadge) {
        kotlin.jvm.internal.m.f(appName, "appName");
        kotlin.jvm.internal.m.f(icon, RoomInstalled.ICON);
        kotlin.jvm.internal.m.f(packageName, "packageName");
        kotlin.jvm.internal.m.f(developer, "developer");
        kotlin.jvm.internal.m.f(splits, "splits");
        kotlin.jvm.internal.m.f(requiredSplits, "requiredSplits");
        kotlin.jvm.internal.m.f(storeName, "storeName");
        kotlin.jvm.internal.m.f(trustedBadge, "trustedBadge");
        return new WalletApp(downloadModel, isInstalled, appName, icon, id, packageName, md5sum, versionCode, versionName, path, pathAlt, obb, size, developer, rating, splits, requiredSplits, storeName, trustedBadge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WalletApp)) {
            return false;
        }
        WalletApp walletApp = (WalletApp) other;
        return kotlin.jvm.internal.m.a(this.downloadModel, walletApp.downloadModel) && this.isInstalled == walletApp.isInstalled && kotlin.jvm.internal.m.a(this.appName, walletApp.appName) && kotlin.jvm.internal.m.a(this.icon, walletApp.icon) && this.id == walletApp.id && kotlin.jvm.internal.m.a(this.packageName, walletApp.packageName) && kotlin.jvm.internal.m.a(this.md5sum, walletApp.md5sum) && this.versionCode == walletApp.versionCode && kotlin.jvm.internal.m.a(this.versionName, walletApp.versionName) && kotlin.jvm.internal.m.a(this.path, walletApp.path) && kotlin.jvm.internal.m.a(this.pathAlt, walletApp.pathAlt) && kotlin.jvm.internal.m.a(this.obb, walletApp.obb) && this.size == walletApp.size && kotlin.jvm.internal.m.a(this.developer, walletApp.developer) && kotlin.jvm.internal.m.a(Float.valueOf(this.rating), Float.valueOf(walletApp.rating)) && kotlin.jvm.internal.m.a(this.splits, walletApp.splits) && kotlin.jvm.internal.m.a(this.requiredSplits, walletApp.requiredSplits) && kotlin.jvm.internal.m.a(this.storeName, walletApp.storeName) && kotlin.jvm.internal.m.a(this.trustedBadge, walletApp.trustedBadge);
    }

    public final boolean exists() {
        return this.id != -1;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public final DownloadModel getDownloadModel() {
        return this.downloadModel;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    public final String getMd5sum() {
        return this.md5sum;
    }

    public final Obb getObb() {
        return this.obb;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPathAlt() {
        return this.pathAlt;
    }

    public final float getRating() {
        return this.rating;
    }

    public final List<String> getRequiredSplits() {
        return this.requiredSplits;
    }

    public final long getSize() {
        return this.size;
    }

    public final List<Split> getSplits() {
        return this.splits;
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final String getTrustedBadge() {
        return this.trustedBadge;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    public int hashCode() {
        DownloadModel downloadModel = this.downloadModel;
        int iHashCode = (downloadModel == null ? 0 : downloadModel.hashCode()) * 31;
        boolean z = this.isInstalled;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iHashCode2 = (((((((((iHashCode + r2) * 31) + this.appName.hashCode()) * 31) + this.icon.hashCode()) * 31) + cm.aptoide.pt.aab.a.a(this.id)) * 31) + this.packageName.hashCode()) * 31;
        String str = this.md5sum;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.versionCode) * 31;
        String str2 = this.versionName;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.path;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.pathAlt;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Obb obb = this.obb;
        return ((((((((((((((iHashCode6 + (obb != null ? obb.hashCode() : 0)) * 31) + cm.aptoide.pt.aab.a.a(this.size)) * 31) + this.developer.hashCode()) * 31) + Float.floatToIntBits(this.rating)) * 31) + this.splits.hashCode()) * 31) + this.requiredSplits.hashCode()) * 31) + this.storeName.hashCode()) * 31) + this.trustedBadge.hashCode();
    }

    public final boolean isInstalled() {
        return this.isInstalled;
    }

    public final void setDownloadModel(DownloadModel downloadModel) {
        this.downloadModel = downloadModel;
    }

    public final void setInstalled(boolean z) {
        this.isInstalled = z;
    }

    public String toString() {
        return "WalletApp(downloadModel=" + this.downloadModel + ", isInstalled=" + this.isInstalled + ", appName=" + this.appName + ", icon=" + this.icon + ", id=" + this.id + ", packageName=" + this.packageName + ", md5sum=" + this.md5sum + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", path=" + this.path + ", pathAlt=" + this.pathAlt + ", obb=" + this.obb + ", size=" + this.size + ", developer=" + this.developer + ", rating=" + this.rating + ", splits=" + this.splits + ", requiredSplits=" + this.requiredSplits + ", storeName=" + this.storeName + ", trustedBadge=" + this.trustedBadge + ')';
    }

    public /* synthetic */ WalletApp(DownloadModel downloadModel, boolean z, String str, String str2, long j2, String str3, String str4, int i2, String str5, String str6, String str7, Obb obb, long j3, String str8, float f2, List list, List list2, String str9, String str10, int i3, kotlin.jvm.internal.g gVar) {
        this((i3 & 1) != 0 ? null : downloadModel, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str, (i3 & 8) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str2, (i3 & 16) != 0 ? -1L : j2, (i3 & 32) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? -1 : i2, (i3 & 256) != 0 ? null : str5, (i3 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? null : str6, (i3 & 1024) != 0 ? null : str7, (i3 & RecyclerView.l.FLAG_MOVED) == 0 ? obb : null, (i3 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) != 0 ? 0L : j3, (i3 & 8192) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str8, (i3 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? -1.0f : f2, (i3 & 32768) != 0 ? kotlin.collections.u.j() : list, (i3 & 65536) != 0 ? kotlin.collections.u.j() : list2, (i3 & 131072) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str9, (i3 & 262144) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str10);
    }
}
