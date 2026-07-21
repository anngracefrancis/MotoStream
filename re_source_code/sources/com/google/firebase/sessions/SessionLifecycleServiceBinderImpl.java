package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.h0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionLifecycleServiceBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl;", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/FirebaseApp;)V", "bindToService", HttpUrl.FRAGMENT_ENCODE_SET, "callback", "Landroid/os/Messenger;", "serviceConnection", "Landroid/content/ServiceConnection;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f19953b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.firebase.j f19954c;

    /* JADX INFO: renamed from: com.google.firebase.sessions.h0$a */
    /* JADX INFO: compiled from: SessionLifecycleServiceBinder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public SessionLifecycleServiceBinderImpl(com.google.firebase.j jVar) {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        this.f19954c = jVar;
    }

    @Override // com.google.firebase.sessions.SessionLifecycleServiceBinder
    public void a(Messenger messenger, ServiceConnection serviceConnection) {
        kotlin.jvm.internal.m.f(messenger, "callback");
        kotlin.jvm.internal.m.f(serviceConnection, "serviceConnection");
        Context applicationContext = this.f19954c.i().getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra("ClientCallbackMessenger", messenger);
        applicationContext.bindService(intent, serviceConnection, 65);
    }
}
