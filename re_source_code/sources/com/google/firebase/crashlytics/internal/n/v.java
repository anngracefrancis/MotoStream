package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.r.f;
import com.google.firebase.sessions.api.SessionSubscriber;

/* JADX INFO: compiled from: CrashlyticsAppQualitySessionsSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public class v implements SessionSubscriber {
    private final e0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f19088b;

    public v(e0 e0Var, f fVar) {
        this.a = e0Var;
        this.f19088b = new u(fVar);
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public boolean a() {
        return this.a.d();
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public SessionSubscriber.a b() {
        return SessionSubscriber.a.CRASHLYTICS;
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public void c(SessionSubscriber.SessionDetails sessionDetails) {
        h.f().b("App Quality Sessions session changed: " + sessionDetails);
        this.f19088b.f(sessionDetails.getSessionId());
    }

    public String d(String str) {
        return this.f19088b.a(str);
    }

    public void e(String str) {
        this.f19088b.g(str);
    }
}
