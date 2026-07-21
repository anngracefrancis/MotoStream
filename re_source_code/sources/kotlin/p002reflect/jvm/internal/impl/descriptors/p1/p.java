package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.i;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.p002reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.o.d;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: FunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends k implements y {
    private boolean A;
    private boolean B;
    private boolean C;
    private Collection<? extends y> D;
    private volatile Function0<Collection<y>> E;
    private final y F;
    private final kotlin.reflect.jvm.internal.impl.descriptors.b.a G;
    private y H;
    protected Map<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> I;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<e1> f25265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<i1> f25266k;
    private e0 l;
    private List<w0> m;
    private w0 n;
    private w0 o;
    private d0 p;
    private u q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    class a implements Function0<Collection<y>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l1 f25267f;

        a(l1 l1Var) {
            this.f25267f = l1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<y> invoke() {
            e eVar = new e();
            Iterator<? extends y> it = p.this.e().iterator();
            while (it.hasNext()) {
                eVar.add(it.next().c(this.f25267f));
            }
            return eVar;
        }
    }

    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    static class b implements Function0<List<j1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f25269f;

        b(List list) {
            this.f25269f = list;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<j1> invoke() {
            return this.f25269f;
        }
    }

    /* JADX INFO: compiled from: FunctionDescriptorImpl.java */
    public class c implements y.a<y> {
        protected kotlin.reflect.y.internal.j0.l.j1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected m f25270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected d0 f25271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected u f25272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected y f25273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.b.a f25274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected List<i1> f25275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected List<w0> f25276h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected w0 f25277i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected w0 f25278j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected e0 f25279k;
        protected f l;
        protected boolean m;
        protected boolean n;
        protected boolean o;
        protected boolean p;
        private boolean q;
        private List<e1> r;
        private g s;
        private boolean t;
        private Map<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> u;
        private Boolean v;
        protected boolean w;
        final /* synthetic */ p x;

        public c(p pVar, kotlin.reflect.y.internal.j0.l.j1 j1Var, m mVar, d0 d0Var, u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, List<i1> list, List<w0> list2, w0 w0Var, e0 e0Var, f fVar) {
            if (j1Var == null) {
                v(0);
            }
            if (mVar == null) {
                v(1);
            }
            if (d0Var == null) {
                v(2);
            }
            if (uVar == null) {
                v(3);
            }
            if (aVar == null) {
                v(4);
            }
            if (list == null) {
                v(5);
            }
            if (list2 == null) {
                v(6);
            }
            if (e0Var == null) {
                v(7);
            }
            this.x = pVar;
            this.f25273e = null;
            this.f25278j = pVar.o;
            this.m = true;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = pVar.w0();
            this.r = null;
            this.s = null;
            this.t = pVar.C0();
            this.u = new LinkedHashMap();
            this.v = null;
            this.w = false;
            this.a = j1Var;
            this.f25270b = mVar;
            this.f25271c = d0Var;
            this.f25272d = uVar;
            this.f25274f = aVar;
            this.f25275g = list;
            this.f25276h = list2;
            this.f25277i = w0Var;
            this.f25279k = e0Var;
            this.l = fVar;
        }

        private static /* synthetic */ void v(int i2) {
            String str;
            int i3;
            switch (i2) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    i3 = 2;
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 14:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newContextReceiverParameters";
                    break;
                case 7:
                    objArr[0] = "newReturnType";
                    break;
                case 8:
                    objArr[0] = "owner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[0] = "modality";
                    break;
                case 12:
                    objArr[0] = "visibility";
                    break;
                case 17:
                    objArr[0] = "name";
                    break;
                case 19:
                case 21:
                    objArr[0] = "parameters";
                    break;
                case 23:
                    objArr[0] = "type";
                    break;
                case 25:
                    objArr[0] = "contextReceiverParameters";
                    break;
                case 35:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 37:
                default:
                    objArr[0] = "substitution";
                    break;
                case 39:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i2) {
                case 9:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 11:
                    objArr[1] = "setModality";
                    break;
                case 13:
                    objArr[1] = "setVisibility";
                    break;
                case 15:
                    objArr[1] = "setKind";
                    break;
                case 16:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 18:
                    objArr[1] = "setName";
                    break;
                case 20:
                    objArr[1] = "setValueParameters";
                    break;
                case 22:
                    objArr[1] = "setTypeParameters";
                    break;
                case 24:
                    objArr[1] = "setReturnType";
                    break;
                case 26:
                    objArr[1] = "setContextReceiverParameters";
                    break;
                case 27:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 28:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 29:
                    objArr[1] = "setOriginal";
                    break;
                case 30:
                    objArr[1] = "setSignatureChange";
                    break;
                case 31:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 32:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 33:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 34:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 36:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 38:
                    objArr[1] = "setSubstitution";
                    break;
                case 40:
                    objArr[1] = "putUserData";
                    break;
                case 41:
                    objArr[1] = "getSubstitution";
                    break;
                case 42:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i2) {
                case 8:
                    objArr[2] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    break;
                case 10:
                    objArr[2] = "setModality";
                    break;
                case 12:
                    objArr[2] = "setVisibility";
                    break;
                case 14:
                    objArr[2] = "setKind";
                    break;
                case 17:
                    objArr[2] = "setName";
                    break;
                case 19:
                    objArr[2] = "setValueParameters";
                    break;
                case 21:
                    objArr[2] = "setTypeParameters";
                    break;
                case 23:
                    objArr[2] = "setReturnType";
                    break;
                case 25:
                    objArr[2] = "setContextReceiverParameters";
                    break;
                case 35:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 37:
                    objArr[2] = "setSubstitution";
                    break;
                case 39:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            switch (i2) {
                case 9:
                case 11:
                case 13:
                case 15:
                case 16:
                case 18:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 36:
                case 38:
                case 40:
                case 41:
                case 42:
                    throw new IllegalStateException(str2);
                case 10:
                case 12:
                case 14:
                case 17:
                case 19:
                case 21:
                case 23:
                case 25:
                case 35:
                case 37:
                case 39:
                default:
                    throw new IllegalArgumentException(str2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public c s(g gVar) {
            if (gVar == null) {
                v(35);
            }
            this.s = gVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public c j(boolean z) {
            this.m = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public c e(w0 w0Var) {
            this.f25278j = w0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public c a() {
            this.p = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public c k(w0 w0Var) {
            this.f25277i = w0Var;
            return this;
        }

        public c H(boolean z) {
            this.v = Boolean.valueOf(z);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public c i() {
            this.t = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public c q() {
            this.q = true;
            return this;
        }

        public c K(boolean z) {
            this.w = z;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public c r(kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar) {
            if (aVar == null) {
                v(14);
            }
            this.f25274f = aVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public c d(d0 d0Var) {
            if (d0Var == null) {
                v(10);
            }
            this.f25271c = d0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public c t(f fVar) {
            if (fVar == null) {
                v(17);
            }
            this.l = fVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public c h(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f25273e = (y) bVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public c p(m mVar) {
            if (mVar == null) {
                v(8);
            }
            this.f25270b = mVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public c f() {
            this.o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public c g(e0 e0Var) {
            if (e0Var == null) {
                v(23);
            }
            this.f25279k = e0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public c u() {
            this.n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public c l(kotlin.reflect.y.internal.j0.l.j1 j1Var) {
            if (j1Var == null) {
                v(37);
            }
            this.a = j1Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public c m(List<e1> list) {
            if (list == null) {
                v(21);
            }
            this.r = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public c b(List<i1> list) {
            if (list == null) {
                v(19);
            }
            this.f25275g = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public c o(u uVar) {
            if (uVar == null) {
                v(12);
            }
            this.f25272d = uVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y c() {
            return this.x.N0(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public <V> y.a<y> n(kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<V> interfaceC0406a, V v) {
            if (interfaceC0406a == null) {
                v(39);
            }
            this.u.put(interfaceC0406a, v);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected p(m mVar, y yVar, g gVar, f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, z0 z0Var) {
        super(mVar, gVar, fVar, z0Var);
        if (mVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (fVar == null) {
            v(2);
        }
        if (aVar == null) {
            v(3);
        }
        if (z0Var == null) {
            v(4);
        }
        this.q = t.f25372i;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = false;
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        this.F = yVar == null ? this : yVar;
        this.G = aVar;
    }

    private z0 O0(boolean z, y yVar) {
        z0 z0VarT;
        if (z) {
            if (yVar == null) {
                yVar = a();
            }
            z0VarT = yVar.t();
        } else {
            z0VarT = z0.a;
        }
        if (z0VarT == null) {
            v(27);
        }
        return z0VarT;
    }

    public static List<i1> P0(y yVar, List<i1> list, l1 l1Var) {
        if (list == null) {
            v(28);
        }
        if (l1Var == null) {
            v(29);
        }
        return Q0(yVar, list, l1Var, false, false, null);
    }

    public static List<i1> Q0(y yVar, List<i1> list, l1 l1Var, boolean z, boolean z2, boolean[] zArr) {
        if (list == null) {
            v(30);
        }
        if (l1Var == null) {
            v(31);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (i1 i1Var : list) {
            e0 type = i1Var.getType();
            r1 r1Var = r1.IN_VARIANCE;
            e0 e0VarP = l1Var.p(type, r1Var);
            e0 e0VarL0 = i1Var.l0();
            e0 e0VarP2 = e0VarL0 == null ? null : l1Var.p(e0VarL0, r1Var);
            if (e0VarP == null) {
                return null;
            }
            if ((e0VarP != i1Var.getType() || e0VarL0 != e0VarP2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(l0.L0(yVar, z ? null : i1Var, i1Var.g(), i1Var.getAnnotations(), i1Var.getName(), e0VarP, i1Var.u0(), i1Var.b0(), i1Var.Y(), e0VarP2, z2 ? i1Var.t() : z0.a, i1Var instanceof l0.b ? new b(((l0.b) i1Var).O0()) : null));
        }
        return arrayList;
    }

    private void U0() {
        Function0<Collection<y>> function0 = this.E;
        if (function0 != null) {
            this.D = function0.invoke();
            this.E = null;
        }
    }

    private void b1(boolean z) {
        this.z = z;
    }

    private void c1(boolean z) {
        this.y = z;
    }

    private void e1(y yVar) {
        this.H = yVar;
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                i3 = 2;
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "contextReceiverParameters";
                break;
            case 6:
                objArr[0] = "typeParameters";
                break;
            case 7:
            case 28:
            case 30:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 8:
            case 10:
                objArr[0] = "visibility";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 11:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 12:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 17:
                objArr[0] = "overriddenDescriptors";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
            case 29:
            case 31:
                objArr[0] = "substitutor";
                break;
            case 25:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 9:
                objArr[1] = "initialize";
                break;
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 14:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 15:
                objArr[1] = "getModality";
                break;
            case 16:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getTypeParameters";
                break;
            case 19:
                objArr[1] = "getValueParameters";
                break;
            case 20:
                objArr[1] = "getOriginal";
                break;
            case 21:
                objArr[1] = "getKind";
                break;
            case 23:
                objArr[1] = "newCopyBuilder";
                break;
            case 26:
                objArr[1] = "copy";
                break;
            case 27:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                break;
            case 10:
                objArr[2] = "setVisibility";
                break;
            case 11:
                objArr[2] = "setReturnType";
                break;
            case 12:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 17:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "newCopyBuilder";
                break;
            case 25:
                objArr[2] = "doSubstitute";
                break;
            case 28:
            case 29:
            case 30:
            case 31:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 26:
            case 27:
                throw new IllegalStateException(str2);
            case 10:
            case 11:
            case 12:
            case 17:
            case 22:
            case 24:
            case 25:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean C0() {
        return this.z;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return this.x;
    }

    public boolean G() {
        return this.C;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean H0() {
        if (this.s) {
            return true;
        }
        Iterator<? extends y> it = a().e().iterator();
        while (it.hasNext()) {
            if (it.next().H0()) {
                return true;
            }
        }
        return false;
    }

    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.g(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: L0 */
    public y k0(m mVar, d0 d0Var, u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z) {
        y yVarC = u().p(mVar).d(d0Var).o(uVar).r(aVar).j(z).c();
        if (yVarC == null) {
            v(26);
        }
        return yVarC;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return this.w;
    }

    protected abstract p M0(m mVar, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, f fVar, g gVar, z0 z0Var);

    protected y N0(c cVar) {
        f0 f0Var;
        w0 w0Var;
        e0 e0VarP;
        if (cVar == null) {
            v(25);
        }
        boolean[] zArr = new boolean[1];
        g gVarA = cVar.s != null ? i.a(getAnnotations(), cVar.s) : getAnnotations();
        m mVar = cVar.f25270b;
        y yVar = cVar.f25273e;
        p pVarM0 = M0(mVar, yVar, cVar.f25274f, cVar.l, gVarA, O0(cVar.o, yVar));
        List<e1> typeParameters = cVar.r == null ? getTypeParameters() : cVar.r;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        l1 l1VarC = kotlin.reflect.y.internal.j0.l.t.c(typeParameters, cVar.a, pVarM0, arrayList, zArr);
        if (l1VarC == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!cVar.f25276h.isEmpty()) {
            for (w0 w0Var2 : cVar.f25276h) {
                e0 e0VarP2 = l1VarC.p(w0Var2.getType(), r1.IN_VARIANCE);
                if (e0VarP2 == null) {
                    return null;
                }
                arrayList2.add(kotlin.reflect.y.internal.j0.i.c.b(pVarM0, e0VarP2, w0Var2.getAnnotations()));
                zArr[0] = (e0VarP2 != w0Var2.getType()) | zArr[0];
            }
        }
        w0 w0Var3 = cVar.f25277i;
        if (w0Var3 != null) {
            e0 e0VarP3 = l1VarC.p(w0Var3.getType(), r1.IN_VARIANCE);
            if (e0VarP3 == null) {
                return null;
            }
            f0 f0Var2 = new f0(pVarM0, new d(pVarM0, e0VarP3, cVar.f25277i.getValue()), cVar.f25277i.getAnnotations());
            zArr[0] = (e0VarP3 != cVar.f25277i.getType()) | zArr[0];
            f0Var = f0Var2;
        } else {
            f0Var = null;
        }
        w0 w0Var4 = cVar.f25278j;
        if (w0Var4 != null) {
            w0 w0VarC = w0Var4.c(l1VarC);
            if (w0VarC == null) {
                return null;
            }
            zArr[0] = zArr[0] | (w0VarC != cVar.f25278j);
            w0Var = w0VarC;
        } else {
            w0Var = null;
        }
        List<i1> listQ0 = Q0(pVarM0, cVar.f25275g, l1VarC, cVar.p, cVar.o, zArr);
        if (listQ0 == null || (e0VarP = l1VarC.p(cVar.f25279k, r1.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (e0VarP != cVar.f25279k);
        if (!zArr[0] && cVar.w) {
            return this;
        }
        pVarM0.S0(f0Var, w0Var, arrayList2, arrayList, listQ0, e0VarP, cVar.f25271c, cVar.f25272d);
        pVarM0.g1(this.r);
        pVarM0.d1(this.s);
        pVarM0.Y0(this.t);
        pVarM0.f1(this.u);
        pVarM0.j1(this.v);
        pVarM0.i1(this.A);
        pVarM0.X0(this.w);
        pVarM0.W0(this.x);
        pVarM0.Z0(this.B);
        pVarM0.c1(cVar.q);
        pVarM0.b1(cVar.t);
        pVarM0.a1(cVar.v != null ? cVar.v.booleanValue() : this.C);
        if (!cVar.u.isEmpty() || this.I != null) {
            Map<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> map = cVar.u;
            Map<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> map2 = this.I;
            if (map2 != null) {
                for (Map.Entry<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> entry : map2.entrySet()) {
                    if (!map.containsKey(entry.getKey())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map.size() == 1) {
                pVarM0.I = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
            } else {
                pVarM0.I = map;
            }
        }
        if (cVar.n || d0() != null) {
            pVarM0.e1((d0() != null ? d0() : this).c(l1VarC));
        }
        if (cVar.m && !a().e().isEmpty()) {
            if (cVar.a.f()) {
                Function0<Collection<y>> function0 = this.E;
                if (function0 != null) {
                    pVarM0.E = function0;
                } else {
                    pVarM0.x0(e());
                }
            } else {
                pVarM0.E = new a(l1VarC);
            }
        }
        return pVarM0;
    }

    public boolean P() {
        return this.v;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean Q() {
        if (this.r) {
            return true;
        }
        Iterator<? extends y> it = a().e().iterator();
        while (it.hasNext()) {
            if (it.next().Q()) {
                return true;
            }
        }
        return false;
    }

    public boolean R0() {
        return this.B;
    }

    public p S0(w0 w0Var, w0 w0Var2, List<w0> list, List<? extends e1> list2, List<i1> list3, e0 e0Var, d0 d0Var, u uVar) {
        if (list == null) {
            v(5);
        }
        if (list2 == null) {
            v(6);
        }
        if (list3 == null) {
            v(7);
        }
        if (uVar == null) {
            v(8);
        }
        this.f25265j = c0.E0(list2);
        this.f25266k = c0.E0(list3);
        this.l = e0Var;
        this.p = d0Var;
        this.q = uVar;
        this.n = w0Var;
        this.o = w0Var2;
        this.m = list;
        for (int i2 = 0; i2 < list2.size(); i2++) {
            e1 e1Var = list2.get(i2);
            if (e1Var.g() != i2) {
                throw new IllegalStateException(e1Var + " index is " + e1Var.g() + " but position is " + i2);
            }
        }
        for (int i3 = 0; i3 < list3.size(); i3++) {
            i1 i1Var = list3.get(i3);
            if (i1Var.g() != i3 + 0) {
                throw new IllegalStateException(i1Var + "index is " + i1Var.g() + " but position is " + i3);
            }
        }
        return this;
    }

    protected c T0(l1 l1Var) {
        if (l1Var == null) {
            v(24);
        }
        return new c(this, l1Var.j(), b(), j(), getVisibility(), i(), f(), r0(), m0(), getReturnType(), null);
    }

    public <V> void V0(kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<V> interfaceC0406a, Object obj) {
        if (this.I == null) {
            this.I = new LinkedHashMap();
        }
        this.I.put(interfaceC0406a, obj);
    }

    public void W0(boolean z) {
        this.x = z;
    }

    public void X0(boolean z) {
        this.w = z;
    }

    public void Y0(boolean z) {
        this.t = z;
    }

    public void Z0(boolean z) {
        this.B = z;
    }

    public void a1(boolean z) {
        this.C = z;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public y d0() {
        return this.H;
    }

    public void d1(boolean z) {
        this.s = z;
    }

    public Collection<? extends y> e() {
        U0();
        Collection<? extends y> collectionEmptyList = this.D;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList == null) {
            v(14);
        }
        return collectionEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        List<i1> list = this.f25266k;
        if (list == null) {
            v(19);
        }
        return list;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public w0 f0() {
        return this.o;
    }

    public void f1(boolean z) {
        this.u = z;
    }

    public void g1(boolean z) {
        this.r = z;
    }

    public e0 getReturnType() {
        return this.l;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<e1> getTypeParameters() {
        List<e1> list = this.f25265j;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        u uVar = this.q;
        if (uVar == null) {
            v(16);
        }
        return uVar;
    }

    public void h1(e0 e0Var) {
        if (e0Var == null) {
            v(11);
        }
        this.l = e0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b
    public kotlin.reflect.jvm.internal.impl.descriptors.b.a i() {
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar = this.G;
        if (aVar == null) {
            v(21);
        }
        return aVar;
    }

    public <V> V i0(kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<V> interfaceC0406a) {
        Map<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> map = this.I;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0406a);
    }

    public void i1(boolean z) {
        this.A = z;
    }

    public boolean isInline() {
        return this.u;
    }

    public boolean isSuspend() {
        return this.A;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        d0 d0Var = this.p;
        if (d0Var == null) {
            v(15);
        }
        return d0Var;
    }

    public void j1(boolean z) {
        this.v = z;
    }

    public void k1(u uVar) {
        if (uVar == null) {
            v(10);
        }
        this.q = uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public w0 m0() {
        return this.n;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public List<w0> r0() {
        List<w0> list = this.m;
        if (list == null) {
            v(13);
        }
        return list;
    }

    public y.a<? extends y> u() {
        c cVarT0 = T0(l1.a);
        if (cVarT0 == null) {
            v(23);
        }
        return cVarT0;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean w0() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x0(Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> collection) {
        if (collection == 0) {
            v(17);
        }
        this.D = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((y) it.next()).C0()) {
                this.z = true;
                return;
            }
        }
    }

    public boolean z() {
        return this.t;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    public y c(l1 l1Var) {
        if (l1Var == null) {
            v(22);
        }
        return l1Var.k() ? this : T0(l1Var).h(a()).f().K(true).c();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public y a() {
        y yVar = this.F;
        y yVarA = yVar == this ? this : yVar.a();
        if (yVarA == null) {
            v(20);
        }
        return yVarA;
    }
}
