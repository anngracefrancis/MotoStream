package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class g extends Service {
    private Binder binder;
    private int lastStartId;
    final ExecutorService executor = p.c();
    private final Object lock = new Object();
    private int runningTasks = 0;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    class a implements y0.a {
        a() {
        }

        @Override // com.google.firebase.messaging.y0.a
        @KeepForSdk
        public Task<Void> a(Intent intent) {
            return g.this.processIntent(intent);
        }
    }

    private void finishTask(Intent intent) {
        if (intent != null) {
            v0.b(intent);
        }
        synchronized (this.lock) {
            int i2 = this.runningTasks - 1;
            this.runningTasks = i2;
            if (i2 == 0) {
                stopSelfResultHook(this.lastStartId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> processIntent(final Intent intent) {
        if (handleIntentOnMainThread(intent)) {
            return Tasks.e(null);
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.executor.execute(new Runnable(this, intent, taskCompletionSource) { // from class: com.google.firebase.messaging.d

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final g f19808f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Intent f19809g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final TaskCompletionSource f19810h;

            {
                this.f19808f = this;
                this.f19809g = intent;
                this.f19810h = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19808f.lambda$processIntent$0$EnhancedIntentService(this.f19809g, this.f19810h);
            }
        });
        return taskCompletionSource.a();
    }

    protected abstract Intent getStartCommandIntent(Intent intent);

    public abstract void handleIntent(Intent intent);

    public boolean handleIntentOnMainThread(Intent intent) {
        return false;
    }

    final /* synthetic */ void lambda$onStartCommand$1$EnhancedIntentService(Intent intent, Task task) {
        finishTask(intent);
    }

    final /* synthetic */ void lambda$processIntent$0$EnhancedIntentService(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            handleIntent(intent);
        } finally {
            taskCompletionSource.c(null);
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.binder == null) {
            this.binder = new y0(new a());
        }
        return this.binder;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.executor.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i2, int i3) {
        synchronized (this.lock) {
            this.lastStartId = i3;
            this.runningTasks++;
        }
        Intent startCommandIntent = getStartCommandIntent(intent);
        if (startCommandIntent == null) {
            finishTask(intent);
            return 2;
        }
        Task<Void> taskProcessIntent = processIntent(startCommandIntent);
        if (taskProcessIntent.m()) {
            finishTask(intent);
            return 2;
        }
        taskProcessIntent.c(e.f19814f, new OnCompleteListener(this, intent) { // from class: com.google.firebase.messaging.f
            private final g a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Intent f19815b;

            {
                this.a = this;
                this.f19815b = intent;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void a(Task task) {
                this.a.lambda$onStartCommand$1$EnhancedIntentService(this.f19815b, task);
            }
        });
        return 3;
    }

    boolean stopSelfResultHook(int i2) {
        return stopSelfResult(i2);
    }
}
