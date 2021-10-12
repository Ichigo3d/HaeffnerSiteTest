package com.links;
import java.util.*;

public class PartsUrls {
    public static String base_url = "http://the-internet.herokuapp.com/";
    static List<String> links = List.of("checkboxes",
            "basic_auth", "add_remove_elements/",
            "broken_images", "challenging_dom", "context_menu", "digest_auth",
            "disappearing_elements", "drag_and_drop", "dropdown", "dynamic_content",
            "dynamic_controls", "entry_ad", "exit_intent", "download",
            "upload", "floating_menu", "forgot_password", "login",
            "frames", "geolocation", "horizontal_slider", "hovers",
            "infinite_scroll", "inputs", "jqueryui/menu", "javascript_alerts",
            "javascript_error", "key_presses", "large", "windows",
            "nested_frames", "notification_message_rendered", "redirector", "download_secure",
            "shadowdom", "shifting_content", "slow", "tables",
            "status_codes", "typos", "tinymce");

    public static String getLink(String nameSection) {
        String result = "";
        for( int i = 0; i < links.size(); i++){
            if(links.get(i).equals(nameSection)){
                result = base_url + links.get(i);
            }
        }
        return result;
    }
}
