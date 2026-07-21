package com.google.firebase.crashlytics.internal.r;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.google.firebase.crashlytics.internal.h;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: FileStore.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f19516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f19517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f19518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f19519f;

    public f(Context context) {
        String str;
        File filesDir = context.getFilesDir();
        this.a = filesDir;
        if (v()) {
            str = ".com.google.firebase.crashlytics.files.v2" + File.pathSeparator + u(Application.getProcessName());
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File fileQ = q(new File(filesDir, str));
        this.f19515b = fileQ;
        this.f19516c = q(new File(fileQ, "open-sessions"));
        this.f19517d = q(new File(fileQ, "reports"));
        this.f19518e = q(new File(fileQ, "priority-reports"));
        this.f19519f = q(new File(fileQ, "native-reports"));
    }

    private void a(File file) {
        if (file.exists() && s(file)) {
            h.f().b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private File n(String str) {
        return r(new File(this.f19516c, str));
    }

    private static synchronized File q(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                return file;
            }
            h.f().b("Unexpected non-directory file: " + file + "; deleting file and creating new directory.");
            file.delete();
        }
        if (!file.mkdirs()) {
            h.f().d("Could not create Crashlytics-specific directory: " + file);
        }
        return file;
    }

    private static File r(File file) {
        file.mkdirs();
        return file;
    }

    static boolean s(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                s(file2);
            }
        }
        return file.delete();
    }

    private static <T> List<T> t(T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    static String u(String str) {
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static boolean v() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public void b() {
        a(new File(this.a, ".com.google.firebase.crashlytics"));
        a(new File(this.a, ".com.google.firebase.crashlytics-ndk"));
        if (v()) {
            a(new File(this.a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }

    public boolean c(String str) {
        return s(new File(this.f19516c, str));
    }

    public List<String> d() {
        return t(this.f19516c.list());
    }

    public File e(String str) {
        return new File(this.f19515b, str);
    }

    public List<File> f(FilenameFilter filenameFilter) {
        return t(this.f19515b.listFiles(filenameFilter));
    }

    public File g(String str) {
        return new File(this.f19519f, str);
    }

    public List<File> h() {
        return t(this.f19519f.listFiles());
    }

    public File i(String str) {
        return r(new File(n(str), "native"));
    }

    public File j(String str) {
        return new File(this.f19518e, str);
    }

    public List<File> k() {
        return t(this.f19518e.listFiles());
    }

    public File l(String str) {
        return new File(this.f19517d, str);
    }

    public List<File> m() {
        return t(this.f19517d.listFiles());
    }

    public File o(String str, String str2) {
        return new File(n(str), str2);
    }

    public List<File> p(String str, FilenameFilter filenameFilter) {
        return t(n(str).listFiles(filenameFilter));
    }
}
