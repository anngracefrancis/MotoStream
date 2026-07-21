package e.h.a.k0;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FileDownloadUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static int a = 65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f21371b = 2000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f21372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f21373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f21374e = Pattern.compile("attachment;\\s*filename\\*\\s*=\\s*\"*([^\"]*)'\\S*'([^\"]*)\"*");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f21375f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"*([^\"\\n]*)\"*");

    public static String A(String str) {
        int length = str.length();
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        int i3 = (iLastIndexOf != -1 || i2 <= 0) ? iLastIndexOf : 2;
        if (i3 == -1) {
            return null;
        }
        char cCharAt = str.charAt(length - 1);
        char c2 = File.separatorChar;
        if (cCharAt == c2) {
            return null;
        }
        return (str.indexOf(c2) == i3 && str.charAt(i2) == File.separatorChar) ? str.substring(0, i3 + 1) : str.substring(0, i3);
    }

    public static String B(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return q(str, str2);
    }

    public static String C(String str) {
        return o("%s.temp", str);
    }

    public static String D(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean E(int i2, e.h.a.e0.b bVar) {
        if (i2 == 206 || i2 == 1) {
            return true;
        }
        return "bytes".equals(bVar.e("Accept-Ranges"));
    }

    private static boolean F(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            if (!powerManager.isInteractive()) {
                return false;
            }
        } else if (!powerManager.isScreenOn()) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean G(int i2, FileDownloadModel fileDownloadModel) {
        return H(i2, fileDownloadModel, null);
    }

    public static boolean H(int i2, FileDownloadModel fileDownloadModel, Boolean bool) {
        if (fileDownloadModel == null) {
            if (d.a) {
                d.a(f.class, "can't continue %d model == null", Integer.valueOf(i2));
            }
            return false;
        }
        if (fileDownloadModel.j() != null) {
            return I(i2, fileDownloadModel, fileDownloadModel.j(), bool);
        }
        if (d.a) {
            d.a(f.class, "can't continue %d temp path == null", Integer.valueOf(i2));
        }
        return false;
    }

    public static boolean I(int i2, FileDownloadModel fileDownloadModel, String str, Boolean bool) {
        if (str == null) {
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d path = null", Integer.valueOf(i2));
            return false;
        }
        File file = new File(str);
        boolean zExists = file.exists();
        boolean zIsDirectory = file.isDirectory();
        if (!zExists || zIsDirectory) {
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i2), Boolean.valueOf(zExists), Boolean.valueOf(zIsDirectory));
            return false;
        }
        long length = file.length();
        long jG = fileDownloadModel.g();
        if (fileDownloadModel.a() <= 1 && jG == 0) {
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i2));
            return false;
        }
        long jK = fileDownloadModel.k();
        if (length < jG || (jK != -1 && (length > jK || jG >= jK))) {
            if (!d.a) {
                return false;
            }
            d.a(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i2), Long.valueOf(length), Long.valueOf(jG), Long.valueOf(jK));
            return false;
        }
        if (bool == null || bool.booleanValue() || jK != length) {
            return true;
        }
        if (!d.a) {
            return false;
        }
        d.a(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i2));
        return false;
    }

    public static boolean J(Context context) {
        Boolean bool = f21373d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zEndsWith = false;
        if (!e.a().f21366d) {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                d.i(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                d.i(f.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    zEndsWith = runningAppProcessInfo.processName.endsWith(":filedownloader");
                    break;
                }
            }
        } else {
            zEndsWith = true;
        }
        Boolean boolValueOf = Boolean.valueOf(zEndsWith);
        f21373d = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public static boolean K(String str) {
        return true;
    }

    public static boolean L(long j2, long j3) {
        return j2 > ((long) y()) && j3 > z();
    }

    public static boolean M() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.i(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static void N(Context context) {
        File fileU = u(context);
        try {
            fileU.getParentFile().mkdirs();
            fileU.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String O(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    public static boolean P(Context context) {
        return Build.VERSION.SDK_INT >= 26 && !F(context);
    }

    public static String Q(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = f21374e.matcher(str);
            if (matcher.find()) {
                return URLDecoder.decode(matcher.group(2), matcher.group(1));
            }
            Matcher matcher2 = f21375f.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (UnsupportedEncodingException | IllegalStateException unused) {
        }
    }

    public static long R(String str) {
        if (str != null && str.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                d.c(f.class, e2, "parse content length from content range error", new Object[0]);
            }
        }
        return -1L;
    }

    public static long S(String str) {
        if (str == null) {
            return -1L;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length >= 2) {
            try {
                return Long.parseLong(strArrSplit[1]);
            } catch (NumberFormatException unused) {
                d.i(f.class, "parse instance length failed with %s", str);
            }
        }
        return -1L;
    }

    public static void T(int i2) throws IllegalAccessException {
        if (!J(c.a())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        a = i2;
    }

    public static void U(long j2) throws IllegalAccessException {
        if (!J(c.a())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        f21371b = j2;
    }

    public static boolean a(String str) {
        return c.a().checkCallingOrSelfPermission(str) == 0;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static e.h.a.j0.a c(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        if (!K(str)) {
            throw new RuntimeException(o("found invalid internal destination filename %s", str));
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            throw new RuntimeException(o("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
        }
        if (file.exists() || file.createNewFile()) {
            return e.h.a.g0.c.j().b(file);
        }
        throw new IOException(o("create new file error  %s", file.getAbsolutePath()));
    }

    public static String d() {
        return o("FileDownloader/%s", "1.7.7");
    }

    public static void e(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void f(String str, String str2) {
        g(str2);
        e(str);
    }

    public static void g(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static long h(int i2, e.h.a.e0.b bVar) {
        long jB = b(bVar.e("Content-Length"));
        String strE = bVar.e("Transfer-Encoding");
        if (jB >= 0) {
            return jB;
        }
        if (!(strE != null && strE.equals("chunked"))) {
            if (!e.a().f21365c) {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            }
            if (d.a) {
                d.a(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i2));
            }
        }
        return -1L;
    }

    public static long i(e.h.a.e0.b bVar) {
        long jR = R(t(bVar));
        if (jR < 0) {
            return -1L;
        }
        return jR;
    }

    public static String j(int i2, e.h.a.e0.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String strE = bVar.e("Etag");
        if (d.a) {
            d.a(f.class, "etag find %s for task(%d)", strE, Integer.valueOf(i2));
        }
        return strE;
    }

    static String k(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String path = new URL(str).getPath();
                String strSubstring = path.substring(path.lastIndexOf(47) + 1);
                if (strSubstring.isEmpty()) {
                    return null;
                }
                return strSubstring;
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }

    public static String l(e.h.a.e0.b bVar, String str) throws FileDownloadSecurityException {
        String strQ = Q(bVar.e("Content-Disposition"));
        if (TextUtils.isEmpty(strQ)) {
            strQ = k(str);
        }
        if (TextUtils.isEmpty(strQ)) {
            return p(str);
        }
        if (strQ.contains("../")) {
            throw new FileDownloadSecurityException(o("The filename [%s] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability", strQ));
        }
        return strQ;
    }

    public static long m(e.h.a.e0.b bVar) {
        long jN = n(bVar);
        if (jN < 0) {
            d.i(f.class, "don't get instance length fromContent-Range header", new Object[0]);
            jN = -1;
        }
        if (jN == 0 && e.a().f21370h) {
            return -1L;
        }
        return jN;
    }

    public static long n(e.h.a.e0.b bVar) {
        return S(t(bVar));
    }

    public static String o(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static String p(String str) {
        return O(str);
    }

    public static String q(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return o("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static int r(String str, String str2) {
        return e.h.a.g0.c.j().i().a(str, str2, false);
    }

    public static int s(String str, String str2, boolean z) {
        return e.h.a.g0.c.j().i().a(str, str2, z);
    }

    private static String t(e.h.a.e0.b bVar) {
        return bVar.e("Content-Range");
    }

    public static File u(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String v(String str) {
        return q(w(), p(str));
    }

    public static String w() {
        if (!TextUtils.isEmpty(f21372c)) {
            return f21372c;
        }
        boolean z = false;
        if (c.a().getExternalCacheDir() != null && Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().getFreeSpace() > 0) {
            z = true;
        }
        return z ? c.a().getExternalCacheDir().getAbsolutePath() : c.a().getCacheDir().getAbsolutePath();
    }

    public static long x(String str) {
        StatFs statFs = new StatFs(str);
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static int y() {
        return a;
    }

    public static long z() {
        return f21371b;
    }
}
