package com.dexbot.portal.home;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import com.dexbot.utils.Constants;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

@Controller
public class HomeController {
	private final Logger log = LoggerFactory.getLogger(HomeController.class);
    public void initSettings() {
        logConfig();
        startTeleBot();
        LoadABI("abi.json");
        if (ConnectBSC(LoadConfig.pancake_factory_addr, LoadConfig.pancake_router_addr, LoadConfig.priKey) == false)
            return;
        getTokenMonitoringsFromConfig();
        MonitorAllPendings();
    }

	public void logConfig() {
		log.info("==============CONFIG DATA======================");
		log.info("[general]");
		log.info("PancakeFactory= " + LoadConfig.pancake_factory_addr);
		log.info("PancakeRouter= "+ LoadConfig.pancake_router_addr);
		log.info("sound_alamp= " + LoadConfig.sound_alamp);
		log.info("msg_notifi= "+ LoadConfig.msg_notifi);
		log.info("notifi_delay= " + LoadConfig.notifi_delay);
		log.info("get_price_delay= "+ LoadConfig.get_price_delay);
		log.info("[bot]");
		log.info("ApiKey= "+ LoadConfig.api_key);
		log.info("ChatID= "+ LoadConfig.chat_id);
		log.info("[wallet]");
		log.info("priKey= " + LoadConfig.priKey.substring(0, 5) + " ... " + LoadConfig.priKey.substring(LoadConfig.priKey.length() - 5));
		log.info("==============END CONFIG DATA======================");
	}
    
    public void startTeleBot() {
    	log.info("==============startTeleBot======================");
    	try {
    		log.info("MessageNotification " + LoadConfig.msg_notifi);
    		if (LoadConfig.msg_notifi) {
    			TelegramBot bot = new TelegramBot(LoadConfig.api_key);
    			// Test Send Message
    			MessageNotify("Phong Pham Test", 1);
    			log.info("Telegram bot connected");
    		} else {
    			log.error("Telegram bot can not connect");
    		}
    	} catch (Exception e) {
    		log.error("Telegram bot can not connect");
		}
    }
    
    public void LoadABI(String fileName) {
    	
    	log.info("==============LoadABI======================");
    }
    
	public boolean ConnectBSC(String pancake_factory_addr, String pancake_router_addr,String priKey) {
		log.info("Connecting to Ethereum ...");
		try {
			Web3j web3 = Web3j.build(new HttpService(Constants.BSC_URL));
	        EthBlockNumber result = web3.ethBlockNumber().sendAsync().get();
	        log.info(" result: " + result.getBlockNumber());

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public boolean  MessageNotify(String message, int retry) {
    	try {
    		TelegramBot bot = new TelegramBot("BOT_TOKEN");
    		bot.execute(new SendMessage(LoadConfig.chat_id, message));
    		log.info("Success send Telegram message");
    		return true;
    	} catch (Exception e) {
    		log.error("Error sending Telegram message. Retry " + retry);
			return false;
		}
    	
    }
    
	 
	public void getTokenMonitoringsFromConfig() {
	 	
	}
	 
	public void MonitorAllPendings() {
	 	
	}
}
