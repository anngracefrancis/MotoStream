package c.l.b;

import android.content.Context;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.properties.ReadOnlyProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.s2;

/* JADX INFO: compiled from: PreferenceDataStoreDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: c.l.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PreferenceDataStoreDelegate.kt */
    public static final class C0081a extends Lambda implements Function1<Context, List<? extends androidx.datastore.core.c<c.l.b.i.d>>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0081a f3312f = new C0081a();

        C0081a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List<androidx.datastore.core.c<c.l.b.i.d>> invoke(Context context) {
            m.f(context, "it");
            return u.j();
        }
    }

    public static final ReadOnlyProperty<Context, androidx.datastore.core.e<c.l.b.i.d>> a(String str, androidx.datastore.core.o.b<c.l.b.i.d> bVar, Function1<? super Context, ? extends List<? extends androidx.datastore.core.c<c.l.b.i.d>>> function1, CoroutineScope coroutineScope) {
        m.f(str, "name");
        m.f(function1, "produceMigrations");
        m.f(coroutineScope, "scope");
        return new c(str, bVar, function1, coroutineScope);
    }

    public static /* synthetic */ ReadOnlyProperty b(String str, androidx.datastore.core.o.b bVar, Function1 function1, CoroutineScope coroutineScope, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        if ((i2 & 4) != 0) {
            function1 = C0081a.f3312f;
        }
        if ((i2 & 8) != 0) {
            Dispatchers dispatchers = Dispatchers.a;
            coroutineScope = p0.a(Dispatchers.b().plus(s2.b(null, 1, null)));
        }
        return a(str, bVar, function1, coroutineScope);
    }
}
