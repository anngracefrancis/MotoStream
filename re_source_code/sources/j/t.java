package j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends AbstractList<i> implements RandomAccess {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f22860g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i[] f22861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f22862i;

    /* JADX INFO: compiled from: Options.kt */
    public static final class a {
        private a() {
        }

        private final void a(long j2, f fVar, int i2, List<? extends i> list, int i3, int i4, List<Integer> list2) throws IOException {
            int i5;
            int i6;
            int i7;
            int i8 = i2;
            if (!(i3 < i4)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i9 = i3; i9 < i4; i9++) {
                if (!(list.get(i9).P() >= i8)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            i iVar = list.get(i3);
            i iVar2 = list.get(i4 - 1);
            if (i8 == iVar.P()) {
                int iIntValue = list2.get(i3).intValue();
                int i10 = i3 + 1;
                i iVar3 = list.get(i10);
                i5 = i10;
                i6 = iIntValue;
                iVar = iVar3;
            } else {
                i5 = i3;
                i6 = -1;
            }
            if (iVar.x(i8) == iVar2.x(i8)) {
                int iMin = Math.min(iVar.P(), iVar2.P());
                int i11 = 0;
                for (int i12 = i8; i12 < iMin && iVar.x(i12) == iVar2.x(i12); i12++) {
                    i11++;
                }
                long jC = j2 + c(fVar) + ((long) 2) + ((long) i11) + 1;
                fVar.writeInt(-i11);
                fVar.writeInt(i6);
                int i13 = i8 + i11;
                while (i8 < i13) {
                    fVar.writeInt(iVar.x(i8) & 255);
                    i8++;
                }
                if (i5 + 1 == i4) {
                    if (!(i13 == list.get(i5).P())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    fVar.writeInt(list2.get(i5).intValue());
                    return;
                } else {
                    f fVar2 = new f();
                    fVar.writeInt(((int) (c(fVar2) + jC)) * (-1));
                    a(jC, fVar2, i13, list, i5, i4, list2);
                    fVar.B0(fVar2);
                    return;
                }
            }
            int i14 = 1;
            for (int i15 = i5 + 1; i15 < i4; i15++) {
                if (list.get(i15 - 1).x(i8) != list.get(i15).x(i8)) {
                    i14++;
                }
            }
            long jC2 = j2 + c(fVar) + ((long) 2) + ((long) (i14 * 2));
            fVar.writeInt(i14);
            fVar.writeInt(i6);
            for (int i16 = i5; i16 < i4; i16++) {
                byte bX = list.get(i16).x(i8);
                if (i16 == i5 || bX != list.get(i16 - 1).x(i8)) {
                    fVar.writeInt(bX & 255);
                }
            }
            f fVar3 = new f();
            while (i5 < i4) {
                byte bX2 = list.get(i5).x(i8);
                int i17 = i5 + 1;
                int i18 = i17;
                while (true) {
                    if (i18 >= i4) {
                        i7 = i4;
                        break;
                    } else {
                        if (bX2 != list.get(i18).x(i8)) {
                            i7 = i18;
                            break;
                        }
                        i18++;
                    }
                }
                if (i17 == i7 && i8 + 1 == list.get(i5).P()) {
                    fVar.writeInt(list2.get(i5).intValue());
                } else {
                    fVar.writeInt(((int) (jC2 + c(fVar3))) * (-1));
                    a(jC2, fVar3, i8 + 1, list, i5, i7, list2);
                }
                fVar3 = fVar3;
                i5 = i7;
            }
            fVar.B0(fVar3);
        }

        static /* synthetic */ void b(a aVar, long j2, f fVar, int i2, List list, int i3, int i4, List list2, int i5, Object obj) throws IOException {
            aVar.a((i5 & 1) != 0 ? 0L : j2, fVar, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long c(f fVar) {
            return fVar.size() / ((long) 4);
        }

        public final t d(i... iVarArr) throws IOException {
            kotlin.jvm.internal.m.f(iVarArr, "byteStrings");
            int i2 = 0;
            kotlin.jvm.internal.g gVar = null;
            if (iVarArr.length == 0) {
                return new t(new i[0], new int[]{0, -1}, gVar);
            }
            List listI0 = kotlin.collections.n.i0(iVarArr);
            kotlin.collections.y.x(listI0);
            ArrayList arrayList = new ArrayList(iVarArr.length);
            for (i iVar : iVarArr) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List listP = kotlin.collections.u.p((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = iVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                listP.set(kotlin.collections.u.i(listI0, iVarArr[i3], 0, 0, 6, null), Integer.valueOf(i4));
                i3++;
                i4++;
            }
            if (!(((i) listI0.get(0)).P() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i5 = 0;
            while (i5 < listI0.size()) {
                i iVar2 = (i) listI0.get(i5);
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < listI0.size()) {
                    i iVar3 = (i) listI0.get(i7);
                    if (!iVar3.Q(iVar2)) {
                        break;
                    }
                    if (!(iVar3.P() != iVar2.P())) {
                        throw new IllegalArgumentException(("duplicate option: " + iVar3).toString());
                    }
                    if (((Number) listP.get(i7)).intValue() > ((Number) listP.get(i5)).intValue()) {
                        listI0.remove(i7);
                        listP.remove(i7);
                    } else {
                        i7++;
                    }
                }
                i5 = i6;
            }
            f fVar = new f();
            b(this, 0L, fVar, 0, listI0, 0, 0, listP, 53, null);
            int[] iArr = new int[(int) c(fVar)];
            while (!fVar.R()) {
                iArr[i2] = fVar.readInt();
                i2++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(iVarArr, iVarArr.length);
            kotlin.jvm.internal.m.e(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new t((i[]) objArrCopyOf, iArr, gVar);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public /* synthetic */ t(i[] iVarArr, int[] iArr, kotlin.jvm.internal.g gVar) {
        this(iVarArr, iArr);
    }

    public static final t r(i... iVarArr) {
        return f22860g.d(iVarArr);
    }

    @Override // kotlin.collections.AbstractCollection
    /* JADX INFO: renamed from: c */
    public int getF25541i() {
        return this.f22861h.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof i) {
            return f((i) obj);
        }
        return false;
    }

    public /* bridge */ boolean f(i iVar) {
        return super.contains(iVar);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public i get(int i2) {
        return this.f22861h[i2];
    }

    public final i[] i() {
        return this.f22861h;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof i) {
            return o((i) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof i) {
            return q((i) obj);
        }
        return -1;
    }

    public final int[] n() {
        return this.f22862i;
    }

    public /* bridge */ int o(i iVar) {
        return super.indexOf(iVar);
    }

    public /* bridge */ int q(i iVar) {
        return super.lastIndexOf(iVar);
    }

    private t(i[] iVarArr, int[] iArr) {
        this.f22861h = iVarArr;
        this.f22862i = iArr;
    }
}
