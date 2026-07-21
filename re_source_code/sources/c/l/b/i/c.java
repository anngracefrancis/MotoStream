package c.l.b.i;

import java.io.File;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreferenceDataStoreFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: compiled from: PreferenceDataStoreFactory.kt */
    static final class a extends Lambda implements Function0<File> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<File> f3331f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function0<? extends File> function0) {
            super(0);
            this.f3331f = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File fileInvoke = this.f3331f.invoke();
            String strA = kotlin.io.f.a(fileInvoke);
            h hVar = h.a;
            if (m.a(strA, hVar.f())) {
                return fileInvoke;
            }
            throw new IllegalStateException(("File extension for file: " + fileInvoke + " does not match required extension for Preferences file: " + hVar.f()).toString());
        }
    }

    private c() {
    }

    public final androidx.datastore.core.e<d> a(androidx.datastore.core.o.b<d> bVar, List<? extends androidx.datastore.core.c<d>> list, CoroutineScope coroutineScope, Function0<? extends File> function0) {
        m.f(list, "migrations");
        m.f(coroutineScope, "scope");
        m.f(function0, "produceFile");
        return new b(androidx.datastore.core.f.a.a(h.a, bVar, list, coroutineScope, new a(function0)));
    }
}
