package cm.aptoide.pt.view;

import android.content.Context;
import cm.aptoide.pt.R;
import cm.aptoide.pt.utils.AptoideUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class Translator {
    public static String translate(String str, Context context, String str2) {
        if (str == null) {
            return str;
        }
        switch (str) {
            case "Health":
                return context.getString(R.string.health);
            case "Game of the Week":
                return context.getString(R.string.home_game_of_the_week);
            case "Brain & Puzzle":
                return context.getString(R.string.brain_puzzle);
            case "Get rewarded with AppCoins":
                return context.getString(R.string.appc_title_ads);
            case "Timeline":
                return context.getString(R.string.timeline);
            case "Puzzle":
                return context.getString(R.string.puzzle);
            case "Racing":
                return context.getString(R.string.racing);
            case "Social":
                return context.getString(R.string.social);
            case "Sports":
                return context.getString(R.string.sports);
            case "Stores":
                return context.getString(R.string.stores);
            case "News & Weather":
                return context.getString(R.string.news_weather);
            case "Themes":
                return context.getString(R.string.themes);
            case "Travel":
                return context.getString(R.string.travel);
            case "Trivia":
                return context.getString(R.string.trivia);
            case "Medical":
                return context.getString(R.string.medical);
            case "Editors' Choice":
            case "Editors Choice":
            case "Editor's Choice":
                return context.getString(R.string.home_title_editors_choice);
            case "Featured Stores":
                return context.getString(R.string.featured_stores);
            case "Reviews":
                return context.getString(R.string.reviews);
            case "Sports Games":
                return context.getString(R.string.sports_games);
            case "Weather":
                return context.getString(R.string.weather);
            case "Use Your AppCoins":
                return context.getString(R.string.appc_home_bundle_iab);
            case "Earn AppCoins Credits":
                return context.getString(R.string.appc_home_bundle_poa);
            case "Transport":
                return context.getString(R.string.transport);
            case "Music & Audio":
                return context.getString(R.string.music_audio);
            case "Aptoide Publishers":
                return AptoideUtils.StringU.getFormattedString(R.string.aptoide_publishers, context.getResources(), str2);
            case "Music & Video":
                return context.getString(R.string.music_video);
            case "Business":
                return context.getString(R.string.business);
            case "Essential Apps":
                return context.getString(R.string.essential_apps);
            case "Followed Stores":
                return context.getString(R.string.followed_stores);
            case "Comments on this store":
            case "Comments in this store":
                return context.getString(R.string.comment_store_title);
            case "Multimedia":
                return context.getString(R.string.multimedia);
            case "Downloads":
                return context.getString(R.string.downloads);
            case "Top Apps":
                return context.getString(R.string.top_apps);
            case "Photography":
                return context.getString(R.string.photography);
            case "Health & Fitness":
                return context.getString(R.string.health_fitness);
            case "AppCoins Enabled":
            case "Spend your AppCoins":
                return context.getString(R.string.appc_title_iab);
            case "News & Magazines":
                return context.getString(R.string.news_magazines);
            case "Role Playing":
                return context.getString(R.string.role_playing);
            case "Cards & Casino":
                return context.getString(R.string.cards_casino);
            case "Latest Applications":
            case "Latest Apps":
                return context.getString(R.string.latest_applications);
            case "Travel & Local":
                return context.getString(R.string.travel_local);
            case "Apps Timeline":
                return context.getString(R.string.apps_timeline);
            case "Summer Apps":
                return context.getString(R.string.summer_apps);
            case "Personalization":
                return context.getString(R.string.personalization);
            case "Shopping":
                return context.getString(R.string.shopping);
            case "Communication":
                return context.getString(R.string.communication);
            case "Libraries & Demo":
                return context.getString(R.string.libraries_demo);
            case "Books & Reference":
                return context.getString(R.string.books_reference);
            case "Highlighted":
                return context.getString(R.string.highlighted);
            case "All":
                return context.getString(R.string.all);
            case "Card":
                return context.getString(R.string.card);
            case "Demo":
                return context.getString(R.string.demo);
            case "Home":
                return context.getString(R.string.home_title);
            case "Word":
                return context.getString(R.string.word);
            case "Board":
                return context.getString(R.string.board);
            case "Games":
                return context.getString(R.string.games);
            case "Music":
                return context.getString(R.string.music);
            case "Tools":
                return context.getString(R.string.tools);
            case "Software Libraries":
                return context.getString(R.string.software_libraries);
            case "Top Games":
                return context.getString(R.string.top_games);
            case "Top Stores":
                return context.getString(R.string.top_stores_fragment_title);
            case "Arcade & Action":
                return context.getString(R.string.arcade_action);
            case "Community":
                return context.getString(R.string.community);
            case "Simulation":
                return context.getString(R.string.simulation);
            case "Finance":
                return context.getString(R.string.finance);
            case "Featured AppCoins Apps":
                return context.getString(R.string.appc_title_featured);
            case "Latest Reviews":
                return context.getString(R.string.latest_reviews);
            case "Transportation":
                return context.getString(R.string.transportation);
            case "The cryptocurrency for the app economy is here! Get free AppCoins by using your favorite apps.":
                return context.getString(R.string.appc_message_homepage_card);
            case "Local Top Apps":
                return context.getString(R.string.local_top_apps);
            case "Reference":
                return context.getString(R.string.reference);
            case "Applications":
                return context.getString(R.string.applications);
            case "Productivity":
                return context.getString(R.string.productivity);
            case "Entertainment":
                return context.getString(R.string.entertainment);
            case "Adventure":
                return context.getString(R.string.adventure);
            case "You can get AppCoins now!":
                return context.getString(R.string.appc_title_homepage_card);
            case "Educational":
                return context.getString(R.string.educational);
            case "Updates":
                return context.getString(R.string.updates);
            case "Trending":
                return context.getString(R.string.trending);
            case "Latest Comments":
                return context.getString(R.string.latest_comments);
            case "Media & Video":
                return context.getString(R.string.media_video);
            case "Education":
                return context.getString(R.string.education);
            case "Lifestyle":
                return context.getString(R.string.lifestyle);
            case "Recommended Stores":
                return context.getString(R.string.recommended_stores);
            case "Top Apps in this store":
                return context.getString(R.string.top_apps_in_store);
            case "Strategy":
                return context.getString(R.string.strategy);
            case "Apps for Kids":
                return context.getString(R.string.apps_for_kids);
            case "Play-it!":
                return context.getString(R.string.title_play_it);
            case "Action":
                return context.getString(R.string.action);
            case "Arcade":
                return context.getString(R.string.arcade);
            case "Casino":
                return context.getString(R.string.casino);
            case "Casual":
                return context.getString(R.string.casual);
            case "Comics":
                return context.getString(R.string.comics);
            case "Family":
                return context.getString(R.string.family);
            default:
                return str;
        }
    }

    public static String[] translateToMultiple(String str, Context context) {
        if (str == null) {
            return null;
        }
        if (str.equals("Your store does not have any applications yet. Install Aptoide Uploader and upload apps to share them with the world!") || str.equals("Your store doesn't have any applications yet. Install Aptoide Uploader and upload apps to share them with the world!")) {
            return new String[]{context.getString(R.string.install_app_outter_pt1), context.getString(R.string.install_app_outter_pt2), context.getString(R.string.install_app_inner), context.getString(R.string.open_app_inner)};
        }
        return null;
    }
}
