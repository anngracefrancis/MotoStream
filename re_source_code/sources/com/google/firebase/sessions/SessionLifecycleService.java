package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.time.Duration;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SessionLifecycleService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService;", "Landroid/app/Service;", "()V", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread$com_google_firebase_firebase_sessions", "()Landroid/os/HandlerThread;", "messageHandler", "Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "messenger", "Landroid/os/Messenger;", "getClientCallback", "intent", "Landroid/content/Intent;", "onBind", "Landroid/os/IBinder;", "onCreate", HttpUrl.FRAGMENT_ENCODE_SET, "onDestroy", "Companion", "MessageHandler", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionLifecycleService extends Service {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f19904f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HandlerThread f19905g = new HandlerThread("FirebaseSessions_HandlerThread");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f19906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Messenger f19907i;

    /* JADX INFO: compiled from: SessionLifecycleService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "BACKGROUNDED", HttpUrl.FRAGMENT_ENCODE_SET, "CLIENT_BOUND", "CLIENT_CALLBACK_MESSENGER", HttpUrl.FRAGMENT_ENCODE_SET, "FOREGROUNDED", "SESSION_UPDATED", "SESSION_UPDATE_EXTRA", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SessionLifecycleService.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "boundClients", "Ljava/util/ArrayList;", "Landroid/os/Messenger;", "Lkotlin/collections/ArrayList;", "hasForegrounded", HttpUrl.FRAGMENT_ENCODE_SET, "lastMsgTimeMs", HttpUrl.FRAGMENT_ENCODE_SET, "broadcastSession", HttpUrl.FRAGMENT_ENCODE_SET, "handleBackgrounding", "msg", "Landroid/os/Message;", "handleClientBound", "handleForegrounding", "handleMessage", "isSessionRestart", "foregroundTimeMs", "maybeSendSessionToClient", "client", "newSession", "sendSessionToClient", "sessionId", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Handler {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f19908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList<Messenger> f19909c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            kotlin.jvm.internal.m.f(looper, "looper");
            this.f19909c = new ArrayList<>();
        }

        private final void a() {
            StringBuilder sb = new StringBuilder();
            sb.append("Broadcasting new session: ");
            SessionGenerator.b bVar = SessionGenerator.a;
            sb.append(bVar.a().c());
            Log.d("SessionLifecycleService", sb.toString());
            SessionFirelogPublisher.a.a().a(bVar.a().c());
            for (Messenger messenger : new ArrayList(this.f19909c)) {
                kotlin.jvm.internal.m.e(messenger, "it");
                f(messenger);
            }
        }

        private final void b(Message message) {
            Log.d("SessionLifecycleService", "Activity backgrounding at " + message.getWhen());
            this.f19908b = message.getWhen();
        }

        private final void c(Message message) {
            this.f19909c.add(message.replyTo);
            Messenger messenger = message.replyTo;
            kotlin.jvm.internal.m.e(messenger, "msg.replyTo");
            f(messenger);
            Log.d("SessionLifecycleService", "Client " + message.replyTo + " bound at " + message.getWhen() + ". Clients: " + this.f19909c.size());
        }

        private final void d(Message message) {
            Log.d("SessionLifecycleService", "Activity foregrounding at " + message.getWhen() + '.');
            if (!this.a) {
                Log.d("SessionLifecycleService", "Cold start detected.");
                this.a = true;
                g();
            } else if (e(message.getWhen())) {
                Log.d("SessionLifecycleService", "Session too long in background. Creating new session.");
                g();
            }
            this.f19908b = message.getWhen();
        }

        private final boolean e(long j2) {
            return j2 - this.f19908b > Duration.F(SessionsSettings.a.c().c());
        }

        private final void f(Messenger messenger) {
            if (this.a) {
                h(messenger, SessionGenerator.a.a().c().getSessionId());
                return;
            }
            String strA = SessionDatastore.a.a().a();
            Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session: " + strA);
            if (strA != null) {
                h(messenger, strA);
            }
        }

        private final void g() {
            SessionGenerator.b bVar = SessionGenerator.a;
            bVar.a().a();
            Log.d("SessionLifecycleService", "Generated new session " + bVar.a().c().getSessionId());
            a();
            SessionDatastore.a.a().b(bVar.a().c().getSessionId());
        }

        private final void h(Messenger messenger, String str) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("SessionUpdateExtra", str);
                Message messageObtain = Message.obtain(null, 3, 0, 0);
                messageObtain.setData(bundle);
                messenger.send(messageObtain);
            } catch (DeadObjectException unused) {
                Log.d("SessionLifecycleService", "Removing dead client from list: " + messenger);
                this.f19909c.remove(messenger);
            } catch (Exception e2) {
                Log.w("SessionLifecycleService", "Unable to push new session to " + messenger + '.', e2);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            if (this.f19908b > msg.getWhen()) {
                Log.d("SessionLifecycleService", "Ignoring old message from " + msg.getWhen() + " which is older than " + this.f19908b + '.');
                return;
            }
            int i2 = msg.what;
            if (i2 == 1) {
                d(msg);
                return;
            }
            if (i2 == 2) {
                b(msg);
                return;
            }
            if (i2 == 4) {
                c(msg);
                return;
            }
            Log.w("SessionLifecycleService", "Received unexpected event from the SessionLifecycleClient: " + msg);
            super.handleMessage(msg);
        }
    }

    private final Messenger a(Intent intent) {
        return Build.VERSION.SDK_INT >= 33 ? (Messenger) intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class) : (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger messengerA = a(intent);
        if (messengerA != null) {
            Message messageObtain = Message.obtain(null, 4, 0, 0);
            messageObtain.replyTo = messengerA;
            b bVar = this.f19906h;
            if (bVar != null) {
                bVar.sendMessage(messageObtain);
            }
        }
        Messenger messenger = this.f19907i;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f19905g.start();
        Looper looper = this.f19905g.getLooper();
        kotlin.jvm.internal.m.e(looper, "handlerThread.looper");
        this.f19906h = new b(looper);
        this.f19907i = new Messenger(this.f19906h);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f19905g.quit();
    }
}
