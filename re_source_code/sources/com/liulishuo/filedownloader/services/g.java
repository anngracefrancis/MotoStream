package com.liulishuo.filedownloader.services;

import android.text.TextUtils;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.b0;
import e.h.a.y;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadManager.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements y {
    private final e.h.a.f0.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f20524b;

    g() {
        e.h.a.g0.c cVarJ = e.h.a.g0.c.j();
        this.a = cVarJ.f();
        this.f20524b = new h(cVarJ.k());
    }

    @Override // e.h.a.y
    public boolean a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean zG = this.f20524b.g(fileDownloadModel.e());
        if (com.liulishuo.filedownloader.model.b.e(fileDownloadModel.h())) {
            if (!zG) {
                return false;
            }
        } else if (!zG) {
            e.h.a.k0.d.b(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.e()), Byte.valueOf(fileDownloadModel.h()));
            return false;
        }
        return true;
    }

    @Override // e.h.a.y
    public int b(String str, int i2) {
        return this.f20524b.e(str, i2);
    }

    public void c() {
        this.a.clear();
    }

    public boolean d(int i2) {
        if (i2 == 0) {
            e.h.a.k0.d.i(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        if (h(i2)) {
            e.h.a.k0.d.i(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        }
        this.a.remove(i2);
        this.a.h(i2);
        return true;
    }

    public long e(int i2) {
        FileDownloadModel fileDownloadModelO = this.a.o(i2);
        if (fileDownloadModelO == null) {
            return 0L;
        }
        int iA = fileDownloadModelO.a();
        if (iA <= 1) {
            return fileDownloadModelO.g();
        }
        List<com.liulishuo.filedownloader.model.a> listN = this.a.n(i2);
        if (listN == null || listN.size() != iA) {
            return 0L;
        }
        return com.liulishuo.filedownloader.model.a.f(listN);
    }

    public byte f(int i2) {
        FileDownloadModel fileDownloadModelO = this.a.o(i2);
        if (fileDownloadModelO == null) {
            return (byte) 0;
        }
        return fileDownloadModelO.h();
    }

    public long g(int i2) {
        FileDownloadModel fileDownloadModelO = this.a.o(i2);
        if (fileDownloadModelO == null) {
            return 0L;
        }
        return fileDownloadModelO.k();
    }

    public boolean h(int i2) {
        return a(this.a.o(i2));
    }

    public boolean i(String str, String str2) {
        return h(e.h.a.k0.f.r(str, str2));
    }

    public boolean j() {
        return this.f20524b.b() <= 0;
    }

    public boolean k(int i2) {
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "request pause the task %d", Integer.valueOf(i2));
        }
        FileDownloadModel fileDownloadModelO = this.a.o(i2);
        if (fileDownloadModelO == null) {
            return false;
        }
        fileDownloadModelO.y((byte) -2);
        this.f20524b.a(i2);
        return true;
    }

    public void l() {
        List<Integer> listF = this.f20524b.f();
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "pause all tasks %d", Integer.valueOf(listF.size()));
        }
        Iterator<Integer> it = listF.iterator();
        while (it.hasNext()) {
            k(it.next().intValue());
        }
    }

    public synchronized boolean m(int i2) {
        return this.f20524b.h(i2);
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0184 A[Catch: all -> 0x01cf, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0034, B:12:0x0044, B:14:0x004e, B:16:0x0052, B:17:0x0065, B:21:0x0072, B:23:0x0078, B:25:0x007c, B:29:0x008d, B:31:0x0096, B:33:0x009f, B:35:0x00a3, B:40:0x00b6, B:43:0x00bf, B:45:0x00c8, B:47:0x00d7, B:49:0x00db, B:51:0x00ec, B:55:0x00fa, B:57:0x0101, B:59:0x0108, B:61:0x010e, B:63:0x0115, B:65:0x011b, B:67:0x0121, B:69:0x013b, B:70:0x013f, B:72:0x0145, B:81:0x0184, B:82:0x0189, B:73:0x0154, B:75:0x015e, B:77:0x0164, B:78:0x016a, B:44:0x00c4, B:30:0x0092), top: B:90:0x0009 }] */
    public synchronized void n(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3) {
        FileDownloadModel fileDownloadModel;
        List<com.liulishuo.filedownloader.model.a> listN;
        boolean z4 = false;
        if (e.h.a.k0.d.a) {
            e.h.a.k0.d.a(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
        }
        b0.a();
        int iS = e.h.a.k0.f.s(str, str2, z);
        FileDownloadModel fileDownloadModelO = this.a.o(iS);
        if (z || fileDownloadModelO != null) {
            fileDownloadModel = fileDownloadModelO;
            listN = null;
        } else {
            int iS2 = e.h.a.k0.f.s(str, e.h.a.k0.f.A(str2), true);
            FileDownloadModel fileDownloadModelO2 = this.a.o(iS2);
            if (fileDownloadModelO2 == null || !str2.equals(fileDownloadModelO2.i())) {
                listN = null;
            } else {
                if (e.h.a.k0.d.a) {
                    e.h.a.k0.d.a(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(iS), Integer.valueOf(iS2));
                }
                listN = this.a.n(iS2);
            }
            fileDownloadModel = fileDownloadModelO2;
        }
        if (e.h.a.k0.c.e(iS, fileDownloadModel, this, true)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "has already started download %d", Integer.valueOf(iS));
            }
            return;
        }
        String strI = fileDownloadModel != null ? fileDownloadModel.i() : e.h.a.k0.f.B(str2, z, null);
        if (e.h.a.k0.c.d(iS, strI, z2, true)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "has already completed downloading %d", Integer.valueOf(iS));
            }
            return;
        }
        if (e.h.a.k0.c.c(iS, fileDownloadModel != null ? fileDownloadModel.g() : 0L, fileDownloadModel != null ? fileDownloadModel.j() : e.h.a.k0.f.C(strI), strI, this)) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(iS), strI);
            }
            if (fileDownloadModel != null) {
                this.a.remove(iS);
                this.a.h(iS);
            }
            return;
        }
        if (fileDownloadModel == null || !(fileDownloadModel.h() == -2 || fileDownloadModel.h() == -1 || fileDownloadModel.h() == 1 || fileDownloadModel.h() == 6 || fileDownloadModel.h() == 2)) {
            if (fileDownloadModel == null) {
                fileDownloadModel = new FileDownloadModel();
            }
            fileDownloadModel.B(str);
            fileDownloadModel.w(str2, z);
            fileDownloadModel.v(iS);
            fileDownloadModel.x(0L);
            fileDownloadModel.z(0L);
            fileDownloadModel.y((byte) 1);
            fileDownloadModel.r(1);
        } else {
            if (fileDownloadModel.e() == iS) {
                if (!TextUtils.equals(str, fileDownloadModel.l())) {
                    fileDownloadModel.B(str);
                }
                if (z4) {
                    this.a.j(fileDownloadModel);
                }
                this.f20524b.c(new e.h.a.g0.d.b().g(fileDownloadModel).d(fileDownloadHeader).h(this).f(Integer.valueOf(i3)).b(Integer.valueOf(i2)).c(Boolean.valueOf(z2)).i(Boolean.valueOf(z3)).e(Integer.valueOf(i4)).a());
            }
            this.a.remove(fileDownloadModel.e());
            this.a.h(fileDownloadModel.e());
            fileDownloadModel.v(iS);
            fileDownloadModel.w(str2, z);
            if (listN != null) {
                for (com.liulishuo.filedownloader.model.a aVar : listN) {
                    aVar.i(iS);
                    this.a.g(aVar);
                }
            }
        }
        z4 = true;
        if (z4) {
            this.a.j(fileDownloadModel);
        }
        this.f20524b.c(new e.h.a.g0.d.b().g(fileDownloadModel).d(fileDownloadHeader).h(this).f(Integer.valueOf(i3)).b(Integer.valueOf(i2)).c(Boolean.valueOf(z2)).i(Boolean.valueOf(z3)).e(Integer.valueOf(i4)).a());
    }
}
