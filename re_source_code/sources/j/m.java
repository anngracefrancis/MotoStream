package j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ForwardingTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class m extends e0 {
    private e0 a;

    public m(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "delegate");
        this.a = e0Var;
    }

    public final e0 a() {
        return this.a;
    }

    public final m b(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "delegate");
        this.a = e0Var;
        return this;
    }

    @Override // j.e0
    public e0 clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // j.e0
    public e0 clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // j.e0
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @Override // j.e0
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // j.e0
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // j.e0
    public e0 timeout(long j2, TimeUnit timeUnit) {
        kotlin.jvm.internal.m.f(timeUnit, "unit");
        return this.a.timeout(j2, timeUnit);
    }

    @Override // j.e0
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // j.e0
    public e0 deadlineNanoTime(long j2) {
        return this.a.deadlineNanoTime(j2);
    }
}
