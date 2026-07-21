package com.google.firebase.sessions.settings;

import android.util.Log;
import androidx.datastore.core.e;
import c.l.b.i.f;
import cm.aptoide.pt.database.room.RoomNotification;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.p005z2.Flow;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.m0.g, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SettingsCache.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\u0013\u0010\u000b\u001a\u00020\fH\u0081@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0016J/\u0010\u0017\u001a\u00020\f\"\u0004\b\u0000\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\u0010\u001b\u001a\u0004\u0018\u0001H\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u001b\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001b\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0004H\u0002J\u001b\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001b\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", HttpUrl.FRAGMENT_ENCODE_SET, "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Landroidx/datastore/core/DataStore;)V", "sessionConfigs", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "hasCacheExpired", HttpUrl.FRAGMENT_ENCODE_SET, "hasCacheExpired$com_google_firebase_firebase_sessions", "removeConfigs", HttpUrl.FRAGMENT_ENCODE_SET, "removeConfigs$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionRestartTimeout", HttpUrl.FRAGMENT_ENCODE_SET, "()Ljava/lang/Integer;", "sessionSamplingRate", HttpUrl.FRAGMENT_ENCODE_SET, "()Ljava/lang/Double;", "sessionsEnabled", "()Ljava/lang/Boolean;", "updateConfigValue", "T", RoomNotification.KEY, "Landroidx/datastore/preferences/core/Preferences$Key;", "value", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSamplingRate", "rate", "(Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSessionCacheDuration", "cacheDurationInSeconds", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSessionCacheUpdatedTime", "cacheUpdatedTime", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSessionConfigs", "preferences", "updateSessionRestartTimeout", "timeoutInSeconds", "updateSettingsEnabled", "enabled", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SettingsCache {
    private static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final c.l.b.i.d.a<Boolean> f20055b = f.a("firebase_sessions_enabled");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final c.l.b.i.d.a<Double> f20056c = f.b("firebase_sessions_sampling_rate");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    private static final c.l.b.i.d.a<Integer> f20057d = f.d("firebase_sessions_restart_timeout");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    private static final c.l.b.i.d.a<Integer> f20058e = f.d("firebase_sessions_cache_duration");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    private static final c.l.b.i.d.a<Long> f20059f = f.e("firebase_sessions_cache_updated_time");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e<c.l.b.i.d> f20060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SessionConfigs f20061h;

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.g$a */
    /* JADX INFO: compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f20062f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f20063g;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return SettingsCache.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            SettingsCache settingsCache;
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f20063g;
            if (i2 == 0) {
                o.b(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                Flow flowB = settingsCache2.f20060g.b();
                this.f20062f = settingsCache2;
                this.f20063g = 1;
                Object objF = kotlinx.coroutines.p005z2.d.f(flowB, this);
                if (objF == objC) {
                    return objC;
                }
                settingsCache = settingsCache2;
                obj = objF;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.f20062f;
                o.b(obj);
            }
            settingsCache.l(((c.l.b.i.d) obj).d());
            return u.a;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.g$b */
    /* JADX INFO: compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "CACHE_DURATION_SECONDS", "Landroidx/datastore/preferences/core/Preferences$Key;", HttpUrl.FRAGMENT_ENCODE_SET, "getCACHE_DURATION_SECONDS", "()Landroidx/datastore/preferences/core/Preferences$Key;", "CACHE_UPDATED_TIME", HttpUrl.FRAGMENT_ENCODE_SET, "getCACHE_UPDATED_TIME", "RESTART_TIMEOUT_SECONDS", "getRESTART_TIMEOUT_SECONDS", "SAMPLING_RATE", HttpUrl.FRAGMENT_ENCODE_SET, "getSAMPLING_RATE", "SESSIONS_ENABLED", HttpUrl.FRAGMENT_ENCODE_SET, "getSESSIONS_ENABLED", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.g$c */
    /* JADX INFO: compiled from: SettingsCache.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {112}, m = "updateConfigValue")
    static final class c<T> extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f20065f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f20067h;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f20065f = obj;
            this.f20067h |= Integer.MIN_VALUE;
            return SettingsCache.this.h(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.g$d */
    /* JADX INFO: compiled from: SettingsCache.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
    static final class d extends SuspendLambda implements Function2<c.l.b.i.a, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20068f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f20069g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ T f20070h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c.l.b.i.d.a<T> f20071i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ SettingsCache f20072j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(T t, c.l.b.i.d.a<T> aVar, SettingsCache settingsCache, Continuation<? super d> continuation) {
            super(2, continuation);
            this.f20070h = t;
            this.f20071i = aVar;
            this.f20072j = settingsCache;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.f20070h, this.f20071i, this.f20072j, continuation);
            dVar.f20069g = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(c.l.b.i.a aVar, Continuation<? super u> continuation) {
            return ((d) create(aVar, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.p003y.intrinsics.d.c();
            if (this.f20068f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
            c.l.b.i.a aVar = (c.l.b.i.a) this.f20069g;
            T t = this.f20070h;
            if (t != 0) {
                aVar.i(this.f20071i, t);
            } else {
                aVar.h(this.f20071i);
            }
            this.f20072j.l(aVar);
            return u.a;
        }
    }

    public SettingsCache(e<c.l.b.i.d> eVar) throws InterruptedException {
        m.f(eVar, "dataStore");
        this.f20060g = eVar;
        i.b(null, new a(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final <T> Object h(c.l.b.i.d.a<T> aVar, T t, Continuation<? super u> continuation) throws Throwable {
        c cVar;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.f20067h;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.f20067h = i2 - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.f20065f;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = cVar.f20067h;
        try {
            if (i3 == 0) {
                o.b(obj);
                e<c.l.b.i.d> eVar = this.f20060g;
                d dVar = new d(t, aVar, this, null);
                cVar.f20067h = 1;
                if (c.l.b.i.g.a(eVar, dVar, cVar) == objC) {
                    return objC;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
        } catch (IOException e2) {
            Log.w("SettingsCache", "Failed to update cache config value: " + e2);
        }
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(c.l.b.i.d dVar) {
        this.f20061h = new SessionConfigs((Boolean) dVar.b(f20055b), (Double) dVar.b(f20056c), (Integer) dVar.b(f20057d), (Integer) dVar.b(f20058e), (Long) dVar.b(f20059f));
    }

    public final boolean d() {
        SessionConfigs sessionConfigs = this.f20061h;
        SessionConfigs sessionConfigs2 = null;
        if (sessionConfigs == null) {
            m.w("sessionConfigs");
            sessionConfigs = null;
        }
        Long cacheUpdatedTime = sessionConfigs.getCacheUpdatedTime();
        SessionConfigs sessionConfigs3 = this.f20061h;
        if (sessionConfigs3 == null) {
            m.w("sessionConfigs");
        } else {
            sessionConfigs2 = sessionConfigs3;
        }
        Integer cacheDuration = sessionConfigs2.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue());
    }

    public final Integer e() {
        SessionConfigs sessionConfigs = this.f20061h;
        if (sessionConfigs == null) {
            m.w("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionRestartTimeout();
    }

    public final Double f() {
        SessionConfigs sessionConfigs = this.f20061h;
        if (sessionConfigs == null) {
            m.w("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionSamplingRate();
    }

    public final Boolean g() {
        SessionConfigs sessionConfigs = this.f20061h;
        if (sessionConfigs == null) {
            m.w("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionEnabled();
    }

    public final Object i(Double d2, Continuation<? super u> continuation) throws Throwable {
        Object objH = h(f20056c, d2, continuation);
        return objH == kotlin.p003y.intrinsics.d.c() ? objH : u.a;
    }

    public final Object j(Integer num, Continuation<? super u> continuation) throws Throwable {
        Object objH = h(f20058e, num, continuation);
        return objH == kotlin.p003y.intrinsics.d.c() ? objH : u.a;
    }

    public final Object k(Long l, Continuation<? super u> continuation) throws Throwable {
        Object objH = h(f20059f, l, continuation);
        return objH == kotlin.p003y.intrinsics.d.c() ? objH : u.a;
    }

    public final Object m(Integer num, Continuation<? super u> continuation) throws Throwable {
        Object objH = h(f20057d, num, continuation);
        return objH == kotlin.p003y.intrinsics.d.c() ? objH : u.a;
    }

    public final Object n(Boolean bool, Continuation<? super u> continuation) throws Throwable {
        Object objH = h(f20055b, bool, continuation);
        return objH == kotlin.p003y.intrinsics.d.c() ? objH : u.a;
    }
}
