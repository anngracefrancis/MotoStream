package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.k.n;

/* JADX INFO: compiled from: ClassTypeConstructorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends b implements e1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f24753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<e1> f24754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Collection<e0> f24755f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(e eVar, List<? extends e1> list, Collection<e0> collection, n nVar) {
        super(nVar);
        if (eVar == null) {
            v(0);
        }
        if (list == null) {
            v(1);
        }
        if (collection == null) {
            v(2);
        }
        if (nVar == null) {
            v(3);
        }
        this.f24753d = eVar;
        this.f24754e = Collections.unmodifiableList(new ArrayList(list));
        this.f24755f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getParameters";
        } else if (i2 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i2 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i2 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return true;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<e1> getParameters() {
        List<e1> list = this.f24754e;
        if (list == null) {
            v(4);
        }
        return list;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g
    protected Collection<e0> l() {
        Collection<e0> collection = this.f24755f;
        if (collection == null) {
            v(6);
        }
        return collection;
    }

    @Override // kotlin.reflect.y.internal.j0.l.g
    protected c1 q() {
        c1.a aVar = c1.a.a;
        if (aVar == null) {
            v(7);
        }
        return aVar;
    }

    public String toString() {
        return d.m(this.f24753d).b();
    }

    @Override // kotlin.reflect.y.internal.j0.l.m, kotlin.reflect.y.internal.j0.l.e1
    public e w() {
        e eVar = this.f24753d;
        if (eVar == null) {
            v(5);
        }
        return eVar;
    }
}
