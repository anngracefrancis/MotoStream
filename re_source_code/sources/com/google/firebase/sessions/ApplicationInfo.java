package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.j, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: ApplicationInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/google/firebase/sessions/ApplicationInfo;", HttpUrl.FRAGMENT_ENCODE_SET, "appId", HttpUrl.FRAGMENT_ENCODE_SET, "deviceModel", "sessionSdkVersion", "osVersion", "logEnvironment", "Lcom/google/firebase/sessions/LogEnvironment;", "androidAppInfo", "Lcom/google/firebase/sessions/AndroidApplicationInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/firebase/sessions/LogEnvironment;Lcom/google/firebase/sessions/AndroidApplicationInfo;)V", "getAndroidAppInfo", "()Lcom/google/firebase/sessions/AndroidApplicationInfo;", "getAppId", "()Ljava/lang/String;", "getDeviceModel", "getLogEnvironment", "()Lcom/google/firebase/sessions/LogEnvironment;", "getOsVersion", "getSessionSdkVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class ApplicationInfo {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final String appId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
    private final String deviceModel;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
    private final String sessionSdkVersion;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from toString */
    private final String osVersion;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from toString */
    private final LogEnvironment logEnvironment;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from toString */
    private final AndroidApplicationInfo androidAppInfo;

    public ApplicationInfo(String str, String str2, String str3, String str4, LogEnvironment logEnvironment, AndroidApplicationInfo androidApplicationInfo) {
        kotlin.jvm.internal.m.f(str, "appId");
        kotlin.jvm.internal.m.f(str2, "deviceModel");
        kotlin.jvm.internal.m.f(str3, "sessionSdkVersion");
        kotlin.jvm.internal.m.f(str4, "osVersion");
        kotlin.jvm.internal.m.f(logEnvironment, "logEnvironment");
        kotlin.jvm.internal.m.f(androidApplicationInfo, "androidAppInfo");
        this.appId = str;
        this.deviceModel = str2;
        this.sessionSdkVersion = str3;
        this.osVersion = str4;
        this.logEnvironment = logEnvironment;
        this.androidAppInfo = androidApplicationInfo;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final AndroidApplicationInfo getAndroidAppInfo() {
        return this.androidAppInfo;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final LogEnvironment getLogEnvironment() {
        return this.logEnvironment;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) other;
        return kotlin.jvm.internal.m.a(this.appId, applicationInfo.appId) && kotlin.jvm.internal.m.a(this.deviceModel, applicationInfo.deviceModel) && kotlin.jvm.internal.m.a(this.sessionSdkVersion, applicationInfo.sessionSdkVersion) && kotlin.jvm.internal.m.a(this.osVersion, applicationInfo.osVersion) && this.logEnvironment == applicationInfo.logEnvironment && kotlin.jvm.internal.m.a(this.androidAppInfo, applicationInfo.androidAppInfo);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getSessionSdkVersion() {
        return this.sessionSdkVersion;
    }

    public int hashCode() {
        return (((((((((this.appId.hashCode() * 31) + this.deviceModel.hashCode()) * 31) + this.sessionSdkVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.logEnvironment.hashCode()) * 31) + this.androidAppInfo.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", sessionSdkVersion=" + this.sessionSdkVersion + ", osVersion=" + this.osVersion + ", logEnvironment=" + this.logEnvironment + ", androidAppInfo=" + this.androidAppInfo + ')';
    }
}
