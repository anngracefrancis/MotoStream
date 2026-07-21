package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public class Rpc {
    private static int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PendingIntent f11571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Executor f11572c = v.f11607f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f11574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzr f11575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ScheduledExecutorService f11576g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Messenger f11578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zza f11579j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.e.g<String, TaskCompletionSource<Bundle>> f11573d = new c.e.g<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Messenger f11577h = new Messenger(new u(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.f11574e = context;
        this.f11575f = new zzr(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f11576g = scheduledThreadPoolExecutor;
    }

    static final /* synthetic */ Bundle b(Task task) throws Exception {
        if (task.n()) {
            return (Bundle) task.j();
        }
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(task.i());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Error making request: ");
            sb.append(strValueOf);
            Log.d("Rpc", sb.toString());
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.i());
    }

    static final /* synthetic */ Task c(Bundle bundle) throws Exception {
        return l(bundle) ? Tasks.e(null) : Tasks.e(bundle);
    }

    private static synchronized String e() {
        int i2;
        i2 = a;
        a = i2 + 1;
        return Integer.toString(i2);
    }

    private static synchronized void f(Context context, Intent intent) {
        if (f11571b == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            f11571b = PendingIntent.getBroadcast(context, 0, intent2, 0);
        }
        intent.putExtra("app", f11571b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zza.C0173zza());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zza) {
                        this.f11579j = (zza) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f11578i = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("Rpc", 3)) {
                        String strValueOf = String.valueOf(action);
                        Log.d("Rpc", strValueOf.length() != 0 ? "Unexpected response action: ".concat(strValueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", stringExtra.length() != 0 ? "Unexpected response string: ".concat(stringExtra) : new String("Unexpected response string: "));
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        j(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String strValueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(strValueOf2);
                    Log.w("Rpc", sb.toString());
                    return;
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", stringExtra2.length() != 0 ? "Received InstanceID error ".concat(stringExtra2) : new String("Received InstanceID error "));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (this.f11573d) {
                        for (int i2 = 0; i2 < this.f11573d.size(); i2++) {
                            j(this.f11573d.j(i2), intent2.getExtras());
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !"ID".equals(strArrSplit[1])) {
                    Log.w("Rpc", stringExtra2.length() != 0 ? "Unexpected structured response ".concat(stringExtra2) : new String("Unexpected structured response "));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                j(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    static final /* synthetic */ void i(TaskCompletionSource taskCompletionSource) {
        if (taskCompletionSource.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }

    private final void j(String str, Bundle bundle) {
        synchronized (this.f11573d) {
            TaskCompletionSource<Bundle> taskCompletionSourceRemove = this.f11573d.remove(str);
            if (taskCompletionSourceRemove != null) {
                taskCompletionSourceRemove.c(bundle);
            } else {
                String strValueOf = String.valueOf(str);
                Log.w("Rpc", strValueOf.length() != 0 ? "Missing callback for ".concat(strValueOf) : new String("Missing callback for "));
            }
        }
    }

    private static boolean l(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00cb  */
    private final Task<Bundle> m(Bundle bundle) {
        final String strE = e();
        final TaskCompletionSource<Bundle> taskCompletionSource = new TaskCompletionSource<>();
        synchronized (this.f11573d) {
            this.f11573d.put(strE, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f11575f.a() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        f(this.f11574e, intent);
        StringBuilder sb = new StringBuilder(String.valueOf(strE).length() + 5);
        sb.append("|ID|");
        sb.append(strE);
        sb.append("|");
        intent.putExtra("kid", sb.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String strValueOf = String.valueOf(intent.getExtras());
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 8);
            sb2.append("Sending ");
            sb2.append(strValueOf);
            Log.d("Rpc", sb2.toString());
        }
        intent.putExtra("google.messenger", this.f11577h);
        if (this.f11578i != null || this.f11579j != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f11578i;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    this.f11579j.b(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
                if (this.f11575f.a() == 2) {
                    this.f11574e.sendBroadcast(intent);
                } else {
                    this.f11574e.startService(intent);
                }
            }
        } else if (this.f11575f.a() == 2) {
            this.f11574e.sendBroadcast(intent);
        } else {
            this.f11574e.startService(intent);
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.f11576g.schedule(new Runnable(taskCompletionSource) { // from class: com.google.android.gms.cloudmessaging.p

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final TaskCompletionSource f11603f;

            {
                this.f11603f = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Rpc.i(this.f11603f);
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.a().c(f11572c, new OnCompleteListener(this, strE, scheduledFutureSchedule) { // from class: com.google.android.gms.cloudmessaging.t
            private final Rpc a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f11605b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final ScheduledFuture f11606c;

            {
                this.a = this;
                this.f11605b = strE;
                this.f11606c = scheduledFutureSchedule;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void a(Task task) {
                this.a.k(this.f11605b, this.f11606c, task);
            }
        });
        return taskCompletionSource.a();
    }

    public Task<Bundle> a(final Bundle bundle) {
        if (this.f11575f.c() >= 12000000) {
            return zze.c(this.f11574e).f(1, bundle).g(f11572c, o.a);
        }
        return !(this.f11575f.a() != 0) ? Tasks.d(new IOException("MISSING_INSTANCEID_SERVICE")) : m(bundle).h(f11572c, new Continuation(this, bundle) { // from class: com.google.android.gms.cloudmessaging.q
            private final Rpc a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Bundle f11604b;

            {
                this.a = this;
                this.f11604b = bundle;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task) {
                return this.a.d(this.f11604b, task);
            }
        });
    }

    final /* synthetic */ Task d(Bundle bundle, Task task) throws Exception {
        return (task.n() && l((Bundle) task.j())) ? m(bundle).p(f11572c, s.a) : task;
    }

    final /* synthetic */ void k(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.f11573d) {
            this.f11573d.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
