package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: compiled from: OpReorderer.java */
/* JADX INFO: loaded from: classes.dex */
class m {
    final a a;

    /* JADX INFO: compiled from: OpReorderer.java */
    interface a {
        void a(androidx.recyclerview.widget.a.b bVar);

        androidx.recyclerview.widget.a.b b(int i2, int i3, int i4, Object obj);
    }

    m(a aVar) {
        this.a = aVar;
    }

    private int a(List<androidx.recyclerview.widget.a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<androidx.recyclerview.widget.a.b> list, int i2, androidx.recyclerview.widget.a.b bVar, int i3, androidx.recyclerview.widget.a.b bVar2) {
        int i4 = bVar.f2008d;
        int i5 = bVar2.f2006b;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = bVar.f2006b;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            bVar.f2006b = i7 + bVar2.f2008d;
        }
        int i8 = bVar2.f2006b;
        if (i8 <= i4) {
            bVar.f2008d = i4 + bVar2.f2008d;
        }
        bVar2.f2006b = i8 + i6;
        list.set(i2, bVar2);
        list.set(i3, bVar);
    }

    private void d(List<androidx.recyclerview.widget.a.b> list, int i2, int i3) {
        androidx.recyclerview.widget.a.b bVar = list.get(i2);
        androidx.recyclerview.widget.a.b bVar2 = list.get(i3);
        int i4 = bVar2.a;
        if (i4 == 1) {
            c(list, i2, bVar, i3, bVar2);
        } else if (i4 == 2) {
            e(list, i2, bVar, i3, bVar2);
        } else {
            if (i4 != 4) {
                return;
            }
            f(list, i2, bVar, i3, bVar2);
        }
    }

    void b(List<androidx.recyclerview.widget.a.b> list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    void e(List<androidx.recyclerview.widget.a.b> list, int i2, androidx.recyclerview.widget.a.b bVar, int i3, androidx.recyclerview.widget.a.b bVar2) {
        boolean z;
        int i4 = bVar.f2006b;
        int i5 = bVar.f2008d;
        boolean z2 = false;
        if (i4 < i5) {
            if (bVar2.f2006b == i4 && bVar2.f2008d == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.f2006b == i5 + 1 && bVar2.f2008d == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = bVar2.f2006b;
        if (i5 < i6) {
            bVar2.f2006b = i6 - 1;
        } else {
            int i7 = bVar2.f2008d;
            if (i5 < i6 + i7) {
                bVar2.f2008d = i7 - 1;
                bVar.a = 2;
                bVar.f2008d = 1;
                if (bVar2.f2008d == 0) {
                    list.remove(i3);
                    this.a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i8 = bVar.f2006b;
        int i9 = bVar2.f2006b;
        androidx.recyclerview.widget.a.b bVarB = null;
        if (i8 <= i9) {
            bVar2.f2006b = i9 + 1;
        } else {
            int i10 = bVar2.f2008d;
            if (i8 < i9 + i10) {
                bVarB = this.a.b(2, i8 + 1, (i9 + i10) - i8, null);
                bVar2.f2008d = bVar.f2006b - bVar2.f2006b;
            }
        }
        if (z2) {
            list.set(i2, bVar2);
            list.remove(i3);
            this.a.a(bVar);
            return;
        }
        if (z) {
            if (bVarB != null) {
                int i11 = bVar.f2006b;
                if (i11 > bVarB.f2006b) {
                    bVar.f2006b = i11 - bVarB.f2008d;
                }
                int i12 = bVar.f2008d;
                if (i12 > bVarB.f2006b) {
                    bVar.f2008d = i12 - bVarB.f2008d;
                }
            }
            int i13 = bVar.f2006b;
            if (i13 > bVar2.f2006b) {
                bVar.f2006b = i13 - bVar2.f2008d;
            }
            int i14 = bVar.f2008d;
            if (i14 > bVar2.f2006b) {
                bVar.f2008d = i14 - bVar2.f2008d;
            }
        } else {
            if (bVarB != null) {
                int i15 = bVar.f2006b;
                if (i15 >= bVarB.f2006b) {
                    bVar.f2006b = i15 - bVarB.f2008d;
                }
                int i16 = bVar.f2008d;
                if (i16 >= bVarB.f2006b) {
                    bVar.f2008d = i16 - bVarB.f2008d;
                }
            }
            int i17 = bVar.f2006b;
            if (i17 >= bVar2.f2006b) {
                bVar.f2006b = i17 - bVar2.f2008d;
            }
            int i18 = bVar.f2008d;
            if (i18 >= bVar2.f2006b) {
                bVar.f2008d = i18 - bVar2.f2008d;
            }
        }
        list.set(i2, bVar2);
        if (bVar.f2006b != bVar.f2008d) {
            list.set(i3, bVar);
        } else {
            list.remove(i3);
        }
        if (bVarB != null) {
            list.add(i2, bVarB);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    void f(List<androidx.recyclerview.widget.a.b> list, int i2, androidx.recyclerview.widget.a.b bVar, int i3, androidx.recyclerview.widget.a.b bVar2) {
        androidx.recyclerview.widget.a.b bVarB;
        int i4;
        int i5;
        int i6;
        int i7 = bVar.f2008d;
        int i8 = bVar2.f2006b;
        androidx.recyclerview.widget.a.b bVarB2 = null;
        if (i7 >= i8) {
            int i9 = bVar2.f2008d;
            if (i7 < i8 + i9) {
                bVar2.f2008d = i9 - 1;
                bVarB = this.a.b(4, bVar.f2006b, 1, bVar2.f2007c);
            }
            i4 = bVar.f2006b;
            i5 = bVar2.f2006b;
            if (i4 <= i5) {
                bVar2.f2006b = i5 + 1;
            } else {
                i6 = bVar2.f2008d;
                if (i4 < i5 + i6) {
                    int i10 = (i5 + i6) - i4;
                    bVarB2 = this.a.b(4, i4 + 1, i10, bVar2.f2007c);
                    bVar2.f2008d -= i10;
                }
            }
            list.set(i3, bVar);
            if (bVar2.f2008d > 0) {
                list.set(i2, bVar2);
            } else {
                list.remove(i2);
                this.a.a(bVar2);
            }
            if (bVarB != null) {
                list.add(i2, bVarB);
            }
            if (bVarB2 != null) {
                list.add(i2, bVarB2);
            }
        }
        bVar2.f2006b = i8 - 1;
        bVarB = null;
        i4 = bVar.f2006b;
        i5 = bVar2.f2006b;
        if (i4 <= i5) {
            bVar2.f2006b = i5 + 1;
        } else {
            i6 = bVar2.f2008d;
            if (i4 < i5 + i6) {
                int i11 = (i5 + i6) - i4;
                bVarB2 = this.a.b(4, i4 + 1, i11, bVar2.f2007c);
                bVar2.f2008d -= i11;
            }
        }
        list.set(i3, bVar);
        if (bVar2.f2008d > 0) {
            list.set(i2, bVar2);
        } else {
            list.remove(i2);
            this.a.a(bVar2);
        }
        if (bVarB != null) {
            list.add(i2, bVarB);
        }
        if (bVarB2 != null) {
            list.add(i2, bVarB2);
        }
    }
}
