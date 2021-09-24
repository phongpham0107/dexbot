package com.dexbot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dexbot.enums.Auto;
import com.dexbot.enums.Freq;
import com.dexbot.enums.Trend;
import com.dexbot.portal.home.LoadConfig;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

public class Utils {
	private static Logger log = LoggerFactory.getLogger(Utils.class);
    public static JSONObject AlertTypeMap() {
    	JSONObject AlertTypeMap = new JSONObject();
    	try {
			AlertTypeMap.put("RiseUpTo", Trend.RiseUpTo);
	    	AlertTypeMap.put("DropTo", Trend.DropTo);
	    	AlertTypeMap.put("ChangeIsOver", Trend.ChangeIsOver);
	    	return AlertTypeMap;
		} catch (JSONException e) {
			return AlertTypeMap;
		}
    }
    
    public static JSONObject FreqMap() {
    	JSONObject FreqMap = new JSONObject();
    	try {
    		FreqMap.put("OneTime", Freq.OneTime);
    		FreqMap.put("Always", Freq.Always);
	    	return FreqMap;
		} catch (JSONException e) {
			return FreqMap;
		}
    }
    
    public static JSONObject ActionMap() {
    	JSONObject ActionMap = new JSONObject();
    	try {
    		ActionMap.put("No", Auto.No);
    		ActionMap.put("Buy", Auto.Buy);
    		ActionMap.put("Sell", Auto.Sell);
	    	return ActionMap;
		} catch (JSONException e) {
			return ActionMap;
		}
    }
    
    public static JSONObject BoolMap() {
    	JSONObject BoolMap = new JSONObject();
    	try {
    		BoolMap.put("True", true);
    		BoolMap.put("False", false);
	    	return BoolMap;
		} catch (JSONException e) {
			return BoolMap;
		}
    }
    
    public static Properties LoadConfigFile(String FILE_CONFIG) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = Utils.class.getClassLoader()
                    .getResourceAsStream(FILE_CONFIG);
 
            // load properties from file
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close objects
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return properties;
	}
}
