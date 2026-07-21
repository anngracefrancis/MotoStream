package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private Random a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, String> f92b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f93c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, d> f94d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final transient Map<String, c<?>> f95e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map<String, Object> f96f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Bundle f97g = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    class a<I> extends androidx.activity.result.b<I> {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.d.a f101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f102c;

        a(int i2, androidx.activity.result.d.a aVar, String str) {
            this.a = i2;
            this.f101b = aVar;
            this.f102c = str;
        }

        @Override // androidx.activity.result.b
        public void b(I i2, androidx.core.app.b bVar) {
            ActivityResultRegistry.this.f(this.a, this.f101b, i2, bVar);
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f102c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    class b<I> extends androidx.activity.result.b<I> {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.d.a f104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f105c;

        b(int i2, androidx.activity.result.d.a aVar, String str) {
            this.a = i2;
            this.f104b = aVar;
            this.f105c = str;
        }

        @Override // androidx.activity.result.b
        public void b(I i2, androidx.core.app.b bVar) {
            ActivityResultRegistry.this.f(this.a, this.f104b, i2, bVar);
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f105c);
        }
    }

    private static class c<O> {
        final androidx.activity.result.a<O> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.activity.result.d.a<?, O> f107b;

        c(androidx.activity.result.a<O> aVar, androidx.activity.result.d.a<?, O> aVar2) {
            this.a = aVar;
            this.f107b = aVar2;
        }
    }

    private static class d {
        final g a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<i> f108b = new ArrayList<>();

        d(g gVar) {
            this.a = gVar;
        }

        void a(i iVar) {
            this.a.a(iVar);
            this.f108b.add(iVar);
        }

        void b() {
            Iterator<i> it = this.f108b.iterator();
            while (it.hasNext()) {
                this.a.c(it.next());
            }
            this.f108b.clear();
        }
    }

    private void a(int i2, String str) {
        this.f92b.put(Integer.valueOf(i2), str);
        this.f93c.put(str, Integer.valueOf(i2));
    }

    private <O> void d(String str, int i2, Intent intent, c<O> cVar) {
        androidx.activity.result.a<O> aVar;
        if (cVar != null && (aVar = cVar.a) != null) {
            aVar.a(cVar.f107b.c(i2, intent));
        } else {
            this.f96f.remove(str);
            this.f97g.putParcelable(str, new ActivityResult(i2, intent));
        }
    }

    private int e() {
        int iNextInt = this.a.nextInt(2147418112);
        while (true) {
            int i2 = iNextInt + 65536;
            if (!this.f92b.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            iNextInt = this.a.nextInt(2147418112);
        }
    }

    private int k(String str) {
        Integer num = this.f93c.get(str);
        if (num != null) {
            return num.intValue();
        }
        int iE = e();
        a(iE, str);
        return iE;
    }

    public final boolean b(int i2, int i3, Intent intent) {
        String str = this.f92b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        d(str, i3, intent, this.f95e.get(str));
        return true;
    }

    public final <O> boolean c(int i2, @SuppressLint({"UnknownNullness"}) O o) {
        androidx.activity.result.a<?> aVar;
        String str = this.f92b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        c<?> cVar = this.f95e.get(str);
        if (cVar != null && (aVar = cVar.a) != null) {
            aVar.a(o);
            return true;
        }
        this.f97g.remove(str);
        this.f96f.put(str, o);
        return true;
    }

    public abstract <I, O> void f(int i2, androidx.activity.result.d.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i3, androidx.core.app.b bVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        int size = stringArrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
        }
        this.a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.f97g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f92b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f92b.values()));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f97g.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> androidx.activity.result.b<I> i(String str, androidx.activity.result.d.a<I, O> aVar, androidx.activity.result.a<O> aVar2) {
        int iK = k(str);
        this.f95e.put(str, new c<>(aVar2, aVar));
        if (this.f96f.containsKey(str)) {
            Object obj = this.f96f.get(str);
            this.f96f.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f97g.getParcelable(str);
        if (activityResult != null) {
            this.f97g.remove(str);
            aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new b(iK, aVar, str);
    }

    public final <I, O> androidx.activity.result.b<I> j(final String str, k kVar, final androidx.activity.result.d.a<I, O> aVar, final androidx.activity.result.a<O> aVar2) {
        g lifecycle = kVar.getLifecycle();
        if (lifecycle.b().g(g.c.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + kVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        int iK = k(str);
        d dVar = this.f94d.get(str);
        if (dVar == null) {
            dVar = new d(lifecycle);
        }
        dVar.a(new i() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.i
            public void a(k kVar2, g.b bVar) {
                if (!g.b.ON_START.equals(bVar)) {
                    if (g.b.ON_STOP.equals(bVar)) {
                        ActivityResultRegistry.this.f95e.remove(str);
                        return;
                    } else {
                        if (g.b.ON_DESTROY.equals(bVar)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f95e.put(str, new c<>(aVar2, aVar));
                if (ActivityResultRegistry.this.f96f.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f96f.get(str);
                    ActivityResultRegistry.this.f96f.remove(str);
                    aVar2.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f97g.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f97g.remove(str);
                    aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
                }
            }
        });
        this.f94d.put(str, dVar);
        return new a(iK, aVar, str);
    }

    final void l(String str) {
        Integer numRemove = this.f93c.remove(str);
        if (numRemove != null) {
            this.f92b.remove(numRemove);
        }
        this.f95e.remove(str);
        if (this.f96f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f96f.get(str));
            this.f96f.remove(str);
        }
        if (this.f97g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f97g.getParcelable(str));
            this.f97g.remove(str);
        }
        d dVar = this.f94d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f94d.remove(str);
        }
    }
}
