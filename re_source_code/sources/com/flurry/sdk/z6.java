package com.flurry.sdk;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class z6 extends l2 implements y6 {
    public a7 o;
    public v6 p;

    public class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ y6 f11164h;

        public a(y6 y6Var) {
            this.f11164h = y6Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            z6.this.o = new a7(q2.c(), this.f11164h);
            z6.this.o.startWatching();
        }
    }

    final class b extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f11166h;

        b(List list) {
            this.f11166h = list;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            d1.c(2, "VNodeFileProcessor", "Number of files already pending: in VNodeListener " + this.f11166h.size());
            ArrayList arrayList = new ArrayList();
            for (File file : this.f11166h) {
                if (file.exists()) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
            if (z6.this.p != null) {
                z6.this.p.e(arrayList);
            }
        }
    }

    public z6(v6 v6Var) {
        super("VNodeFileProcessor", i2.a(i2.b.DATA_PROCESSOR));
        this.o = null;
        this.p = v6Var;
    }

    public final void e(List<File> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        m(new b(list));
    }

    @Override // com.flurry.sdk.y6
    public final void h(String str) {
        File file = new File(q2.c() + File.separator + str);
        if (file.exists()) {
            e(Arrays.asList(file));
        }
    }
}
