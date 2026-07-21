package cm.aptoide.pt.bottomNavigation;

import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationMapper {
    public static final int APPS_POSITION = 4;
    static final int CURATION_POSITION = 1;
    static final int HOME_POSITION = 0;
    static final int SEARCH_POSITION = 2;
    static final int STORES_POSITION = 3;

    /* JADX INFO: renamed from: cm.aptoide.pt.bottomNavigation.BottomNavigationMapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem;

        static {
            int[] iArr = new int[BottomNavigationItem.values().length];
            $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem = iArr;
            try {
                iArr[BottomNavigationItem.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.CURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.SEARCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.STORES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[BottomNavigationItem.APPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BottomNavigationItem mapItemClicked(Integer num) {
        switch (num.intValue()) {
            case R.id.action_apps /* 2131296317 */:
                return BottomNavigationItem.APPS;
            case R.id.action_curation /* 2131296330 */:
                return BottomNavigationItem.CURATION;
            case R.id.action_home /* 2131296332 */:
                return BottomNavigationItem.HOME;
            case R.id.action_search /* 2131296341 */:
                return BottomNavigationItem.SEARCH;
            case R.id.action_stores /* 2131296342 */:
                return BottomNavigationItem.STORES;
            default:
                throw new IllegalStateException("The selected menuItem is not supported");
        }
    }

    public int mapToBottomNavigationPosition(BottomNavigationItem bottomNavigationItem) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$bottomNavigation$BottomNavigationItem[bottomNavigationItem.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3) {
            return 2;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 5) {
            return 4;
        }
        throw new IllegalStateException("The selected bottomNavigationItem is not supported");
    }

    public int mapToBottomNavigationPosition(Integer num) {
        switch (num.intValue()) {
            case R.id.action_apps /* 2131296317 */:
                return 4;
            case R.id.action_curation /* 2131296330 */:
                return 1;
            case R.id.action_home /* 2131296332 */:
                return 0;
            case R.id.action_search /* 2131296341 */:
                return 2;
            case R.id.action_stores /* 2131296342 */:
                return 3;
            default:
                throw new IllegalStateException("The selected menuItem is not supported");
        }
    }
}
