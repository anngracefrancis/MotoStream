package com.google.firebase.crashlytics.internal.u;

/* JADX INFO: compiled from: MiddleOutFallbackStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements d {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d[] f19575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f19576c;

    public a(int i2, d... dVarArr) {
        this.a = i2;
        this.f19575b = dVarArr;
        this.f19576c = new b(i2);
    }

    @Override // com.google.firebase.crashlytics.internal.u.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (d dVar : this.f19575b) {
            if (stackTraceElementArrA.length <= this.a) {
                break;
            }
            stackTraceElementArrA = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.a ? this.f19576c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
