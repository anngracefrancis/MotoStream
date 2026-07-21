package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.u, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ProcessDetailsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/ProcessDetailsProvider;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "buildProcessDetails", "Lcom/google/firebase/sessions/ProcessDetails;", "processName", HttpUrl.FRAGMENT_ENCODE_SET, "pid", HttpUrl.FRAGMENT_ENCODE_SET, "importance", "isDefaultProcess", HttpUrl.FRAGMENT_ENCODE_SET, "getAppProcessDetails", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "getCurrentProcessDetails", "getProcessName", "getProcessName$com_google_firebase_firebase_sessions", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider a = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    private final ProcessDetails a(String str, int i2, int i3, boolean z) {
        return new ProcessDetails(str, i2, i3, z);
    }

    static /* synthetic */ ProcessDetails b(ProcessDetailsProvider processDetailsProvider, String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        return processDetailsProvider.a(str, i2, i3, z);
    }

    public final List<ProcessDetails> c(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        int i2 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = kotlin.collections.u.j();
        }
        List listR = kotlin.collections.c0.R(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listR) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.v.u(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String str2 = runningAppProcessInfo.processName;
            kotlin.jvm.internal.m.e(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new ProcessDetails(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, kotlin.jvm.internal.m.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final ProcessDetails d(Context context) {
        Object next;
        kotlin.jvm.internal.m.f(context, "context");
        int iMyPid = Process.myPid();
        Iterator<T> it = c(context).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ProcessDetails) next).getPid() == iMyPid));
        ProcessDetails processDetails = (ProcessDetails) next;
        return processDetails == null ? b(this, e(), iMyPid, 0, false, 12, null) : processDetails;
    }

    public final String e() throws Throwable {
        String processName;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            String strMyProcessName = Process.myProcessName();
            kotlin.jvm.internal.m.e(strMyProcessName, "myProcessName()");
            return strMyProcessName;
        }
        if (i2 >= 28 && (processName = Application.getProcessName()) != null) {
            return processName;
        }
        String strA = ProcessUtils.a();
        return strA != null ? strA : HttpUrl.FRAGMENT_ENCODE_SET;
    }
}
