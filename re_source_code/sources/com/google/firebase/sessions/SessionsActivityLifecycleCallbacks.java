package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.i0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionsActivityLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R$\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/sessions/SessionsActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "hasPendingForeground", HttpUrl.FRAGMENT_ENCODE_SET, "getHasPendingForeground$com_google_firebase_firebase_sessions$annotations", "getHasPendingForeground$com_google_firebase_firebase_sessions", "()Z", "setHasPendingForeground$com_google_firebase_firebase_sessions", "(Z)V", "lifecycleClient", "Lcom/google/firebase/sessions/SessionLifecycleClient;", "getLifecycleClient", "()Lcom/google/firebase/sessions/SessionLifecycleClient;", "setLifecycleClient", "(Lcom/google/firebase/sessions/SessionLifecycleClient;)V", "onActivityCreated", HttpUrl.FRAGMENT_ENCODE_SET, "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SessionsActivityLifecycleCallbacks f19960f = new SessionsActivityLifecycleCallbacks();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f19961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static SessionLifecycleClient f19962h;

    private SessionsActivityLifecycleCallbacks() {
    }

    public final void a(SessionLifecycleClient sessionLifecycleClient) {
        f19962h = sessionLifecycleClient;
        if (sessionLifecycleClient == null || !f19961g) {
            return;
        }
        f19961g = false;
        sessionLifecycleClient.k();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = f19962h;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.h();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kotlin.u uVar;
        kotlin.jvm.internal.m.f(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = f19962h;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.k();
            uVar = kotlin.u.a;
        } else {
            uVar = null;
        }
        if (uVar == null) {
            f19961g = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        kotlin.jvm.internal.m.f(activity, "activity");
        kotlin.jvm.internal.m.f(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
    }
}
