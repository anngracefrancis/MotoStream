package cm.aptoide.pt.install;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class PackageRepository {
    private List<PackageInfo> memoryCache;
    private final PackageManager packageManager;

    public PackageRepository(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    private rx.e<List<PackageInfo>> getAdbInstalledPackages() {
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.a3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6400f.a();
            }
        });
    }

    private rx.e<List<PackageInfo>> getCachedInstalledPackages() {
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.d3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6425f.b();
            }
        });
    }

    private rx.e<List<PackageInfo>> getInstalledPackages() {
        return getCachedInstalledPackages().n0(getPackageManagerInstalledPackages()).n0(getAdbInstalledPackages().I0(Schedulers.io())).x(new rx.m.b() { // from class: cm.aptoide.pt.install.q2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6572f.c((List) obj);
            }
        });
    }

    private rx.e<List<PackageInfo>> getPackageManagerInstalledPackages() {
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.v2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6593f.e();
            }
        });
    }

    private Single<Boolean> isPackageInstalled(final String str) {
        return Single.c(new Callable() { // from class: cm.aptoide.pt.install.p2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6566f.h(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAdbInstalledPackages$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List a() throws Exception {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
            try {
                Process processExec = Runtime.getRuntime().exec("pm list packages");
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        arrayList.add(this.packageManager.getPackageInfo(line.substring(line.indexOf(58) + 1), 0));
                    } catch (PackageManager.NameNotFoundException e2) {
                        e = e2;
                        throw new RuntimeException(e);
                    } catch (IOException e3) {
                        e = e3;
                        throw new RuntimeException(e);
                    } catch (InterruptedException e4) {
                        e = e4;
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                processExec.waitFor();
                try {
                    bufferedReader2.close();
                } catch (IOException unused2) {
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            e = e5;
        } catch (IOException e6) {
            e = e6;
        } catch (InterruptedException e7) {
            e = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getCachedInstalledPackages$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List b() throws Exception {
        List<PackageInfo> list = this.memoryCache;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("No cached packages available!");
    }

    static /* synthetic */ Iterable lambda$getLatestInstalledPackages$0(List list) {
        return list;
    }

    static /* synthetic */ Integer lambda$getLatestInstalledPackages$1(PackageInfo packageInfo, PackageInfo packageInfo2) {
        int i2;
        long j2 = packageInfo.lastUpdateTime;
        long j3 = packageInfo2.lastUpdateTime;
        if (j2 < j3) {
            i2 = 1;
        } else {
            i2 = j2 == j3 ? 0 : -1;
        }
        return Integer.valueOf(i2);
    }

    static /* synthetic */ Iterable lambda$getLatestInstalledPackages$2(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPackageLabel$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single d(String str) throws Exception {
        try {
            return Single.m(this.packageManager.getApplicationLabel(this.packageManager.getApplicationInfo(str, 0)).toString());
        } catch (Exception e2) {
            return Single.h(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPackageManagerInstalledPackages$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List e() throws Exception {
        return this.packageManager.getInstalledPackages(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getPackageVersionCode$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single f(String str) throws Exception {
        try {
            return Single.m(Integer.valueOf(this.packageManager.getPackageInfo(str, 0).versionCode));
        } catch (Exception e2) {
            return Single.h(e2);
        }
    }

    static /* synthetic */ List lambda$getRandomInstalledPackages$13(List list) {
        Collections.shuffle(list);
        return list;
    }

    static /* synthetic */ Iterable lambda$getRandomInstalledPackages$14(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$isAppInstalled$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single g(String str, List list) {
        return isPackageInstalled(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$isPackageInstalled$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single h(String str) throws Exception {
        try {
            return Single.m(Boolean.valueOf(this.packageManager.getPackageInfo(str, 0) != null));
        } catch (PackageManager.NameNotFoundException unused) {
            return Single.m(Boolean.FALSE);
        } catch (Exception e2) {
            return Single.h(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCachedInstalledPackages, reason: merged with bridge method [inline-methods] */
    public void c(List<PackageInfo> list) {
        this.memoryCache = list;
    }

    public rx.e<String> getLatestInstalledPackages(int i2) {
        return getInstalledPackages().J(new rx.m.e() { // from class: cm.aptoide.pt.install.s2
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                PackageRepository.lambda$getLatestInstalledPackages$0(list);
                return list;
            }
        }).a1(new rx.m.f() { // from class: cm.aptoide.pt.install.r2
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return PackageRepository.lambda$getLatestInstalledPackages$1((PackageInfo) obj, (PackageInfo) obj2);
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.install.o2
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                PackageRepository.lambda$getLatestInstalledPackages$2(list);
                return list;
            }
        }).N0(i2).X(new rx.m.e() { // from class: cm.aptoide.pt.install.y2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PackageInfo) obj).packageName;
            }
        }).I0(Schedulers.io());
    }

    public Single<String> getPackageLabel(final String str) {
        return Single.c(new Callable() { // from class: cm.aptoide.pt.install.w2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6597f.d(str);
            }
        });
    }

    public Single<Integer> getPackageVersionCode(final String str) {
        return Single.c(new Callable() { // from class: cm.aptoide.pt.install.b3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6410f.f(str);
            }
        });
    }

    public rx.e<String> getRandomInstalledPackages(int i2) {
        return getInstalledPackages().X(new rx.m.e() { // from class: cm.aptoide.pt.install.t2
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                PackageRepository.lambda$getRandomInstalledPackages$13(list);
                return list;
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.install.u2
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                PackageRepository.lambda$getRandomInstalledPackages$14(list);
                return list;
            }
        }).N0(i2).X(new rx.m.e() { // from class: cm.aptoide.pt.install.z2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((PackageInfo) obj).packageName;
            }
        }).I0(Schedulers.io());
    }

    public boolean isAppInstalled(final String str) {
        return ((Boolean) getInstalledPackages().Z0().i(new rx.m.e() { // from class: cm.aptoide.pt.install.x2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6602f.g(str, (List) obj);
            }
        }).r(new rx.m.e() { // from class: cm.aptoide.pt.install.c3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.FALSE;
            }
        }).y().b()).booleanValue();
    }
}
