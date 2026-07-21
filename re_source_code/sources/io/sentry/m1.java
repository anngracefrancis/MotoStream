package io.sentry;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: FullyDisplayedReporter.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class m1 {
    private static final m1 a = new m1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f22493b = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: FullyDisplayedReporter.java */
    @ApiStatus.Internal
    public interface a {
    }

    private m1() {
    }

    public static m1 a() {
        return a;
    }

    public void b(a aVar) {
        this.f22493b.add(aVar);
    }
}
