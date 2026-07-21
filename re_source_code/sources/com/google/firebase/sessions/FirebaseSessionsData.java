package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.r, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: SessionDatastore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsData;", HttpUrl.FRAGMENT_ENCODE_SET, "sessionId", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class FirebaseSessionsData {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final String sessionId;

    public FirebaseSessionsData(String str) {
        this.sessionId = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FirebaseSessionsData) && kotlin.jvm.internal.m.a(this.sessionId, ((FirebaseSessionsData) other).sessionId);
    }

    public int hashCode() {
        String str = this.sessionId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "FirebaseSessionsData(sessionId=" + this.sessionId + ')';
    }
}
