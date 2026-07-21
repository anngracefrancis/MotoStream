package com.flurry.sdk;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class w2 extends c3 {
    protected p3 s;
    protected x6 t;

    final class a extends f2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ u6 f11119h;

        /* JADX INFO: renamed from: com.flurry.sdk.w2$a$a, reason: collision with other inner class name */
        final class C0168a implements p3.a {
            C0168a() {
            }

            @Override // com.flurry.sdk.p3.a
            public final void a() {
                w2.this.p = c3.c.f10671h;
                w2.this.s.d();
                w2.this.p = c3.c.f10672i;
                w2.this.v();
            }
        }

        a(u6 u6Var) {
            this.f11119h = u6Var;
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            if (!w2.this.s.c()) {
                if (w2.this.y("currentFile")) {
                    d1.c(4, "FileWriterModule", "File created. Adding counter");
                    w2.this.s.f(t5.h(), null);
                } else {
                    d1.c(4, "FileWriterModule", "File creation failed.");
                }
            }
            if (this.f11119h.a().equals(s6.FLUSH_FRAME)) {
                w2.this.p = c3.c.f10671h;
                d1.c(4, "FileWriterModule", "Adding flush frame:" + this.f11119h.d());
                w2.this.s.f(this.f11119h, new C0168a());
                return;
            }
            d1.c(4, "FileWriterModule", "Adding frame " + this.f11119h.a() + ": " + this.f11119h.d());
            w2.this.s.f(this.f11119h, null);
        }
    }

    w2() {
        super("FileWriterModule", null);
        this.s = null;
        this.t = null;
        this.s = new m3();
        this.t = new x6();
    }

    private static String A() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null || i2 >= 1000 || sb.length() + line.length() > 524288) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
                i2++;
            }
            d1.c(4, "FileWriterModule", "Get Logcat lines: ".concat(String.valueOf(i2)));
            return sb.toString();
        } catch (IOException unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(String str) {
        if (this.s.c()) {
            d1.c(6, "FileWriterModule", "File was open, closing now.");
            this.s.a();
        }
        return this.s.i(q2.e(), str);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ca  */
    private static t3 z() {
        String[] list;
        boolean z;
        String str;
        long j2;
        List<m7> list2;
        d1.c(4, "FileWriterModule", "Start getting native crash entity.");
        File fileStreamPath = b0.a().getFileStreamPath(".yflurrynativecrash");
        Pattern patternCompile = Pattern.compile(io.sentry.x4.DEFAULT_PROPAGATION_TARGETS + Pattern.quote(".dmp") + "$");
        char c2 = 0;
        if (fileStreamPath.exists()) {
            list = fileStreamPath.list(new q2.a(patternCompile));
            if (list == null) {
                list = new String[0];
            }
        } else {
            list = new String[0];
        }
        String str2 = null;
        if (list.length == 0) {
            return null;
        }
        int length = list.length;
        t3 t3Var = null;
        int i2 = 0;
        while (i2 < length) {
            String str3 = list[i2];
            d1.l("FileWriterModule", "Native crash occurred in previous session! Found minidump file - ".concat(String.valueOf(str3)));
            String[] strArrC = b2.c(fileStreamPath, Pattern.compile(io.sentry.x4.DEFAULT_PROPAGATION_TARGETS + Pattern.quote(str3 + ".fcb") + io.sentry.x4.DEFAULT_PROPAGATION_TARGETS));
            String str4 = strArrC.length > 0 ? strArrC[c2] : str2;
            boolean z2 = true;
            if (TextUtils.isEmpty(str4)) {
                d1.c(4, "FileWriterModule", "There was no breadcrumbs file associated with the minidump file.");
                z = true;
            } else {
                z = false;
            }
            d1.c(4, "FileWriterModule", "Breadcrumbs file associated with minidump file - ".concat(String.valueOf(str4)));
            if (!TextUtils.isEmpty(str4)) {
                String[] strArrSplit = str4.split("\\.");
                str2 = strArrSplit.length != 5 ? null : strArrSplit[3];
            }
            if (TextUtils.isEmpty(str4)) {
                str = null;
            } else {
                String[] strArrSplit2 = str4.split("\\.");
                if (strArrSplit2.length != 5) {
                    str = null;
                } else {
                    str = strArrSplit2[4];
                }
            }
            if (TextUtils.isEmpty(str2)) {
                d1.c(4, "FileWriterModule", "There is no session id specified with crash breadcrumbs file: ".concat(String.valueOf(str4)));
                z = true;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                Long.parseLong(str2);
                j2 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                d1.c(4, "FileWriterModule", "Issue parsing session id into start time: ".concat(String.valueOf(str2)));
                j2 = jCurrentTimeMillis;
                z = true;
            }
            File file = new File(fileStreamPath, str4);
            if (file.exists()) {
                List<m7> listB = new n7(file).b();
                d1.c(4, "FileWriterModule", "Number of crash breadcrumbs - " + listB.size());
                file.delete();
                list2 = listB;
                z2 = z;
            } else {
                d1.c(4, "FileWriterModule", "Breadcrumbs file does not exist.");
                list2 = null;
            }
            String str5 = p7.NATIVE_CRASH.f11009i;
            File file2 = new File(fileStreamPath, str3);
            if (!file2.exists()) {
                d1.c(4, "FileWriterModule", "Minidump file doesn't exist.");
            } else if (z2) {
                d1.c(4, "FileWriterModule", "Some error occurred with minidump file. Deleting it.");
                file2.delete();
            } else {
                String strF = b2.f(file2);
                file2.delete();
                String strA = A();
                d1.c(4, "FileWriterModule", "Logcat size: " + strA.length());
                t3Var = new t3(s3.k().incrementAndGet(), str5, j2, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, s3.a.UNRECOVERABLE_CRASH.f11043j, s3.b.NATIVE_CRASH_ATTACHED.f11048j, null, null, n7.c(), list2, strF, strA);
            }
            i2++;
            c2 = 0;
            str2 = null;
        }
        d1.c(4, "FileWriterModule", "Finished getting native crash entity.");
        return t3Var;
    }

    @Override // com.flurry.sdk.c3
    public final void b(u6 u6Var) {
        if (this.p != c3.c.f10671h) {
            m(new a(u6Var));
            return;
        }
        this.q.add(u6Var);
        d1.c(4, "FileWriterModule", "In paused state, cannot process message now. " + u6Var.a());
    }

    @Override // com.flurry.sdk.c3, com.flurry.sdk.x2
    public final x2.a c(u6 u6Var) {
        m3 m3Var = new m3();
        if (m3Var.i(q2.e(), "crashFile")) {
            m3Var.b(u6Var);
            m3Var.a();
        } else {
            d1.c(4, "FileWriterModule", "Can't create crash file. Cannot write crash frame to disc");
        }
        return x2.a.QUEUED;
    }

    @Override // com.flurry.sdk.c3
    public final void t() {
        q2.a();
        File file = new File(q2.e());
        if (!file.exists()) {
            file.mkdirs();
        }
        q2.a();
        File file2 = new File(q2.c());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        t3 t3VarZ = z();
        s3 s3VarI = t3VarZ != null ? s3.i(t3VarZ) : null;
        StringBuilder sb = new StringBuilder();
        sb.append(q2.e());
        String str = File.separator;
        sb.append(str);
        sb.append("currentFile");
        if (q2.d(sb.toString())) {
            if (q2.d(q2.e() + str + "crashFile")) {
                w6 w6Var = new w6(q2.e(), "currentFile");
                w6 w6Var2 = new w6(q2.e(), "crashFile");
                if (r2.a(w6Var, w6Var2) && r2.b(w6Var.a, w6Var.f11133b, w6Var2.a, w6Var2.f11133b) && x6.d(w6Var, w6Var2)) {
                    x6.a(w6Var2);
                }
                x6.a(w6Var2);
            }
            this.s.d();
        }
        if (y("currentFile")) {
            this.s.f(t5.h(), null);
            if (s3VarI != null) {
                this.s.b(s3VarI);
            }
        }
    }
}
