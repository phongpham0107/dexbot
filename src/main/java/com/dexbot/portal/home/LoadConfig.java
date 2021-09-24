package com.dexbot.portal.home;

import com.dexbot.utils.Utils;

public class LoadConfig {
    private static final String FILE_CONFIG = "\\config.properties";
	public static String pancake_factory_addr = Utils.LoadConfigFile(FILE_CONFIG).getProperty("PancakeFactory");
	public static String pancake_router_addr = Utils.LoadConfigFile(FILE_CONFIG).getProperty("PancakeRouter");
	public static String priKey = Utils.LoadConfigFile(FILE_CONFIG).getProperty("priKey");
	public static boolean sound_alamp = Boolean.parseBoolean(Utils.LoadConfigFile(FILE_CONFIG).getProperty("SoundAlarm"));
	public static boolean msg_notifi = Boolean.parseBoolean(Utils.LoadConfigFile(FILE_CONFIG).getProperty("MessageNotification"));
	public static int notifi_delay = Integer.parseInt(Utils.LoadConfigFile(FILE_CONFIG).getProperty("NotificationDelay")) / 1000;
    public static int get_price_delay = Integer.parseInt(Utils.LoadConfigFile(FILE_CONFIG).getProperty("GetPriceDelay")) / 1000;
    public static String chat_id  = Utils.LoadConfigFile(FILE_CONFIG).getProperty("ApiKey");
    public static String latestBloc  = Utils.LoadConfigFile(FILE_CONFIG).getProperty("ChatID");
    public static String api_key = Utils.LoadConfigFile(FILE_CONFIG).getProperty("ApiKey");
}
