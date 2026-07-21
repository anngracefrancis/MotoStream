package com.google.firebase.sessions;

import android.util.Log;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import kotlin.Metadata;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.n, reason: from Kotlin metadata */
/* JADX INFO: compiled from: EventGDTLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLogger;", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "transportFactoryProvider", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "(Lcom/google/firebase/inject/Provider;)V", "encode", HttpUrl.FRAGMENT_ENCODE_SET, "value", "Lcom/google/firebase/sessions/SessionEvent;", "log", HttpUrl.FRAGMENT_ENCODE_SET, "sessionEvent", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventGDTLogger implements EventGDTLoggerInterface {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.firebase.s.b<e.e.b.a.g> f20073b;

    /* JADX INFO: renamed from: com.google.firebase.sessions.n$a */
    /* JADX INFO: compiled from: EventGDTLogger.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLogger$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "AQS_LOG_SOURCE", HttpUrl.FRAGMENT_ENCODE_SET, "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public EventGDTLogger(com.google.firebase.s.b<e.e.b.a.g> bVar) {
        kotlin.jvm.internal.m.f(bVar, "transportFactoryProvider");
        this.f20073b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] b(SessionEvent sessionEvent) {
        String strB = SessionEvents.a.c().b(sessionEvent);
        kotlin.jvm.internal.m.e(strB, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d("EventGDTLogger", "Session Event: " + strB);
        byte[] bytes = strB.getBytes(Charsets.f25054b);
        kotlin.jvm.internal.m.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public void a(SessionEvent sessionEvent) {
        kotlin.jvm.internal.m.f(sessionEvent, "sessionEvent");
        this.f20073b.get().a("FIREBASE_APPQUALITY_SESSION", SessionEvent.class, e.e.b.a.b.b(BodyInterceptorV3.RESPONSE_MODE_JSON), new e.e.b.a.e() { // from class: com.google.firebase.sessions.a
            @Override // e.e.b.a.e
            public final Object a(Object obj) {
                return this.a.b((SessionEvent) obj);
            }
        }).a(e.e.b.a.c.d(sessionEvent));
    }
}
