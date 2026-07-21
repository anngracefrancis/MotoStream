package e.h.a.k0;

import android.annotation.SuppressLint;
import android.content.Context;
import com.liulishuo.filedownloader.exception.PathConflictException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.y;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: FileDownloadHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context a;

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface a {
        int a(int i2, String str, String str2, long j2);
    }

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface b {
        e.h.a.e0.b a(String str) throws IOException;
    }

    /* JADX INFO: renamed from: e.h.a.k0.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface InterfaceC0281c {
        e.h.a.f0.a a();
    }

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface d {
        int a(String str, String str2, boolean z);

        int b(int i2, String str, String str2, boolean z);
    }

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface e {
        e.h.a.j0.a a(File file) throws IOException;

        boolean b();
    }

    public static Context a() {
        return a;
    }

    public static void b(Context context) {
        a = context;
    }

    public static boolean c(int i2, long j2, String str, String str2, y yVar) {
        int iB;
        if (str2 == null || str == null || (iB = yVar.b(str, i2)) == 0) {
            return false;
        }
        com.liulishuo.filedownloader.message.b.a().b(com.liulishuo.filedownloader.message.c.b(i2, j2, new PathConflictException(iB, str, str2)));
        return true;
    }

    public static boolean d(int i2, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.liulishuo.filedownloader.message.b.a().b(com.liulishuo.filedownloader.message.c.a(i2, file, z2));
                return true;
            }
        }
        return false;
    }

    public static boolean e(int i2, FileDownloadModel fileDownloadModel, y yVar, boolean z) {
        if (!yVar.a(fileDownloadModel)) {
            return false;
        }
        com.liulishuo.filedownloader.message.b.a().b(com.liulishuo.filedownloader.message.c.d(i2, fileDownloadModel.g(), fileDownloadModel.k(), z));
        return true;
    }
}
