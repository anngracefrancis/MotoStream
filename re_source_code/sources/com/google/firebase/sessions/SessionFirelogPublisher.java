package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.b0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionFirelogPublisher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisher;", HttpUrl.FRAGMENT_ENCODE_SET, "logSession", HttpUrl.FRAGMENT_ENCODE_SET, "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SessionFirelogPublisher {
    public static final a a = a.a;

    /* JADX INFO: renamed from: com.google.firebase.sessions.b0$a */
    /* JADX INFO: compiled from: SessionFirelogPublisher.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisher$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "instance", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "getInstance", "()Lcom/google/firebase/sessions/SessionFirelogPublisher;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final SessionFirelogPublisher a() {
            Object objH = com.google.firebase.l.a(Firebase.a).h(SessionFirelogPublisher.class);
            kotlin.jvm.internal.m.e(objH, "Firebase.app[SessionFirelogPublisher::class.java]");
            return (SessionFirelogPublisher) objH;
        }
    }

    void a(SessionDetails sessionDetails);
}
