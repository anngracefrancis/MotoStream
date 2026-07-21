package c.l.b.i;

import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;

/* JADX INFO: compiled from: Preferences.kt */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: compiled from: Preferences.kt */
    @DebugMetadata(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
    static final class a extends SuspendLambda implements Function2<d, Continuation<? super d>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3333f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f3334g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<c.l.b.i.a, Continuation<? super u>, Object> f3335h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super c.l.b.i.a, ? super Continuation<? super u>, ? extends Object> function2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f3335h = function2;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.f3335h, continuation);
            aVar.f3334g = obj;
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
            int i2 = this.f3333f;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c.l.b.i.a aVar = (c.l.b.i.a) this.f3334g;
                o.b(obj);
                return aVar;
            }
            o.b(obj);
            c.l.b.i.a aVarC = ((d) this.f3334g).c();
            Function2<c.l.b.i.a, Continuation<? super u>, Object> function2 = this.f3335h;
            this.f3334g = aVarC;
            this.f3333f = 1;
            return function2.invoke(aVarC, this) == objC ? objC : aVarC;
        }
    }

    public static final Object a(androidx.datastore.core.e<d> eVar, Function2<? super c.l.b.i.a, ? super Continuation<? super u>, ? extends Object> function2, Continuation<? super d> continuation) {
        return eVar.a(new a(function2, null), continuation);
    }
}
