package c.l.b;

import android.content.Context;
import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreferenceDataStoreDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ReadOnlyProperty<Context, androidx.datastore.core.e<c.l.b.i.d>> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.datastore.core.o.b<c.l.b.i.d> f3313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<Context, List<androidx.datastore.core.c<c.l.b.i.d>>> f3314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f3315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f3316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile androidx.datastore.core.e<c.l.b.i.d> f3317f;

    /* JADX INFO: compiled from: PreferenceDataStoreDelegate.kt */
    static final class a extends Lambda implements Function0<File> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f3318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f3319g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, c cVar) {
            super(0);
            this.f3318f = context;
            this.f3319g = cVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            Context context = this.f3318f;
            m.e(context, "applicationContext");
            return b.a(context, this.f3319g.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String str, androidx.datastore.core.o.b<c.l.b.i.d> bVar, Function1<? super Context, ? extends List<? extends androidx.datastore.core.c<c.l.b.i.d>>> function1, CoroutineScope coroutineScope) {
        m.f(str, "name");
        m.f(function1, "produceMigrations");
        m.f(coroutineScope, "scope");
        this.a = str;
        this.f3313b = bVar;
        this.f3314c = function1;
        this.f3315d = coroutineScope;
        this.f3316e = new Object();
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public androidx.datastore.core.e<c.l.b.i.d> a(Context context, KProperty<?> kProperty) {
        androidx.datastore.core.e<c.l.b.i.d> eVar;
        m.f(context, "thisRef");
        m.f(kProperty, "property");
        androidx.datastore.core.e<c.l.b.i.d> eVar2 = this.f3317f;
        if (eVar2 != null) {
            return eVar2;
        }
        synchronized (this.f3316e) {
            if (this.f3317f == null) {
                Context applicationContext = context.getApplicationContext();
                c.l.b.i.c cVar = c.l.b.i.c.a;
                androidx.datastore.core.o.b<c.l.b.i.d> bVar = this.f3313b;
                Function1<Context, List<androidx.datastore.core.c<c.l.b.i.d>>> function1 = this.f3314c;
                m.e(applicationContext, "applicationContext");
                this.f3317f = cVar.a(bVar, function1.invoke(applicationContext), this.f3315d, new a(applicationContext, this));
            }
            eVar = this.f3317f;
            m.c(eVar);
        }
        return eVar;
    }
}
