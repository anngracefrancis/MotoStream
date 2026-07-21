package cm.aptoide.pt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Icon;
import android.os.Build;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.util.PreferencesXmlParser;
import cm.aptoide.pt.view.MainActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: FirstLaunchManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0006\u0010\u001a\u001a\u00020\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcm/aptoide/pt/FirstLaunchManager;", HttpUrl.FRAGMENT_ENCODE_SET, "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "idsRepository", "Lcm/aptoide/pt/networking/IdsRepository;", "followedStoresManager", "Lcm/aptoide/pt/FollowedStoresManager;", "rootAvailabilityManager", "Lcm/aptoide/pt/root/RootAvailabilityManager;", "accountManager", "Lcm/aptoide/accountmanager/AptoideAccountManager;", "shortcutManager", "Lcm/aptoide/pt/AptoideShortcutManager;", "context", "Landroid/content/Context;", "(Landroid/content/SharedPreferences;Lcm/aptoide/pt/networking/IdsRepository;Lcm/aptoide/pt/FollowedStoresManager;Lcm/aptoide/pt/root/RootAvailabilityManager;Lcm/aptoide/accountmanager/AptoideAccountManager;Lcm/aptoide/pt/AptoideShortcutManager;Landroid/content/Context;)V", "createAppShortcut", HttpUrl.FRAGMENT_ENCODE_SET, "createShortcut", "Lrx/Completable;", "generateAptoideUuid", "isShortcutAdded", HttpUrl.FRAGMENT_ENCODE_SET, "shortcutInfo", "Landroid/content/pm/ShortcutInfo;", "runFirstLaunch", "setSharedPreferencesValues", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FirstLaunchManager {
    private final AptoideAccountManager accountManager;
    private final Context context;
    private final SharedPreferences defaultSharedPreferences;
    private final FollowedStoresManager followedStoresManager;
    private final IdsRepository idsRepository;
    private final RootAvailabilityManager rootAvailabilityManager;
    private final AptoideShortcutManager shortcutManager;

    public FirstLaunchManager(SharedPreferences sharedPreferences, IdsRepository idsRepository, FollowedStoresManager followedStoresManager, RootAvailabilityManager rootAvailabilityManager, AptoideAccountManager aptoideAccountManager, AptoideShortcutManager aptoideShortcutManager, Context context) {
        kotlin.jvm.internal.m.f(sharedPreferences, "defaultSharedPreferences");
        kotlin.jvm.internal.m.f(idsRepository, "idsRepository");
        kotlin.jvm.internal.m.f(followedStoresManager, "followedStoresManager");
        kotlin.jvm.internal.m.f(rootAvailabilityManager, "rootAvailabilityManager");
        kotlin.jvm.internal.m.f(aptoideAccountManager, "accountManager");
        kotlin.jvm.internal.m.f(aptoideShortcutManager, "shortcutManager");
        kotlin.jvm.internal.m.f(context, "context");
        this.defaultSharedPreferences = sharedPreferences;
        this.idsRepository = idsRepository;
        this.followedStoresManager = followedStoresManager;
        this.rootAvailabilityManager = rootAvailabilityManager;
        this.accountManager = aptoideAccountManager;
        this.shortcutManager = aptoideShortcutManager;
        this.context = context;
    }

    private final void createAppShortcut() {
        Intent intent = new Intent(this.context, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.MAIN");
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", this.context.getResources().getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.context, R.mipmap.ic_launcher));
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        this.context.sendBroadcast(intent2);
    }

    private final rx.b createShortcut() {
        rx.b bVarT = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.i0
            @Override // rx.m.a
            public final void call() {
                FirstLaunchManager.m16createShortcut$lambda3(this.f6394f);
            }
        });
        kotlin.jvm.internal.m.e(bVarT, "fromAction {\n           …}\n            }\n        }");
        return bVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createShortcut$lambda-3, reason: not valid java name */
    public static final void m16createShortcut$lambda3(FirstLaunchManager firstLaunchManager) {
        kotlin.jvm.internal.m.f(firstLaunchManager, "this$0");
        if (!firstLaunchManager.shortcutManager.shouldCreateShortcut() || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        firstLaunchManager.createAppShortcut();
    }

    private final rx.b generateAptoideUuid() {
        rx.b bVarT = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.f0
            @Override // rx.m.a
            public final void call() {
                FirstLaunchManager.m17generateAptoideUuid$lambda1(this.f5648f);
            }
        });
        kotlin.jvm.internal.m.e(bVarT, "fromAction { idsRepository.uniqueIdentifier }");
        return bVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: generateAptoideUuid$lambda-1, reason: not valid java name */
    public static final void m17generateAptoideUuid$lambda1(FirstLaunchManager firstLaunchManager) {
        kotlin.jvm.internal.m.f(firstLaunchManager, "this$0");
        firstLaunchManager.idsRepository.getUniqueIdentifier();
    }

    private final boolean isShortcutAdded(Context context, ShortcutInfo shortcutInfo) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            return false;
        }
        List<ShortcutInfo> pinnedShortcuts = shortcutManager.getPinnedShortcuts();
        kotlin.jvm.internal.m.e(pinnedShortcuts, "shortcutManager.pinnedShortcuts");
        Iterator<ShortcutInfo> it = pinnedShortcuts.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.m.a(it.next().getId(), shortcutInfo.getId())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runFirstLaunch$lambda-0, reason: not valid java name */
    public static final void m18runFirstLaunch$lambda0(Throwable th) {
        CrashReport.getInstance().log(th);
    }

    private final rx.b setSharedPreferencesValues() {
        rx.b bVarT = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.h0
            @Override // rx.m.a
            public final void call() {
                FirstLaunchManager.m19setSharedPreferencesValues$lambda2(this.f5676f);
            }
        });
        kotlin.jvm.internal.m.e(bVarT, "fromAction {\n           …)\n            }\n        }");
        return bVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setSharedPreferencesValues$lambda-2, reason: not valid java name */
    public static final void m19setSharedPreferencesValues$lambda2(FirstLaunchManager firstLaunchManager) {
        kotlin.jvm.internal.m.f(firstLaunchManager, "this$0");
        PreferencesXmlParser preferencesXmlParser = new PreferencesXmlParser();
        XmlResourceParser xml = firstLaunchManager.context.getResources().getXml(R.xml.settings);
        kotlin.jvm.internal.m.e(xml, "context.resources.getXml(R.xml.settings)");
        try {
            for (String[] strArr : preferencesXmlParser.parse(xml)) {
                SharedPreferences.Editor editorEdit = firstLaunchManager.defaultSharedPreferences.edit();
                String str = strArr[0];
                Boolean boolValueOf = Boolean.valueOf(strArr[1]);
                kotlin.jvm.internal.m.e(boolValueOf, "valueOf(keyValue[1])");
                editorEdit.putBoolean(str, boolValueOf.booleanValue()).apply();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public final rx.b runFirstLaunch() {
        rx.b bVarN = rx.b.x(setSharedPreferencesValues(), generateAptoideUuid()).a(rx.b.x(this.followedStoresManager.setDefaultFollowedStores(), this.rootAvailabilityManager.updateRootAvailability(), this.accountManager.updateAccount().A(), createShortcut())).n(new rx.m.b() { // from class: cm.aptoide.pt.g0
            @Override // rx.m.b
            public final void call(Object obj) {
                FirstLaunchManager.m18runFirstLaunch$lambda0((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.e(bVarN, "mergeDelayError(setShare…rt.getInstance().log(e) }");
        return bVarN;
    }

    private final void createAppShortcut(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction("android.intent.action.MAIN");
        ShortcutInfo shortcutInfoBuild = new ShortcutInfo.Builder(context, "shortcut_id").setIntent(intent).setShortLabel(context.getResources().getString(R.string.app_name)).setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher)).build();
        kotlin.jvm.internal.m.e(shortcutInfoBuild, "Builder(context, \"shortc…er))\n            .build()");
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null || !shortcutManager.isRequestPinShortcutSupported() || isShortcutAdded(context, shortcutInfoBuild)) {
            return;
        }
        shortcutManager.requestPinShortcut(shortcutInfoBuild, null);
    }
}
