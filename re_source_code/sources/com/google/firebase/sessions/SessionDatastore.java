package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.w, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionDatastore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastore;", HttpUrl.FRAGMENT_ENCODE_SET, "getCurrentSessionId", HttpUrl.FRAGMENT_ENCODE_SET, "updateSessionId", HttpUrl.FRAGMENT_ENCODE_SET, "sessionId", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SessionDatastore {
    public static final a a = a.a;

    /* JADX INFO: renamed from: com.google.firebase.sessions.w$a */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastore$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "instance", "Lcom/google/firebase/sessions/SessionDatastore;", "getInstance", "()Lcom/google/firebase/sessions/SessionDatastore;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final SessionDatastore a() {
            Object objH = com.google.firebase.l.a(Firebase.a).h(SessionDatastore.class);
            kotlin.jvm.internal.m.e(objH, "Firebase.app[SessionDatastore::class.java]");
            return (SessionDatastore) objH;
        }
    }

    String a();

    void b(String str);
}
