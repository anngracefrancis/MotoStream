package c.l.b.i;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.p005z2.Flow;

/* JADX INFO: compiled from: PreferenceDataStoreFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements androidx.datastore.core.e<d> {
    private final androidx.datastore.core.e<d> a;

    /* JADX INFO: compiled from: PreferenceDataStoreFactory.kt */
    @DebugMetadata(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
    static final class a extends SuspendLambda implements Function2<d, Continuation<? super d>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3328f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f3329g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<d, Continuation<? super d>, Object> f3330h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super d, ? super Continuation<? super d>, ? extends Object> function2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f3330h = function2;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.f3330h, continuation);
            aVar.f3329g = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d dVar, Continuation<? super d> continuation) {
            return ((a) create(dVar, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f3328f;
            if (i2 == 0) {
                o.b(obj);
                d dVar = (d) this.f3329g;
                Function2<d, Continuation<? super d>, Object> function2 = this.f3330h;
                this.f3328f = 1;
                obj = function2.invoke(dVar, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
            d dVar2 = (d) obj;
            ((c.l.b.i.a) dVar2).f();
            return dVar2;
        }
    }

    public b(androidx.datastore.core.e<d> eVar) {
        m.f(eVar, "delegate");
        this.a = eVar;
    }

    @Override // androidx.datastore.core.e
    public Object a(Function2<? super d, ? super Continuation<? super d>, ? extends Object> function2, Continuation<? super d> continuation) {
        return this.a.a(new a(function2, null), continuation);
    }

    @Override // androidx.datastore.core.e
    public Flow<d> b() {
        return this.a.b();
    }
}
