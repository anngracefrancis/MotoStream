package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.a0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/sessions/SessionEvents;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "SESSION_EVENT_ENCODER", "Lcom/google/firebase/encoders/DataEncoder;", "getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions", "()Lcom/google/firebase/encoders/DataEncoder;", "buildSession", "Lcom/google/firebase/sessions/SessionEvent;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "subscribers", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "firebaseInstallationId", HttpUrl.FRAGMENT_ENCODE_SET, "getApplicationInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "toDataCollectionState", "Lcom/google/firebase/sessions/DataCollectionState;", "subscriber", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionEvents {
    public static final SessionEvents a = new SessionEvents();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.firebase.encoders.a f19910b;

    static {
        com.google.firebase.encoders.a aVarF = new com.google.firebase.encoders.json.d().g(k.a).h(true).f();
        kotlin.jvm.internal.m.e(aVarF, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f19910b = aVarF;
    }

    private SessionEvents() {
    }

    private final DataCollectionState d(SessionSubscriber sessionSubscriber) {
        if (sessionSubscriber == null) {
            return DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        }
        return sessionSubscriber.a() ? DataCollectionState.COLLECTION_ENABLED : DataCollectionState.COLLECTION_DISABLED;
    }

    public final SessionEvent a(com.google.firebase.j jVar, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map<SessionSubscriber.a, ? extends SessionSubscriber> map, String str) {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        kotlin.jvm.internal.m.f(sessionDetails, "sessionDetails");
        kotlin.jvm.internal.m.f(sessionsSettings, "sessionsSettings");
        kotlin.jvm.internal.m.f(map, "subscribers");
        kotlin.jvm.internal.m.f(str, "firebaseInstallationId");
        return new SessionEvent(EventType.SESSION_START, new SessionInfo(sessionDetails.getSessionId(), sessionDetails.getFirstSessionId(), sessionDetails.getSessionIndex(), sessionDetails.getSessionStartTimestampUs(), new DataCollectionStatus(d(map.get(SessionSubscriber.a.PERFORMANCE)), d(map.get(SessionSubscriber.a.CRASHLYTICS)), sessionsSettings.b()), str), b(jVar));
    }

    public final ApplicationInfo b(com.google.firebase.j jVar) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        Context contextI = jVar.i();
        kotlin.jvm.internal.m.e(contextI, "firebaseApp.applicationContext");
        String packageName = contextI.getPackageName();
        PackageInfo packageInfo = contextI.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        String strC = jVar.l().c();
        kotlin.jvm.internal.m.e(strC, "firebaseApp.options.applicationId");
        String str = Build.MODEL;
        kotlin.jvm.internal.m.e(str, "MODEL");
        String str2 = Build.VERSION.RELEASE;
        kotlin.jvm.internal.m.e(str2, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        kotlin.jvm.internal.m.e(packageName, "packageName");
        String str3 = packageInfo.versionName;
        String str4 = str3 == null ? strValueOf : str3;
        String str5 = Build.MANUFACTURER;
        kotlin.jvm.internal.m.e(str5, "MANUFACTURER");
        ProcessDetailsProvider processDetailsProvider = ProcessDetailsProvider.a;
        Context contextI2 = jVar.i();
        kotlin.jvm.internal.m.e(contextI2, "firebaseApp.applicationContext");
        ProcessDetails processDetailsD = processDetailsProvider.d(contextI2);
        Context contextI3 = jVar.i();
        kotlin.jvm.internal.m.e(contextI3, "firebaseApp.applicationContext");
        return new ApplicationInfo(strC, str, "1.2.1", str2, logEnvironment, new AndroidApplicationInfo(packageName, str4, strValueOf, str5, processDetailsD, processDetailsProvider.c(contextI3)));
    }

    public final com.google.firebase.encoders.a c() {
        return f19910b;
    }
}
