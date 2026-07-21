package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.y, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: SessionGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/google/firebase/sessions/SessionDetails;", HttpUrl.FRAGMENT_ENCODE_SET, "sessionId", HttpUrl.FRAGMENT_ENCODE_SET, "firstSessionId", "sessionIndex", HttpUrl.FRAGMENT_ENCODE_SET, "sessionStartTimestampUs", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Ljava/lang/String;IJ)V", "getFirstSessionId", "()Ljava/lang/String;", "getSessionId", "getSessionIndex", "()I", "getSessionStartTimestampUs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class SessionDetails {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final String sessionId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
    private final String firstSessionId;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
    private final int sessionIndex;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from toString */
    private final long sessionStartTimestampUs;

    public SessionDetails(String str, String str2, int i2, long j2) {
        kotlin.jvm.internal.m.f(str, "sessionId");
        kotlin.jvm.internal.m.f(str2, "firstSessionId");
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i2;
        this.sessionStartTimestampUs = j2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getSessionStartTimestampUs() {
        return this.sessionStartTimestampUs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) other;
        return kotlin.jvm.internal.m.a(this.sessionId, sessionDetails.sessionId) && kotlin.jvm.internal.m.a(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + this.sessionIndex) * 31) + cm.aptoide.pt.aab.a.a(this.sessionStartTimestampUs);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }
}
