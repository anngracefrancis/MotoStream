package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {

    /* JADX INFO: compiled from: StarProjectionImpl.kt */
    public static final class a extends f1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<e1> f24786d;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends e1> list) {
            this.f24786d = list;
        }

        @Override // kotlin.reflect.y.internal.j0.l.f1
        public g1 k(e1 e1Var) {
            m.f(e1Var, RoomNotification.KEY);
            if (!this.f24786d.contains(e1Var)) {
                return null;
            }
            h hVarC = e1Var.c();
            m.d(hVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return n1.s((e1) hVarC);
        }
    }

    private static final e0 a(List<? extends e1> list, List<? extends e0> list2, kotlin.reflect.y.internal.j0.b.h hVar) {
        e0 e0VarP = l1.g(new a(list)).p((e0) s.U(list2), r1.OUT_VARIANCE);
        if (e0VarP == null) {
            e0VarP = hVar.y();
        }
        m.e(e0VarP, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return e0VarP;
    }

    public static final e0 b(e1 e1Var) {
        m.f(e1Var, "<this>");
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = e1Var.b();
        m.e(mVarB, "this.containingDeclaration");
        if (mVarB instanceof i) {
            List<e1> parameters = ((i) mVarB).h().getParameters();
            m.e(parameters, "descriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(v.u(parameters, 10));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                e1 e1VarH = ((e1) it.next()).h();
                m.e(e1VarH, "it.typeConstructor");
                arrayList.add(e1VarH);
            }
            List<e0> upperBounds = e1Var.getUpperBounds();
            m.e(upperBounds, "upperBounds");
            return a(arrayList, upperBounds, kotlin.reflect.y.internal.j0.i.t.a.f(e1Var));
        }
        if (!(mVarB instanceof y)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List<e1> typeParameters = ((y) mVarB).getTypeParameters();
        m.e(typeParameters, "descriptor.typeParameters");
        ArrayList arrayList2 = new ArrayList(v.u(typeParameters, 10));
        Iterator<T> it2 = typeParameters.iterator();
        while (it2.hasNext()) {
            e1 e1VarH2 = ((e1) it2.next()).h();
            m.e(e1VarH2, "it.typeConstructor");
            arrayList2.add(e1VarH2);
        }
        List<e0> upperBounds2 = e1Var.getUpperBounds();
        m.e(upperBounds2, "upperBounds");
        return a(arrayList2, upperBounds2, kotlin.reflect.y.internal.j0.i.t.a.f(e1Var));
    }
}
