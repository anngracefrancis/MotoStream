package com.google.firebase.sessions;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.p0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.f0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionLifecycleClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0010J \u0010\u0015\u001a\u0004\u0018\u00010\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0016\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0003J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006#"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient;", HttpUrl.FRAGMENT_ENCODE_SET, "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "queuedMessages", "Ljava/util/concurrent/LinkedBlockingDeque;", "Landroid/os/Message;", "service", "Landroid/os/Messenger;", "serviceBound", HttpUrl.FRAGMENT_ENCODE_SET, "serviceConnection", "com/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1", "Lcom/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1;", "backgrounded", HttpUrl.FRAGMENT_ENCODE_SET, "bindToService", "drainQueue", HttpUrl.FRAGMENT_ENCODE_SET, "foregrounded", "getLatestByCode", "messages", HttpUrl.FRAGMENT_ENCODE_SET, "msgCode", HttpUrl.FRAGMENT_ENCODE_SET, "queueMessage", "msg", "sendLifecycleEvent", "messageCode", "sendLifecycleEvents", "Lkotlinx/coroutines/Job;", "sendMessageToServer", "ClientUpdateHandler", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionLifecycleClient {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f19942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Messenger f19943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedBlockingDeque<Message> f19945e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f19946f;

    /* JADX INFO: renamed from: com.google.firebase.sessions.f0$a */
    /* JADX INFO: compiled from: SessionLifecycleClient.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient$ClientUpdateHandler;", "Landroid/os/Handler;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "handleMessage", HttpUrl.FRAGMENT_ENCODE_SET, "msg", "Landroid/os/Message;", "handleSessionUpdate", "sessionId", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Handler {
        private final CoroutineContext a;

        /* JADX INFO: renamed from: com.google.firebase.sessions.f0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SessionLifecycleClient.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.sessions.SessionLifecycleClient$ClientUpdateHandler$handleSessionUpdate$1", f = "SessionLifecycleClient.kt", l = {74}, m = "invokeSuspend")
        static final class C0235a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f19947f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f19948g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0235a(String str, Continuation<? super C0235a> continuation) {
                super(2, continuation);
                this.f19948g = str;
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                return new C0235a(this.f19948g, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
                return ((C0235a) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objC = kotlin.p003y.intrinsics.d.c();
                int i2 = this.f19947f;
                if (i2 == 0) {
                    kotlin.o.b(obj);
                    FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.a;
                    this.f19947f = 1;
                    obj = firebaseSessionsDependencies.c(this);
                    if (obj == objC) {
                        return objC;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.o.b(obj);
                }
                Collection<SessionSubscriber> collectionValues = ((Map) obj).values();
                String str = this.f19948g;
                for (SessionSubscriber sessionSubscriber : collectionValues) {
                    sessionSubscriber.c(new SessionSubscriber.SessionDetails(str));
                    Log.d("SessionLifecycleClient", "Notified " + sessionSubscriber.b() + " of new session " + str);
                }
                return kotlin.u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineContext coroutineContext) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.m.f(coroutineContext, "backgroundDispatcher");
            this.a = coroutineContext;
        }

        private final void a(String str) {
            Log.d("SessionLifecycleClient", "Session update received: " + str);
            kotlinx.coroutines.j.b(p0.a(this.a), null, null, new C0235a(str, null), 3, null);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            String string;
            kotlin.jvm.internal.m.f(msg, "msg");
            if (msg.what == 3) {
                Bundle data = msg.getData();
                if (data == null || (string = data.getString("SessionUpdateExtra")) == null) {
                    string = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                a(string);
                return;
            }
            Log.w("SessionLifecycleClient", "Received unexpected event from the SessionLifecycleService: " + msg);
            super.handleMessage(msg);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.f0$b */
    /* JADX INFO: compiled from: SessionLifecycleClient.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleClient$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "MAX_QUEUED_MESSAGES", HttpUrl.FRAGMENT_ENCODE_SET, "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.f0$c */
    /* JADX INFO: compiled from: SessionLifecycleClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionLifecycleClient$sendLifecycleEvents$1", f = "SessionLifecycleClient.kt", l = {151}, m = "invokeSuspend")
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f19949f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List<Message> f19951h;

        /* JADX INFO: renamed from: com.google.firebase.sessions.f0$c$a */
        /* JADX INFO: compiled from: Comparisons.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.b.a(Long.valueOf(((Message) t).getWhen()), Long.valueOf(((Message) t2).getWhen()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<Message> list, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f19951h = list;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return SessionLifecycleClient.this.new c(this.f19951h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z;
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f19949f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.a;
                this.f19949f = 1;
                obj = firebaseSessionsDependencies.c(this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            Map map = (Map) obj;
            if (map.isEmpty()) {
                Log.d("SessionLifecycleClient", "Sessions SDK did not have any dependent SDKs register as dependencies. Events will not be sent.");
            } else {
                Collection collectionValues = map.values();
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    Iterator it = collectionValues.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        if (((SessionSubscriber) it.next()).a()) {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = true;
                    break;
                }
                if (z) {
                    Log.d("SessionLifecycleClient", "Data Collection is disabled for all subscribers. Skipping this Event");
                } else {
                    List listX0 = kotlin.collections.c0.x0(kotlin.collections.c0.R(kotlin.collections.u.p(SessionLifecycleClient.this.l(this.f19951h, 2), SessionLifecycleClient.this.l(this.f19951h, 1))), new a());
                    SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
                    Iterator it2 = listX0.iterator();
                    while (it2.hasNext()) {
                        sessionLifecycleClient.p((Message) it2.next());
                    }
                }
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.f0$d */
    /* JADX INFO: compiled from: SessionLifecycleClient.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/google/firebase/sessions/SessionLifecycleClient$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", HttpUrl.FRAGMENT_ENCODE_SET, "className", "Landroid/content/ComponentName;", "serviceBinder", "Landroid/os/IBinder;", "onServiceDisconnected", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements ServiceConnection {
        d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder serviceBinder) {
            Log.d("SessionLifecycleClient", "Connected to SessionLifecycleService. Queue size " + SessionLifecycleClient.this.f19945e.size());
            SessionLifecycleClient.this.f19943c = new Messenger(serviceBinder);
            SessionLifecycleClient.this.f19944d = true;
            SessionLifecycleClient sessionLifecycleClient = SessionLifecycleClient.this;
            sessionLifecycleClient.o(sessionLifecycleClient.j());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
            SessionLifecycleClient.this.f19943c = null;
            SessionLifecycleClient.this.f19944d = false;
        }
    }

    public SessionLifecycleClient(CoroutineContext coroutineContext) {
        kotlin.jvm.internal.m.f(coroutineContext, "backgroundDispatcher");
        this.f19942b = coroutineContext;
        this.f19945e = new LinkedBlockingDeque<>(20);
        this.f19946f = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Message> j() {
        ArrayList arrayList = new ArrayList();
        this.f19945e.drainTo(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Message l(List<Message> list, int i2) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((Message) obj2).what == i2) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long when = ((Message) next).getWhen();
                do {
                    Object next2 = it.next();
                    long when2 = ((Message) next2).getWhen();
                    if (when < when2) {
                        next = next2;
                        when = when2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Message) obj;
    }

    private final void m(Message message) {
        if (!this.f19945e.offer(message)) {
            Log.d("SessionLifecycleClient", "Failed to enqueue message " + message.what + ". Dropping.");
            return;
        }
        Log.d("SessionLifecycleClient", "Queued message " + message.what + ". Queue size " + this.f19945e.size());
    }

    private final void n(int i2) {
        List<Message> listJ = j();
        Message messageObtain = Message.obtain(null, i2, 0, 0);
        kotlin.jvm.internal.m.e(messageObtain, "obtain(null, messageCode, 0, 0)");
        listJ.add(messageObtain);
        o(listJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job o(List<Message> list) {
        return kotlinx.coroutines.j.b(p0.a(this.f19942b), null, null, new c(list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Message message) {
        if (this.f19943c == null) {
            m(message);
            return;
        }
        try {
            Log.d("SessionLifecycleClient", "Sending lifecycle " + message.what + " to service");
            Messenger messenger = this.f19943c;
            if (messenger != null) {
                messenger.send(message);
            }
        } catch (RemoteException e2) {
            Log.w("SessionLifecycleClient", "Unable to deliver message: " + message.what, e2);
            m(message);
        }
    }

    public final void h() {
        n(2);
    }

    public final void i() {
        SessionLifecycleServiceBinder.a.a().a(new Messenger(new a(this.f19942b)), this.f19946f);
    }

    public final void k() {
        n(1);
    }
}
