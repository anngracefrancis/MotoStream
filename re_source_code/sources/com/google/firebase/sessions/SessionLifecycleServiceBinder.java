package com.google.firebase.sessions;

import android.content.ServiceConnection;
import android.os.Messenger;
import com.google.firebase.Firebase;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.g0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionLifecycleServiceBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", HttpUrl.FRAGMENT_ENCODE_SET, "bindToService", HttpUrl.FRAGMENT_ENCODE_SET, "callback", "Landroid/os/Messenger;", "serviceConnection", "Landroid/content/ServiceConnection;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SessionLifecycleServiceBinder {
    public static final a a = a.a;

    /* JADX INFO: renamed from: com.google.firebase.sessions.g0$a */
    /* JADX INFO: compiled from: SessionLifecycleServiceBinder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinder$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "instance", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "getInstance", "()Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final SessionLifecycleServiceBinder a() {
            Object objH = com.google.firebase.l.a(Firebase.a).h(SessionLifecycleServiceBinder.class);
            kotlin.jvm.internal.m.e(objH, "Firebase.app[SessionLife…erviceBinder::class.java]");
            return (SessionLifecycleServiceBinder) objH;
        }
    }

    void a(Messenger messenger, ServiceConnection serviceConnection);
}
