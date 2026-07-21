package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryThreadFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class a5 {
    private final z4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x4 f22004b;

    public a5(z4 z4Var, x4 x4Var) {
        this.a = (z4) io.sentry.util.q.c(z4Var, "The SentryStackTraceFactory is required.");
        this.f22004b = (x4) io.sentry.util.q.c(x4Var, "The SentryOptions is required");
    }

    private io.sentry.protocol.w d(boolean z, StackTraceElement[] stackTraceElementArr, Thread thread) {
        io.sentry.protocol.w wVar = new io.sentry.protocol.w();
        wVar.w(thread.getName());
        wVar.x(Integer.valueOf(thread.getPriority()));
        wVar.u(Long.valueOf(thread.getId()));
        wVar.s(Boolean.valueOf(thread.isDaemon()));
        wVar.z(thread.getState().name());
        wVar.q(Boolean.valueOf(z));
        List<io.sentry.protocol.u> listA = this.a.a(stackTraceElementArr);
        if (this.f22004b.isAttachStacktrace() && listA != null && !listA.isEmpty()) {
            io.sentry.protocol.v vVar = new io.sentry.protocol.v(listA);
            vVar.e(Boolean.TRUE);
            wVar.y(vVar);
        }
        return wVar;
    }

    List<io.sentry.protocol.w> a() {
        HashMap map = new HashMap();
        Thread threadCurrentThread = Thread.currentThread();
        map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        return c(map, null, false);
    }

    List<io.sentry.protocol.w> b(List<Long> list, boolean z) {
        return c(Thread.getAllStackTraces(), list, z);
    }

    List<io.sentry.protocol.w> c(Map<Thread, StackTraceElement[]> map, List<Long> list, boolean z) {
        Thread threadCurrentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(threadCurrentThread)) {
            map.put(threadCurrentThread, threadCurrentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(d((key == threadCurrentThread && !z) || (list != null && list.contains(Long.valueOf(key.getId()))), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}
