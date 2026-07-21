package com.google.firebase.sessions.settings;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p003y.Continuation;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.c;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.m0.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: LocalOverrideSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/sessions/settings/LocalOverrideSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "metadata", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "getMetadata$annotations", "()V", "samplingRate", HttpUrl.FRAGMENT_ENCODE_SET, "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", HttpUrl.FRAGMENT_ENCODE_SET, "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocalOverrideSettings implements SettingsProvider {
    private static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f20016b;

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.b$a */
    /* JADX INFO: compiled from: LocalOverrideSettings.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/settings/LocalOverrideSettings$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "SAMPLING_RATE", HttpUrl.FRAGMENT_ENCODE_SET, "SESSIONS_ENABLED", "SESSION_RESTART_TIMEOUT", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public LocalOverrideSettings(Context context) {
        m.f(context, "context");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f20016b = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean a() {
        if (this.f20016b.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(this.f20016b.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Duration b() {
        if (this.f20016b.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return Duration.k(c.h(this.f20016b.getInt("firebase_sessions_sessions_restart_timeout"), DurationUnit.SECONDS));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double c() {
        if (this.f20016b.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(this.f20016b.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Object d(Continuation<? super u> continuation) {
        return SettingsProvider.a.a(this, continuation);
    }
}
