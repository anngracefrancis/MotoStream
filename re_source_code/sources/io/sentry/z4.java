package io.sentry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryStackTraceFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class z4 {
    private final x4 a;

    public z4(x4 x4Var) {
        this.a = x4Var;
    }

    public List<io.sentry.protocol.u> a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (!className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    io.sentry.protocol.u uVar = new io.sentry.protocol.u();
                    uVar.t(b(className));
                    uVar.w(className);
                    uVar.s(stackTraceElement.getMethodName());
                    uVar.r(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        uVar.u(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    uVar.x(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(uVar);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public Boolean b(String str) {
        if (str == null || str.isEmpty()) {
            return Boolean.TRUE;
        }
        Iterator<String> it = this.a.getInAppIncludes().iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return Boolean.TRUE;
            }
        }
        Iterator<String> it2 = this.a.getInAppExcludes().iterator();
        while (it2.hasNext()) {
            if (str.startsWith(it2.next())) {
                return Boolean.FALSE;
            }
        }
        return null;
    }
}
