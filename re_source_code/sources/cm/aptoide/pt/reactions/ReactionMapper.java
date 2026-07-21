package cm.aptoide.pt.reactions;

import cm.aptoide.pt.R;
import cm.aptoide.pt.reactions.data.ReactionType;

/* JADX INFO: loaded from: classes.dex */
public class ReactionMapper {

    /* JADX INFO: renamed from: cm.aptoide.pt.reactions.ReactionMapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType;

        static {
            int[] iArr = new int[ReactionType.values().length];
            $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType = iArr;
            try {
                iArr[ReactionType.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[ReactionType.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    public static int mapReaction(String str) {
        str.hashCode();
        switch (str) {
            case "thumbs_down":
                return R.drawable.ic_react_thumbs_down;
            case "love":
                return R.drawable.ic_react_love;
            case "thug":
                return R.drawable.ic_react_thug;
            case "laugh":
                return R.drawable.ic_react_laugh;
            case "thumbs_up":
                return R.drawable.ic_react_thumbs_up;
            default:
                return -1;
        }
    }

    public static String mapUserReaction(ReactionType reactionType) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$reactions$data$ReactionType[reactionType.ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? reactionType.toString().toLowerCase() : "thumbs_down";
        }
        return "thumbs_up";
    }
}
