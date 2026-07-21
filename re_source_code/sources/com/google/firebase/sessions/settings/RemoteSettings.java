package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.datastore.core.e;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.i;
import com.google.firebase.sessions.ApplicationInfo;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.s;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.u;
import kotlinx.coroutines.sync.Mutex;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.google.firebase.sessions.m0.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RemoteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0015H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\u0011\u0010%\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", HttpUrl.FRAGMENT_ENCODE_SET, "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", HttpUrl.FRAGMENT_ENCODE_SET, "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "clearCachedSettings", HttpUrl.FRAGMENT_ENCODE_SET, "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", HttpUrl.FRAGMENT_ENCODE_SET, "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RemoteSettings implements SettingsProvider {
    private static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f20017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f20018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ApplicationInfo f20019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CrashlyticsSettingsFetcher f20020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SettingsCache f20021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Mutex f20022g;

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.c$a */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "FORWARD_SLASH_STRING", HttpUrl.FRAGMENT_ENCODE_SET, "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.c$b */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {170, 76, 94}, m = "updateSettings")
    static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f20023f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f20024g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f20025h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f20027j;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f20025h = obj;
            this.f20027j |= Integer.MIN_VALUE;
            return RemoteSettings.this.d(this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.c$c */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {125, 128, 131, 133, 134, 136}, m = "invokeSuspend")
    static final class c extends SuspendLambda implements Function2<JSONObject, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f20028f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f20029g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f20030h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f20031i;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            c cVar = RemoteSettings.this.new c(continuation);
            cVar.f20031i = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(JSONObject jSONObject, Continuation<? super u> continuation) {
            return ((c) create(jSONObject, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x00fc  */
        /* JADX WARN: Code duplicated, block: B:47:0x0118 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:50:0x011f  */
        /* JADX WARN: Code duplicated, block: B:52:0x013b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:55:0x0142  */
        /* JADX WARN: Code duplicated, block: B:57:0x015e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:59:0x0162  */
        /* JADX WARN: Code duplicated, block: B:61:0x0165  */
        /* JADX WARN: Code duplicated, block: B:63:0x0181 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:66:0x019f A[RETURN] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v12, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Double] */
        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            f0 f0Var;
            Boolean bool;
            f0 f0Var2;
            f0 f0Var3;
            f0 f0Var4;
            f0 f0Var5;
            Integer num;
            SettingsCache settingsCache;
            Integer num2;
            Double d2;
            SettingsCache settingsCache2;
            Double d3;
            Integer num3;
            u uVar;
            SettingsCache settingsCache3;
            Integer num4;
            SettingsCache settingsCache4;
            Integer numB;
            SettingsCache settingsCache5;
            Long lC;
            Object objC = kotlin.p003y.intrinsics.d.c();
            switch (this.f20030h) {
                case 0:
                    o.b(obj);
                    JSONObject jSONObject = (JSONObject) this.f20031i;
                    Log.d("SessionConfigFetcher", "Fetched settings: " + jSONObject);
                    f0 f0Var6 = new f0();
                    f0Var = new f0();
                    f0 f0Var7 = new f0();
                    if (jSONObject.has("app_quality")) {
                        Object obj2 = jSONObject.get("app_quality");
                        m.d(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                        JSONObject jSONObject2 = (JSONObject) obj2;
                        try {
                            bool = jSONObject2.has("sessions_enabled") ? (Boolean) jSONObject2.get("sessions_enabled") : null;
                            try {
                                if (jSONObject2.has("sampling_rate")) {
                                    f0Var6.f22943f = (Double) jSONObject2.get("sampling_rate");
                                }
                                if (jSONObject2.has("session_timeout_seconds")) {
                                    f0Var.f22943f = (Integer) jSONObject2.get("session_timeout_seconds");
                                }
                                if (jSONObject2.has("cache_duration")) {
                                    f0Var7.f22943f = (Integer) jSONObject2.get("cache_duration");
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                Log.e("SessionConfigFetcher", "Error parsing the configs remotely fetched: ", e);
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            bool = null;
                        }
                        break;
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        RemoteSettings remoteSettings = RemoteSettings.this;
                        bool.booleanValue();
                        SettingsCache settingsCache6 = remoteSettings.f20021f;
                        this.f20031i = f0Var6;
                        this.f20028f = f0Var;
                        this.f20029g = f0Var7;
                        this.f20030h = 1;
                        if (settingsCache6.n(bool, this) == objC) {
                            return objC;
                        }
                        f0Var4 = f0Var6;
                        f0Var5 = f0Var;
                        f0Var3 = f0Var7;
                        f0Var = f0Var5;
                        f0Var2 = f0Var4;
                    } else {
                        f0Var2 = f0Var6;
                        f0Var3 = f0Var7;
                    }
                    num = (Integer) f0Var.f22943f;
                    if (num != null) {
                        RemoteSettings remoteSettings2 = RemoteSettings.this;
                        num.intValue();
                        settingsCache = remoteSettings2.f20021f;
                        num2 = (Integer) f0Var.f22943f;
                        this.f20031i = f0Var2;
                        this.f20028f = f0Var3;
                        this.f20029g = null;
                        this.f20030h = 2;
                        if (settingsCache.m(num2, this) == objC) {
                            return objC;
                        }
                    }
                    d2 = (Double) f0Var2.f22943f;
                    if (d2 != null) {
                        RemoteSettings remoteSettings3 = RemoteSettings.this;
                        d2.doubleValue();
                        settingsCache2 = remoteSettings3.f20021f;
                        d3 = (Double) f0Var2.f22943f;
                        this.f20031i = f0Var3;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 3;
                        if (settingsCache2.i(d3, this) == objC) {
                            return objC;
                        }
                    }
                    num3 = (Integer) f0Var3.f22943f;
                    if (num3 != null) {
                        RemoteSettings remoteSettings4 = RemoteSettings.this;
                        num3.intValue();
                        settingsCache3 = remoteSettings4.f20021f;
                        num4 = (Integer) f0Var3.f22943f;
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 4;
                        if (settingsCache3.j(num4, this) == objC) {
                            return objC;
                        }
                        uVar = u.a;
                    } else {
                        uVar = null;
                    }
                    if (uVar == null) {
                        settingsCache4 = RemoteSettings.this.f20021f;
                        numB = kotlin.p003y.j.p004a.b.b(86400);
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 5;
                        if (settingsCache4.j(numB, this) == objC) {
                            return objC;
                        }
                    }
                    settingsCache5 = RemoteSettings.this.f20021f;
                    lC = kotlin.p003y.j.p004a.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache5.k(lC, this) == objC) {
                        return objC;
                    }
                    return u.a;
                case 1:
                    f0Var3 = (f0) this.f20029g;
                    f0Var5 = (f0) this.f20028f;
                    f0Var4 = (f0) this.f20031i;
                    o.b(obj);
                    f0Var = f0Var5;
                    f0Var2 = f0Var4;
                    num = (Integer) f0Var.f22943f;
                    if (num != null) {
                        RemoteSettings remoteSettings5 = RemoteSettings.this;
                        num.intValue();
                        settingsCache = remoteSettings5.f20021f;
                        num2 = (Integer) f0Var.f22943f;
                        this.f20031i = f0Var2;
                        this.f20028f = f0Var3;
                        this.f20029g = null;
                        this.f20030h = 2;
                        if (settingsCache.m(num2, this) == objC) {
                            return objC;
                        }
                    }
                    d2 = (Double) f0Var2.f22943f;
                    if (d2 != null) {
                        RemoteSettings remoteSettings6 = RemoteSettings.this;
                        d2.doubleValue();
                        settingsCache2 = remoteSettings6.f20021f;
                        d3 = (Double) f0Var2.f22943f;
                        this.f20031i = f0Var3;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 3;
                        if (settingsCache2.i(d3, this) == objC) {
                            return objC;
                        }
                    }
                    num3 = (Integer) f0Var3.f22943f;
                    if (num3 != null) {
                        RemoteSettings remoteSettings7 = RemoteSettings.this;
                        num3.intValue();
                        settingsCache3 = remoteSettings7.f20021f;
                        num4 = (Integer) f0Var3.f22943f;
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 4;
                        if (settingsCache3.j(num4, this) == objC) {
                            return objC;
                        }
                        uVar = u.a;
                    } else {
                        uVar = null;
                    }
                    if (uVar == null) {
                        settingsCache4 = RemoteSettings.this.f20021f;
                        numB = kotlin.p003y.j.p004a.b.b(86400);
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 5;
                        if (settingsCache4.j(numB, this) == objC) {
                            return objC;
                        }
                    }
                    settingsCache5 = RemoteSettings.this.f20021f;
                    lC = kotlin.p003y.j.p004a.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache5.k(lC, this) == objC) {
                        return objC;
                    }
                    return u.a;
                case 2:
                    f0Var3 = (f0) this.f20028f;
                    f0Var2 = (f0) this.f20031i;
                    o.b(obj);
                    d2 = (Double) f0Var2.f22943f;
                    if (d2 != null) {
                        RemoteSettings remoteSettings8 = RemoteSettings.this;
                        d2.doubleValue();
                        settingsCache2 = remoteSettings8.f20021f;
                        d3 = (Double) f0Var2.f22943f;
                        this.f20031i = f0Var3;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 3;
                        if (settingsCache2.i(d3, this) == objC) {
                            return objC;
                        }
                    }
                    num3 = (Integer) f0Var3.f22943f;
                    if (num3 != null) {
                        RemoteSettings remoteSettings9 = RemoteSettings.this;
                        num3.intValue();
                        settingsCache3 = remoteSettings9.f20021f;
                        num4 = (Integer) f0Var3.f22943f;
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 4;
                        if (settingsCache3.j(num4, this) == objC) {
                            return objC;
                        }
                        uVar = u.a;
                    } else {
                        uVar = null;
                    }
                    if (uVar == null) {
                        settingsCache4 = RemoteSettings.this.f20021f;
                        numB = kotlin.p003y.j.p004a.b.b(86400);
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 5;
                        if (settingsCache4.j(numB, this) == objC) {
                            return objC;
                        }
                    }
                    settingsCache5 = RemoteSettings.this.f20021f;
                    lC = kotlin.p003y.j.p004a.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache5.k(lC, this) == objC) {
                        return objC;
                    }
                    return u.a;
                case 3:
                    f0Var3 = (f0) this.f20031i;
                    o.b(obj);
                    num3 = (Integer) f0Var3.f22943f;
                    if (num3 != null) {
                        RemoteSettings remoteSettings10 = RemoteSettings.this;
                        num3.intValue();
                        settingsCache3 = remoteSettings10.f20021f;
                        num4 = (Integer) f0Var3.f22943f;
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 4;
                        if (settingsCache3.j(num4, this) == objC) {
                            return objC;
                        }
                        uVar = u.a;
                    } else {
                        uVar = null;
                    }
                    if (uVar == null) {
                        settingsCache4 = RemoteSettings.this.f20021f;
                        numB = kotlin.p003y.j.p004a.b.b(86400);
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 5;
                        if (settingsCache4.j(numB, this) == objC) {
                            return objC;
                        }
                    }
                    settingsCache5 = RemoteSettings.this.f20021f;
                    lC = kotlin.p003y.j.p004a.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache5.k(lC, this) == objC) {
                        return objC;
                    }
                    return u.a;
                case 4:
                    o.b(obj);
                    uVar = u.a;
                    if (uVar == null) {
                        settingsCache4 = RemoteSettings.this.f20021f;
                        numB = kotlin.p003y.j.p004a.b.b(86400);
                        this.f20031i = null;
                        this.f20028f = null;
                        this.f20029g = null;
                        this.f20030h = 5;
                        if (settingsCache4.j(numB, this) == objC) {
                            return objC;
                        }
                    }
                    settingsCache5 = RemoteSettings.this.f20021f;
                    lC = kotlin.p003y.j.p004a.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache5.k(lC, this) == objC) {
                        return objC;
                    }
                    return u.a;
                case 5:
                    o.b(obj);
                    settingsCache5 = RemoteSettings.this.f20021f;
                    lC = kotlin.p003y.j.p004a.b.c(System.currentTimeMillis());
                    this.f20031i = null;
                    this.f20028f = null;
                    this.f20029g = null;
                    this.f20030h = 6;
                    if (settingsCache5.k(lC, this) == objC) {
                        return objC;
                    }
                    return u.a;
                case 6:
                    o.b(obj);
                    return u.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.m0.c$d */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "msg", HttpUrl.FRAGMENT_ENCODE_SET}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
    static final class d extends SuspendLambda implements Function2<String, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f20034g;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(continuation);
            dVar.f20034g = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, Continuation<? super u> continuation) {
            return ((d) create(str, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.p003y.intrinsics.d.c();
            if (this.f20033f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
            Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.f20034g));
            return u.a;
        }
    }

    public RemoteSettings(CoroutineContext coroutineContext, i iVar, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, e<c.l.b.i.d> eVar) {
        m.f(coroutineContext, "backgroundDispatcher");
        m.f(iVar, "firebaseInstallationsApi");
        m.f(applicationInfo, "appInfo");
        m.f(crashlyticsSettingsFetcher, "configsFetcher");
        m.f(eVar, "dataStore");
        this.f20017b = coroutineContext;
        this.f20018c = iVar;
        this.f20019d = applicationInfo;
        this.f20020e = crashlyticsSettingsFetcher;
        this.f20021f = new SettingsCache(eVar);
        this.f20022g = kotlinx.coroutines.sync.d.b(false, 1, null);
    }

    private final String f(String str) {
        return new Regex("/").c(str, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean a() {
        return this.f20021f.g();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Duration b() {
        Integer numE = this.f20021f.e();
        if (numE == null) {
            return null;
        }
        Duration.a aVar = Duration.f25090f;
        return Duration.k(kotlin.time.c.h(numE.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double c() {
        return this.f20021f.f();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b8 A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #0 {all -> 0x0052, blocks: (B:21:0x004e, B:44:0x00b4, B:46:0x00b8, B:50:0x00c4, B:36:0x0089, B:38:0x0091, B:41:0x009c), top: B:59:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:52:0x014c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x014d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [kotlinx.coroutines.d3.b] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.d3.b] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlinx.coroutines.d3.b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Object d(Continuation<? super u> continuation) throws Throwable {
        b bVar;
        ?? r2;
        Mutex mutex;
        RemoteSettings remoteSettings;
        String str;
        Map<String, String> mapL;
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher;
        c cVar;
        d dVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.f20027j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.f20027j = i2 - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objA = bVar.f20025h;
        Object objC = kotlin.p003y.intrinsics.d.c();
        ?? r4 = bVar.f20027j;
        try {
            if (r4 == 0) {
                o.b(objA);
                if (!this.f20022g.a() && !this.f20021f.d()) {
                    return u.a;
                }
                Mutex mutex2 = this.f20022g;
                bVar.f20023f = this;
                bVar.f20024g = mutex2;
                bVar.f20027j = 1;
                if (mutex2.b(null, bVar) == objC) {
                    return objC;
                }
                mutex = mutex2;
                remoteSettings = this;
            } else {
                if (r4 != 1) {
                    if (r4 != 2) {
                        if (r4 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r2 = (Mutex) bVar.f20023f;
                        try {
                            o.b(objA);
                            r2 = r2;
                            u uVar = u.a;
                            r2.c(null);
                            return uVar;
                        } catch (Throwable th) {
                            th = th;
                            r2.c(null);
                            throw th;
                        }
                    }
                    mutex = (Mutex) bVar.f20024g;
                    remoteSettings = (RemoteSettings) bVar.f20023f;
                    o.b(objA);
                    str = (String) objA;
                    if (str == null) {
                        Log.w("SessionConfigFetcher", "Error getting Firebase Installation ID. Skipping this Session Event.");
                        u uVar2 = u.a;
                        mutex.c(null);
                        return uVar2;
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                    String str2 = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                    m.e(str2, "format(format, *args)");
                    String str3 = Build.VERSION.INCREMENTAL;
                    m.e(str3, "INCREMENTAL");
                    String str4 = Build.VERSION.RELEASE;
                    m.e(str4, "RELEASE");
                    mapL = q0.l(s.a("X-Crashlytics-Installation-ID", str), s.a("X-Crashlytics-Device-Model", remoteSettings.f(str2)), s.a("X-Crashlytics-OS-Build-Version", remoteSettings.f(str3)), s.a("X-Crashlytics-OS-Display-Version", remoteSettings.f(str4)), s.a("X-Crashlytics-API-Client-Version", remoteSettings.f20019d.getSessionSdkVersion()));
                    Log.d("SessionConfigFetcher", "Fetching settings from server.");
                    crashlyticsSettingsFetcher = remoteSettings.f20020e;
                    cVar = remoteSettings.new c(null);
                    dVar = new d(null);
                    bVar.f20023f = mutex;
                    bVar.f20024g = null;
                    bVar.f20027j = 3;
                    if (crashlyticsSettingsFetcher.a(mapL, cVar, dVar, bVar) == objC) {
                        return objC;
                    }
                    r2 = mutex;
                    u uVar3 = u.a;
                    r2.c(null);
                    return uVar3;
                }
                mutex = (Mutex) bVar.f20024g;
                remoteSettings = (RemoteSettings) bVar.f20023f;
                o.b(objA);
            }
            if (!remoteSettings.f20021f.d()) {
                Log.d("SessionConfigFetcher", "Remote settings cache not expired. Using cached values.");
                u uVar4 = u.a;
                mutex.c(null);
                return uVar4;
            }
            Task<String> id = remoteSettings.f20018c.getId();
            m.e(id, "firebaseInstallationsApi.id");
            bVar.f20023f = remoteSettings;
            bVar.f20024g = mutex;
            bVar.f20027j = 2;
            objA = kotlinx.coroutines.tasks.b.a(id, bVar);
            if (objA == objC) {
                return objC;
            }
            str = (String) objA;
            if (str == null) {
                Log.w("SessionConfigFetcher", "Error getting Firebase Installation ID. Skipping this Session Event.");
                u uVar5 = u.a;
                mutex.c(null);
                return uVar5;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String str5 = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
            m.e(str5, "format(format, *args)");
            String str6 = Build.VERSION.INCREMENTAL;
            m.e(str6, "INCREMENTAL");
            String str7 = Build.VERSION.RELEASE;
            m.e(str7, "RELEASE");
            mapL = q0.l(s.a("X-Crashlytics-Installation-ID", str), s.a("X-Crashlytics-Device-Model", remoteSettings.f(str5)), s.a("X-Crashlytics-OS-Build-Version", remoteSettings.f(str6)), s.a("X-Crashlytics-OS-Display-Version", remoteSettings.f(str7)), s.a("X-Crashlytics-API-Client-Version", remoteSettings.f20019d.getSessionSdkVersion()));
            Log.d("SessionConfigFetcher", "Fetching settings from server.");
            crashlyticsSettingsFetcher = remoteSettings.f20020e;
            cVar = remoteSettings.new c(null);
            dVar = new d(null);
            bVar.f20023f = mutex;
            bVar.f20024g = null;
            bVar.f20027j = 3;
            if (crashlyticsSettingsFetcher.a(mapL, cVar, dVar, bVar) == objC) {
                return objC;
            }
            r2 = mutex;
            u uVar6 = u.a;
            r2.c(null);
            return uVar6;
        } catch (Throwable th2) {
            th = th2;
            r2 = r4;
        }
    }
}
