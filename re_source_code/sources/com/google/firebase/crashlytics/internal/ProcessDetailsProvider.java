package com.google.firebase.crashlytics.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.crashlytics.internal.p.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.crashlytics.h.j, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ProcessDetailsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/crashlytics/internal/ProcessDetailsProvider;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "buildProcessDetails", "Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event$Application$ProcessDetails;", "processName", HttpUrl.FRAGMENT_ENCODE_SET, "pid", HttpUrl.FRAGMENT_ENCODE_SET, "importance", "isDefaultProcess", HttpUrl.FRAGMENT_ENCODE_SET, "getAppProcessDetails", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "getCurrentProcessDetails", "getProcessName", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider a = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    public static /* synthetic */ f0.e.d.a.c c(ProcessDetailsProvider processDetailsProvider, String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        return processDetailsProvider.b(str, i2, i3, z);
    }

    private final String f() {
        String processName;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 33) {
            return (i2 < 28 || (processName = Application.getProcessName()) == null) ? HttpUrl.FRAGMENT_ENCODE_SET : processName;
        }
        String strMyProcessName = Process.myProcessName();
        m.e(strMyProcessName, "{\n      Process.myProcessName()\n    }");
        return strMyProcessName;
    }

    public final f0.e.d.a.c a(String str, int i2, int i3) {
        m.f(str, "processName");
        return c(this, str, i2, i3, false, 8, null);
    }

    public final f0.e.d.a.c b(String str, int i2, int i3, boolean z) {
        m.f(str, "processName");
        f0.e.d.a.c cVarA = f0.e.d.a.c.a().e(str).d(i2).c(i3).b(z).a();
        m.e(cVarA, "builder()\n      .setProc…ltProcess)\n      .build()");
        return cVarA;
    }

    public final List<f0.e.d.a.c> d(Context context) {
        m.f(context, "context");
        int i2 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = u.j();
        }
        List listR = c0.R(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(v.u(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            arrayList2.add(f0.e.d.a.c.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(m.a(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final f0.e.d.a.c e(Context context) {
        Object next;
        m.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator<T> it = d(context).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((f0.e.d.a.c) next).c() == iMyPid));
        f0.e.d.a.c cVar = (f0.e.d.a.c) next;
        return cVar == null ? c(this, f(), iMyPid, 0, false, 12, null) : cVar;
    }
}
