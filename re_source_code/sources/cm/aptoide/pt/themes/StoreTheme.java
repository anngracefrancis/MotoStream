package cm.aptoide.pt.themes;

import cm.aptoide.pt.R;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public enum StoreTheme {
    DEFAULT(R.style.AptoideThemeLight, true),
    DEFAULT_DARK(R.style.AptoideThemeDark, false),
    GREEN(R.style.AptoideThemeLight_Green, true),
    GREEN_DARK(R.style.AptoideThemeDark_Green, false),
    TEAL(R.style.AptoideThemeLight_Teal, true),
    TEAL_DARK(R.style.AptoideThemeDark_Teal, false),
    RED(R.style.AptoideThemeLight_Red, true),
    RED_DARK(R.style.AptoideThemeDark_Red, false),
    INDIGO(R.style.AptoideThemeLight_Indigo, true),
    INDIGO_DARK(R.style.AptoideThemeDark_Indigo, false),
    PINK(R.style.AptoideThemeLight_Pink, true),
    PINK_DARK(R.style.AptoideThemeDark_Pink, false),
    ORANGE(R.style.AptoideThemeLight_Orange, true),
    ORANGE_DARK(R.style.AptoideThemeDark_Orange, false),
    BROWN(R.style.AptoideThemeLight_Brown, true),
    BROWN_DARK(R.style.AptoideThemeDark_Brown, false),
    BLUE_GREY(R.style.AptoideThemeLight_BlueGrey, true),
    BLUE_GREY_DARK(R.style.AptoideThemeDark_BlueGrey, false),
    GREY(R.style.AptoideThemeLight_Grey, true),
    GREY_DARK(R.style.AptoideThemeDark_Grey, false),
    BLACK(R.style.AptoideThemeLight_Black, true),
    BLACK_DARK(R.style.AptoideThemeDark_Black, false),
    DEEP_PURPLE(R.style.AptoideThemeLight_DeepPurple, true),
    DEEP_PURPLE_DARK(R.style.AptoideThemeDark_DeepPurple, false),
    AMBER(R.style.AptoideThemeLight_Amber, true),
    AMBER_DARK(R.style.AptoideThemeDark_Amber, false),
    LIGHT_GREEN(R.style.AptoideThemeLight_LightGreen, true),
    LIGHT_GREEN_DARK(R.style.AptoideThemeDark_LightGreen, false),
    LIME(R.style.AptoideThemeLight_Lime, true),
    LIME_DARK(R.style.AptoideThemeDark_Lime, false),
    LIGHT_BLUE(R.style.AptoideThemeLight_LightBlue, true),
    LIGHT_BLUE_DARK(R.style.AptoideThemeDark_LightBlue, false),
    SEA_GREEN(R.style.AptoideThemeLight_Green, false),
    SEA_GREEN_DARK(R.style.AptoideThemeDark_Green, false),
    SLATE_GRAY(R.style.AptoideThemeLight_Teal, false),
    SLATE_GRAY_DARK(R.style.AptoideThemeDark_Teal, false),
    BLUE(R.style.AptoideThemeLight_Indigo, false),
    BLUE_DARK(R.style.AptoideThemeDark_Indigo, false),
    MAROON(R.style.AptoideThemeLight_Brown, false),
    MAROON_DARK(R.style.AptoideThemeDark_Brown, false),
    MIDNIGHT(R.style.AptoideThemeLight_BlueGrey, false),
    MIDNIGHT_DARK(R.style.AptoideThemeDark_BlueGrey, false),
    BLUE_GRAY(R.style.AptoideThemeLight_BlueGrey, false),
    BLUE_GRAY_DARK(R.style.AptoideThemeDark_BlueGrey, false),
    SILVER(R.style.AptoideThemeLight_Grey, false),
    SILVER_DARK(R.style.AptoideThemeDark_Grey, false),
    DIM_GRAY(R.style.AptoideThemeLight_Grey, false),
    DIM_GRAY_DARK(R.style.AptoideThemeDark_Grey, false),
    MAGENTA(R.style.AptoideThemeLight_DeepPurple, false),
    MAGENTA_DARK(R.style.AptoideThemeDark_DeepPurple, false),
    YELLOW(R.style.AptoideThemeLight_Amber, false),
    YELLOW_DARK(R.style.AptoideThemeDark_Amber, false),
    GOLD(R.style.AptoideThemeLight_Amber, false),
    GOLD_DARK(R.style.AptoideThemeDark_Amber, false),
    SPRING_GREEN(R.style.AptoideThemeLight_Green, false),
    SPRING_GREEN_DARK(R.style.AptoideThemeDark_Green, false),
    GREEN_APPLE(R.style.AptoideThemeLight_Lime, false),
    GREEN_APPLE_DARK(R.style.AptoideThemeDark_Lime, false),
    LIGHT_SKY(R.style.AptoideThemeLight_LightBlue, false),
    LIGHT_SKY_DARK(R.style.AptoideThemeDark_LightBlue, false),
    HAPPY_BLUE(R.style.AptoideThemeLight_LightBlue, false),
    HAPPY_BLUE_DARK(R.style.AptoideThemeDark_LightBlue, false);

    private boolean isSelectable;
    private int storeStyle;

    StoreTheme(int i2, boolean z) {
        this.storeStyle = i2;
        this.isSelectable = z;
    }

    static StoreTheme get(String str, boolean z) {
        StoreTheme storeThemeValueOf = null;
        if (str != null) {
            try {
                storeThemeValueOf = valueOf(str.replace("-", "_").toUpperCase());
            } catch (IllegalArgumentException unused) {
            }
        }
        if (storeThemeValueOf == null) {
            storeThemeValueOf = DEFAULT;
        }
        if (!z || storeThemeValueOf.toString().contains("_DARK")) {
            return storeThemeValueOf;
        }
        return valueOf(storeThemeValueOf.toString() + "_DARK");
    }

    public static List<StoreTheme> getThemesFromVersion(int i2) {
        LinkedList linkedList = new LinkedList();
        for (StoreTheme storeTheme : values()) {
            if (storeTheme.isSelectable) {
                linkedList.add(storeTheme);
            }
        }
        return linkedList;
    }

    public String getThemeName() {
        String strReplace = name().toLowerCase().replace('_', '-');
        return strReplace.contains("-dark") ? strReplace.substring(0, strReplace.indexOf("-dark")) : strReplace;
    }

    public int getThemeResource() {
        return this.storeStyle;
    }
}
