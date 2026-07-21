package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.n;
import androidx.work.q;
import androidx.work.w;
import androidx.work.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: WorkContinuationImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends w {
    private static final String a = n.f("WorkContinuationImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f2423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.work.g f2425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<? extends z> f2426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f2427f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<String> f2428g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<g> f2429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private q f2431j;

    public g(j jVar, List<? extends z> list) {
        this(jVar, null, androidx.work.g.KEEP, list, null);
    }

    private static boolean i(g gVar, Set<String> set) {
        set.addAll(gVar.c());
        Set<String> setL = l(gVar);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (setL.contains(it.next())) {
                return true;
            }
        }
        List<g> listE = gVar.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator<g> it2 = listE.iterator();
            while (it2.hasNext()) {
                if (i(it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set<String> l(g gVar) {
        HashSet hashSet = new HashSet();
        List<g> listE = gVar.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator<g> it = listE.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().c());
            }
        }
        return hashSet;
    }

    public q a() {
        if (this.f2430i) {
            n.c().h(a, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f2427f)), new Throwable[0]);
        } else {
            androidx.work.impl.utils.b bVar = new androidx.work.impl.utils.b(this);
            this.f2423b.u().b(bVar);
            this.f2431j = bVar.d();
        }
        return this.f2431j;
    }

    public androidx.work.g b() {
        return this.f2425d;
    }

    public List<String> c() {
        return this.f2427f;
    }

    public String d() {
        return this.f2424c;
    }

    public List<g> e() {
        return this.f2429h;
    }

    public List<? extends z> f() {
        return this.f2426e;
    }

    public j g() {
        return this.f2423b;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.f2430i;
    }

    public void k() {
        this.f2430i = true;
    }

    public g(j jVar, String str, androidx.work.g gVar, List<? extends z> list) {
        this(jVar, str, gVar, list, null);
    }

    public g(j jVar, String str, androidx.work.g gVar, List<? extends z> list, List<g> list2) {
        this.f2423b = jVar;
        this.f2424c = str;
        this.f2425d = gVar;
        this.f2426e = list;
        this.f2429h = list2;
        this.f2427f = new ArrayList(list.size());
        this.f2428g = new ArrayList();
        if (list2 != null) {
            Iterator<g> it = list2.iterator();
            while (it.hasNext()) {
                this.f2428g.addAll(it.next().f2428g);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String strA = list.get(i2).a();
            this.f2427f.add(strA);
            this.f2428g.add(strA);
        }
    }
}
