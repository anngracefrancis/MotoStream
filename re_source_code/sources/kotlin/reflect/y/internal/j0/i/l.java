package kotlin.reflect.y.internal.j0.i;

import android.R;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.utils.f;
import kotlin.u;

/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: Add missing generic type declarations: [H] */
    /* JADX INFO: compiled from: overridingUtils.kt */
    static final class a<H> extends Lambda implements Function1<H, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f<H> f24350f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f<H> fVar) {
            super(1);
            this.f24350f = fVar;
        }

        public final void b(H h2) {
            f<H> fVar = this.f24350f;
            m.e(h2, "it");
            fVar.add(h2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Object obj) {
            b(obj);
            return u.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> a(Collection<? extends H> collection, Function1<? super H, ? extends kotlin.p002reflect.jvm.internal.impl.descriptors.a> function1) {
        m.f(collection, "<this>");
        m.f(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        f fVarA = f.f25524f.a();
        while (!linkedList.isEmpty()) {
            Object objU = s.U(linkedList);
            f fVarA2 = f.f25524f.a();
            Collection<R.attr> collectionP = j.p(objU, linkedList, function1, new a(fVarA2));
            m.e(collectionP, "val conflictedHandles = …nflictedHandles.add(it) }");
            if (collectionP.size() == 1 && fVarA2.isEmpty()) {
                Object objR0 = s.r0(collectionP);
                m.e(objR0, "overridableGroup.single()");
                fVarA.add(objR0);
            } else {
                R.attr attrVar = (Object) j.L(collectionP, function1);
                m.e(attrVar, "selectMostSpecificMember…roup, descriptorByHandle)");
                kotlin.p002reflect.jvm.internal.impl.descriptors.a aVarInvoke = function1.invoke(attrVar);
                for (R.attr attrVar2 : collectionP) {
                    m.e(attrVar2, "it");
                    if (!j.B(aVarInvoke, function1.invoke(attrVar2))) {
                        fVarA2.add(attrVar2);
                    }
                }
                if (!fVarA2.isEmpty()) {
                    fVarA.addAll(fVarA2);
                }
                fVarA.add(attrVar);
            }
        }
        return fVarA;
    }
}
