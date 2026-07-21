package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.z, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: SessionEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/sessions/SessionEvent;", HttpUrl.FRAGMENT_ENCODE_SET, "eventType", "Lcom/google/firebase/sessions/EventType;", "sessionData", "Lcom/google/firebase/sessions/SessionInfo;", "applicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "(Lcom/google/firebase/sessions/EventType;Lcom/google/firebase/sessions/SessionInfo;Lcom/google/firebase/sessions/ApplicationInfo;)V", "getApplicationInfo", "()Lcom/google/firebase/sessions/ApplicationInfo;", "getEventType", "()Lcom/google/firebase/sessions/EventType;", "getSessionData", "()Lcom/google/firebase/sessions/SessionInfo;", "component1", "component2", "component3", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class SessionEvent {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final EventType eventType;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
    private final SessionInfo sessionData;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
    private final ApplicationInfo applicationInfo;

    public SessionEvent(EventType eventType, SessionInfo sessionInfo, ApplicationInfo applicationInfo) {
        kotlin.jvm.internal.m.f(eventType, "eventType");
        kotlin.jvm.internal.m.f(sessionInfo, "sessionData");
        kotlin.jvm.internal.m.f(applicationInfo, "applicationInfo");
        this.eventType = eventType;
        this.sessionData = sessionInfo;
        this.applicationInfo = applicationInfo;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final EventType getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final SessionInfo getSessionData() {
        return this.sessionData;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) other;
        return this.eventType == sessionEvent.eventType && kotlin.jvm.internal.m.a(this.sessionData, sessionEvent.sessionData) && kotlin.jvm.internal.m.a(this.applicationInfo, sessionEvent.applicationInfo);
    }

    public int hashCode() {
        return (((this.eventType.hashCode() * 31) + this.sessionData.hashCode()) * 31) + this.applicationInfo.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.eventType + ", sessionData=" + this.sessionData + ", applicationInfo=" + this.applicationInfo + ')';
    }
}
