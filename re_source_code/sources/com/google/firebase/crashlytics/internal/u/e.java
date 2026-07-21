package com.google.firebase.crashlytics.internal.u;

import java.util.Stack;

/* JADX INFO: compiled from: TrimmedThrowableData.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f19578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f19579d;

    private e(String str, String str2, StackTraceElement[] stackTraceElementArr, e eVar) {
        this.a = str;
        this.f19577b = str2;
        this.f19578c = stackTraceElementArr;
        this.f19579d = eVar;
    }

    public static e a(Throwable th, d dVar) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            eVar = new e(th2.getLocalizedMessage(), th2.getClass().getName(), dVar.a(th2.getStackTrace()), eVar);
        }
        return eVar;
    }
}
