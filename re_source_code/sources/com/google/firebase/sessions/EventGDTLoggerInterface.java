package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.o, reason: from Kotlin metadata */
/* JADX INFO: compiled from: EventGDTLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLoggerInterface;", HttpUrl.FRAGMENT_ENCODE_SET, "log", HttpUrl.FRAGMENT_ENCODE_SET, "sessionEvent", "Lcom/google/firebase/sessions/SessionEvent;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface EventGDTLoggerInterface {
    void a(SessionEvent sessionEvent);
}
