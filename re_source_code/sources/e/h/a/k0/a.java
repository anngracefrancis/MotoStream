package e.h.a.k0;

/* JADX INFO: compiled from: DownloadServiceNotConnectedHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(int i2) {
        c("request clear the task[%d] data in the database", Integer.valueOf(i2));
        return false;
    }

    public static byte b(int i2) {
        c("request get the status for the task[%d] in the download service", Integer.valueOf(i2));
        return (byte) 0;
    }

    private static void c(String str, Object... objArr) {
        d.i(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your code invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean d(int i2) {
        c("request pause the task[%d] in the download service", Integer.valueOf(i2));
        return false;
    }

    public static boolean e(String str, String str2, boolean z) {
        c("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }

    public static void f(boolean z) {
        c("request cancel the foreground status[%B] for the download service", Boolean.valueOf(z));
    }
}
