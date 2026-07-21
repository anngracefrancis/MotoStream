package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.p0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.q, reason: from Kotlin metadata */
/* JADX INFO: compiled from: FirebaseSessions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", HttpUrl.FRAGMENT_ENCODE_SET, "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "settings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/sessions/settings/SessionsSettings;Lkotlin/coroutines/CoroutineContext;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FirebaseSessions {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.firebase.j f20078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SessionsSettings f20079c;

    /* JADX INFO: renamed from: com.google.firebase.sessions.q$a */
    /* JADX INFO: compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {44, 48}, m = "invokeSuspend")
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20080f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ CoroutineContext f20082h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CoroutineContext coroutineContext, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f20082h = coroutineContext;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return FirebaseSessions.this.new a(this.f20082h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0079  */
        /* JADX WARN: Code duplicated, block: B:32:0x007f  */
        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f20080f;
            boolean z = true;
            if (i2 != 0) {
                if (i2 == 1) {
                    kotlin.o.b(obj);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.o.b(obj);
                }
                if (FirebaseSessions.this.f20079c.d()) {
                    SessionLifecycleClient sessionLifecycleClient = new SessionLifecycleClient(this.f20082h);
                    sessionLifecycleClient.i();
                    SessionsActivityLifecycleCallbacks.f19960f.a(sessionLifecycleClient);
                    FirebaseSessions.this.f20078b.f(new com.google.firebase.k() { // from class: com.google.firebase.sessions.b
                    });
                } else {
                    Log.d("FirebaseSessions", "Sessions SDK disabled. Not listening to lifecycle events.");
                }
                return kotlin.u.a;
            }
            kotlin.o.b(obj);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.a;
            this.f20080f = 1;
            obj = firebaseSessionsDependencies.c(this);
            if (obj == objC) {
                return objC;
            }
            Collection collectionValues = ((Map) obj).values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (((SessionSubscriber) it.next()).a()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                Log.d("FirebaseSessions", "No Sessions subscribers. Not listening to lifecycle events.");
            } else {
                SessionsSettings sessionsSettings = FirebaseSessions.this.f20079c;
                this.f20080f = 2;
                if (sessionsSettings.g(this) == objC) {
                    return objC;
                }
                if (FirebaseSessions.this.f20079c.d()) {
                    Log.d("FirebaseSessions", "Sessions SDK disabled. Not listening to lifecycle events.");
                } else {
                    SessionLifecycleClient sessionLifecycleClient2 = new SessionLifecycleClient(this.f20082h);
                    sessionLifecycleClient2.i();
                    SessionsActivityLifecycleCallbacks.f19960f.a(sessionLifecycleClient2);
                    FirebaseSessions.this.f20078b.f(new com.google.firebase.k() { // from class: com.google.firebase.sessions.b
                    });
                }
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.q$b */
    /* JADX INFO: compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public FirebaseSessions(com.google.firebase.j jVar, SessionsSettings sessionsSettings, CoroutineContext coroutineContext) {
        kotlin.jvm.internal.m.f(jVar, "firebaseApp");
        kotlin.jvm.internal.m.f(sessionsSettings, "settings");
        kotlin.jvm.internal.m.f(coroutineContext, "backgroundDispatcher");
        this.f20078b = jVar;
        this.f20079c = sessionsSettings;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        Context applicationContext = jVar.i().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.f19960f);
            kotlinx.coroutines.j.b(p0.a(coroutineContext), null, null, new a(coroutineContext, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }
}
