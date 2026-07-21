package cm.aptoide.pt.aab;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DynamicSplit.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\nHÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006&"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplit;", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "type", "md5Sum", "path", "fileSize", HttpUrl.FRAGMENT_ENCODE_SET, "deliveryTypes", HttpUrl.FRAGMENT_ENCODE_SET, "configSplits", "Lcm/aptoide/pt/aab/Split;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)V", "getConfigSplits", "()Ljava/util/List;", "getDeliveryTypes", "getFileSize", "()J", "getMd5Sum", "()Ljava/lang/String;", "getName", "getPath", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class DynamicSplit {
    private final List<Split> configSplits;
    private final List<String> deliveryTypes;
    private final long fileSize;
    private final String md5Sum;
    private final String name;
    private final String path;
    private final String type;

    public DynamicSplit(String str, String str2, String str3, String str4, long j2, List<String> list, List<Split> list2) {
        m.f(str, "name");
        m.f(str2, "type");
        m.f(str3, "md5Sum");
        m.f(str4, "path");
        m.f(list, "deliveryTypes");
        m.f(list2, "configSplits");
        this.name = str;
        this.type = str2;
        this.md5Sum = str3;
        this.path = str4;
        this.fileSize = j2;
        this.deliveryTypes = list;
        this.configSplits = list2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMd5Sum() {
        return this.md5Sum;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    public final List<String> component6() {
        return this.deliveryTypes;
    }

    public final List<Split> component7() {
        return this.configSplits;
    }

    public final DynamicSplit copy(String name, String type, String md5Sum, String path, long fileSize, List<String> deliveryTypes, List<Split> configSplits) {
        m.f(name, "name");
        m.f(type, "type");
        m.f(md5Sum, "md5Sum");
        m.f(path, "path");
        m.f(deliveryTypes, "deliveryTypes");
        m.f(configSplits, "configSplits");
        return new DynamicSplit(name, type, md5Sum, path, fileSize, deliveryTypes, configSplits);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DynamicSplit)) {
            return false;
        }
        DynamicSplit dynamicSplit = (DynamicSplit) other;
        return m.a(this.name, dynamicSplit.name) && m.a(this.type, dynamicSplit.type) && m.a(this.md5Sum, dynamicSplit.md5Sum) && m.a(this.path, dynamicSplit.path) && this.fileSize == dynamicSplit.fileSize && m.a(this.deliveryTypes, dynamicSplit.deliveryTypes) && m.a(this.configSplits, dynamicSplit.configSplits);
    }

    public final List<Split> getConfigSplits() {
        return this.configSplits;
    }

    public final List<String> getDeliveryTypes() {
        return this.deliveryTypes;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getMd5Sum() {
        return this.md5Sum;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.md5Sum.hashCode()) * 31) + this.path.hashCode()) * 31) + a.a(this.fileSize)) * 31) + this.deliveryTypes.hashCode()) * 31) + this.configSplits.hashCode();
    }

    public String toString() {
        return "DynamicSplit(name=" + this.name + ", type=" + this.type + ", md5Sum=" + this.md5Sum + ", path=" + this.path + ", fileSize=" + this.fileSize + ", deliveryTypes=" + this.deliveryTypes + ", configSplits=" + this.configSplits + ')';
    }
}
