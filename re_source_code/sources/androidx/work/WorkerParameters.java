package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class WorkerParameters {
    private UUID a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f2274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f2275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f2276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Executor f2278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.work.impl.utils.p.a f2279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a0 f2280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private t f2281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private i f2282j;

    public static class a {
        public List<String> a = Collections.emptyList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Uri> f2283b = Collections.emptyList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Network f2284c;
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i2, Executor executor, androidx.work.impl.utils.p.a aVar2, a0 a0Var, t tVar, i iVar) {
        this.a = uuid;
        this.f2274b = eVar;
        this.f2275c = new HashSet(collection);
        this.f2276d = aVar;
        this.f2277e = i2;
        this.f2278f = executor;
        this.f2279g = aVar2;
        this.f2280h = a0Var;
        this.f2281i = tVar;
        this.f2282j = iVar;
    }

    public Executor a() {
        return this.f2278f;
    }

    public i b() {
        return this.f2282j;
    }

    public UUID c() {
        return this.a;
    }

    public e d() {
        return this.f2274b;
    }

    public Network e() {
        return this.f2276d.f2284c;
    }

    public t f() {
        return this.f2281i;
    }

    public int g() {
        return this.f2277e;
    }

    public Set<String> h() {
        return this.f2275c;
    }

    public androidx.work.impl.utils.p.a i() {
        return this.f2279g;
    }

    public List<String> j() {
        return this.f2276d.a;
    }

    public List<Uri> k() {
        return this.f2276d.f2283b;
    }

    public a0 l() {
        return this.f2280h;
    }
}
