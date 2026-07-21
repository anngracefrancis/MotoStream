package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.e0, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: SessionEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/google/firebase/sessions/SessionInfo;", HttpUrl.FRAGMENT_ENCODE_SET, "sessionId", HttpUrl.FRAGMENT_ENCODE_SET, "firstSessionId", "sessionIndex", HttpUrl.FRAGMENT_ENCODE_SET, "eventTimestampUs", HttpUrl.FRAGMENT_ENCODE_SET, "dataCollectionStatus", "Lcom/google/firebase/sessions/DataCollectionStatus;", "firebaseInstallationId", "(Ljava/lang/String;Ljava/lang/String;IJLcom/google/firebase/sessions/DataCollectionStatus;Ljava/lang/String;)V", "getDataCollectionStatus", "()Lcom/google/firebase/sessions/DataCollectionStatus;", "getEventTimestampUs", "()J", "getFirebaseInstallationId", "()Ljava/lang/String;", "getFirstSessionId", "getSessionId", "getSessionIndex", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class SessionInfo {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final String sessionId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
    private final String firstSessionId;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
    private final int sessionIndex;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from toString */
    private final long eventTimestampUs;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from toString */
    private final DataCollectionStatus dataCollectionStatus;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from toString */
    private final String firebaseInstallationId;

    public SessionInfo(String str, String str2, int i2, long j2, DataCollectionStatus dataCollectionStatus, String str3) {
        kotlin.jvm.internal.m.f(str, "sessionId");
        kotlin.jvm.internal.m.f(str2, "firstSessionId");
        kotlin.jvm.internal.m.f(dataCollectionStatus, "dataCollectionStatus");
        kotlin.jvm.internal.m.f(str3, "firebaseInstallationId");
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i2;
        this.eventTimestampUs = j2;
        this.dataCollectionStatus = dataCollectionStatus;
        this.firebaseInstallationId = str3;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) other;
        return kotlin.jvm.internal.m.a(this.sessionId, sessionInfo.sessionId) && kotlin.jvm.internal.m.a(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && kotlin.jvm.internal.m.a(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && kotlin.jvm.internal.m.a(this.firebaseInstallationId, sessionInfo.firebaseInstallationId);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public int hashCode() {
        return (((((((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + this.sessionIndex) * 31) + cm.aptoide.pt.aab.a.a(this.eventTimestampUs)) * 31) + this.dataCollectionStatus.hashCode()) * 31) + this.firebaseInstallationId.hashCode();
    }

    public String toString() {
        return "SessionInfo(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", eventTimestampUs=" + this.eventTimestampUs + ", dataCollectionStatus=" + this.dataCollectionStatus + ", firebaseInstallationId=" + this.firebaseInstallationId + ')';
    }
}
