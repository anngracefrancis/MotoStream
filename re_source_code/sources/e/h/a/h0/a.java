package e.h.a.h0;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DownloadEventPoolImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final Executor a = e.h.a.k0.b.a(10, "EventPool");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, LinkedList<d>> f21336b = new HashMap<>();

    /* JADX INFO: renamed from: e.h.a.h0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadEventPoolImpl.java */
    class RunnableC0277a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f21337f;

        RunnableC0277a(c cVar) {
            this.f21337f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.c(this.f21337f);
        }
    }

    private void d(LinkedList<d> linkedList, c cVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((d) obj).d(cVar)) {
                break;
            }
        }
        Runnable runnable = cVar.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean a(String str, d dVar) {
        boolean zAdd;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "setListener %s", str);
        }
        if (dVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<d> linkedList = this.f21336b.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.f21336b.get(str);
                if (linkedList == null) {
                    HashMap<String, LinkedList<d>> map = this.f21336b;
                    LinkedList<d> linkedList2 = new LinkedList<>();
                    map.put(str, linkedList2);
                    linkedList = linkedList2;
                }
            }
        }
        synchronized (str.intern()) {
            zAdd = linkedList.add(dVar);
        }
        return zAdd;
    }

    public void b(c cVar) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "asyncPublishInNewThread %s", cVar.a());
        }
        if (cVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        this.a.execute(new RunnableC0277a(cVar));
    }

    public boolean c(c cVar) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.h(this, "publish %s", cVar.a());
        }
        if (cVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String strA = cVar.a();
        LinkedList<d> linkedList = this.f21336b.get(strA);
        if (linkedList == null) {
            synchronized (strA.intern()) {
                linkedList = this.f21336b.get(strA);
                if (linkedList == null) {
                    if (e.h.a.k0.d.a) {
                        e.h.a.k0.d.a(this, "No listener for this event %s", strA);
                    }
                    return false;
                }
            }
        }
        d(linkedList, cVar);
        return true;
    }
}
